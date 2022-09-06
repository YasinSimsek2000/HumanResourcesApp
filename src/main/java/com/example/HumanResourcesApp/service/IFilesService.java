package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Files;
import java.util.List;

public interface IFilesService {
    void createFiles (Files files);
    void deleteFiles (String fileName);
    List<Files> getFiles ();

    Files getFileByName(String fileName);

    void updateFiles (Long id, Files files);
}
