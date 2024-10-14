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
    
     private int userId;
    private String fullName;
    private String userName;
    private String email;
    private String mobile;
    private String password;
    private int roleId;
    private String status;
    private String note;
    private Timestamp createdAt;
    private int createdById;
    private Timestamp updatedAt;
    private int updatedById;

    public User() {
    }

    public User(int userId, String fullName, String userName, String email, String mobile, String password, int roleId, String status, String note, Timestamp createdAt, int createdById, Timestamp updatedAt, int updatedById) {
        this.userId = userId;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
        this.note = note;
        this.createdAt = createdAt;
        this.createdById = createdById;
        this.updatedAt = updatedAt;
        this.updatedById = updatedById;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(int updatedById) {
        this.updatedById = updatedById;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", email=" + email + ", mobile=" + mobile + ", password=" + password + ", roleId=" + roleId + ", status=" + status + ", note=" + note + ", createdAt=" + createdAt + ", createdById=" + createdById + ", updatedAt=" + updatedAt + ", updatedById=" + updatedById + '}';
    }
    
    
    
}
