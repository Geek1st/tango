<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑文章</title>
<script src="${domain }/resource/js/template-web.js"></script>
<script src="${domain }/resource/js/jquery-2.1.4.js"></script>
<script src="${domain }/resource/js/bootstrap.min.js"></script>
<script src="${domain }/resource/js/global.js"></script>
<script src="${domain }/resource/js/bootstrap-markdown.js"></script>
<script src="${domain }/resource/js/markdown.js"></script>
<script src="${domain }/resource/js/to-markdown.js"></script>
<script src="${domain }/resource/js/marked.js"></script>

<link rel="stylesheet" href="${domain }/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="${domain }/resource/css/global.css" />
<link rel="stylesheet" href="${domain }/resource/css/bootstrap-markdown.min.css" />

<style type="text/css">
.md-preview {
	padding: 30px;
}

.md-input {
	padding: 30px;
}

#tag {
	line-height: 30px
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:link {
	text-decoration: none;
}

.page-header a: hover {
	text-decoration: none;
	color: #FF3366;
}

.page-header a:active {
	text-decoration: none;
	color: #FF3366;
}

.page-header a:visited {
	text-decoration: none;
	color: #FF3366;
}

.page-header a:link {
	text-decoration: none;
	color: #FF3366;
}
.label{
	display: inline-block;
}

</style>

<script type="text/javascript">
	$(function(){
		$(".col-md-4 .panel:eq(0)").click(function(){
			window.location.href="../document/add.do";
		})
	})
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row">
					<div class="col-md-8 column">
						<c:forEach items="${documents }" var="document">
							<div id="document">
								<div class="page-header">
									<h2>
										<a href="<%=request.getContextPath() %>/document/${document.id}">${document.title }</a>
									</h2>
								</div>
								<ul class="list-inline">
									<li><span class="glyphicon glyphicon-calendar"></span>&nbsp;
										<fmt:formatDate value="${document.gmtCreate }" pattern="yyyy/MM/dd"/>
									</li>
									<li>
										<span class="glyphicon glyphicon-user"></span>&nbsp;
										${document.author }
									</li>
									<li>
										<span class="glyphicon glyphicon-tag"></span> 
										<span class="label label-primary">java</span>
										<span class="label label-primary">java</span>
									</li>
								</ul>
								<p>
									${fn:substring(document.content,0,fn:indexOf(document.content,"<!-- more -->")) }
								</p>
							</div>
						</c:forEach>
					</div>
					<div class="col-md-4 column">
						<div class="form-group has-feedback">
	                        <span class="glyphicon glyphicon-search form-control-feedback" style="color:#AAA"></span>
	                        <input type="text" class="form-control" id="search" name="search" placeholder="站内搜索">
                        </div>
						<div class="panel panel-default">
							<div class="panel-body">添加一个新文档</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">文档分类</div>
							<ul class="list-group">
								<li class="list-group-item"><span class="badge">14</span> Cras justo odio</li>
								<li class="list-group-item"><span class="badge">14</span> Cras justo odio</li>
								<li class="list-group-item"><span class="badge">14</span> Cras justo odio</li>
								<li class="list-group-item"><span class="badge">14</span> Cras justo odio</li>
								<li class="list-group-item"><span class="badge">14</span> Cras justo odio</li>
							</ul>
						</div>
						<div class="panel panel-default" id="tag">
							<div class="panel-heading">
								<b>标签云</b>
							</div>
							<div class="panel-body">

								<a href="#"><span class="label label-default">java</span></a> <a href="#"><span class="label label-default">maven</span></a>
								<a href="#"><span class="label label-default">jsp</span></a> <a href="#"><span class="label label-default">mysql</span></a>
								<a href="#"><span class="label label-default">websocket</span></a> <a href="#"><span class="label label-default">webservice</span></a>
								<a href="#"><span class="label label-default">archetype</span></a> <a href="#"><span class="label label-default">String</span></a>
								<a href="#"><span class="label label-default">I/O</span></a> <a href="#"><span class="label label-default">多线程</span></a>
								<a href="#"><span class="label label-default">集合</span></a> <a href="#"><span class="label label-default">commons</span></a>
								<a href="#"><span class="label label-default">linux</span></a> <a href="#"><span class="label label-default">注解</span></a>
								<a href="#"><span class="label label-default">mybatis</span></a> <a href="#"><span class="label label-default">service
										worker</span></a> <a href="#"><span class="label label-default">spring</span></a>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-body">Panel content</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>