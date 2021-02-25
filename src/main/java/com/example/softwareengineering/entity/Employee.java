package com.example.softwareengineering.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private Integer EmployeeID;
    private String Password;
    private String LastName;
    private String FirstName;
    private Boolean Active;
    private String Role;
    private Integer ManagerID;
    private Date CreatedOn;
    public Employee() {
    }
    public Employee(String lastName, String firstname, String password, Boolean active, String role, Integer managerID, Date createdOn) {
        this.LastName = lastName;
        this.FirstName = firstname;
        this.Password = password;
        this.Active = active;
        this.Role = role;
        this.ManagerID = managerID;
        this.CreatedOn = createdOn;
    }
    public Integer getEmployeeID() {
        return EmployeeID;
    }
    public void setEmployeeID(Integer employeeID) {
        this.EmployeeID = employeeID;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
    public Boolean getActive() {
        return Active;
    }
    public void setActive(Boolean active) {
        this.Active = active;
    }
    public String getRole() { return Role; }
    public void setRole(String role) { this.Role = role; }
    public Integer getManagerID() { return ManagerID; }
    public void setManagerID(Integer managerID) { this.ManagerID = managerID; }
    public Date getCreatedOn() { return CreatedOn; }
    public void setCreatedOn(Date createdOn) { this.CreatedOn = createdOn; }
}