package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Department;
import com.example.HumanResourcesApp.entity.Employee;
import com.example.HumanResourcesApp.entity.Project;
import com.example.HumanResourcesApp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    FilesService filesService;

    @Override
    public void createEmployee(Employee employee) throws Exception {
        employeeRepository.save(employee);
        filesService.findPath("Employee", employee.getId(), null);
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

    public Department getDepartmentOfEmployee(Long employee_id) {
        if(employeeRepository.findById(employee_id).isPresent()) {
            return employeeRepository.findById(employee_id).get().getDepartment();
        }
        return null;
    }

    public Project getProjectOfEmployee(Long employee_id) {
        if(employeeRepository.findById(employee_id).isPresent()) {
            return employeeRepository.findById(employee_id).get().getProject();
        }
        return null;
    }

    @Override
    public void updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> oldEmployee = employeeRepository.findById(id);

        if(oldEmployee.isPresent()){
            updatedEmployee.setId(oldEmployee.get().getId());
            employeeRepository.save(updatedEmployee);
        }
    }

    @Override
    public Employee getEmployeeById (Long employee_id) {
        if (employeeRepository.findById(employee_id).isPresent()) {
            return employeeRepository.findById(employee_id).get();
        }

        else { return null; }
    }
}

