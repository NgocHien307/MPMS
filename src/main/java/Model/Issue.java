/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author hient
 */
public class Issue {

    
    private int issue_id;
    private String title;
    private int type_setting_id;
    private int req_id;
    private int assigner_id;
    private int assignee_id;
    private Date deadline;
    private String status;
    private Timestamp status_date;
    private String description;
    private Timestamp created_at;
    private int created_by_id;
    private Timestamp updated_at;
    private int updated_by_id;

    public Issue() {
    }

    public Issue(int issue_id, String title, int type_setting_id, int req_id, int assigner_id, int assignee_id, Date deadline, String status, Timestamp status_date, String description, Timestamp created_at, int created_by_id, Timestamp updated_at, int updated_by_id) {
        this.issue_id = issue_id;
        this.title = title;
        this.type_setting_id = type_setting_id;
        this.req_id = req_id;
        this.assigner_id = assigner_id;
        this.assignee_id = assignee_id;
        this.deadline = deadline;
        this.status = status;
        this.status_date = status_date;
        this.description = description;
        this.created_at = created_at;
        this.created_by_id = created_by_id;
        this.updated_at = updated_at;
        this.updated_by_id = updated_by_id;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType_setting_id() {
        return type_setting_id;
    }

    public void setType_setting_id(int type_setting_id) {
        this.type_setting_id = type_setting_id;
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public int getAssigner_id() {
        return assigner_id;
    }

    public void setAssigner_id(int assigner_id) {
        this.assigner_id = assigner_id;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStatus_date() {
        return status_date;
    }

    public void setStatus_date(Timestamp status_date) {
        this.status_date = status_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Issue{" + "issue_id=" + issue_id + ", title=" + title + ", type_setting_id=" + type_setting_id + ", req_id=" + req_id + ", assigner_id=" + assigner_id + ", assignee_id=" + assignee_id + ", deadline=" + deadline + ", status=" + status + ", status_date=" + status_date + ", description=" + description + ", created_at=" + created_at + ", created_by_id=" + created_by_id + ", updated_at=" + updated_at + ", updated_by_id=" + updated_by_id + '}';
    }
    

}
