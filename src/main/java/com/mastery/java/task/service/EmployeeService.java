package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;


public interface EmployeeService {
    public void addEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public List<Employee> getAllEmployees();

    public void updateEmployee(Employee employee);

    public void deleteEmployeeById(Long id);
}
