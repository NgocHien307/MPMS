/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.*;
import  java.sql.*;
import java.util.*;

public class SettingDAO {

    //get all Setting
    public List<Setting> getAllSetting() throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM setting";
        List<Setting> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Setting setting = new Setting();
                setting.setSetting_id(rs.getInt("setting_id"));
                setting.setName(rs.getString("name"));
                setting.setValue(rs.getString("value"));
                setting.setType_id(rs.getInt("type_id"));
                setting.setPriority(rs.getInt("priority"));
                setting.setStatus(rs.getString("status"));
                setting.setDescription(rs.getString("description"));
                setting.setCreated_at(rs.getTimestamp("created_at"));
                setting.setCreated_by_id(rs.getInt("created_by_id"));
                setting.setUpdated_at(rs.getTimestamp("updated_at"));
                setting.setUpdated_by_id(rs.getInt("updated_by_id"));
                list.add(setting);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return list;
    }

    //get Setting by id
    public Setting getSettingById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM setting WHERE setting_id = ?";
        Setting setting = new Setting();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                setting.setSetting_id(rs.getInt("setting_id"));
                setting.setName(rs.getString("name"));
                setting.setValue(rs.getString("value"));
                setting.setType_id(rs.getInt("type_id"));
                setting.setPriority(rs.getInt("priority"));
                setting.setStatus(rs.getString("status"));
                setting.setDescription(rs.getString("description"));
                setting.setCreated_at(rs.getTimestamp("created_at"));
                setting.setCreated_by_id(rs.getInt("created_by_id"));
                setting.setUpdated_at(rs.getTimestamp("updated_at"));
                setting.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setting;
    }

    //add new Setting
    public void addSetting(Setting setting) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "INSERT INTO setting(name, value, type_id, priority, status, description, created_at, created_by_id, updated_at, updated_by_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, setting.getName());
            ps.setString(2, setting.getValue());
            ps.setInt(3, setting.getType_id());
            ps.setInt(4, setting.getPriority());
            ps.setString(5, setting.getStatus());
            ps.setString(6, setting.getDescription());
            ps.setTimestamp(7, setting.getCreated_at());
            ps.setInt(8, setting.getCreated_by_id());
            ps.setTimestamp(9, setting.getUpdated_at());
            ps.setInt(10, setting.getUpdated_by_id());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update Setting
    public void updateSetting(Setting setting) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE setting SET name = ?, value = ?, type_id = ?, priority = ?, status = ?, description = ?, created_at = ?, created_by_id = ?, updated_at = ?, updated_by_id = ? WHERE setting_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, setting.getName());
            ps.setString(2, setting.getValue());
            ps.setInt(3, setting.getType_id());
            ps.setInt(4, setting.getPriority());
            ps.setString(5, setting.getStatus());
            ps.setString(6, setting.getDescription());
            ps.setTimestamp(7, setting.getCreated_at());
            ps.setInt(8, setting.getCreated_by_id());
            ps.setTimestamp(9, setting.getUpdated_at());
            ps.setInt(10, setting.getUpdated_by_id());
            ps.setInt(11, setting.getSetting_id());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete Setting
    public void deleteSetting(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "DELETE FROM setting WHERE setting_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //get Setting by name
    public Setting getSettingByName(String name) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM setting WHERE name = ?";
        Setting setting = new Setting();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                setting.setSetting_id(rs.getInt("setting_id"));
                setting.setName(rs.getString("name"));
                setting.setValue(rs.getString("value"));
                setting.setType_id(rs.getInt("type_id"));
                setting.setPriority(rs.getInt("priority"));
                setting.setStatus(rs.getString("status"));
                setting.setDescription(rs.getString("description"));
                setting.setCreated_at(rs.getTimestamp("created_at"));
                setting.setCreated_by_id(rs.getInt("created_by_id"));
                setting.setUpdated_at(rs.getTimestamp("updated_at"));
                setting.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setting;
    }

}
