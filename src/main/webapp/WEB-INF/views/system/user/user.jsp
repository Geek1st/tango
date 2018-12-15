<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${domain}/resource/css/bootstrap-table.min.css">
<link rel="stylesheet" href="${domain}/resource/css/bootstrap-switch.min.css">
<link rel="stylesheet" href="${domain}/resource/css/bootstrapValidator.min.css"/>
<script src="${domain}/resource/js/bootstrap-table.min.js"></script>
<script src="${domain}/resource/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${domain}/resource/js/bootstrap-switch.min.js"></script>
<script src="${domain}/resource/js/bootstrapValidator.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#table").bootstrapTable({
			"classes" : "table table-bordered table-hover",
			"url" : "${domain}/system/user/",
			"toolbar" : "#toolbar",
			"idField" : "id",
			"uniqueId" : "id",
			"showToggle" : true,
			"showPaginationSwitch" : true,
			"search" : true,
			"showColumns" : true,
			"showRefresh" : true,
			"rowStyle":function(row,index){
				if(index % 2 == 0 && index % 4 != 0 && index % 6 != 0){
					return {"classes":"success"};
				}else if(index % 4 == 0 && index % 6 != 0){
					return {"classes":"warning"};
				}else if(index % 6 == 0){
					return {"classes":"danger"};
				}
				
				return {};
			},
			"columns" : [ {
				"field" : "_checkbox",
				"checkbox" : true,
				"visible" : false,
				"width" : "30px"
			}, {
				"field" : "id",
				"visible" : false,

			}, {
				"field" : "username",
				"title" : "用户名",
			}, {
				"field" : "nickname",
				"title" : "昵称"
			}, {
				"field" : "mobilePhone",
				"title" : "移动电话"
			}, {
				"field" : "gmtCreate",
				"title" : "创建日期"
			}, {
				"field" : "gmtModify",
				"title" : "最后修改日期"
			}, {
				"field" : "locking",
				"title" : "状态",
				"formatter":function(row,index){
					return '<input name="switch" type="checkbox" checked data-size="mini" data-animate="false"/>'; 
				}
			}, {
				"formatter":function(row, index){
					return ''
				}
			} ],
			onPostBody:function(){
				$("[name='switch']").bootstrapSwitch();
			}
		});
		
		$('#form').bootstrapValidator({
            message: '未通过验证',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	username: {
                    message: '用户名未通过验证',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '用户名长度必须介于6~30之间'
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
                nickname: {
                    validators: {
                        notEmpty: {
                            message: '昵称不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '昵称长度必须介于6~30之间'
                        },
                    }
                },
                password:{
                	validators: {
	                	notEmpty: {
	                        message: '密码不能为空'
	                    },
	                    stringLength: {
	                        min: 8,
	                        max: 20,
	                        message: '密码长度必须介于8~20之间'
	                    },
	                    identical:{
                			field: "confirmPassword",
                			message: "两次输入的密码不一致"
                		}
                	}
                },
                confirmPassword:{
                	validators: {
	                	notEmpty: {
	                        message: '密码不能为空'
	                    },
	                    stringLength: {
	                    	min: 8,
	                        max: 20,
	                        message: '密码长度必须介于8~20之间'
	                    },
                		identical:{
                			field: "password",
                			message: "两次输入的密码不一致"
                		}
                	}
                },
                mobilePhone:{
                	validators: {
	                	notEmpty: {
	                        message: '电话不能为空'
	                    },
	                    phone: {
	                    	country : "CN",
	                    	message : "不是有效的手机号码"
	                    }
                	}
                },
                email:{
                	validators: {
	                	notEmpty: {
	                        message: '邮箱不能为空'
	                    },
	                    emailAddress: {
	                    	message : "不是有效的邮箱地址"
	                    }
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
        }).on('success.form.bv', function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function() {
                $("#modal_add_user").modal("hide");
                $("#table").bootstrapTable('refresh', {
					url : "${domain}/system/user/"
				})
				$form
                .bootstrapValidator('disableSubmitButtons', false)  // Enable the submit buttons
                .bootstrapValidator('resetForm', true);             // Reset the form
            });
        });
        
        $("#btn_submit").click(function(){
        	var is = $("#form").data('bootstrapValidator').validate();
        })
        
        $("#modal_add_user").on("hide.bs.modal",function(){
        	$("#form").data('bootstrapValidator').resetForm(true);
        })
	})
	
</script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">用户管理</h1>
	</div>
</div>
<div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    Action<span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">编辑</a></li>
    <li><a href="#">删除</a></li>
    <li><a href="#">查看详细</a></li>
  </ul>
</div>
<div class="btn-group">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Action <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
    <li><a href="#">编辑</a></li>
    <li><a href="#">删除</a></li>
    <li><a href="#">查看详细</a></li>
  </ul>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="btn-toolbar" id="toolbar">
			<div class="btn-group" role="group" aria-label="..."
				id="toolbarGroupDefault">
				<button class="btn btn-primary" type="button" id="btn_add"
					data-toggle="modal" data-target="#modal_add_user">
					<em class="glyphicon glyphicon-plus"></em>&nbsp;新增
				</button>
				<button class="btn btn-warning" type="button" id="btnEdit">
					<em class="glyphicon glyphicon-pencil"></em>&nbsp;编辑
				</button>
			</div>
		</div>
		<table id="table"></table>
		<div id="modal_add_user"class="modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
		    	<div class="modal-content">
		      		<div class="modal-header">
		      			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          			<span aria-hidden="true">&times;</span>
		        		</button>
		        		<h4 class="modal-title">新增用户</h4>
		      		</div>
		      		<div class="modal-body">
		        		<form id="form" action="${domain }/system/user/">
		        			<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="username">用户名</label> 
										<input type="text" class="form-control" name="username" placeholder="用户名">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="nickname">昵称</label> 
										<input type="text" class="form-control" name="nickname" placeholder="昵称">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="password">密码</label> 
										<input type="password" class="form-control" name="password" placeholder="密码" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="confirmPassword">确认密码</label> 
										<input type="password" class="form-control" name="confirmPassword" placeholder="重复密码" required >
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="phone">移动电话</label> 
										<input type="text" class="form-control" name="mobilePhone" placeholder="密码" required >
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="email">电子邮箱</label> 
										<input type="text" class="form-control" name="email" placeholder="密码" required >
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="description">描述信息</label> 
								<textarea  class="form-control" id="description" name="description" placeholder="描述内容"></textarea>
							</div>
		        		</form>
		      		</div>
		      		<div class="modal-footer">
		        		<button id="btn_close" type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
		        		<button id="btn_submit"type="button" class="btn btn-primary">新增</button>
		      		</div>
		      		
		    	</div>
		  	</div>
		</div>
	</div>
</div>
