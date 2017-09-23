<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑文章</title>
<script src="../resource/js/template-web.js"></script>
<script src="../resource/js/jquery-2.1.4.js"></script>
<script src="../resource/js/bootstrap.min.js"></script>
<script src="../resource/js/global.js"></script>
<script src="../resource/js/bootstrap-markdown.js"></script>
<script src="../resource/js/marked.js"></script>

<link rel="stylesheet" href="../resource/css/bootstrap.min.css">
<link rel="stylesheet" href="../resource/css/global.css" />
<link rel="stylesheet" href="../resource/css/bootstrap-markdown.min.css" />

<style type="text/css">
	.md-preview{
		padding:30px;
	}
	.md-input{
		padding:30px;
	}
</style>
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form action="../document/save.do" method="post">
					<input name="title" type="text" class="form-control" placeholder="Title?" />
					<br />
					<textarea name="content" data-provide="markdown" rows="25"></textarea>
					<label class="checkbox"> <input name="publish" type="checkbox"> Publish
					</label>
					<hr />
					<button type="submit" class="btn">保存</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>