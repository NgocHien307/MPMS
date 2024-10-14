/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.User;

import java.sql.*;

public class DBConnect {

    public Connection conn;

    // Constructor to establish connection when the object is created
    public DBConnect() {}

    // Function to fetch data from the database
    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            // Create a statement object to send SQL commands to the database
            conn = getConnection();
            Statement  stmt = conn.createStatement();

            // Execute the query and get the result set
            rs = stmt.executeQuery(sql);

            if (rs != null) {
                System.out.println("Data fetched successfully");
            } else {
                System.out.println("Failed to fetch data");
            }
        } catch (SQLException e) {
            System.out.println("SQL query execution failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    // Get the database connection
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // Load the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/project_management", "root", "12345678");
    }

    // Function to fetch a User object based on the username
   

    // Main method to test the connection and data retrieval
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println(new DBConnect().getConnection());
    }
}
