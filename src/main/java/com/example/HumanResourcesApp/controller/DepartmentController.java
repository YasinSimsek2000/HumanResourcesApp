package com.example.HumanResourcesApp.controller;


import com.example.HumanResourcesApp.entity.Department;
import com.example.HumanResourcesApp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/departments")
    public ResponseEntity<Object> getDepartment() {
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public ResponseEntity<Object> createDepartment (@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDepartment (@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDepartment (@PathVariable("id") Long id, @RequestBody Department department) {
        departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
