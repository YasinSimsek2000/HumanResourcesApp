package com.example.HumanResourcesApp.controller;


import com.example.HumanResourcesApp.entity.Employee;
import com.example.HumanResourcesApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getEmployees")
    public ResponseEntity<Object> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getDepartmentOfEmployee")
    public ResponseEntity<Object> getDepartmentOfEmployee(@RequestBody Long id) {
        return new ResponseEntity<>(employeeService.getDepartmentOfEmployee(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/getDepartmentOfEmployee/{id}")
    public ResponseEntity<Object> getDepartmentOfEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getDepartmentOfEmployee(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/getProjectOfEmployee/{id}")
    public ResponseEntity<Object> getProjectOfEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getProjectOfEmployee(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) throws Exception {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@RequestBody Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateEmployee/{ID}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmployee(@PathVariable("ID") Long ID, @RequestBody Employee employee) {
        employeeService.updateEmployee(ID, employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
