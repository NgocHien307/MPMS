/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.*;
import java.sql.*;
import java.util.*;


public class UserRoleDAO {

    //get all user roles
    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new ArrayList<>();
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "SELECT * FROM user_roles";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                UserRole userRole = new UserRole();
                userRole.setRole_id(rs.getInt("role_id"));
                userRole.setRole_name(rs.getString("role_name"));
                userRole.setDescription(rs.getString("description"));
                userRole.setCreated_at(rs.getTimestamp("created_at"));
                userRole.setCreated_by_id(rs.getInt("created_by_id"));
                userRole.setUpdated_at(rs.getTimestamp("updated_at"));
                userRole.setUpdated_by_id(rs.getInt("updated_by_id"));
                userRoles.add(userRole);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    //get user role by id
    public UserRole getUserRoleById(int role_id) {
        UserRole userRole = new UserRole();
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "SELECT * FROM user_roles WHERE role_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, role_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userRole.setRole_id(rs.getInt("role_id"));
                userRole.setRole_name(rs.getString("role_name"));
                userRole.setDescription(rs.getString("description"));
                userRole.setCreated_at(rs.getTimestamp("created_at"));
                userRole.setCreated_by_id(rs.getInt("created_by_id"));
                userRole.setUpdated_at(rs.getTimestamp("updated_at"));
                userRole.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userRole;
    }

    //add user role
    public void addUserRole(UserRole userRole) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "INSERT INTO user_roles(role_name, description, created_at, created_by_id, updated_at, updated_by_id) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userRole.getRole_name());
            ps.setString(2, userRole.getDescription());
            ps.setTimestamp(3, userRole.getCreated_at());
            ps.setInt(4, userRole.getCreated_by_id());
            ps.setTimestamp(5, userRole.getUpdated_at());
            ps.setInt(6, userRole.getUpdated_by_id());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //update user role
    public void updateUserRole(UserRole userRole) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "UPDATE user_roles SET role_name = ?, description = ?, updated_at = ?, updated_by_id = ? WHERE role_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userRole.getRole_name());
            ps.setString(2, userRole.getDescription());
            ps.setTimestamp(3, userRole.getUpdated_at());
            ps.setInt(4, userRole.getUpdated_by_id());
            ps.setInt(5, userRole.getRole_id());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //delete user role
    public void deleteUserRole(int role_id) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "DELETE FROM user_roles WHERE role_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, role_id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //main method
    public static void main(String[] args) {
        UserRoleDAO userRoleDAO = new UserRoleDAO();

        //test get all user roles
        List<UserRole> userRoles = userRoleDAO.getAllUserRoles();
        for (UserRole userRole : userRoles) {
            System.out.println(userRole.getRole_id() + " - " + userRole.getRole_name() + " - " + userRole.getDescription() + " - " + userRole.getCreated_at() + " - " + userRole.getCreated_by_id() + " - " + userRole.getUpdated_at() + " - " + userRole.getUpdated_by_id());
        }
    }


    
}
