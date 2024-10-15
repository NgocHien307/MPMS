/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.*;
import  java.sql.*;
import java.util.*;
public class RequirementStatusDAO {

    //get all RequirementStatus
    public List<RequirementStatus> getAllRequirementStatus() throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM requirement_status";
        List<RequirementStatus> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RequirementStatus requirementStatus = new RequirementStatus();
                requirementStatus.setStatus_id(rs.getInt("status_id"));
                requirementStatus.setStatus_name(rs.getString("status_name"));
                requirementStatus.setDescription(rs.getString("description"));
                requirementStatus.setCreated_at(rs.getTimestamp("created_at"));
                requirementStatus.setCreated_by_id(rs.getInt("created_by_id"));
                requirementStatus.setUpdated_at(rs.getTimestamp("updated_at"));
                requirementStatus.setUpdated_by_id(rs.getInt("updated_by_id"));
                list.add(requirementStatus);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return list;
    }

    //get RequirementStatus by id
    public RequirementStatus getRequirementStatusById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM requirement_status WHERE status_id = ?";
        RequirementStatus requirementStatus = new RequirementStatus();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                requirementStatus.setStatus_id(rs.getInt("status_id"));
                requirementStatus.setStatus_name(rs.getString("status_name"));
                requirementStatus.setDescription(rs.getString("description"));
                requirementStatus.setCreated_at(rs.getTimestamp("created_at"));
                requirementStatus.setCreated_by_id(rs.getInt("created_by_id"));
                requirementStatus.setUpdated_at(rs.getTimestamp("updated_at"));
                requirementStatus.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requirementStatus;
    }

    //add new RequirementStatus
    public void addRequirementStatus(RequirementStatus requirementStatus) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "INSERT INTO requirement_status(status_name, description, created_at, created_by_id, updated_at, updated_by_id) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, requirementStatus.getStatus_name());
            ps.setString(2, requirementStatus.getDescription());
            ps.setTimestamp(3, requirementStatus.getCreated_at());
            ps.setInt(4, requirementStatus.getCreated_by_id());
            ps.setTimestamp(5, requirementStatus.getUpdated_at());
            ps.setInt(6, requirementStatus.getUpdated_by_id());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update RequirementStatus
    public void updateRequirementStatus(RequirementStatus requirementStatus) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "UPDATE requirement_status SET status_name = ?, description = ?, updated_at = ?, updated_by_id = ? WHERE status_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, requirementStatus.getStatus_name());
            ps.setString(2, requirementStatus.getDescription());
            ps.setTimestamp(3, requirementStatus.getUpdated_at());
            ps.setInt(4, requirementStatus.getUpdated_by_id());
            ps.setInt(5, requirementStatus.getStatus_id());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete RequirementStatus
    public void deleteRequirementStatus(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "DELETE FROM requirement_status WHERE status_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //get RequirementStatus by name
    public RequirementStatus getRequirementStatusByName(String name) throws SQLException, ClassNotFoundException {
        Connection connection = new DBConnect().getConnection();
        String sql = "SELECT * FROM requirement_status WHERE status_name = ?";
        RequirementStatus requirementStatus = new RequirementStatus();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                requirementStatus.setStatus_id(rs.getInt("status_id"));
                requirementStatus.setStatus_name(rs.getString("status_name"));
                requirementStatus.setDescription(rs.getString("description"));
                requirementStatus.setCreated_at(rs.getTimestamp("created_at"));
                requirementStatus.setCreated_by_id(rs.getInt("created_by_id"));
                requirementStatus.setUpdated_at(rs.getTimestamp("updated_at"));
                requirementStatus.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requirementStatus;
    }

    //main method for testing

    
}
