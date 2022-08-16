package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Employee;
import java.util.List;

public interface IEmployeeService {
    void createEmployee(Employee Employee);
    void updateEmployee(Long id, Employee Employee);
    void deleteEmployee(Long id);
    List<Employee> getEmployees();
}
