package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Project;
import java.util.List;

public interface IProjectService {

     void createProject(Project project) throws Exception;
     void deleteProject(Long id);
     List<Project> getProjects();

    Project getProjectById (Long project_id);

    void updateProject(Long id, Project project);
}
