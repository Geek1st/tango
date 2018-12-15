/**
 * 
 */

var domain = "http://127.0.0.1:8080/tango"

$.ajaxSetup({
	complete: function(xhr) {
	    
	    if(401 == xhr.status){
			window.location.href = domain + "/login";   			        	
        }
    }
});