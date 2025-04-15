<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Book Shelf</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #ff7a65;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            position: relative;
            overflow: hidden;
        }

        .background-shape {
            position: absolute;
            bottom: -200px;
            left: -100px;
            width: 800px;
            height: 800px;
            background-color: rgba(255, 255, 255, 0.2);
            border-radius: 50%;
            z-index: 0;
        }

        .card {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 400px;
            padding: 40px;
            z-index: 1;
        }

        .logo {
            text-align: center;
            margin-bottom: 20px;
        }

        .logo h1 {
            font-size: 28px;
            color: #333;
            letter-spacing: 1px;
        }

        .logo span {
            color: #ff7a65;
        }

        .title {
            text-align: center;
            margin-bottom: 5px;
            font-size: 18px;
            color: #333;
        }

        .subtitle {
            text-align: center;
            margin-bottom: 25px;
            font-size: 14px;
            color: #888;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-size: 14px;
        }

        .form-group input {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        .password-field {
            position: relative;
        }

        .password-field .toggle-password {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            color: #888;
        }

        .remember-forgot {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            font-size: 14px;
        }

        .remember {
            display: flex;
            align-items: center;
        }

        .remember input {
            margin-right: 5px;
        }

        .forgot a {
            color: #333;
            text-decoration: none;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background-color: #ff7a65;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            margin-bottom: 20px;
        }

        .footer {
            display: flex;
            justify-content: space-between;
            font-size: 14px;
            color: #333;
        }

        .footer a {
            color: #333;
            text-decoration: none;
        }

        #loginForm, #registerForm {
            display: none;
        }

        .active {
            display: block !important;
        }
    </style>
</head>
<body>
<div class="background-shape"></div>

<div class="card">
    <div class="logo">
        <h1>My <span>Book</span><br>Shelf</h1>
    </div>

    <!-- Login Form -->
    <form id="loginForm" class="active" action="login" method="post">
        <div class="title">Welcome Back !</div>
        <div class="subtitle">Sign in to continue to your Digital Library</div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="username@collegename.ac.in" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <div class="password-field">
                <input type="password" id="password" name="password" placeholder="••••••••" required>
                <span class="toggle-password">👁️</span>
            </div>
        </div>

        <div class="remember-forgot">
            <div class="remember">
                <input type="checkbox" id="remember" name="remember">
                <label for="remember">Remember me</label>
            </div>
            <div class="forgot">
                <a href="#" id="forgotPassword">Forgot password?</a>
            </div>
        </div>

        <button type="submit" class="btn">Login</button>

        <div class="footer">
            <div>New User? <a href="#" id="showRegister">Register Here</a></div>
            <div><a href="guest">Use as Guest</a></div>
        </div>
    </form>

    <!-- Register Form -->
    <form id="registerForm" action="register" method="post">
        <div class="title">Registration</div>
        <div class="subtitle">For Both Staff & Students</div>

        <div class="form-group">
            <label for="emailId">Email ID</label>
            <input type="email" id="emailId" name="emailId" placeholder="username@collegename.ac.in" required>
        </div>

        <div class="form-group">
            <label for="newPassword">Password</label>
            <div class="password-field">
                <input type="password" id="newPassword" name="newPassword" placeholder="••••••••" required>
                <span class="toggle-password">👁️</span>
            </div>
        </div>

        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <div class="password-field">
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="••••••••" required>
                <span class="toggle-password">👁️</span>
            </div>
        </div>

        <button type="submit" class="btn">Register</button>

        <div class="footer">
            <div>Already a User? <a href="#" id="showLogin">Login now</a></div>
            <div><a href="guest">Use as Guest</a></div>
        </div>
    </form>
</div>

<script>
    // Toggle between login and register forms
    document.getElementById('showRegister').addEventListener('click', function(e) {
        e.preventDefault();
        document.getElementById('loginForm').classList.remove('active');
        document.getElementById('registerForm').classList.add('active');
    });

    document.getElementById('showLogin').addEventListener('click', function(e) {
        e.preventDefault();
        document.getElementById('registerForm').classList.remove('active');
        document.getElementById('loginForm').classList.add('active');
    });

    // Toggle password visibility
    const togglePasswordButtons = document.querySelectorAll('.toggle-password');
    togglePasswordButtons.forEach(button => {
        button.addEventListener('click', function() {
            const passwordField = this.previousElementSibling;
            if (passwordField.type === 'password') {
                passwordField.type = 'text';
            } else {
                passwordField.type = 'password';
            }
        });
    });
</script>
</body>
</html>