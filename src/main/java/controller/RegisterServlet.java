package controller;

import dao.UserDAO;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String roleParam = request.getParameter("role");

        // Convert role string to enum
        User.Role role = User.Role.user; // default role
        if (roleParam != null && roleParam.equalsIgnoreCase("admin")) {
            role = User.Role.admin;
        }

        // Create User object
        User newUser = new User(name, email, password, role, null);

        // Register user
        int userId = UserDAO.registerUser(newUser);

        if (userId != -1) {
            // Registration successful — redirect to login
            response.sendRedirect("login.jsp?registerSuccess=true");
        } else {
            // Registration failed
            request.setAttribute("error", "Registration failed. Try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    // Optional: Redirect GET requests to the register page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
}