package com.practical.employee.model;

import com.practical.employee.constants.Department;

public class EmployeeDto{
    private String firstName;

    private String lastName;
    private Department department;
    private long dateOfBirth;
    private long joinDate;
    private Double salary;
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
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
}