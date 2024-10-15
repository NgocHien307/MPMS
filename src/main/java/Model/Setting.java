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
public class Setting {

//    setting_id INT PRIMARY KEY AUTO_INCREMENT,
//    name VARCHAR(255) NOT NULL,
//    value TEXT,
//    type_id INT,
//    priority INT,
//    status ENUM('active', 'inactive') DEFAULT 'active',
//    description TEXT,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    created_by_id INT,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//    updated_by_id INT

    private int setting_id;
    private String name;
    private String value;
    private int type_id;
    private int priority;
    private String status;
    private String description;
    private Timestamp created_at;
    private int created_by_id;
    private Timestamp updated_at;
    private int updated_by_id;


    public Setting() {
    }

    public Setting(int setting_id, String name, String value, int type_id, int priority, String status, String description, Timestamp created_at, int created_by_id, Timestamp updated_at, int updated_by_id) {
        this.setting_id = setting_id;
        this.name = name;
        this.value = value;
        this.type_id = type_id;
        this.priority = priority;
        this.status = status;
        this.description = description;
        this.created_at = created_at;
        this.created_by_id = created_by_id;
        this.updated_at = updated_at;
        this.updated_by_id = updated_by_id;
    }

    public int getSetting_id() {
        return setting_id;
    }

    public void setSetting_id(int setting_id) {
        this.setting_id = setting_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
        return "Setting{" + "setting_id=" + setting_id + ", name=" + name + ", value=" + value + ", type_id=" + type_id + ", priority=" + priority + ", status=" + status + ", description=" + description + ", created_at=" + created_at + ", created_by_id=" + created_by_id + ", updated_at=" + updated_at + ", updated_by_id=" + updated_by_id + '}';
    }
}
