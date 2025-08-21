package com.example.reactivestream.repository;

import com.example.reactivestream.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.net.http.HttpResponse;
import java.sql.*;

@Repository
public class EmployeeRepository {

    private final DataSource dataSource;

    public EmployeeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Employee getEmployeeByName(String name) throws SQLException {
        Employee employee = new Employee();
        String sql = "Select employee_id, employee_name, manager_name from enterprise.employees where employee_name = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            employee = new Employee(rs.getString("employee_name"), rs.getString("manager_name"));
        }

        return employee;

    }

    public ResponseEntity<Object> insertIntoEmployees(Employee employee) throws SQLException {
        String sql = "INSERT INTO enterprise.employees(employee_name, manager_name) values" + "('"+employee.getName() +"', '"+employee.getManagerName()+"')";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        try {
            statement.execute(sql);
            return ResponseEntity.ok("{data : Successfully inserted into database}");

        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Exception occurred while inserting into database");
        }
    }

    public ResponseEntity<String> deleteFromEmployees(String name) throws SQLException {
        String sql = "Delete from enterprise.employees where employee_name = " + "'"+name+"'";

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        try {
            statement.execute(sql);
            return ResponseEntity.ok("Successfully deleted from database");

        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Exception occurred while deleting from database");
        }
    }
}
