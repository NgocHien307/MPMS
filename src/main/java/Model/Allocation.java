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
public class Allocation {
    
    private int allocationId;
    private int memberId;
    private int projectId;
    private int roleId;
    private Date fromDate;
    private Date toDate;
    private float effort;
    private String description;
    private Timestamp createdAt;
    private int createdById;
    private Timestamp updatedAt;
    private int updatedById;

    public Allocation() {
    }

    public Allocation(int allocationId, int memberId, int projectId, int roleId, Date fromDate, Date toDate, float effort, String description, Timestamp createdAt, int createdById, Timestamp updatedAt, int updatedById) {
        this.allocationId = allocationId;
        this.memberId = memberId;
        this.projectId = projectId;
        this.roleId = roleId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.effort = effort;
        this.description = description;
        this.createdAt = createdAt;
        this.createdById = createdById;
        this.updatedAt = updatedAt;
        this.updatedById = updatedById;
    }

    public int getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(int allocationId) {
        this.allocationId = allocationId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public float getEffort() {
        return effort;
    }

    public void setEffort(float effort) {
        this.effort = effort;
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
        return "Allocation{" + "allocationId=" + allocationId + ", memberId=" + memberId + ", projectId=" + projectId + ", roleId=" + roleId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", effort=" + effort + ", description=" + description + ", createdAt=" + createdAt + ", createdById=" + createdById + ", updatedAt=" + updatedAt + ", updatedById=" + updatedById + '}';
    }
    
    
    
    
}
