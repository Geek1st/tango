<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线工具</title>

<script src="../resource/js/jquery-2.1.4.js"></script>
<script src="../resource/js/bootstrap.min.js"></script>
<script src="../resource/js/bootstrap-table.min.js"></script>
<script src="../resource/js/bootstrap-table-zh-CN.min.js"></script>
<script src="../resource/json/server-table-config.json"></script>
<script src="../resource/json/server-table-edit-config.json"></script>
<script src="../resource/js/global.js"></script>

<link rel="stylesheet" href="../resource/css/bootstrap.min.css">
<link rel="stylesheet" href="../resource/css/bootstrap-table.min.css">
<link rel="stylesheet" href="../resource/css/global.css" />

<style type="text/css">
.media .media-left .media-object {
	height: 72px;
	width: 72px;
	border-radius: 2px;
}

.media{
	border-radius:3px;
	padding:6px;
	border:1px solid #CCCCCC;
}
.media .media-body p{
	text-overflow: -o-ellipsis-lastline;  
	overflow: hidden;  
	text-overflow: ellipsis;  
	display: -webkit-box;  
	-webkit-line-clamp: 2;  
	-webkit-box-orient: vertical;  
	margin:0px auto;
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
				<div class="row">
					<div class="col-md-12 tabbable" id="tabs-15135">
						<ul class="nav nav-tabs">
							<li role="presentation" class="active"><a href="#pnlAPI" data-toggle="tab">Home</a></li>
							<li role="presentation"><a href="#pnlTool" data-toggle="tab">第二部分</a></li>
							<li role="presentation"><a href="#">Messages</a></li>
							<li class="navbar-right" style="margin-right: 0px;">
					        	<input type="text" class="form-control" placeholder="Search..">
					        </li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="pnlAPI">
								<p>
									第一部分内容.
								</p>
							</div>
							<div class="tab-pane" id="pnlTool">
								<p>
									第二部分内容.
								</p>
							</div>
						</div>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-3">
						<div class="media">
							<div class="media-left">
								<a href="#"> <img class="media-object"
									src="../resource/image/whatsapp.png" alt="...">
								</a>
							</div>
							<div class="media-body">
								<h3 class="media-heading">在线API</h3>
								<p>
								tango 项目APItango 项目APItango 项目APItango 项目APItango 项目APItango 项目APItango 项目APItango 项目APItango 项目APItango 项目APItango 项目API
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="media">
							<div class="media-left">
								<a href="#"> <img class="media-object"
									src="../resource/image/whatsapp.png" alt="...">
								</a>
							</div>
							<div class="media-body">
								<h4 class="media-heading">在线API</h4>
								tango 项目API
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="media">
							<div class="media-left">
								<a href="#"> <img class="media-object"
									src="../resource/image/whatsapp.png" alt="...">
								</a>
							</div>
							<div class="media-body">
								<h4 class="media-heading">在线API</h4>
								tango 项目API
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="media">
							<div class="media-left">
								<a href="#"> <img class="media-object"
									src="../resource/image/whatsapp.png" alt="...">
								</a>
							</div>
							<div class="media-body">
								<h4 class="media-heading">在线API</h4>
								tango 项目API
							</div>
						</div>
					</div>
				</div>




				<div class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object"
							src="../resource/image/whatsapp.png" alt="...">
						</a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">在线API</h4>
						tango 项目API
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>