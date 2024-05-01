<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<style>
.header, .footer {
	background-color: #cce6ff;
	width: 100%;
	padding: 10px;
	text-align: center;
}

body {
	background-color: #ffccdd;
	display: flex;
	flex-direction: column;
	justify-content: left;
	align-items: center;
	height: 100vh;
	margin: 0;
}
</style>
</head>
<body>
	<div class="header">
		<h1>HEADER CONTENT</h1>
	</div>
	<h1>welcome</h1>
	<h1>${responseMessage}</h1>
	<div class="footer">
		<h1>FOOTER CONTENT</h1>
	</div>
</body>
</html>