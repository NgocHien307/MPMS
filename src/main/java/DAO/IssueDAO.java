/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.*;

import Model.DBConnect;
import Model.Issue;

public class IssueDAO {

    //get all issues
    public List<Issue> getAllIssues() {
        List<Issue> issues = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM issue";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Issue issue = new Issue();
                issue.setIssue_id(rs.getInt("issue_id"));
                issue.setTitle(rs.getString("title"));
                issue.setType_setting_id(rs.getInt("type_setting_id"));
                issue.setReq_id(rs.getInt("req_id"));
                issue.setAssigner_id(rs.getInt("assigner_id"));
                issue.setAssignee_id(rs.getInt("assignee_id"));
                issue.setDeadline(rs.getDate("deadline"));
                issue.setStatus(rs.getString("status"));
                issue.setStatus_date(rs.getTimestamp("status_date"));
                issue.setDescription(rs.getString("description"));
                issue.setCreated_at(rs.getTimestamp("created_at"));
                issue.setCreated_by_id(rs.getInt("created_by_id"));
                issue.setUpdated_at(rs.getTimestamp("updated_at"));
                issue.setUpdated_by_id(rs.getInt("updated_by_id"));
                issues.add(issue);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return issues;
    }

    //get issue by id
    public Issue getIssueById(int id) {
        Issue issue = new Issue();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM issue WHERE issue_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                issue.setIssue_id(rs.getInt("issue_id"));
                issue.setTitle(rs.getString("title"));
                issue.setType_setting_id(rs.getInt("type_setting_id"));
                issue.setReq_id(rs.getInt("req_id"));
                issue.setAssigner_id(rs.getInt("assigner_id"));
                issue.setAssignee_id(rs.getInt("assignee_id"));
                issue.setDeadline(rs.getDate("deadline"));
                issue.setStatus(rs.getString("status"));
                issue.setStatus_date(rs.getTimestamp("status_date"));
                issue.setDescription(rs.getString("description"));
                issue.setCreated_at(rs.getTimestamp("created_at"));
                issue.setCreated_by_id(rs.getInt("created_by_id"));
                issue.setUpdated_at(rs.getTimestamp("updated_at"));
                issue.setUpdated_by_id(rs.getInt("updated_by_id"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return issue;
    }

    //create issue
    public void createIssue(Issue issue) throws SQLException, ClassNotFoundException {
        Connection conn = new DBConnect().getConnection();
        String sql = "INSERT INTO issue (title, type_setting_id, req_id, " +
                "assigner_id, assignee_id, deadline, status, " +
                "status_date, description, created_at, created_by_id, " +
                "updated_at, updated_by_id) VALUES (?,? ,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, issue.getTitle());
            ps.setInt(2, issue.getType_setting_id());
            ps.setInt(3, issue.getReq_id());
            ps.setInt(4, issue.getAssigner_id());
            ps.setInt(5, issue.getAssignee_id());
            ps.setDate(6, issue.getDeadline());
            ps.setString(7, issue.getStatus());
            ps.setTimestamp(8, issue.getStatus_date());
            ps.setString(9, issue.getDescription());
            ps.setTimestamp(10, issue.getCreated_at());
            ps.setInt(11, issue.getCreated_by_id());
            ps.setTimestamp(12, issue.getUpdated_at());
            ps.setInt(13, issue.getUpdated_by_id());
            ps.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update issue
    public void updateIssue(Issue issue) throws SQLException, ClassNotFoundException {
        Connection conn = new DBConnect().getConnection();
        String sql = "UPDATE issue SET title = ?, type_setting_id = ?, req_id = ?, " +
                "assigner_id = ?, assignee_id = ?, deadline = ?, status = ?, " +
                "status_date = ?, description = ?, created_at = ?, created_by_id = ?, " +
                "updated_at = ?, updated_by_id = ? WHERE issue_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, issue.getTitle());
            ps.setInt(2, issue.getType_setting_id());
            ps.setInt(3, issue.getReq_id());
            ps.setInt(4, issue.getAssigner_id());
            ps.setInt(5, issue.getAssignee_id());
            ps.setDate(6, issue.getDeadline());
            ps.setString(7, issue.getStatus());
            ps.setTimestamp(8, issue.getStatus_date());
            ps.setString(9, issue.getDescription());
            ps.setTimestamp(10, issue.getCreated_at());
            ps.setInt(11, issue.getCreated_by_id());
            ps.setTimestamp(12, issue.getUpdated_at());
            ps.setInt(13, issue.getUpdated_by_id());
            ps.setInt(14, issue.getIssue_id());
            ps.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete issue
    public void deleteIssue(int id) throws SQLException, ClassNotFoundException {
        Connection conn = new DBConnect().getConnection();
        String sql = "DELETE FROM issue WHERE issue_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //get all issues by assignee_id
    public List<Issue> getIssuesByAssigneeId(int assignee_id) {
        List<Issue> issues = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM issue WHERE assignee_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, assignee_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Issue issue = new Issue();
                issue.setIssue_id(rs.getInt("issue_id"));
                issue.setTitle(rs.getString("title"));
                issue.setType_setting_id(rs.getInt("type_setting_id"));
                issue.setReq_id(rs.getInt("req_id"));
                issue.setAssigner_id(rs.getInt("assigner_id"));
                issue.setAssignee_id(rs.getInt("assignee_id"));
                issue.setDeadline(rs.getDate("deadline"));
                issue.setStatus(rs.getString("status"));
                issue.setStatus_date(rs.getTimestamp("status_date"));
                issue.setDescription(rs.getString("description"));
                issue.setCreated_at(rs.getTimestamp("created_at"));
                issue.setCreated_by_id(rs.getInt("created_by_id"));
                issue.setUpdated_at(rs.getTimestamp("updated_at"));
                issue.setUpdated_by_id(rs.getInt("updated_by_id"));
                issues.add(issue);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return issues;
    }

    //get all issues by assigner_id
    public List<Issue> getIssuesByAssignerId(int assigner_id) {
        List<Issue> issues = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM issue WHERE assigner_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, assigner_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Issue issue = new Issue();
                issue.setIssue_id(rs.getInt("issue_id"));
                issue.setTitle(rs.getString("title"));
                issue.setType_setting_id(rs.getInt("type_setting_id"));
                issue.setReq_id(rs.getInt("req_id"));
                issue.setAssigner_id(rs.getInt("assigner_id"));
                issue.setAssignee_id(rs.getInt("assignee_id"));
                issue.setDeadline(rs.getDate("deadline"));
                issue.setStatus(rs.getString("status"));
                issue.setStatus_date(rs.getTimestamp("status_date"));
                issue.setDescription(rs.getString("description"));
                issue.setCreated_at(rs.getTimestamp("created_at"));
                issue.setCreated_by_id(rs.getInt("created_by_id"));
                issue.setUpdated_at(rs.getTimestamp("updated_at"));
                issue.setUpdated_by_id(rs.getInt("updated_by_id"));
                issues.add(issue);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return issues;
    }

    //get all issues by req_id
    public List<Issue> getIssuesByReqId(int req_id) {
        List<Issue> issues = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM issue WHERE req_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, req_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Issue issue = new Issue();
                issue.setIssue_id(rs.getInt("issue_id"));
                issue.setTitle(rs.getString("title"));
                issue.setType_setting_id(rs.getInt("type_setting_id"));
                issue.setReq_id(rs.getInt("req_id"));
                issue.setAssigner_id(rs.getInt("assigner_id"));
                issue.setAssignee_id(rs.getInt("assignee_id"));
                issue.setDeadline(rs.getDate("deadline"));
                issue.setStatus(rs.getString("status"));
                issue.setStatus_date(rs.getTimestamp("status_date"));
                issue.setDescription(rs.getString("description"));
                issue.setCreated_at(rs.getTimestamp("created_at"));
                issue.setCreated_by_id(rs.getInt("created_by_id"));
                issue.setUpdated_at(rs.getTimestamp("updated_at"));
                issue.setUpdated_by_id(rs.getInt("updated_by_id"));
                issues.add(issue);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return issues;
    }

    //get all issues by type_setting_id
    public List<Issue> getIssuesByTypeSettingId(int type_setting_id) {
        List<Issue> issues = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM issue WHERE type_setting_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, type_setting_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Issue issue = new Issue();
                issue.setIssue_id(rs.getInt("issue_id"));
                issue.setTitle(rs.getString("title"));
                issue.setType_setting_id(rs.getInt("type_setting_id"));
                issue.setReq_id(rs.getInt("req_id"));
                issue.setAssigner_id(rs.getInt("assigner_id"));
                issue.setAssignee_id(rs.getInt("assignee_id"));
                issue.setDeadline(rs.getDate("deadline"));
                issue.setStatus(rs.getString("status"));
                issue.setStatus_date(rs.getTimestamp("status_date"));
                issue.setDescription(rs.getString("description"));
                issue.setCreated_at(rs.getTimestamp("created_at"));
                issue.setCreated_by_id(rs.getInt("created_by_id"));
                issue.setUpdated_at(rs.getTimestamp("updated_at"));
                issue.setUpdated_by_id(rs.getInt("updated_by_id"));
                issues.add(issue);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return issues;
    }

    //main method to test the getIssuesByTypeSettingId
    public static void main(String[] args) {
        IssueDAO issueDAO = new IssueDAO();
        List<Issue> issues = issueDAO.getAllIssues();
        for (Issue issue : issues) {
            System.out.println(issue.getIssue_id() + " " + issue.getTitle() + " " + issue.getType_setting_id() + " " + issue.getReq_id() + " " + issue.getAssigner_id() + " " + issue.getAssignee_id() + " " + issue.getDeadline() + " " + issue.getStatus() + " " + issue.getStatus_date() + " " + issue.getDescription() + " " + issue.getCreated_at() + " " + issue.getCreated_by_id() + " " + issue.getUpdated_at() + " " + issue.getUpdated_by_id());
        }
    }

}
