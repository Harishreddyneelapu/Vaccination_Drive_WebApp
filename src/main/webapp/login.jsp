<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To login</title>
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

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	font-weight: bold;
}

button[type="submit"] {
	background-color: orange;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.header{
	background-color: #cce6ff;
	width: 100%;
	padding: 10px;
	text-align: center;
}
.footer {
	background-color: #cce6ff;
	width: 100%;
	padding: 10px;
	text-align: center;
	bottom:0;
	position:fixed;
}

input[type="number"], input[type="text"] {
	width: 100%;
	padding: 5px;
}
</style>
</head>
<body>
	<div class="header">
		<h1>HEADER CONTENT</h1>
	</div>
	<br>
	<br>
	<form class="form-container" action="userLogin">
		<table>
			<tr>
				<th>EMAIL</th>
				<td><input id="email" type="text" name="email"
					placeholder="EMAIL" required></td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input id="password" type="password" name="password"
					placeholder="PASSWORD" required></td>
			</tr>

		</table>
		<button type="submit">LOGIN</button>
		<br> <a href="forgotPasswordUrl">ForgotPassword</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;
		<a href="registerNewUser">To Register</a>
	</form>

	<h1>${responseMessage}</h1>
	<div class="header">
		<h1>FOOTER CONTENT</h1>
	</div>
</body>
</html>