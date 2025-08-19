package com.example.reactivestream.service;

import com.example.reactivestream.database.config.EmployeeRowMapper;
import com.example.reactivestream.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Service
public class EmployeeService {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee getEmployee(int employeeId){
        return jdbcTemplate.queryForObject("Select employee_name, manager_name from enterprise.employees", new EmployeeRowMapper());
    }

    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("Select employee_name, manager_name from enterprise.employees", new EmployeeRowMapper());
    }

}
