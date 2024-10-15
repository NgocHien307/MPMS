/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.*;
import java.sql.*;
import java.util.*;


public class ProjectDAO {

    public List<Project> getAllProject() {
        List<Project> projects = new ArrayList<Project>();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project");
            while (rs.next()) {
                Project project = new Project();
                project.setProject_id(rs.getInt("project_id"));
                project.setName(rs.getString("name"));
                project.setCode(rs.getString("code"));
                project.setStart_date(rs.getDate("start_date"));
                project.setEnd_date(rs.getDate("end_date"));
                project.setDept_setting_id(rs.getInt("dept_setting_id"));
                project.setStatus(rs.getString("status"));
                project.setDescription(rs.getString("description"));
                project.setCreated_at(rs.getTimestamp("created_at"));
                project.setCreated_by_id(rs.getInt("created_by_id"));
                project.setUpdated_at(rs.getTimestamp("updated_at"));
                project.setUpdated_by_id(rs.getInt("updated_by_id"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return projects;
    }

    //get project by id
    public Project getProjectById(int id) {
        Project project = new Project();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE project_id = " + id);
            while (rs.next()) {
                project.setProject_id(rs.getInt("project_id"));
                project.setName(rs.getString("name"));
                project.setCode(rs.getString("code"));
                project.setStart_date(rs.getDate("start_date"));
                project.setEnd_date(rs.getDate("end_date"));
                project.setDept_setting_id(rs.getInt("dept_setting_id"));
                project.setStatus(rs.getString("status"));
                project.setDescription(rs.getString("description"));
                project.setCreated_at(rs.getTimestamp("created_at"));
                project.setCreated_by_id(rs.getInt("created_by_id"));
                project.setUpdated_at(rs.getTimestamp("updated_at"));
                project.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return project;
    }

    //add project
    public void addProject(Project project) {
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO project (name, code, start_date, end_date, dept_setting_id, status, description, created_at, created_by_id, updated_at, updated_by_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getCode());
            stmt.setDate(3, project.getStart_date());
            stmt.setDate(4, project.getEnd_date());
            stmt.setInt(5, project.getDept_setting_id());
            stmt.setString(6, project.getStatus());
            stmt.setString(7, project.getDescription());
            stmt.setTimestamp(8, project.getCreated_at());
            stmt.setInt(9, project.getCreated_by_id());
            stmt.setTimestamp(10, project.getUpdated_at());
            stmt.setInt(11, project.getUpdated_by_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //update project
    public void updateProject(Project project) {
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE project SET name = ?, code = ?, start_date = ?, end_date = ?, dept_setting_id = ?, status = ?, description = ?, updated_at = ?, updated_by_id = ? WHERE project_id = ?");
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getCode());
            stmt.setDate(3, project.getStart_date());
            stmt.setDate(4, project.getEnd_date());
            stmt.setInt(5, project.getDept_setting_id());
            stmt.setString(6, project.getStatus());
            stmt.setString(7, project.getDescription());
            stmt.setTimestamp(8, project.getUpdated_at());
            stmt.setInt(9, project.getUpdated_by_id());
            stmt.setInt(10, project.getProject_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //delete project
    public void deleteProject(int id) {
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM project WHERE project_id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //main method for getallproject
    public static void main(String[] args) {
        ProjectDAO projectDAO = new ProjectDAO();
        List<Project> projects = projectDAO.getAllProject();
        for (Project project : projects) {
            System.out.println(project.getProject_id() + " " + project.getName() + " " + project.getCode() + " " + project.getStart_date() + " " + project.getEnd_date() + " " + project.getDept_setting_id() + " " + project.getStatus() + " " + project.getDescription() + " " + project.getCreated_at() + " " + project.getCreated_by_id() + " " + project.getUpdated_at() + " " + project.getUpdated_by_id());
        }
    }


    
}
