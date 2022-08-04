package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Project;
import com.example.HumanResourcesApp.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    IProjectRepository projectRepository;

    @Override
    public void createProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
        projectRepository.saveAll(projectRepository.findAll());
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void updateProject(Long id, Project updatedProject) {
        Optional<Project> oldProject = projectRepository.findById(id);

        if (oldProject.isPresent()) {
            updatedProject.setId(oldProject.get().getId());
            projectRepository.save(updatedProject);
        }
    }
}
