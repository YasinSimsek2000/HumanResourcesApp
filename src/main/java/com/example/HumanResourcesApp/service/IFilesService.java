package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Files;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface IFilesService {
    void createFile (Long ID, String Class, MultipartFile file) throws Exception;
    void createFile (Long ID, String Class, File file) throws Exception;
    void deleteFiles (String fileName);
    List<Files> getFiles ();

    Files getFileByName(String fileName);

    void updateFileName (Long id, String newFileName);
}
