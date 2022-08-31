package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(Long id);
}
