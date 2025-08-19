package com.example.reactivestream.database.config;

import com.example.reactivestream.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getString("employee_name"),  // DB column
                rs.getString("manager_name")    // DB column
        );
    }
}
