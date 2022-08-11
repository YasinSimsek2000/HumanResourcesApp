package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Long> { }
