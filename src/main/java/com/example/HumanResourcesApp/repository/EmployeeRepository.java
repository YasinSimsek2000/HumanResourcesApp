package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employer, Long> {}

