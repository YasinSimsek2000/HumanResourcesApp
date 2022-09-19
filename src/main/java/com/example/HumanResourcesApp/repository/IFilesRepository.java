package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IFilesRepository extends JpaRepository<Files, Long> {
    void deleteFilesByFileName(String fileName);
    Optional<Files> findFilesByFileName(String fileName);
}
