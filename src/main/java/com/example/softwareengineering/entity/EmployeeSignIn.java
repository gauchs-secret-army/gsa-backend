package com.example.softwareengineering.entity;

public class EmployeeSignIn {

    private Integer EmployeeId;
    private String Password;

    public EmployeeSignIn()
    {

    }

    public EmployeeSignIn(Integer employeeId, String password)
    {
        this.EmployeeId = employeeId;
        this.Password = password;
    }

    public Integer getEmployeeID() {
        return EmployeeId;
    }
    public void setEmployeeID(Integer employeeID) {
        this.EmployeeId = employeeID;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
}
