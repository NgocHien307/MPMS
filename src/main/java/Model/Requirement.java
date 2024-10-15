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
public class Requirement {
    
//     req_id INT PRIMARY KEY AUTO_INCREMENT,
//    title VARCHAR(255) NOT NULL,
//    owner_id INT,
//    complexity_id INT,
//    status_id INT,
//    description TEXT,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    created_by_id INT,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//    updated_by_id INT,
//    FOREIGN KEY (owner_id) REFERENCES user(user_id),
//    FOREIGN KEY (complexity_id) REFERENCES requirement_complexity(complexity_id),
//    FOREIGN KEY (status_id) REFERENCES requirement_status(status_id)
    
    private int req_id;
    private String title;
    private int owner_id;
    private int complexity_id;
    private int status_id;
    private String description;
    private Timestamp created_at;
    private int created_by_id;
    private Timestamp updated_at;
    private int updated_by_id;

    public Requirement() {
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getComplexity_id() {
        return complexity_id;
    }

    public void setComplexity_id(int complexity_id) {
        this.complexity_id = complexity_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
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
        return "Requirement{" + "req_id=" + req_id + ", title=" + title + ", owner_id=" + owner_id + ", complexity_id=" + complexity_id + ", status_id=" + status_id + ", description=" + description + ", created_at=" + created_at + ", created_by_id=" + created_by_id + ", updated_at=" + updated_at + ", updated_by_id=" + updated_by_id + '}';
    }
    
    

 
}
