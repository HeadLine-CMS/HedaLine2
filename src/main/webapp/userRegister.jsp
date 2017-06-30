<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<style type="text/css">
.out {
	width: 800px;
	margin: auto;
	padding: 100px;
}

.main {
	width: 500px;
	margin: auto;
	padding: 50px;
	background: url(img/register.jpg) repeat scroll top left;
	background-size: 500px 325px;
}
</style>
<script type="text/javascript">
	function check() {
		var flag = true;
		var account = document.getElementById("account").value;
		var password = document.getElementById("password").value;
		var name = document.getElementById("name").value;
		var account = document.getElementById("account");
		var password = document.getElementById("password");
		var name = document.getElementById("name");
		if (account.value.match(" ")) {
			alert("输入框不能有空格")
			return false;
		} else if (password.value.match(" ")) {
			alert("输入框不能有空格")
			return false;
		} else if (name.value.match(" ")) {
			alert("输入框不能有空格")
			return false;
		} else if ("" == account) {
			alert("请输入账号！");
			flag = false;
			return false;
		} else if ("" == password) {
			alert("请输入密码！");
			flag = false;
			return false;
		} else if ("" == name) {
			alert("请输入名称！");
			flag = false;
			return false;
		}
		if (flag == true) {
			return true;
		}
	}
</script>
</head>

<body style="background-color: #E8E8E8;">
	<div>
		<a href="./home.html"><img src="img/logo2.png"
			style="width: 150px; float: left;" /></a>
	</div>
	<div class="out">
		<div class="main">
			<form class="form-horizontal" action="${path }/user/register" method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="account" name="headaccount"
							placeholder="请设置账号">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="headpassword"
							placeholder="请设置登陆密码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="headname"
							placeholder="请输入姓名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="请设置邮箱">
					</div>
				</div>
				<!-- <div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">头像</label>
					<div class="col-sm-10">
						<input type="file" id="exampleInputFile">
					</div>
				</div> -->
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" onclick="check()">提交申请</button>
					<a href="./login.html"><button type="button"
							class="btn btn-default">返回登陆</button></a>
				</div>
		</div>
		</form>
	</div>
	</div>

</body>

</html>