package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.dto.ManagerDto;
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
    public void createManager(Manager manager) {
        manager.setPassword(hashPassword(manager.getPassword()));
        managerRepository.save(manager);
    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
        managerRepository.saveAll(managerRepository.findAll());
    }

    @Override
    public List<Manager> getManager() { return managerRepository.findAll(); }

    @Override
    public Optional<Manager> getManagerByMail(String email) { return managerRepository.findManagerByEmail(email); }

    @Override
    public void updateManager(ManagerDto managerDto) {
        Optional<Manager> oldManager = managerRepository.findManagerByEmail(managerDto.getEmail());

        if (oldManager.isPresent()) {
            oldManager.get().setPassword(hashPassword(managerDto.getPassword()));
            managerRepository.save(oldManager.get());
        }
    }

    public String hashPassword (String password) {
        String newPassword = "";

        for (int x = 0; x < password.length(); x++) {
            int newChar = password.charAt(x);
            int code = (newChar + 30 % 127 < 33) ? newChar - 30 : newChar + 30;
            newPassword += (char)code;
        }

        return newPassword;
    }
}
