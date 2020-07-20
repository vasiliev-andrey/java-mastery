package com.mastery.java.task.service;

import com.mastery.java.task.dao.JdbcTemplateEmployeeDaoImpl;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    JdbcTemplateEmployeeDaoImpl employeeDao;

    List<Employee> employeeList = new ArrayList<>();
    private Employee employee;
    private Long employee_id = 1L;

    @Before
    public void init() {
        employee = new Employee(1L, "Mary", "Jane",
                100, "QA", Gender.FEMALE);
    }

    @Test
    public void addEmployeeTest() {
        doNothing().when(employeeDao).addEmployee(any(Employee.class));
        when((employeeDao).getEmployeeById(employee_id)).thenReturn(employee);

        employeeService.addEmployee(employee);
        Employee acturalEmployee = employeeService.getEmployeeById(employee_id);

        ArgumentCaptor<Employee> employeeArgument = ArgumentCaptor.forClass(Employee.class);

        verify(employeeDao, times(1)).addEmployee(employeeArgument.capture());
        verify(employeeDao, times(1)).getEmployeeById(employee_id);
        verifyNoMoreInteractions(employeeDao);

        assertEmployee(acturalEmployee, employee);
    }

    @Test
    public void getEmployeeByIdTest() {
        when(employeeDao.getEmployeeById(employee_id)).thenReturn(employee);

        Employee actualEmployee = employeeService.getEmployeeById(employee_id);

        assertEmployee(employee, actualEmployee);

        verify(employeeDao, times(1)).getEmployeeById(employee_id);
        verifyNoMoreInteractions(employeeDao);
    }

    @Test
    public void getAllEmployeesTest() {
        employeeList.add(employee);

        when(employeeDao.getAllEmployees()).thenReturn(employeeList);

        List<Employee> actualList = employeeService.getAllEmployees();

        assertEquals(employeeList.size(), actualList.size());
        assertEquals(employeeList.size(), 1);
        assertEmployee(employeeList.get(0), employee);
        verify(employeeDao, times(1)).getAllEmployees();
        verifyNoMoreInteractions(employeeDao);
    }

    @Test
    public void updateEmployeeTest() {
        doNothing().when(employeeDao).updateEmployee(employee);
        when((employeeDao).getEmployeeById(employee_id)).thenReturn(employee);

        employeeDao.updateEmployee(employee);
        Employee actualEmployee = employeeService.getEmployeeById(employee_id);

        assertEmployee(employee, actualEmployee);
        verify(employeeDao, times(1)).updateEmployee(employee);
        verify(employeeDao, times(1)).getEmployeeById(employee_id);
        verifyNoMoreInteractions(employeeDao);
    }

    @Test
    public void deleteEmployeeById() {
        doNothing().when(employeeDao).deleteEmployeeById(employee_id);

        employeeService.deleteEmployeeById(employee_id);

        verify(employeeDao, times(1)).deleteEmployeeById(employee_id);
        verifyNoMoreInteractions(employeeDao);
    }

    private void assertEmployee(Employee expected, Employee actual) {
        assertEquals(expected.getFirst_name(), actual.getFirst_name());
    }
}
