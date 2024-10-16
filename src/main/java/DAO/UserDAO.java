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


    //check login
    public static User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
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
        String sql = "INSERT INTO user(full_name, user_name, email, mobile, password, role_setting_id, status, note, created_at, created_by_id, updated_at, updated_by_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
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
                user.setNote(rs.getString("note"));
                user.setCreated_at(rs.getTimestamp("created_at"));
                user.setCreated_by_id(rs.getInt("created_by_id"));
                user.setUpdated_at(rs.getTimestamp("updated_at"));
                user.setUpdated_by_id(rs.getInt("updated_by_id"));
                user.setVerification_code(rs.getString("verification_code"));
                user.setOtp(rs.getString("otp"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Cập nhật trạng thái và mã xác thực email
    public void updateVerificationCode(int userId, String verificationCode) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET verification_code = ?, status = 'unverified' WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, verificationCode);
            ps.setInt(2, userId);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Cập nhật trạng thái sau khi xác thực email
    public void verifyUserEmail(String email) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET status = 'active' WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật OTP
    public void updateOtp(int userId, String otp) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET otp = ? WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, otp);
            ps.setInt(2, userId);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xác thực OTP
    public boolean validateOtp(int userId, String otp) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT otp FROM user WHERE user_id = ?";
        boolean isValid = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String storedOtp = rs.getString("otp");
                if (storedOtp != null && storedOtp.equals(otp)) {
                    isValid = true;
                    // Xóa OTP sau khi xác thực thành công
                    updateOtp(userId, null);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    // Kiểm tra email đã được xác thực chưa
    public boolean isEmailVerified(String email) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT status FROM user WHERE email = ?";
        boolean isVerified = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                if ("active".equalsIgnoreCase(status)) {
                    isVerified = true;
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isVerified;
    }

    // Đăng nhập: Kiểm tra email và mật khẩu
    public User authenticateUser(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM user WHERE email = ?";
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                // So sánh mật khẩu đã mã hóa
                if (PasswordUtility.checkPassword(password, storedPassword)) {
                    user = new User();
                    user.setUser_id(rs.getInt("user_id"));
                    user.setFull_name(rs.getString("full_name"));
                    user.setUser_name(rs.getString("user_name"));
                    user.setEmail(rs.getString("email"));
                    user.setMobile(rs.getString("mobile"));
                    user.setPassword(storedPassword);
                    user.setRole_setting_id(rs.getInt("role_setting_id"));
                    user.setStatus(rs.getString("status"));
                    user.setNote(rs.getString("note"));
                    user.setCreated_at(rs.getTimestamp("created_at"));
                    user.setCreated_by_id(rs.getInt("created_by_id"));
                    user.setUpdated_at(rs.getTimestamp("updated_at"));
                    user.setUpdated_by_id(rs.getInt("updated_by_id"));
                    user.setVerification_code(rs.getString("verification_code"));
                    user.setOtp(rs.getString("otp"));
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByEmailAndPassword(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
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
    
    public String getRoleNameBySettingId(int roleSettingId) throws SQLException, ClassNotFoundException {
    Connection connection = new DBConnect().getConnection();
    String sql = "SELECT name FROM setting WHERE setting_id = ? AND type = 'user_role'";
    String roleName = "";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, roleSettingId);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            roleName = rs.getString("name");
        }
        connection.close();
    } catch (SQLException e){
        e.printStackTrace();
    }
    return roleName;
}

         //method getRoleSettingIdByNameAndType
         public int getRoleSettingIdByNameAndType(String roleName, String type) throws SQLException, ClassNotFoundException {
             Connection connection = new DBConnect().getConnection();
             String sql = "SELECT setting_id FROM setting WHERE name = ? AND type = ?";
             int settingId = 0;
             try {
                 PreparedStatement ps = connection.prepareStatement(sql);
                 ps.setString(1, roleName);
                 ps.setString(2, type);
                 ResultSet rs = ps.executeQuery();
                 if(rs.next()){
                     settingId = rs.getInt("setting_id");
                 }
                 connection.close();
             } catch (SQLException e){
                 e.printStackTrace();
             }
             return settingId;
         }

    public void updateUserStatus(int userId, String newStatus, int updatedById) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET status = ?, updated_at = CURRENT_TIMESTAMP, updated_by_id = ? WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newStatus);
            ps.setInt(2, updatedById);
            ps.setInt(3, userId);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //method updateUserStatusByEmail
    public void updateUserStatusByEmail(String email, String newStatus) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE user SET status = ? WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newStatus);
            ps.setString(2, email);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //method checkEmailExists
    public boolean checkEmailExists(String email) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM user WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Trả về true nếu có kết quả
        } finally {
            connection.close();
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
