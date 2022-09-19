package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Employee;
import java.util.List;

public interface IEmployeeService {
    void createEmployee(Employee Employee) throws Exception;
    void updateEmployee(Long id, Employee Employee);
    void deleteEmployee(Long id);
    List<Employee> getEmployees();

    Employee getEmployeeById(Long employee_id);
}
