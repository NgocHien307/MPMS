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
    
//    issue_id INT PRIMARY KEY AUTO_INCREMENT,
//    title VARCHAR(255) NOT NULL,
//    type_id INT,
//    req_id INT,
//    assigner_id INT,
//    assignee_id INT,
//    deadline DATE,
//    status ENUM('pending', 'to do', 'doing', 'done', 'closed') DEFAULT 'pending',
//    status_date TIMESTAMP,
//    description TEXT,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    created_by_id INT,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//    updated_by_id INT,
//    FOREIGN KEY (type_id) REFERENCES issue_types(type_id),
//    FOREIGN KEY (req_id) REFERENCES requirement(req_id),
//    FOREIGN KEY (assigner_id) REFERENCES user(user_id),
//    FOREIGN KEY (assignee_id) REFERENCES user(user_id)
    
    private int issue_id;
    private String title;
    private int type_id;
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

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
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
        return "Issue{" + "issue_id=" + issue_id + ", title=" + title + ", type_id=" + type_id + ", req_id=" + req_id + ", assigner_id=" + assigner_id + ", assignee_id=" + assignee_id + ", deadline=" + deadline + ", status=" + status + ", status_date=" + status_date + ", description=" + description + ", created_at=" + created_at + ", created_by_id=" + created_by_id + ", updated_at=" + updated_at + ", updated_by_id=" + updated_by_id + '}';
    }
      
}
