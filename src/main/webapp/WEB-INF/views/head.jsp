<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    
    <style type="text/css">
    	.navbar{
    		border-radius: 0px;
    	}
    	
    	.nofiticaiton{
    		border-bottom: 1px solid #CCCCCC;
    	}
    </style>
    <script type="text/javascript">
    
    	$(function(){
    		
    		$('[data-toggle="popover"]').popover();
    		
    		var pathname = window.location.pathname;
    		
    		if(pathname.indexOf("software") != -1)
    		{
    			$("#software").addClass("active");
    		}
    		
    		if(pathname.indexOf("server") != -1)
    		{
    			$("#server").addClass("active");
    		}
    		
   			$(".glyphicon-bell").popover({
   				"container":"nav",
   				"placement":"bottom",
   				"html":true,
   				"content":$("#tempNofication").html()
       		})
       		
       		$(".glyphicon-bell").mouseover(function(){
       			$(".glyphicon-bell").popover("show");
       		})
       		
       		$(".glyphicon-bell").mouseout(function(){
       			$(".glyphicon-bell").popover("hide");
       		})
       		
       		
        		//$("#notification").html('<ul class="list-group"><li class="list-group-item"><span class="badge">14</span> Cras justo odio</li><li class="list-group-item"><span class="badge">14</span> Cras justo odio</li><li class="list-group-item"><span class="badge">14</span> Cras justo odio</li><li class="list-group-item"><span class="badge">14</span> Cras justo odio</li><li class="list-group-item"><span class="badge">14</span> Cras justo odio</li></ul>')
        		//$("#notification").popover('show');
    			
    		$.post("${domain}/user/gravatar",function(data){
    			var url = "https://www.gravatar.com/avatar/";
    			$("#gravatar").attr("src",url + data + "?d=mm&s=32")
    		})
    		
    	});
    	
    </script>
  
  	<script type="text/template" id="tempNofication">
			<div class="nofiticaiton"> 胡尼玛修改了你添加的服务器Diskstation</div>
			<div class="nofiticaiton"> Cras justo odio</div>
			<div class="nofiticaiton"> Cras justo odio</div>
			<div class="nofiticaiton"> Cras justo odio</div>
			<div class="nofiticaiton"> Cras justo odio</div>
	</div>
	</script>  
</head>

<body>
	<%-- 固定导航栏  navbar-fixed-top --%>
    <nav class="navbar navbar-inverse">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
                <a class="navbar-brand" href="${domain }">Tango</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li id="project"><a href="#">项目 <span class="sr-only">(current)</span></a></li>
                    <li id="document"><a href="<%=request.getContextPath()%>/document">文档</a></li>
                    <li id="server"><a href="<%=request.getContextPath()%>/server">服务器</a></li>
                    <li id="database"><a href="#">数据库</a></li>
                    <li id="software"><a href="<%=request.getContextPath()%>/software">软件</a></li>
                    <li id="onlineTool"><a href="<%=request.getContextPath()%>/onlinetool">在线工具</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li id="notification">
                    	<a href="${domain}/notification"> 
                    		<span class="glyphicon glyphicon-bell" aria-hidden="true" style="font-size: 16px"></span> 
                    		<span class="badge">4</span>
                    	</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="padding-top:10px; padding-bottom: 10px">
                        	<img src="" alt="..." id="gravatar" width="30" height="30" style="border-radius: 50%"/><span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人中心</a></li>
                            <li><a href="#" data-toggle="modal" data-target="#modalSendMessage">发送站内信</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">关于</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="${domain}/sign">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <jsp:include page="modal/send-message-modal.jsp"></jsp:include>
</body>