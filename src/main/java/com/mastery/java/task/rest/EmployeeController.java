package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping
    @ApiOperation(value = "Create a new Employee.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "New employee created."),
            })
    public void addEmployee(@ApiParam(value = "Employee object that should be created.", required = true)
                            @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping(value = "/getEmployee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Find employee by Id.",
            notes = "Provide an Id to look up specific employee from database.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "NOT_FOUND")
            })
    public Employee getEmployeeById(@ApiParam(value = "Id value for employee object you need to retrieve.", required = true)
                                    @PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/getAllEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Gets all employees from database.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "NOT_FOUND")
            })
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping(value = "/updateEmployee")
    @ApiOperation(value = "Update an existing employee by Id.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
            })
    public void updateEmployee(@ApiParam(value = "The employee object, which need to update.", required = true)
                               @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")
    @ApiOperation(
            value = "Delete employee by Id.",
            notes = "Provide an Id to delete specific employee from the database.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 204, message = "NO_CONTENT"),
                    @ApiResponse(code = 404, message = "NOT_FOUND")
            })
    public void deleteEmployee(@ApiParam(value = "Id value for the employee you need to delete.", required = true)
                               @PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
