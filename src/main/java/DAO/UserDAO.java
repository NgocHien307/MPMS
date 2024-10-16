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

    public String getRoleNameById(int roleSettingId) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT name FROM setting WHERE setting_id = ? AND type = 'user_role'";
        String roleName = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roleSettingId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                roleName = rs.getString("name");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleName;
    }

    public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user WHERE email = ?";
        User user = null;

        try (Connection connection = new DBConnect().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("password");
                    if (PasswordUtility.checkPassword(password, hashedPassword)) {
                        user = new User();
                        user.setUser_id(rs.getInt("user_id"));
                        user.setFull_name(rs.getString("full_name"));
                        user.setUser_name(rs.getString("user_name"));
                        user.setEmail(rs.getString("email"));
                        user.setMobile(rs.getString("mobile"));
                        user.setPassword(hashedPassword);
                        user.setRole_setting_id(rs.getInt("role_setting_id"));
                        user.setStatus(rs.getString("status"));
                        user.setCreated_at(rs.getTimestamp("created_at"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để servlet xử lý
        }

        return user;
    }


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

    public void addUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "INSERT INTO user(full_name, user_name, email, mobile, password, role_setting_id, status, created_at, otp) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFull_name());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole_setting_id());
            ps.setString(7, user.getStatus());
            ps.setTimestamp(8, user.getCreated_at());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //Update User
    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET full_name = ?, user_name = ?, email = ?, mobile = ?, password = ?, role_setting_id = ?, status = ?, note = ?, created_at = ?, created_by_id = ?, updated_at = ?, updated_by_id = ? WHERE user_id = ?";
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
    public int getRoleSettingIdByName(String roleName) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT setting_id FROM setting WHERE name = ? AND type = 'user_role'";
        int roleSettingId = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, roleName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                roleSettingId = rs.getInt("setting_id");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleSettingId;
    }


    // Lấy người dùng theo email
    public User getUserByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM user WHERE email = ?";
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setFull_name(rs.getString("full_name"));
                user.setUser_name(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("password"));
                user.setRole_setting_id(rs.getInt("role_setting_id"));
                user.setStatus(rs.getString("status"));
                user.setCreated_at(rs.getTimestamp("created_at"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    // Cập nhật trạng thái người dùng và xóa OTP
    public void updateUserStatusAndOtp(User user) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET status = ?, otp = ? WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getStatus());
            ps.setNull(2, java.sql.Types.VARCHAR); // Xóa OTP
            ps.setInt(3, user.getUser_id());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Cập nhật OTP cho người dùng
    public void updateUserOtp(String email, String otp) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET otp = ? WHERE email = ?";

        try (Connection connection = new DBConnect().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, otp);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Cập nhật mật khẩu mới
    public void updateUserPassword(String email, String newHashedPassword) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET password = ?, otp = NULL WHERE email = ?";

        try (Connection connection = new DBConnect().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, newHashedPassword);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }



}
