package com.mastery.java.task.dao;

import com.mastery.java.task.config.AppConfiguration;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class EmployeeDaoTest {

    @Mock
    private JdbcTemplateEmployeeDaoImpl employeeDao;

    private Employee employee;
    private Long employee_id = 1L;

    @Before
    public void init() {
        employee = new Employee(1L, "Mary", "Jane",
                100, "QA", Gender.FEMALE);
    }

    @Test
    public void getAllEmployeesTest() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee);
        when(employeeDao.getAllEmployees()).thenReturn(employeeList);

        List<Employee> list = employeeDao.getAllEmployees();
        assertTrue(list.size() == 2);
    }

    @Test
    public void getEmployeeByIdTest() {
        when(employeeDao.getEmployeeById(employee_id)).thenReturn(employee);
        Employee employee = employeeDao.getEmployeeById(1L);
        assertNotNull(employee);
    }

    @Test
    public void deleteEmployeeByIdTest() {
        employeeDao.deleteEmployeeById(employee_id);
        assertFalse(employee.getEmployee_id() == null);
    }

    @Test
    public void addEmployeeTest() {
        doNothing().when(employeeDao).addEmployee(any(Employee.class));
        employeeDao.addEmployee(employee);
        assertTrue(employee.getEmployee_id() == 1L);
    }

    @Test
    public void updateEmployeeTest() {
        employeeDao.updateEmployee(employee);
        Employee employee = new Employee(2L, "Mary", "Jane",
                100, "QA", Gender.FEMALE);
        assertTrue(employee.getEmployee_id() == 2L);
    }

}
