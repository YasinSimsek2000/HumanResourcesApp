package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Manager;
import java.util.List;

public interface IManagerService {

    public abstract void createManager (Manager manager);
    public abstract void deleteManager(Long id);
    public abstract List<Manager> getManager ();
    public abstract void updateManager(Long id, Manager manager);
}
