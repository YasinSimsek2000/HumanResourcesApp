package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Department;
import java.util.List;

public interface IDepartmentService {

    void createDepartment(Department department);
    void deleteDepartment(Long id);
    List<Department> getDepartments();
    void updateDepartment(Long id, Department department);
}
