/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Allocation {
   
    
    private int allocation_id;
    private int member_id;
    private int project_id;
    private int role_setting_id;
    private Date from_date;
    private Date to_date;
    private float rate;
    private String description;
    private Timestamp created_at;
    private int created_by_id;
    private Timestamp updated_at;
    private int updated_by_id;
    

    public Allocation() {
    }

    public Allocation(int allocation_id, int member_id, int project_id, int role_setting_id, Date from_date, Date to_date, float rate, String description, Timestamp created_at, int created_by_id, Timestamp updated_at, int updated_by_id) {
        this.allocation_id = allocation_id;
        this.member_id = member_id;
        this.project_id = project_id;
        this.role_setting_id = role_setting_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.rate = rate;
        this.description = description;
        this.created_at = created_at;
        this.created_by_id = created_by_id;
        this.updated_at = updated_at;
        this.updated_by_id = updated_by_id;
    }

    public int getAllocation_id() {
        return allocation_id;
    }

    public void setAllocation_id(int allocation_id) {
        this.allocation_id = allocation_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getRole_setting_id() {
        return role_setting_id;
    }

    public void setRole_setting_id(int role_setting_id) {
        this.role_setting_id = role_setting_id;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
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
        return "Allocation{" + "allocation_id=" + allocation_id + ", member_id=" + member_id + ", project_id=" + project_id + ", role_setting_id=" + role_setting_id + ", from_date=" + from_date + ", to_date=" + to_date + ", rate=" + rate + ", description=" + description + ", created_at=" + created_at + ", created_by_id=" + created_by_id + ", updated_at=" + updated_at + ", updated_by_id=" + updated_by_id + '}';
    }
    
    

   
}
