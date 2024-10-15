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
                user.setUser_id(rs.getInt("user_id"));
                user.setFull_name(rs.getString("full_name"));
                user.setUser_name(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("password"));
                user.setRole_setting_id(rs.getInt("role_setting_id"));
                user.setStatus(rs.getString("status"));
                user.setNote(rs.getString("note"));
                user.setCreated_at(rs.getTimestamp("created_at"));
                user.setCreated_by_id(rs.getInt("created_by_id"));
                user.setUpdated_at(rs.getTimestamp("updated_at"));
                user.setUpdated_by_id(rs.getInt("updated_by_id"));
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
                user.setUser_id(rs.getInt("user_id"));
                user.setFull_name(rs.getString("full_name"));
                user.setUser_name(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("password"));
                user.setRole_setting_id(rs.getInt("role_setting_id"));
                user.setStatus(rs.getString("status"));
                user.setNote(rs.getString("note"));
                user.setCreated_at(rs.getTimestamp("created_at"));
                user.setCreated_by_id(rs.getInt("created_by_id"));
                user.setUpdated_at(rs.getTimestamp("updated_at"));
                user.setUpdated_by_id(rs.getInt("updated_by_id"));
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
            ps.setString(1, user.getFull_name());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole_setting_id());
            ps.setString(7, user.getStatus());
            ps.setString(8, user.getNote());
            ps.setTimestamp(9, user.getCreated_at());
            ps.setInt(10, user.getCreated_by_id());
            ps.setTimestamp(11, user.getUpdated_at());
            ps.setInt(12, user.getUpdated_by_id());
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
            ps.setString(1, user.getFull_name());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole_setting_id());
            ps.setString(7, user.getStatus());
            ps.setString(8, user.getNote());
            ps.setTimestamp(9, user.getCreated_at());
            ps.setInt(10, user.getCreated_by_id());
            ps.setTimestamp(11, user.getUpdated_at());
            ps.setInt(12, user.getUpdated_by_id());
            ps.setInt(13, user.getUser_id());
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
            System.out.println(user.getUser_id()+ " - " + user.getFull_name()+ " " + user.getEmail());
        }
    }
    
}
