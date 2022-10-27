package com.example.crudapplication.service;

import com.example.crudapplication.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAlEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);
}
