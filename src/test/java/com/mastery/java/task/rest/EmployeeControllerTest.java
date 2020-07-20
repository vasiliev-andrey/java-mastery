package com.mastery.java.task.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastery.java.task.config.AppConfiguration;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = AppConfiguration.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeServiceImpl employeeService;

    private static Employee employee;

    @BeforeAll
    private static void setTestEmployeeEntity() {
        employee = new Employee(1L, "Mary", "Jane",
                100, "QA", Gender.FEMALE);
    }

    @Test
    void getAllEmployeesTest() throws Exception {
        List<Employee> allEmployees = Arrays.asList(employee);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allEmployees);
        given(employeeService.getAllEmployees()).willReturn(allEmployees);

        mockMvc
                .perform(
                        get("/getAllEmployees")
                                .content(jsonString)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployeeByIdTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        given(employeeService.getEmployeeById(1L)).willReturn(employee);
        mockMvc
                .perform(
                        get("/getEmployee/{id}", 1L)
                                .content(jsonString)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addEmployeeTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        mockMvc
                .perform(
                        post("/")
                                .content(jsonString)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEmployeeTest() throws Exception {
        mockMvc
                .perform(
                        delete("/deleteEmployee/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void updateEmployee() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        mockMvc
                .perform(
                        put("/updateEmployee")
                                .content(jsonString)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
