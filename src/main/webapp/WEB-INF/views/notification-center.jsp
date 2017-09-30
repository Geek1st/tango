<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://geeklib.com/functions" prefix="dic"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="${domain}/resource/js/template-web.js"></script>
<script src="${domain}/resource/js/jquery-2.1.4.js"></script>
<script src="${domain}/resource/js/bootstrap.min.js"></script>
<script src="${domain}/resource/js/global.js"></script>

<link rel="stylesheet" href="${domain}/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="${domain}/resource/css/global.css" />

<style type="text/css">
.media img {
	width: 42px;
}

.panel {
	margin: 10px auto;
}
</style>

<script type="text/javascript">
	$(function() {
		$.get("${domain}/internalMessage/privateMessage",function(data){
			var data = {data:data}
			$("#profile").html(template("templateInnerMessage",data));
		})
	});
</script>
<script type="text/html" id="templateInnerMessage">
{{each data innerMessage i}}
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="media">
				<div class="media-left">
					<a href="#"> <img class="media-object" src="${domain }/resource/image/whatsapp.png" alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">{{innerMessage.sendUserId}} 
						<small>
							{{innerMessage.gmtCreate}}
						</small>
					</h4>
					{{innerMessage.message}}
				</div>
			</div>
		</div>
	</div>
{{/each}}
</script>

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div>
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#systemNotification" aria-controls="systemNotification" role="tab"
							data-toggle="tab">系统通知</a></li>
						<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">站内信</a></li>
						<button class="btn btn-default pull-right btn-sm"> 全部已读</button>
						<!-- <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li> -->
					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="systemNotification">
						</div>
						<div role="tabpanel" class="tab-pane" id="profile">
							
						</div>
						<div role="tabpanel" class="tab-pane" id="messages">3</div>
						<div role="tabpanel" class="tab-pane" id="settings">4</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>