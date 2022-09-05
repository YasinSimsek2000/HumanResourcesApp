package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.ManagerFiles;
import com.example.HumanResourcesApp.repository.IManagerFilesRepository;
import com.example.HumanResourcesApp.repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerFilesService implements IManagerFilesService{

    @Autowired
    IManagerFilesRepository managerFilesRepository;

    @Autowired
    IManagerRepository managerRepository;

    @Override
    public void createManagerFiles(ManagerFiles files) {
        managerFilesRepository.save(files);
    }

    @Override
    public void deleteManagerFiles(Long id) {
        managerFilesRepository.deleteById(id);
        managerFilesRepository.saveAll(managerFilesRepository.findAll());
    }

    @Override
    public List<ManagerFiles> getManagerFiles() { return managerFilesRepository.findAll(); }

    @Override
    public void updateManagerFiles(Long id, ManagerFiles newFiles) {
        Optional<ManagerFiles> oldFiles = managerFilesRepository.findById(id);
        if (oldFiles.isPresent()) {
            newFiles.setId(oldFiles.get().getId());
            managerFilesRepository.save(newFiles);
        }
    }
}
