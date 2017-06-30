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
<title>登陆头条</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<style type="text/css">
.main {
	margin: auto;
	padding: 50px;
	width: 500px;
	background-color: aquamarine;
	background: url(img/loginbg.jpg);
	background-size: 500px 260px;
}

.out {
	padding: 100px;
	margin: auto;
	width: 800px;
	height: 500px;
}

img {
	height: 100%;
	width: 100%;
}
</style>
<script>
	function check() {
		var flag = true;
		var account = document.getElementById("account").value;
		var password = document.getElementById("password").value;
		var account = document.getElementById("account");
		var password = document.getElementById("password");
		if (account.value.match(" ")) {
			alert("输入框不能有空格")
			return false;
		} else if (password.value.match(" ")) {
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
		}
		if (flag == true) {
			return true;
		}
	}
</script>
</head>

<body>
	<div>
		<a href="./home.html"><img src="img/logo2.png"
			style="width: 150px; float: left;" /></a>
	</div>
	<div class="out">
		<div class="main">
			<form class="form-horizontal" action="${path }/user/login" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="account" name="account"
							placeholder="请输入账号">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="password"
							placeholder="请输入密码">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default" onclick="check()">登陆</button>
						<button type="reset" class="btn btn-default">重置</button>
						<a href="./register.html"><button type="button"
								class="btn btn-default">注册</button></a>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>

</html>