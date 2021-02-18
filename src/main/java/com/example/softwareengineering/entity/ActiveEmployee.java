package com.example.softwareengineering.entity;

import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ActiveEmployee")
public class ActiveEmployee {
    @Id
    private Integer RecordID;
    private Integer EmployeeID;
    private String Name;
    private String Role;
    private String SessionKey;
    private Date CreatedOn;
    public ActiveEmployee() {
    }
    public ActiveEmployee(Integer recordID, Integer employeeID, String name, String role, String sessionKey, Date createdOn) {
        this.RecordID = recordID;
        this.EmployeeID = employeeID;
        this.Name = name;
        this.Role = role;
        this.SessionKey = sessionKey;
        this.CreatedOn = createdOn;
    }
    public Integer getRecordID() {
        return RecordID;
    }
    public void setRecordID(Integer recordID) {
        this.RecordID = recordID;
    }
    public Integer getEmployeeID() {
        return EmployeeID;
    }
    public void setEmployeeID(Integer employeeID) {
        this.EmployeeID = employeeID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getRole() {
        return Role;
    }
    public void setRole(String role) {
        this.Role = role;
    }
    public String getSessionKey() {
        return SessionKey;
    }
    public void setSessionKey(String sessionKey) {
        this.SessionKey = sessionKey;
    }
    public Date getCreatedOn() {
        return CreatedOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.CreatedOn = createdOn;
    }
}