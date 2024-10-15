/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import Model.DBConnect;
import java.util.List;

/**
 *
 * @author hient
 */
public class UserDAO {

    //get all User
    public List<User> getAllUser() throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM user";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("role_id"));
                user.setStatus(rs.getString("status"));
                user.setNote(rs.getString("note"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedById(rs.getInt("created_by_id"));
                user.setUpdatedAt(rs.getTimestamp("updated_at"));
                user.setUpdatedById(rs.getInt("updated_by_id"));
                list.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return list;
    }

    //get User by id
    public User getUserById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM user WHERE user_id = ?";
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("role_id"));
                user.setStatus(rs.getString("status"));
                user.setNote(rs.getString("note"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedById(rs.getInt("created_by_id"));
                user.setUpdatedAt(rs.getTimestamp("updated_at"));
                user.setUpdatedById(rs.getInt("updated_by_id"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //add User
    public void addUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "INSERT INTO user(full_name," +
                " user_name, email, " +
                "mobile, password, role_id, " +
                "status, note, created_at, created_by_id, " +
                "updated_at, updated_by_id) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRoleId());
            ps.setString(7, user.getStatus());
            ps.setString(8, user.getNote());
            ps.setTimestamp(9, user.getCreatedAt());
            ps.setInt(10, user.getCreatedById());
            ps.setTimestamp(11, user.getUpdatedAt());
            ps.setInt(12, user.getUpdatedById());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Update User
    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET full_name = ?, user_name = ?, email = ?, mobile = ?, password = ?, role_id = ?, status = ?, note = ?, created_at = ?, created_by_id = ?, updated_at = ?, updated_by_id = ? WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRoleId());
            ps.setString(7, user.getStatus());
            ps.setString(8, user.getNote());
            ps.setTimestamp(9, user.getCreatedAt());
            ps.setInt(10, user.getCreatedById());
            ps.setTimestamp(11, user.getUpdatedAt());
            ps.setInt(12, user.getUpdatedById());
            ps.setInt(13, user.getUserId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Delete User
    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "DELETE FROM user WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDAO dao = new UserDAO();
        List<User> list = dao.getAllUser();
        for (User user : list) {
            System.out.println(user.getUserId() + " - " + user.getFullName() + " " + user.getEmail());
        }
    }
    
}
