package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeDao {

    public void addEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public List<Employee> getAllEmployees();

    public void updateEmployee(Employee employee);

    public void deleteEmployeeById(Long id);

}
