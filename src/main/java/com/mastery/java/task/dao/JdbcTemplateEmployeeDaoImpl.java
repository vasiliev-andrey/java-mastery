package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcTemplateEmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addEmployee(Employee employee) {
        String SQL = "INSERT INTO EMPLOYEE (first_name, last_name, department_id, job_title, gender) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(SQL, employee.getFirst_name(), employee.getLast_name(), employee.getDepartment_id(),
                employee.getJob_title(), String.valueOf(employee.getGender()));
        System.out.println("Employee successfully created.");
    }

    @Override
    public Employee getEmployeeById(Long id) {
        String SQL = "SELECT * FROM EMPLOYEE WHERE employee_id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(SQL, rowMapper, id);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String SQL = "SELECT * FROM EMPLOYEE";

        return jdbcTemplate.query(SQL, new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee e = new Employee();
                e.setEmployee_id(rs.getLong(1));
                e.setFirst_name(rs.getString(2));
                e.setLast_name(rs.getString(3));
                e.setDepartment_id(rs.getInt(4));
                e.setJob_title(rs.getString(5));
                e.setGender(Gender.valueOf(rs.getString(6)));
                return e;
            }
        });
    }

    @Override
    public void updateEmployee(Employee employee) {
        String SQL = "UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=? WHERE employee_id=?";

        jdbcTemplate.update(SQL, employee.getFirst_name(), employee.getLast_name(), employee.getDepartment_id(),
                employee.getJob_title(), String.valueOf(employee.getGender()), employee.getEmployee_id());
        System.out.println("Employee successfully updated.");
    }

    @Override
    public void deleteEmployeeById(Long id) {
        String SQL = "DELETE FROM EMPLOYEE WHERE employee_id=?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Employee successfully deleted.");
    }
}
