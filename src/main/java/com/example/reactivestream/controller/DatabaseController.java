package com.example.reactivestream.controller;


import com.example.reactivestream.model.Employee;
import com.example.reactivestream.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class DatabaseController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getCurrentSymbol(){
        return employeeService.getAllEmployees();
    }
}
