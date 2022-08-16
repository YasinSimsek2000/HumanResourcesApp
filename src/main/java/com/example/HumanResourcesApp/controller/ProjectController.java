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

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public ResponseEntity<Object> createProject (@RequestBody Project project) {
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
}
