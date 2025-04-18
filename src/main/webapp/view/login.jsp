<%--
  Created by IntelliJ IDEA.
  User: Nischal Koirala
  Date: 4/18/2025
  Time: 3:00 PM
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            background-color: #f4f4f4;
        }
        form {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input, button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            font-size: 0.9em;
        }
        .success {
            color: green;
            font-size: 0.9em;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .loading {
            display: none;
            text-align: center;
            color: #555;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<h2>Login</h2>

<form id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
    <input type="email" name="email" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit" id="submitButton">Login</button>

    <p class="loading" id="loadingMessage">Processing...</p>
    <p class="success">
        <% if (request.getParameter("registerSuccess") != null) { %>
        Registration successful! Please login below.
        <% } %>
    </p>
    <p class="error">${error}</p>
</form>

<p style="text-align: center;">
    Don't have an account? <a href="${pageContext.request.contextPath}/view/register.jsp">Register here</a>.
</p>

<script>
    document.getElementById('loginForm').addEventListener('submit', function(e) {
        const emailInput = document.querySelector('input[name="email"]');
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(emailInput.value)) {
            e.preventDefault();
            alert('Please enter a valid email address.');
            return;
        }
        // Show loading message
        document.getElementById('loadingMessage').style.display = 'block';
        document.getElementById('submitButton').disabled = true;
    });
</script>
</body>
</html>