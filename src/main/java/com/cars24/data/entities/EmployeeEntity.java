package com.cars24.data.entities;

public class EmployeeEntity {
    private int employeeId;
    private String name;
    private String phone;
    private String email;
    private String role;
    private Double salary;

    public EmployeeEntity(int employeeId, String name, String phone, String email, String role, Double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
