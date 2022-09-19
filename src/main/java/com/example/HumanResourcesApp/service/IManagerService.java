package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.dto.ManagerDto;
import com.example.HumanResourcesApp.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface IManagerService {

    void createManager(Manager manager) throws Exception;

    void deleteManager(Long id);

    List<Manager> getManager();

    Optional<Manager> getManagerByMail(String email);

    Optional<Manager> getManagerByID(Long id);

    void updateManager(ManagerDto manager);
}
