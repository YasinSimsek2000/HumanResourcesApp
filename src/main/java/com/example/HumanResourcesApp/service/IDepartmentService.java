package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Department;
import java.util.List;

public interface IDepartmentService {

    void createDepartment(Department department) throws Exception;
    void deleteDepartment(Long id);
    List<Department> getDepartments();

    Department getDepartmentById (Long department_id);
    void updateDepartment(Long id, Department department);
}
