package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.ManagerFiles;

import java.util.List;
import java.util.Optional;

public interface IManagerFilesService {
    void createManagerFiles (ManagerFiles files);
    void deleteManagerFiles (Long id);
    List<ManagerFiles> getManagerFiles ();
    void updateManagerFiles (Long id, ManagerFiles files);
}
