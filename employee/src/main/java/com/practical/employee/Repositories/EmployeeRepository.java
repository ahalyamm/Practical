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

    public EmployeeRepository() {
        gson = new Gson();
        persons = loadPersonsFromFile();
    }

    private List<Employee> loadPersonsFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type personListType = new TypeToken<List<Employee>>() {}.getType();
            return gson.fromJson(reader, personListType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }


    public void addPerson(Employee person) {
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

    public Employee getPerson(int id) {
        for (Employee person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }


}
