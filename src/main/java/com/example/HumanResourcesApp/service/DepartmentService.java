package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Department;
import com.example.HumanResourcesApp.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    IDepartmentRepository departmentRepository;

    @Autowired
    FilesService filesService;

    @Override
    public void createDepartment(Department department) throws Exception {
        departmentRepository.save(department);
        filesService.findPath("Department", department.getId(), null);
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
        if (departmentRepository.findById(department_id).isPresent()) {
            return departmentRepository.findById(department_id).get();
        }

        else { return null; }
    }
}
