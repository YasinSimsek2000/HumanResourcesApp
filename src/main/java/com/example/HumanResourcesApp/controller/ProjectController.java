package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.entity.Project;
import com.example.HumanResourcesApp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public ResponseEntity<Object> createProject (@RequestBody Project project) {
        projectService.createProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProject (@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(projectService.getProjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/projects")
    public ResponseEntity<Object> getProject () {
        return new ResponseEntity<>(projectService.getProjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProject (@PathVariable("id") Long id,  @RequestBody Project project) {
        projectService.updateProject(id, project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

}
