package com.mastery.java.task.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {
    @ApiModelProperty(
            value = "The unique Id of employee.",
            required = false,
            position = 1,
            example = "1",
            hidden = false)
    private Long employee_id;

    @NotNull(message = "Employee first name can't be null.")
    @Size(max = 25, message = "Length field should not be greater 25 symbols.")
    @ApiModelProperty(
            value = "The employee's first name.",
            required = true,
            position = 2,
            example = "first_name",
            hidden = false)
    private String first_name;

    @NotNull(message = "Employee last name can't be null.")
    @Size(max = 25, message = "Length field should not be greater 25 symbols.")
    @ApiModelProperty(
            value = "The employee's last name.",
            required = true,
            position = 3,
            example = "last_name",
            hidden = false)
    private String last_name;

    @NotNull(message = "Employee department id can't be null. Value between 0 and 300.")
    @Min(0)
    @Max(300)
    @ApiModelProperty(
            value = "The employee's department id.",
            required = true,
            position = 4,
            example = "100",
            hidden = false)
    private int department_id;

    @NotNull(message = "Employee job title can't be null.")
    @Size(max = 25, message = "Length field should not be greater 25 symbols.")
    @ApiModelProperty(
            value = "The employee's job title.",
            required = true,
            position = 5,
            example = "job title",
            hidden = false)
    private String job_title;

    @NotNull(message = "Employee gender can't be null.")
    @Size(max = 10, message = "Length field should not be greater 10 symbols.")
    @ApiModelProperty(
            value = "The employee's gender.",
            required = true,
            position = 6,
            example = "MALE OR FEMALE",
            hidden = false)
    private Gender gender;

    public Employee() {
    }

    public Employee(Long employee_id, String first_name, String last_name,
                    int department_id, String job_title, Gender gender) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department_id = department_id;
        this.job_title = job_title;
        this.gender = gender;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", department_id=" + department_id +
                ", job_title='" + job_title + '\'' +
                ", gender=" + gender +
                '}';
    }
}
