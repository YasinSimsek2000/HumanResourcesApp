package com.example.HumanResourcesApp.service;

import java.util.List;
import java.util.Optional;

import com.example.HumanResourcesApp.entity.Employer;
import com.example.HumanResourcesApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeServiceInterfaces{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createEmployer(Employer employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployer(Long id, Employer updateEmployee) {
        Optional<Employer> old = employeeRepository.findById(id);

        if(old.isPresent()){
            updateEmployee.setId(old.get().getId());
            employeeRepository.save(updateEmployee);
        }

    }

    @Override
    public void deleteEmployer(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employer> getEmployers() {
        return employeeRepository.findAll();
    }
}

