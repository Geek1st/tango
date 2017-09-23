<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://geeklib.com/functions" prefix="dic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<script src="${domain}/resource/js/bootstrapValidator.min.js"></script>

<link rel="stylesheet" href="${domain}/resource/css/bootstrapValidator.min.css"/>

<script type="text/javascript">
	$(function(){
		$('#form').bootstrapValidator({
            message: '未通过验证',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	name: {
                    message: '服务器名称未通过验证',
                    validators: {
                        notEmpty: {
                            message: '服务器名称不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '服务器名称必须介于6~30之间'
                        },
                        /*remote: {
                            url: 'remote.php',
                            message: 'The username is not available'
                        },*/
                        /* regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: 'The username can only consist of alphabetical, number, dot and underscore'
                        } */
                    }
                },
                address: {
                    validators: {
                        notEmpty: {
                            message: '服务器地址不能为空'
                        },
                        /* emailAddress: {
                            message: 'The input is not a valid email address'
                        } */
                    }
                },
                description: {
                    validators: {
                        notEmpty: {
                            message: '描述内容不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 300,
                            message: '长度不能超过300个字'
                        }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function() {
            	console.log($form.serialize())
                $("#modalAddServer").modal("hide");
                $("#table").bootstrapTable('refresh', {
					url : "${domain}/server/listServer.do"
				})
				$form
                .bootstrapValidator('disableSubmitButtons', false)  // Enable the submit buttons
                .bootstrapValidator('resetForm', true);             // Reset the form
            });
        });
	})
</script>

</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="modalAddServer" tabindex="-1" role="dialog" aria-labelledby="新增服务器">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增服务器</h4>
				</div>
				
				<form id="form" action="${domain}/server/insert.do">
					<div class="modal-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="name">服务器名称</label> 
									<input type="text" class="form-control" id="name" name="name" placeholder="服务器名称">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="serverAddress">服务器地址</label> 
									<input type="text" class="form-control" id="address" name="address" placeholder="服务器地址" required>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="serverUsername">用户名</label> 
									<input type="text" class="form-control" id="serverUsername" name="username" placeholder="用户名" required>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="serverPassword">密码</label> 
									<input type="text" class="form-control" id="serverPassword" name="password" placeholder="密码" required >
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="serverType">服务器类型</label> 
									<select class="form-control" id="serverType" placeholder="服务器类型" name="serverType">
										<c:forEach items="${dic:listServerType()}" var="serverType">
											<option value="${serverType.id}">${serverType.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectId">所属项目</label> <select class="form-control" id="projectId" placeholder="所属项目" name="projectID">
										<c:forEach items="${dic:listProject()}" var="project">
											<option value="${project.id}">${project.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="description">描述信息</label> 
							<textarea  class="form-control" id="description" name="description" placeholder="描述内容"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" id="btnSave">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>