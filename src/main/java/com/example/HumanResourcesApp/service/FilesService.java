package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Files;
import com.example.HumanResourcesApp.repository.IFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilesService implements IFilesService {

    @Autowired
    IFilesRepository filesRepository;

    @Override
    public void createFiles(Files files) {
        filesRepository.save(files);
    }

    @Override
    public void deleteFiles(String fileName) {
        filesRepository.deleteFilesByFileName(fileName);
        filesRepository.saveAll(filesRepository.findAll());
    }

    @Override
    public List<Files> getFiles() { return filesRepository.findAll(); }

    @Override
    public Files getFileByName(String fileName) { return filesRepository.findFilesByFileName(fileName).get(); }

    @Override
    public void updateFiles(Long id, Files newFiles) {
        Optional<Files> oldFiles = filesRepository.findById(id);
        if (oldFiles.isPresent()) {
            newFiles.setId(oldFiles.get().getId());
            filesRepository.save(newFiles);
        }
    }
}
