package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService implements IManagerService {

    @Autowired
    IManagerRepository managerRepository;

    @Override
    public void createManager(Manager manager) { managerRepository.save(manager); }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
        managerRepository.saveAll(managerRepository.findAll());
    }

    @Override
    public List<Manager> getManager() { return managerRepository.findAll(); }

    @Override
    public void updateManager(Long id, Manager updatedManager) {
        Optional<Manager> oldManager = managerRepository.findById(id);

        if (oldManager.isPresent()) {
            updatedManager.setId(oldManager.get().getId());
            managerRepository.save(updatedManager);
        }
    }
}
