/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author hient
 */
public class User {

    
    private int user_id;
    private String full_name;
    private String user_name;
    private String email;
    private String mobile;
    private String password;
    private int role_setting_id;
    private String status;
    private String note;
    private Timestamp created_at;
    private int created_by_id;
    private Timestamp updated_at;
    private int updated_by_id;
    private String verification_code; // Thêm trường mã xác thực email
    private String otp;

    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_MANAGER = 2;
    public static final int ROLE_PROJECT_MANAGER = 3;
    public static final int ROLE_MEMBER = 4;
    public static final int ROLE_GUEST = 5;

    public User() {
    }

    public User(int user_id, String full_name, String user_name, String email, String mobile, String password, int role_setting_id, String status, String note, Timestamp created_at, int created_by_id, Timestamp updated_at, int updated_by_id, String verification_code, String otp) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.user_name = user_name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.role_setting_id = role_setting_id;
        this.status = status;
        this.note = note;
        this.created_at = created_at;
        this.created_by_id = created_by_id;
        this.updated_at = updated_at;
        this.updated_by_id = updated_by_id;
        this.verification_code = verification_code;
        this.otp = otp;
    }

    // Phương thức lấy tên vai trò
    public String getRoleName() {
        switch (this.role_setting_id) {
            case ROLE_ADMIN:
                return "Admin";
            case ROLE_MANAGER:
                return "Manager";
            case ROLE_PROJECT_MANAGER:
                return "Project Manager";
            case ROLE_MEMBER:
                return "Member";
            case ROLE_GUEST:
                return "Guest";
            default:
                return "Unknown";
        }
    }

    // Phương thức kiểm tra vai trò
    public boolean hasRole(String roleName) {
        return roleName.equalsIgnoreCase(this.getRoleName());
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_setting_id() {
        return role_setting_id;
    }

    public void setRole_setting_id(int role_setting_id) {
        this.role_setting_id = role_setting_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public int getCreated_by_id() {
        return created_by_id;
    }

    public void setCreated_by_id(int created_by_id) {
        this.created_by_id = created_by_id;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public int getUpdated_by_id() {
        return updated_by_id;
    }

    public void setUpdated_by_id(int updated_by_id) {
        this.updated_by_id = updated_by_id;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", full_name=" + full_name + ", user_name=" + user_name + ", email=" + email + ", mobile=" + mobile + ", password=" + password + ", role_setting_id=" + role_setting_id + ", status=" + status + ", note=" + note + ", created_at=" + created_at + ", created_by_id=" + created_by_id + ", updated_at=" + updated_at + ", updated_by_id=" + updated_by_id + ", verification_code=" + verification_code + ", otp=" + otp + '}';
    }
}
