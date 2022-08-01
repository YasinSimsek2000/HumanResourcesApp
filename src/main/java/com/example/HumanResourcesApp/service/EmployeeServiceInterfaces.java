package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Employer;
import java.util.List;

public interface EmployeeServiceInterfaces {
    public abstract void createEmployer(Employer employer);
    public abstract void updateEmployer(Long id, Employer employer);
    public abstract void deleteEmployer(Long id);
    public abstract List<Employer> getEmployers();
}
