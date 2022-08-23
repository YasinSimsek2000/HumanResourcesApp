package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Department;
import com.example.HumanResourcesApp.repository.IDepartmentRepository;
import com.example.HumanResourcesApp.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    IDepartmentRepository departmentRepository;

    public IDepartmentRepository getDepartmentRepository () { return this.departmentRepository;}

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        departmentRepository.saveAll(departmentRepository.findAll());
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> oldDepartment = departmentRepository.findById(id);

        if (oldDepartment.isPresent()) {
            updatedDepartment.setId(oldDepartment.get().getId());
            departmentRepository.save(updatedDepartment);
        }
    }

    @Override
    public Department getDepartmentById (Long department_id) {
        return departmentRepository.findById(department_id).get();
    }
}
