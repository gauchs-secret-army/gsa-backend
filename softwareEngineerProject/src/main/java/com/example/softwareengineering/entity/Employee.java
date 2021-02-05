package com.example.softwareengineering.entity;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private Integer EmployeeID;
    private String LastName;
    private String FirstName;
    private String Address;
    private String City;
    public Employee() {
    }
    public Employee(String lastName, String firstname, String address, String city) {
        this.LastName = lastName;
        this.FirstName = firstname;
        this.Address = address;
        this.City = city;
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
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        this.Address = address;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        this.City = city;
    }
}