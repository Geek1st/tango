<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://geeklib.com/functions" prefix="dic"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="../resource/js/template-web.js"></script>
<script src="../resource/js/jquery-2.1.4.js"></script>
<script src="../resource/js/bootstrap.min.js"></script>
<script src="../resource/js/global.js"></script>

<link rel="stylesheet" href="../resource/css/bootstrap.min.css">
<link rel="stylesheet" href="../resource/css/global.css"/>

<style type="text/css">
.media img{
	width:64px;
}

</style>

<script type="text/javascript">
	$(function() {

		
		$("#softwareTypeList").on("click", "a",function(){

			$(".list-group-item").removeClass("active");
			$(this).addClass("active");

			$.post("../software/listSoftware.do",{softwareTypeId:1},function(data){
				
				var data = {data:data}
				$(".col-md-9").html(template("tempMedia",data))
			})
			
		})
		
		
	});
</script>

<script type="text/html" id="tempMedia">
	{{each data software i}}
		<div class="media">
			<a href="{{software.path}}" class="pull-left" >
				<img src="" class="media-object" alt='' />
			</a>
			<div class="media-body">
				<h4 class="media-heading">{{software.name}}</h4>
				{{software.detail}}
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
				<div class="row clearfix">
					<div class="col-md-3 column">
						<div class="list-group" id="softwareTypeList">
							<c:forEach items="${dic:listSoftwareType() }" var="softwareType">
								<a href="#" class="list-group-item" id="${softwareType.id }">${softwareType.name }</a>
							</c:forEach>
						</div>
					</div>
					<div class="col-md-9 column">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>