<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://geeklib.com/functions" prefix="dic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<script src="<%=request.getContextPath()%>/resource/js/vue.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-3-typeahead/4.0.2/bootstrap3-typeahead.js"></script>

<script type="text/javascript">
	$(function(){
		var user = new Vue({
			el : '#modalSendMessage',
			data : {
				user : ''
			}
		})
		
		var availableTags = ["ActionScript1111111111111111111111111111111111111", "AppleScript", "Asp", "BASIC", "C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP", "Python", "Ruby", "Scala", "Scheme"];
		 
		$("#addressee").typeahead({source:availableTags});
		
		$("#btnSendInnerMessage").click(function(){
			var json = {};
			json["message"] = $("#message").val();
			json["receiveUserId"] = 1;
			json["sendUserId"] = 2;
			$.post("<%=request.getContextPath()%>/internalMessage/sendMessage",json,function(){
				
			})
		})
		
	})
</script>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="modalSendMessage" tabindex="-1" role="dialog" aria-labelledby="新增服务器">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">发送站内信 {{ user }}</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="receiveUser">收件人</label> 
						<input type="text" class="form-control" id="receiveUser" placeholder="" v-model="user" data-provide="typeahead">
					</div>
					<div class="form-group">
						<label for="description">信息</label>
						<textarea class="form-control" id="message" placeholder=""></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSendInnerMessage" data-dismiss="modal">发送</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>