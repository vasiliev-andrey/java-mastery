package com.mastery.java.task.service;

import com.mastery.java.task.dao.JdbcTemplateEmployeeDaoImpl;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    JdbcTemplateEmployeeDaoImpl employeeDao;

    /**
     * Add employee to database/
     *
     * @param employee - entity of Employee we need to add
     */
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    /**
     * Get employee from database by Id/
     *
     * @param id - id number of requested Employee
     * @return Employee entity from database
     */
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    /**
     * Get all employees from database/
     *
     * @return List of Employee from database
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    /**
     * Update employee in databse by Id.
     *
     * @param employee - entity of Employee we need to update
     */
    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    /**
     * Delete employee from database/
     *
     * @param id - id number of requested Employee
     */
    @Override
    public void deleteEmployeeById(Long id) {
        employeeDao.deleteEmployeeById(id);
    }
}
