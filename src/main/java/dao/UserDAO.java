package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    // SQL query to insert a new user into the database
    public static final String INSERT_USER = "INSERT INTO users(name,email,password,role, profile_picture) VALUES(?,?,?,?, ?)";

    // SQL query to select a user by email and password for authentication
    public static final String SELECT_USER_BY_EMAIL_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?";

    // SQL query to select a user by ID
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String INITIAL_USER = "";

    public static int registerUser(User user) {
        try (Connection connection = DBConnection.getDbConnection();
             PreparedStatement ps = connection.prepareStatement(INITIAL_USER, PreparedStatement.RETURN_GENERATED_KEYS);) {
            // Set parameters for the prepared statement
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword()); // In production, this should be hashed
            ps.setString(4, user.getRole().name());
            ps.setBytes(5, user.getImage());

            // Execute the insert statement
            int rows = ps.executeUpdate();

            // If insertion was successful, get the generated user ID
            if (rows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            // Log the exception details for debugging
            System.err.println("Error registering user: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return -1; // Return -1 to indicate registration failure
    }

    public static User loginUser(User user) {
        try (Connection connection = DBConnection.getDbConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_EMAIL_PASSWORD);) {
            // Set parameters for the prepared statement
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword()); // In production, use password hashing

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // If a matching user is found, create and return a User object
            if (rs.next()) {
                User userFromDB = new User();
                userFromDB.setUserId(rs.getInt("id"));
                userFromDB.setName(rs.getString("name"));
                userFromDB.setEmail(rs.getString("email"));
                userFromDB.setPassword(rs.getString("password"));
                userFromDB.setRole(User.Role.valueOf(rs.getString("role")));
                userFromDB.setImage(rs.getBytes("profile_picture"));
                return userFromDB;
            }
        } catch (SQLException e) {
            // Log the exception details for debugging
            System.err.println("Error authenticating user: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return null; // Return null if authentication fails
    }

    public static User getUserById(int id) {
        try (Connection connection = DBConnection.getDbConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);) {
            // Set the user ID parameter
            ps.setInt(1, id);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // If the user is found, create and return a User object
            if (rs.next()) {
                User userFromDB = new User();
                userFromDB.setUserId(rs.getInt("id"));
                userFromDB.setName(rs.getString("name"));
                userFromDB.setEmail(rs.getString("email"));
                userFromDB.setPassword(rs.getString("password"));
                userFromDB.setRole(User.Role.valueOf(rs.getString("role")));
                userFromDB.setImage(rs.getBytes("profile_picture"));
                return userFromDB;
            }
        } catch (SQLException e) {
            // Log the exception details for debugging
            System.err.println("Error retrieving user by ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return null; // Return null if user not found
    }
}

