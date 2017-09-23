var link;
self.addEventListener('push', function (event) {
    event.waitUntil(
        fetch('../server/listServet.do').then(function (response) {
            return response.json();
        }).then(function(data){
            link = data.link;
            return self.registration.showNotification('New article in Auth0 blog!', {
                body: data.title,
                icon: data.thumbnail,
                tag: 'Auth0-blog-post-notification'
            })
        })
    );
});

self.addEventListener('notificationclick', function(event) {
    event.waitUntil(
        clients.matchAll({
            type: "window"
        })
        .then(function(clientList) {
            for (var i = 0; i < clientList.length; i++) {
                var client = clientList[i];
                if (client.url == '/' && 'focus' in client)
                    return client.focus();
            }
            if (clients.openWindow) {
                return clients.openWindow(link);
            }
        })
    );
});

self.addEventListener('message', function(event) {
	  const data = event.data;
	  console.log("message interceptor")
	  if (data.command === 'oneWayCommunication') {
	    console.log("Message from the Page : ${data.message}");
	  } 
	});