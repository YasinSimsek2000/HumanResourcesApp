package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.dto.ManagerDto;
import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService implements IManagerService {

    @Autowired
    IManagerRepository managerRepository;

    @Autowired
    FilesService filesService;


    @Override
    public void createManager(Manager manager) throws Exception {
        manager.setPassword(hashPassword(manager.getPassword()));
        managerRepository.save(manager);
        String path = "hr-frontend\\src\\assets\\ProfilePhoto.png";
        File file = new File(path);
        System.out.println(file.exists());
        filesService.createFile(manager.getId(), "Manager", file);
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
    public Optional<Manager> getManagerByID(Long id) { return managerRepository.findById(id); }

    @Override
    public void updateManager(ManagerDto managerDto) {
        Optional<Manager> oldManager = managerRepository.findManagerByEmail(managerDto.getEmail());

        if (oldManager.isPresent()) {
            oldManager.get().setPassword(hashPassword(managerDto.getPassword()));
            managerRepository.save(oldManager.get());
        }
    }

    public String hashPassword (String password) {
        StringBuilder newPassword = new StringBuilder();

        for (int x = 0; x < password.length(); x++) {
            int newChar = password.charAt(x);
            int code = (newChar + 30 % 127 < 33) ? newChar - 30 : newChar + 30;
            newPassword.append((char) code);
        }

        return newPassword.toString();
    }
}
