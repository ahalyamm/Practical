package com.practical.employee.controller;

import com.practical.employee.model.EmployeeDto;
import com.practical.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController{

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void addEmployee(@RequestBody EmployeeDto employee) throws Exception{
        employeeService.addEmployee(employee);
    }
}