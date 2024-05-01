<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
</head>
<style>
body {
	background-color: #ffccdd;
	display: flex;
	flex-direction: column;
	justify-content: left;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.form-container {
	background-color: #cce6ff;
	border: 1px solid #ddd;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	text-align: center;
	margin-bottom: 20px;
}

button[type="submit"] {
	background-color: orange;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.header, .footer {
	background-color: #cce6ff;
	width: 100%;
	padding: 10px;
	text-align: center;
}
</style>
<body>
	<div class="header">
		<h1>HEADER CONTENT</h1>
		<form action="register">
			<button type="submit">Register</button>
		</form>
	
	</div>
	<div class="footer">
		<h1>FOOTER CONTENT</h1>
	</div>
</body>
</html>