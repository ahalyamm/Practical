package com.practical.employee.Repositories;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.practical.employee.Domain.Employee;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;

@Repository
public class EmployeeRepository {
    private static final String FILE_PATH = "employee.json";

    private List<Employee> persons;
    private Gson gson;

    // public EmployeeRepository() {
    //     gson = new Gson();
    //     persons = loadPersonsFromFile();
    // }

    private List<Employee> loadPersonsFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type personListType = new TypeToken<List<Employee>>() {}.getType();
            return gson.fromJson(reader, personListType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }


    public void addPerson(Employee person) {
        gson = new Gson();
        persons = loadPersonsFromFile();
        if(!persons.isEmpty())
            person.setId(persons.size()+1);
        else
          person.setId(1);
        persons.add(person);
        savePersonsToFile();
    }

    private void savePersonsToFile() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(persons, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Employee getPerson(long id) throws Exception{
        gson = new Gson();
        persons = loadPersonsFromFile();
        for (Employee person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new Exception("Invalid User Id");
    }

    public List<Employee> getPersonByParam(String name, Double fromSalary, Double toSalary){
        gson = new Gson();
        persons = loadPersonsFromFile();
        List<Employee> emp = new ArrayList<>();
        System.out.println(fromSalary);


        for (Employee person : persons) {


            if(name != null && fromSalary != null && toSalary != null && person.getFirstName().equals(name) && fromSalary<= person.getSalary() && toSalary>= person.getSalary()){
                 emp.add(person);
                 System.out.println("condition1");
                continue;
            }

            if(name != null && fromSalary != null && person.getFirstName().equals(name) && fromSalary<= person.getSalary()){
                System.out.println("condition2");
                emp.add(person);
                continue;
            }

            if(name != null && toSalary != null && person.getFirstName().equals(name) && toSalary>= person.getSalary()){
                System.out.println("condition3");
                emp.add(person);
                continue;
            }


            if(fromSalary != null && toSalary != null && fromSalary<= person.getSalary() && toSalary>= person.getSalary()){
                System.out.println("condition4");
            emp.add(person);
            continue;
                }
            
            if (name != null && person.getFirstName().equals(name)) {
                System.out.println("condition5");
                emp.add(person);
                continue;
            }

            if(fromSalary != null  && fromSalary<= person.getSalary()){
                System.out.println("condition6");
                emp.add(person);
                continue;
            }

            if(toSalary != null  && toSalary>= person.getSalary()){
                System.out.println("condition7");
                emp.add(person);
                continue;
            }
        }
        return emp;
    }




}
