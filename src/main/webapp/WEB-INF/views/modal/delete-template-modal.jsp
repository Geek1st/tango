<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通用删除确认对话框模板</title>

<style type="text/css">
	#modalDelete .modal-body{
		padding:0px 0px 15px 0px ;
	}
	
	#modalDelete .alert {
	    margin-bottom: 20px;
	    border-bottom: 1px solid transparent;
	    border-radius: 0px;
	}
	
	#modalDelete .alert-warning{
	    color: #735c0f;
	    background-color: #ffea7f;
	    border-color: rgba(176,136,0,0.3);
	}
/* 	.modal-backdrop {
		opacity: 0 !important;
		filter: alpha(opacity=0) !important;
	} */
</style>
<script type="text/javascript">
	/**
	 * 用于确认删除的模态框，通过用户输入文本进行确认删除，适用于需要慎重删除的场景
	 * @author Geek1st
	 * @param title 模态框标题
	 * @param body 模态框内容
	 * @param expect 期待用户输入的值
	 * @param size 模态框的宽度，可以省略，默认457px
	 */
	function deleteConfirm(object)
	{
		var $button = $("#modalDelete .modal-body button");
		
		$("#modalDelete .modal-title").text(object.title);
		$("#modalDelete .modal-body .row:eq(0)").find(".col-md-12").text(object.body);
		$("#modelDelete .modal-dialog").css("width", object.size ? object.size : "457px")
		$("#modalDelete").modal("show");
		
		$button.click(function(){
			$("#modalDelete").modal("hide");
			object.callback();
		});
		
		$("#modalDelete .modal-body input").on("input",function(){
			console.log($(this).val())
			if($(this).val() == object.expect){
				$button.removeAttr("disabled");
			}else{
				$button.attr("disabled","disabled");
			}
		})
		
		$("#modalDelete").on("hidden.bs.modal",function(){
			$("#modalDelete .modal-body input").val("");
			$button.attr("disabled","disabled");
		})
	}
</script>
</head>
<body>
	<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="width:457px;height:200px">
			<div class="modal-content" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalDeleteTitle"></h4>
				</div>
				<div class="modal-body">
					<div class="alert alert-warning" role="alert">如果你不读这个，意外的事情会发生！</div>
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
							</div>
						</div>
						<br/>
						<div class="row">
							<div class="col-md-12">
								<input type="text" class="form-control">
							</div>
							<div class="col-md-12">
								<div style="height:5px"></div>
								<button type="button" class="btn btn-danger btn-block" disabled>我已理解，确认删除</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>