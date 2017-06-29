<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	color: #6a6f8c;
	background: #c8c8c8;
	font: 600 16px/18px 'Open Sans', sans-serif;
}

*, :after, :before {
	box-sizing: border-box
}

.clearfix:after, .clearfix:before {
	content: '';
	display: table
}

.clearfix:after {
	clear: both;
	display: block
}

a {
	color: inherit;
	text-decoration: none;
}

input, button {
	outline: none;
	border: none;
}

.login-wrap {
	width: 100%;
	margin: auto;
	max-width: 525px;
	min-height: 500px;
	position: relative;
	background: url(../img/bg.jpg) no-repeat center;
	box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0
		rgba(0, 0, 0, .19);
}

.login-html {
	width: 100%;
	height: 100%;
	position: absolute;
	padding: 90px 70px 50px 70px;
	background: rgba(40, 57, 101, .9);
}

.login-html .sign-in-htm, .login-html .sign-up-htm {
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	position: absolute;
	-webkit-transform: rotateY(180deg);
	transform: rotateY(180deg);
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
	-webkit-transition: all .4s linear;
	transition: all .4s linear;
}

.login-html .sign-in, .login-html .sign-up, .login-form .group .check {
	display: none;
}

.login-html .tab, .login-form .group .label, .login-form .group .button
	{
	text-transform: uppercase;
}

.login-html .tab {
	font-size: 22px;
	margin-right: 15px;
	padding-bottom: 5px;
	margin: 0 15px 10px 0;
	display: inline-block;
	border-bottom: 2px solid transparent;
}

.login-html .sign-in:checked+.tab, .login-html .sign-up:checked+.tab {
	color: #fff;
	border-color: #1161ee;
}

.login-form {
	min-height: 345px;
	position: relative;
	-webkit-perspective: 1000px;
	perspective: 1000px;
	-webkit-transform-style: preserve-3d;
	transform-style: preserve-3d;
}

.login-form .group {
	margin-bottom: 15px;
}

.login-form .group .label, .login-form .group .input, .login-form .group .button
	{
	width: 100%;
	color: #fff;
	display: block;
}

.login-form .group .input, .login-form .group .button {
	border: none;
	padding: 15px 20px;
	border-radius: 25px;
	background: rgba(255, 255, 255, .1);
}

.login-form .group input[data-type="password"] {
	text-security: circle;
	-webkit-text-security: circle;
}

.login-form .group .label {
	color: #aaa;
	font-size: 12px;
}

.login-form .group .button {
	background: #1161ee;
}

.login-form .group label .icon {
	width: 15px;
	height: 15px;
	border-radius: 2px;
	position: relative;
	display: inline-block;
	background: rgba(255, 255, 255, .1);
}

.login-form .group label .icon:before, .login-form .group label .icon:after
	{
	content: '';
	width: 10px;
	height: 2px;
	background: #fff;
	position: absolute;
	-webkit-transition: all .2s ease-in-out 0s;
	transition: all .2s ease-in-out 0s;
}

.login-form .group label .icon:before {
	left: 3px;
	width: 5px;
	bottom: 6px;
	-webkit-transform: scale(0) rotate(0);
	-ms-transform: scale(0) rotate(0);
	transform: scale(0) rotate(0);
}

.login-form .group label .icon:after {
	top: 6px;
	right: 0;
	-webkit-transform: scale(0) rotate(0);
	-ms-transform: scale(0) rotate(0);
	transform: scale(0) rotate(0);
}

.login-form .group .check:checked+label {
	color: #fff;
}

.login-form .group .check:checked+label .icon {
	background: #1161ee;
}

.login-form .group .check:checked+label .icon:before {
	-webkit-transform: scale(1) rotate(45deg);
	-ms-transform: scale(1) rotate(45deg);
	transform: scale(1) rotate(45deg);
}

.login-form .group .check:checked+label .icon:after {
	-webkit-transform: scale(1) rotate(-45deg);
	-ms-transform: scale(1) rotate(-45deg);
	transform: scale(1) rotate(-45deg);
}

.login-html .sign-in:checked+.tab+.sign-up+.tab+.login-form .sign-in-htm
	{
	-webkit-transform: rotate(0);
	-ms-transform: rotate(0);
	transform: rotate(0);
}

.login-html .sign-up:checked+.tab+.login-form .sign-up-htm {
	-webkit-transform: rotate(0);
	-ms-transform: rotate(0);
	transform: rotate(0);
}

.hr {
	height: 2px;
	margin: 60px 0 50px 0;
	background: rgba(255, 255, 255, .2);
}

.foot-lnk {
	text-align: center;
}
</style>
</head>
<body>
	<div class="jq22-container" style="padding-top: 100px">
		<div class="login-wrap">
			<div class="login-html">
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
					for="tab-1" class="tab">登录</label> <input id="tab-2" type="radio"
					name="tab" class="sign-up"><label for="tab-2" class="tab">注册</label>
				<div class="login-form">
					<div align="center">
						<font color="red"> ${success}</font>
					</div>
					<form action="${path}/admin1/login" method="post">
						<div class="sign-in-htm">
							<div class="group">
								<label for="user" class="label">账号</label> <input id="user"
									type="text" class="input" name="name">
							</div>
							<div class="group">
								<label for="pass" class="label">密码</label> <input
									name="password" id="pass" type="password" class="input"
									data-type="password">
							</div>

							<div class="group">
								<input type="submit" class="button" value="登录">
							</div>
							<div class="hr"></div>
						</div>
					</form>
					<form action="${path}/admin1/register" method="post">
						<div class="sign-up-htm">
							<div class="group">
								<label for="user" class="label">账号</label> <input id="user"
									type="text" class="input" name="name">
							</div>
							<div class="group">
								<label for="pass" class="label">名称</label> <input id="pass"
									type="text" class="input" name="account">
							</div>
							<div class="group">
								<label for="pass" class="label">密码</label> <input
									name="password" id="pass" type="password" class="input"
									data-type="password">
							</div>
							<div class="group">
								<input type="submit" class="button" value="注册">
							</div>
							<div class="hr"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>