package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.entity.Department;
import com.example.HumanResourcesApp.entity.Project;
import com.example.HumanResourcesApp.service.DepartmentService;
import com.example.HumanResourcesApp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public ResponseEntity<Object> createProject (@RequestBody Project project) throws Exception {
        projectService.createProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProject (@RequestBody Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(projectService.getProjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getProjects")
    public ResponseEntity<Object> getProjects () {
        return new ResponseEntity<>(projectService.getProjects(), HttpStatus.OK);
    }


    @RequestMapping(value = "/updateProject", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProject ( @RequestBody Project project) {
        projectService.updateProject(project.getId(), project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollProject", method = RequestMethod.PUT)
    public ResponseEntity<Object> enrollDepartmentToProject( @RequestBody Long[] ids) throws Exception {
        Long project_id = ids[0];
        Long department_id = ids[1];
        Project project = projectService.getProjectById(project_id);
        Department department = departmentService.getDepartmentById(department_id);
        project.getDepartments().add(department);
        department.getProjects().add(project);
        projectService.createProject(project);
        departmentService.createDepartment(department);
        return new ResponseEntity<>(new Long[]{project_id, department_id}, HttpStatus.OK);
    }
}
