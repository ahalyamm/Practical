package com.practical.employee.Domain;

import com.practical.employee.constants.Department;

public class Employee {
    private long id;
    private String firstName;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public long getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public long getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(long joinDate) {
        this.joinDate = joinDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    private String lastName;
    private Department department;
    private long dateOfBirth;
    private long joinDate;
    private double salary;

}
