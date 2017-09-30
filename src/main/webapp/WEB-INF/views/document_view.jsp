<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>编辑文章</title>
<script src="${domain }/resource/js/template-web.js"></script>
<script src="${domain }/resource/js/jquery-2.1.4.js"></script>
<script src="${domain }/resource/js/bootstrap.min.js"></script>
<script src="${domain }/resource/js/global.js"></script>
<script src="${domain }/resource/js/bootstrap-markdown.js"></script>
<script src="${domain }/resource/js/to-markdown.js"></script>
<script src="${domain }/resource/js/marked.js"></script>
<script src="http://cdn.bootcss.com/markdown.js/0.5.0/markdown.min.js"></script>
<script src="${domain }/resource/js/jquery.pin.js"></script>

<link rel="stylesheet" href="${domain }/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="${domain }/resource/css/global.css" />

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
		
		var nav = $("#content h1,#content h2,#content h3,#content h4");
		//$("#pnlNav .panel-body").html(template("tempMedia",{data:nav}))
		
		nav.each(function(i,n){
			$(this).attr("id","autotitle" + i);
			if($(this).is("h1")){
				$("#pnlNav .panel-body .list-unstyled").append("<a href='#autotitle" + i + "'><li>" + $(this).text() + "<li><a>");
			}else if($(this).is("h2")){
				$("#pnlNav .panel-body .list-unstyled").append("<a href='#autotitle" + i + "'><li>&emsp;" + $(this).text() + "<li><a>");
			}else if($(this).is("h3")){
				$("#pnlNav .panel-body .list-unstyled").append("<a href='#autotitle" + i + "'><li>&emsp;&emsp;" + $(this).text() + "<li><a>");
			}
			
		})
		
		$("#pnlNav").pin();
	})
</script>

<script type="text/html" id="tempMedia">
	<ul class="list-unstyled">
	{{each data title i}}
		<li>
			{{@title.innerText}}
		</li>
	{{/each}}
	</ul>
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row">
					<div class="col-md-8 column">
						<div id="document">
							<div class="page-header">
								<h2>
									<a href="#">${document.title } </a>
								</h2>
							</div>
							<div id="content">${document.markdownStyleContent }</div>
						</div>
					</div>
					<div class="col-md-4 column">
						<div class="panel panel-default">
							<div class="panel-body">
								<ul class="list-unstyled">
									<li>
										创建日期：<fmt:formatDate value="${document.gmtCreate }" pattern="yyyy/MM/dd"/>
									</li>
									<li>
										修改日期：<fmt:formatDate value="${document.gmtModified }" pattern="yyyy/MM/dd"/>
									</li>
									<li>
										作者：${document.author}
									</li>
									<li>
										标签：
										<span class="label label-primary">java</span>
										<span class="label label-primary">java</span>
									</li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default" id="pnlNav">
							<div class="panel-heading">文章导航</div>
							<div class="panel-body">
								<ul class="list-unstyled"></ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>