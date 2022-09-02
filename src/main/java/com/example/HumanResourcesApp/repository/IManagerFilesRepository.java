package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.entity.ManagerFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IManagerFilesRepository extends JpaRepository<ManagerFiles, Long> {
    Optional<ManagerFiles> findManagerFilesByManagerId(Long id);
}
