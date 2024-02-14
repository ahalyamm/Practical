package com.practical.employee.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.practical.employee.Domain.Employee;
import com.practical.employee.Repositories.EmployeeRepository;
import com.practical.employee.model.EmployeeDto;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public void addEmployee(EmployeeDto employee) throws IOException, Exception{
        System.out.println("Reached here...");
        System.out.println("Emloooyee.."+employee.getFirstName());
        Employee emp = new Employee();
        emp.setId(1);
        emp.setFirstName(employee.getFirstName());
        employeeRepository.addPerson(emp);
    }

}
