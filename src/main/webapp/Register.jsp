<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>To Register</title>

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

        .header, .footer {
            background-color: #cce6ff;
            width: 100%;
            padding: 10px;
            text-align: center;
        }

        input[type="number"], input[type="text"] {
            width: 100%;
            padding: 5px;
        }

        .login-link p a {
            color: #001f3f;
            text-decoration: none;
            font-weight: 600;
            font-size: 16px;
        }

        .login-link p a:hover {
            color: royalblue;
            text-decoration: underline;
        }
    </style>

    <script>
        function validate() {
            const username = document.getElementById("username").value;
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;
            const cnfPassword = document.getElementById("cnfPassword").value;
            const phone = document.getElementById("phone").value;
            const gender = document.querySelector('input[name="gender"]:checked');
            const dob = document.getElementById("dob");

            const usernameRegex = /^[a-zA-Z0-9]{3,15}$/;
            const phoneRegex = /^[6-9]{1}[0-9]{9}$/;

            if (username === "") {
                alert("Please enter a valid username (3-15 alphanumeric characters).");
                return false;
            } else if (!usernameRegex.test(username)) {
                alert("Please enter a valid username (3-15 alphanumeric characters).");
                return false;
            } else if (!/(?=.*[a-z])/.test(username)) {
                alert("Please enter at least one lowercase alphabet in the username.");
                return false;
            } else if (!/(?=.*[A-Z])/.test(username)) {
                alert("Please choose at least one uppercase alphabet in the username.");
                return false;
            } else if (!/(?=.*\d)/.test(username)) {
                alert("Please maintain at least one digit in the username.");
                return false;
            }

            if (email === "") {
                alert("Please enter valid Email...");
                return false;
            }

            if (password.length < 8) {
                alert("Password should be at least 8 characters.");
                return false;
            } else if (!/(?=.*[a-z])/.test(password)) {
                alert("Please enter at least one lowercase alphabet in the password.");
                return false;
            } else if (!/(?=.*[A-Z])/.test(password)) {
                alert("Please choose at least one uppercase alphabet in the password.");
                return false;
            } else if (!/(?=.*\d)/.test(password)) {
                alert("Please maintain at least one digit in the password.");
                return false;
            }

            if (password !== cnfPassword) {
                alert("Passwords do not match.");
                return false;
            }

            if (!phoneRegex.test(phone)) {
                alert("Please enter a valid 10-digit phone number starting with 6-9.");
                return false;
            }

            if (!gender) {
                alert("Please select a gender.");
                return false;
            }

            if (!dob.value) {
                alert("Please select a date of birth.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="header">
    <h1>HEADER CONTENT</h1>
</div>
<br>
<div class="form-container">
    <h1>REGISTER FORM</h1>
    <form action="${pageContext.request.contextPath}/registerVaccine" method="post" onsubmit="return validate()">
        <table>
            <tr>
                <th>USERNAME</th>
                <td><input id="username" type="text" name="username" placeholder="USERNAME" required></td>
            </tr>
            <tr>
                <th>PASSWORD</th>
                <td><input id="password" type="password" name="password" placeholder="PASSWORD" required></td>
            </tr>
            <tr>
                <th>CONFIRM PASSWORD</th>
                <td><input id="cnfPassword" type="password" name="cnfPassword" placeholder="CONFIRM PASSWORD"
                           required></td>
            </tr>
            <tr>
                <th>EMAIL</th>
                <td><input id="email" type="text" name="email" placeholder="EMAIL" required></td>
            </tr>
            <tr>
                <th>MOBILE_NO</th>
                <td><input id="phone" type="text" name="mobileNo" placeholder="MOBILE_NO" required></td>
            </tr>
            <tr>
                <th>GENDER</th>
                <td>
                    <input id="genderMale" type="radio" name="gender" value="male">
                    Male
                    <input id="genderFemale" type="radio" name="gender" value="female">
                    Female
                    <input id="genderOther" type="radio" name="gender" value="other">
                    Other
                </td>
            </tr>
            <tr>
                <th>DOB</th>
                <td><input id="dob" type="date" name="dob" required></td>
            </tr>
        </table>
        <button type="submit">Register</button>
    </form>
    <div class="login-link">
        <p>
            Already have an account? <a href="login">Login </a>
        </p>
    </div>
    <h1>${responseMessage}</h1>
</div>

<div class="footer">
    <h1>FOOTER CONTENT</h1>
</div>
</body>
</html>
