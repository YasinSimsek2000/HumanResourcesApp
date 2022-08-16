package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Project;
import java.util.List;

public interface IProjectService {

     void createProject(Project project);
     void deleteProject(Long id);
     List<Project> getProjects();
     void updateProject(Long id, Project project);
}
