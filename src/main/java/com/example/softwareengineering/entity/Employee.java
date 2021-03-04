package com.example.softwareengineering.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private Integer EmployeeID;
    private String password;
    private String LastName;
    private String FirstName;
    private Boolean Active;
    private String Role;
    private Integer ManagerID;
    public Employee() {
    }
    public Employee(Integer employeeID, String lastName, String firstname, String password, Boolean active, String role, Integer managerID) {
        this.EmployeeID = employeeID;
        this.FirstName = firstname;
        this.LastName = lastName;
        this.password = password;
        this.Active = active;
        this.Role = role;
        this.ManagerID = managerID;
    }

    public Employee(Integer employeeID, String lastName, String firstname, String password, String role, Integer managerID) {
        this.EmployeeID = employeeID;
        this.FirstName = firstname;
        this.LastName = lastName;
        this.password = password;
        this.Active = true;
        this.Role = role;
        this.ManagerID = managerID;
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
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
}