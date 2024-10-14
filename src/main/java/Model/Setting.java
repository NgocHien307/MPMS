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
    
    private int settingId;
    private String name;
    private String value;
    private int typeId;
    private int priority;
    private String status;
    private String description;
    private Timestamp createdAt;
    private int createdById;
    private Timestamp updatedAt;
    private int updatedById;

    public Setting() {
    }

    public Setting(int settingId, String name, String value, int typeId, int priority, String status, String description, Timestamp createdAt, int createdById, Timestamp updatedAt, int updatedById) {
        this.settingId = settingId;
        this.name = name;
        this.value = value;
        this.typeId = typeId;
        this.priority = priority;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
        this.createdById = createdById;
        this.updatedAt = updatedAt;
        this.updatedById = updatedById;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(int updatedById) {
        this.updatedById = updatedById;
    }

    @Override
    public String toString() {
        return "Setting{" + "settingId=" + settingId + ", name=" + name + ", value=" + value + ", typeId=" + typeId + ", priority=" + priority + ", status=" + status + ", description=" + description + ", createdAt=" + createdAt + ", createdById=" + createdById + ", updatedAt=" + updatedAt + ", updatedById=" + updatedById + '}';
    }
    
    
    
}
