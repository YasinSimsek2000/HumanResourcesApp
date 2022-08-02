package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Department;
import com.example.HumanResourcesApp.entity.Employee;

import java.util.List;

public interface IDepartmentService {

    public abstract void createDepartment(Department department);
    public abstract void updateDepartment(Long id, Department department);
    public abstract void deleteDepartment(Long id);
    public abstract List<Department> getDepartments();
}
