package com.practical.employee.controller;

import java.util.List;

import com.practical.employee.Domain.Employee;
import com.practical.employee.model.EmployeeDto;
import com.practical.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/employees")
public class EmployeeController{

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void addEmployee(@RequestBody EmployeeDto employee) throws Exception{
        employeeService.addEmployee(employee);
    }

    @GetMapping( "/{id}")
    public Employee getEmployee(@PathVariable("id") long id) throws Exception{
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getEmployeeByParams(@RequestParam(required = false) String name, @RequestParam(required = false) double fromSalary, @RequestParam(required = false)double toSalary){
        return employeeService.getEmployeeByParam(name, fromSalary, toSalary);
    }



}