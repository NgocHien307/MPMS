/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.*;
import java.sql.*;
import java.util.*;

public class RequirementDAO {

    //get all requirements
    public List<Requirement> getAllRequirements() {
        List<Requirement> requirements = new ArrayList<>();
        try {
            DBConnect db = new DBConnect();
            ResultSet rs = db.getData("SELECT * FROM requirement");
            while (rs.next()) {
                Requirement requirement = new Requirement();
                requirement.setReq_id(rs.getInt("req_id"));
                requirement.setTitle(rs.getString("title"));
                requirement.setOwner_id(rs.getInt("owner_id"));
                requirement.setComplexity_setting_id(rs.getInt("complexity_setting_id"));
                requirement.setStatus_id(rs.getInt("status_id"));
                requirement.setDescription(rs.getString("description"));
                requirement.setCreated_at(rs.getTimestamp("created_at"));
                requirement.setCreated_by_id(rs.getInt("created_by_id"));
                requirement.setUpdated_at(rs.getTimestamp("updated_at"));
                requirement.setUpdated_by_id(rs.getInt("updated_by_id"));
                requirements.add(requirement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requirements;
    }

    //get requirement by id
    public Requirement getRequirementById(int req_id) {
        Requirement requirement = new Requirement();
        try {
            DBConnect db = new DBConnect();
            ResultSet rs = db.getData("SELECT * FROM requirement WHERE req_id = " + req_id);
            while (rs.next()) {
                requirement.setReq_id(rs.getInt("req_id"));
                requirement.setTitle(rs.getString("title"));
                requirement.setOwner_id(rs.getInt("owner_id"));
                requirement.setComplexity_setting_id(rs.getInt("complexity_setting_id"));
                requirement.setStatus_id(rs.getInt("status_id"));
                requirement.setDescription(rs.getString("description"));
                requirement.setCreated_at(rs.getTimestamp("created_at"));
                requirement.setCreated_by_id(rs.getInt("created_by_id"));
                requirement.setUpdated_at(rs.getTimestamp("updated_at"));
                requirement.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requirement;
    }

    // add new requirement
    public void addRequirement(Requirement requirement) {

    }
}
