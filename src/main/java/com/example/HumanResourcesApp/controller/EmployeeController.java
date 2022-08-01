package com.example.HumanResourcesApp.controller;


import com.example.HumanResourcesApp.entity.Employer;
import com.example.HumanResourcesApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired

    EmployeeService employeeService;

    @RequestMapping(value = "/employees")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(employeeService.getEmployers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Employer employer) {
        employeeService.createEmployer(employer);
        return new ResponseEntity<>( employer, HttpStatus.CREATED);
    }
}
