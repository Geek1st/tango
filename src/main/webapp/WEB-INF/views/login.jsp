<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>编辑文章</title>
<script src="<%=request.getContextPath()%>/resource/js/template-web.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/jquery-2.1.4.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/global.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/bootstrap-markdown.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/to-markdown.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/marked.js"></script>
<script src="http://cdn.bootcss.com/markdown.js/0.5.0/markdown.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/global.css" />

<style type="text/css">
#formCard {
	background: #FFFFFF;
	filter: alpha(opacity = 95);
	-moz-opacity: 0.95;
	opacity: 0.95;
}


body {
	background-image:
		url("<%=request.getContextPath()%>/resource/image/login_backgroud.jpg");
}

.panel-body img{
	width:64px;
	margin:0px auto ;
	display: -webkit-box;
}
.row{
	max-width:400px;
	position: absolute;
    top: 50%;
    width: 100%;
    margin-top: -205px;
}

.container-fluid{
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    width: 100%;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="">
				<div id="formCard" class="panel panel-default">
					<div class="panel-body">
						<img src="${domain}/resource/image/icons/atom.svg"/>
						<form action="${domain }/login" method="POST">
							<div class="form-group">
								<label for="username">用户名</label> 
								<input type="email" class="form-control" id="username" placeholder="Email" name="username">
							</div>
							<div class="form-group">
								<label for="password">密码</label> 
								<input type="password" class="form-control" id="password" placeholder="Password" name="password">
							</div>
							<button type="submit" class="btn btn-primary btn-block">登录</button>
							${message }
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>