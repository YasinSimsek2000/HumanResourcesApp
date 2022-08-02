package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Employee;
import java.util.List;

public interface IEmployeeService {
    public abstract void createEmployee(Employee Employee);
    public abstract void updateEmployee(Long id, Employee Employee);
    public abstract void deleteEmployee(Long id);
    public abstract List<Employee> getEmployees();
}
