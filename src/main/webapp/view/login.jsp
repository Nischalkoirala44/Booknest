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
    </style>
</head>
<body>
<h2>Login</h2>

<form method="post" action="${pageContext.request.contextPath}/login">
    <input type="email" name="email" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit">Login</button>

    <p class="success">
        <% if (request.getParameter("registerSuccess") != null) { %>
        Registration successful! Please login below.
        <% } %>
    </p>
    <p class="error">${error}</p>
</form>

<p style="text-align: center;">
    Don't have an account? <a href="./register.jsp">Register here</a>.
</p>
</body>
</html>