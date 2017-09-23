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
	width: 64px;
}
</style>

<script type="text/javascript">
	$(function() {

	});
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
						<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
						<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
						<li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
						<li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="home">1</div>
						<div role="tabpanel" class="tab-pane" id="profile">2</div>
						<div role="tabpanel" class="tab-pane" id="messages">3</div>
						<div role="tabpanel" class="tab-pane" id="settings">4</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>