<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
<meta charset="utf-8">
<title>Welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="${domain}/resource/js/jquery-2.1.4.js"></script>
<script src="${domain}/resource/js/bootstrap.min.js"></script>
<script src="${domain}/resource/js/global.js"></script>

<link rel="stylesheet" href="${domain}/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="${domain}/resource/css/global.css" />

</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>Hello, world! </h1>
					<p>
						<shiro:guest>匿名者</shiro:guest>
						<shiro:user>
							<shiro:principal property="nickName"/>
						</shiro:user>
					</p>
					<p>
						<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>

</html>