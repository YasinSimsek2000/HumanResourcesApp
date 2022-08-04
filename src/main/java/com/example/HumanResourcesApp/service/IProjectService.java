package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Project;
import java.util.List;

public interface IProjectService {

    public abstract void createProject(Project project);
    public abstract void deleteProject(Long id);
    public abstract List<Project> getProjects();
    public abstract void updateProject(Long id, Project project);
}
