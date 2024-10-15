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
public class Project {
    
// project_id INT PRIMARY KEY AUTO_INCREMENT,
//    name VARCHAR(255) NOT NULL,
//    code VARCHAR(50) NOT NULL UNIQUE,
//    start_date DATE,
//    end_date DATE,
//    dept_setting_id INT, -- References setting
//    status ENUM('pending', 'in-progress', 'closed', 'cancelled') DEFAULT 'pending',
//    description TEXT,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    created_by_id INT,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//    updated_by_id INT,
//    FOREIGN KEY (dept_setting_id) REFERENCES setting(setting_id),
//    FOREIGN KEY (created_by_id) REFERENCES user(user_id),
//    FOREIGN KEY (updated_by_id) REFERENCES user(user_id)
    
    private int project_id;
    private String name;
    private String code;
    private Date start_date;
    private Date end_date;
    private int dept_setting_id;
    private String status;
    private String description;
    private Timestamp created_at;
    private int created_by_id;
    private Timestamp updated_at;
    private int updated_by_id;

    public Project(int project_id, String name, String code, Date start_date, Date end_date, int dept_setting_id, String status, String description, Timestamp created_at, int created_by_id, Timestamp updated_at, int updated_by_id) {
        this.project_id = project_id;
        this.name = name;
        this.code = code;
        this.start_date = start_date;
        this.end_date = end_date;
        this.dept_setting_id = dept_setting_id;
        this.status = status;
        this.description = description;
        this.created_at = created_at;
        this.created_by_id = created_by_id;
        this.updated_at = updated_at;
        this.updated_by_id = updated_by_id;
    }
    
    

    public Project() {
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getDept_setting_id() {
        return dept_setting_id;
    }

    public void setDept_setting_id(int dept_setting_id) {
        this.dept_setting_id = dept_setting_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "Project{" + "project_id=" + project_id + ", name=" + name + ", code=" + code + ", start_date=" + start_date + ", end_date=" + end_date + ", dept_setting_id=" + dept_setting_id + ", status=" + status + ", description=" + description + ", created_at=" + created_at + ", created_by_id=" + created_by_id + ", updated_at=" + updated_at + ", updated_by_id=" + updated_by_id + '}';
    }

    
   

    
    
}
