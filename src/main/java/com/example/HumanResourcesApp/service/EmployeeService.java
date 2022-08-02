package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Employee;
import com.example.HumanResourcesApp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        employeeRepository.saveAll(employeeRepository.findAll());
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> oldEmployee = employeeRepository.findById(id);

        if(oldEmployee.isPresent()){
            updatedEmployee.setId(oldEmployee.get().getId());
            employeeRepository.save(updatedEmployee);
        }
    }
}

