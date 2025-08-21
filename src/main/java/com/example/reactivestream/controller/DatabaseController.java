package com.example.reactivestream.controller;


import com.example.reactivestream.model.Employee;
import com.example.reactivestream.repository.EmployeeRepository;
import com.example.reactivestream.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class DatabaseController {

    private final EmployeeService employeeService;

    @Autowired
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getCurrentEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{name}")
    public Employee getEmployee(@PathVariable String name) throws SQLException {
        return employeeRepository.getEmployeeByName(name);
    }

    @PostMapping()
    public ResponseEntity<Object> insertIntoEmployees(@RequestBody Employee employee) throws SQLException {
        return employeeRepository.insertIntoEmployees(employee);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteFromEmployees(@PathVariable String name) throws SQLException {
        return employeeRepository.deleteFromEmployees(name);
    }

}
