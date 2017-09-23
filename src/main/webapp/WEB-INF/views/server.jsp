<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://geeklib.com/functions" prefix="dic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>服务器</title>

<script src="${domain}/resource/js/jquery-2.1.4.js"></script>
<script src="${domain}/resource/js/bootstrap.min.js"></script>
<script src="${domain}/resource/js/bootstrap-table.min.js"></script>
<script src="${domain}/resource/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${domain }/resource/json/server-table-config.json"></script>
<script src="${domain}/resource/js/global.js"></script>

<link rel="stylesheet" href="${domain}/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="${domain}/resource/css/bootstrap-table.min.css">
<link rel="stylesheet" href="${domain}/resource/css/global.css"/>

<script type="text/javascript">
	$(function() {
		
		$("#toolbarGroupEdit").hide();
		
		//初始化表格
		$("#table").bootstrapTable(setting);
		//保存按钮单机事件
		/* $("#btnSave").click(function(){
			
			$("#form").validator();
			
			var json = {};
			json["name"] = $("#serverName").val();
			json["address"] = $("#serverAddress").val()
			json["username"] = $("#serverUsername").val()
			json["password"] = $("#serverPassword").val()
			json["type"] = $("#serverType").val()
			json["projectId"] = $("#projectId").val()
			json["description"] = $("#other").val()
			
			$.post("${domain}/server/insert.do", json,function(data){
				$("#table").bootstrapTable('refresh', {
					url : "${domain}/server/listServer.do"
				})
			});
		}) */
		
		/**
		 * 编辑按钮单击事件
		 */		
		$("#btnEdit").click(function(){
			
			var setting = $("#table").bootstrapTable("getOptions");
			setting.detailView = false;
			$("#table").bootstrapTable("refreshOptions",setting);
			
			$("#toolbarGroupEdit").show();
			$("#toolbarGroupDefault").hide();
			$("#table").bootstrapTable("showColumn","_checkbox");
			//$("#table").bootstrapTable("showColumn","_btnEdit");
			
		})
		
		/**
		 * 删除按钮单击事件
		 */
		$("#btnDelete").click(function(){
			var servers = $("#table").bootstrapTable("getSelections");
			
			var json = [];
			for(var i in servers){
				json.push({"id":servers[i].id})
			}
			
			var title = "你绝对确认吗？"
			var body = "此操作无法撤消。 这将永久删除服务器，请输入服务器的名称以进行确认。";
			var expect = servers[0].name;
			deleteConfirm({"title":title,"body":body,"expect":expect,"callback":function(){
				$.ajax({
					type : "POST",
					url : "<%=request.getContextPath()%>/server/delete.do",
					contentType : "application/json;charset=utf-8",
					data : JSON.stringify(json),
					success:function(){
						$("#table").bootstrapTable('refresh', {
							url : "<%=request.getContextPath()%>/server/listServer.do"
						})
					}
				})
			}})
				
		})
		
		/**
		 * 编辑单条数据单击事件
		 */
		$("#table").on("click",".glyphicon-pencil",function(){
			alert();
		})
		
		/**
		 * 完成按钮单击事件
		 */
		$("#btnComplete").click(function(){
			
			var setting = $("#table").bootstrapTable("getOptions");
			setting.detailView = true;
			$("#table").bootstrapTable("refreshOptions",setting);
			
			$("#toolbarGroupEdit").hide();
			$("#toolbarGroupDefault").show();
			$("#table").bootstrapTable("hideColumn","_checkbox");
			//$("#table").bootstrapTable("hideColumn","_btnEdit");
			
		})
		
		
		
		var webSocket = new WebSocket("ws://developer.geeklib.com/Notification");
		
		webSocket.onopen = function(event){
			console.log(event)
		}

		webSocket.onmessage = function(event){

			console.log(JSON.stringify(event.data))
			var data = JSON.parse(event.data);
			console.log(JSON.stringify(event.data))
			new Notification(data.title,{"body":data.body,icon:"<%=request.getContextPath()%>/resource/image/whatsapp.png"});
			console.log(event)
		}

		webSocket.onclose = function(event){
			console.log(event);
			webSocket.close();
		}

		webSocket.onerror = function(event){
			console.log(event)
		}

		if (navigator.serviceWorker.controller) {
		    navigator.serviceWorker.controller.postMessage({
		      command: 'oneWayCommunication',
		      message: 'Hi, SW'
		    });
		  }
		
/* 		$('#modalAddServer').on('shown.bs.modal', function() {
			$('#serverAddress').focus()
		}) */
		
		
		/* $("#table").on("dbl-click-cell.bs.table",function(field, value, row, $element){
			alert(JSON.stringify(field));
			alert("value:" + value);
			alert("row :" + row);
			alert(JSON.stringify($element));
		}) */
		
		/* Notification.requestPermission( function(status) {
			  console.log(status); // 仅当值为 "granted" 时显示通知
			  var n = new Notification("項目：web-standard", {body: "用戶：anonymous 提交了 SignController",icon:"123"}); // 显示通知
			}); */
		
		/* $("#table").on("dbl-click-cell.bs.table",function(field, value, row, $element){
			alert(JSON.stringify(field));
			alert("value:" + value);
			alert("row :" + row);
			alert(JSON.stringify($element));
	    }) */
	});
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<jsp:include page="modal/server-modal.jsp"></jsp:include>
	<c:import url="/page/global.jsp"/>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="page-header">
					<h1>
						<small>服务器列表</small>
					</h1>
				</div>
				<div class="btn-toolbar" id="toolbar">
					<div class="btn-group" role="group" aria-label="..." id="toolbarGroupDefault">
						<button class="btn btn-primary" type="button" id="btn_add" data-toggle="modal" data-target="#modalAddServer">
							<em class="glyphicon glyphicon-plus"></em>&nbsp;新增
						</button>
						<button class="btn btn-warning" type="button" id="btnEdit">
							<em class="glyphicon glyphicon-pencil"></em>&nbsp;编辑
						</button>
					</div>
					<div class="btn-group" role="group" id="toolbarGroupEdit">
						<button class="btn btn-danger" type="button" id="btnDelete" >
							<em class="glyphicon glyphicon-remove"></em>&nbsp;删除
						</button>
						<button class="btn btn-success" type="button" id="btnComplete">
							<em class="glyphicon glyphicon-ok"></em>&nbsp;完成
						</button>
					</div>
				</div>
				<table id="table">
				</table>
			</div>
		</div>
	</div>
</body>
</html>