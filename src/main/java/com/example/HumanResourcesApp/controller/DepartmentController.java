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

    @RequestMapping(value = "/getDepartments")
    public ResponseEntity<Object> getDepartments() {
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getProjectsOfDepartment")
    public ResponseEntity<Object> getProjectsOfDepartment(@RequestBody Long department_id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(department_id).getProjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
    public ResponseEntity<Object> createDepartment (@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDepartment (@RequestBody Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDepartment (@RequestBody Department department) {
        departmentService.updateDepartment(department.getId(), department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
