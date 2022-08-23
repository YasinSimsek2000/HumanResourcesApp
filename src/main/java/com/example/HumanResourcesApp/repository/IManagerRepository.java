package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findManagerByEmail(String email);
}
