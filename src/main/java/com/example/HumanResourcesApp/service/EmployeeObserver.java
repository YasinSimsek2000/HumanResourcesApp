package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Employee;
import com.example.HumanResourcesApp.entity.Notification;

import java.util.ArrayList;

public class EmployeeObserver extends Observer {
    NotificationService notificationService;
    @Override
    public void newNotificationAll(EmployeeService employeeService, Notification notification) {
        for (Employee employee : employeeService.getEmployees()) {
            notification.getEmployees().add(employee);
        }
    };

    public void newNotification(EmployeeService employeeService, Notification notification, ArrayList<Long> employeeList) {
        for (Long ID : employeeList) {
            notification.getEmployees().add(employeeService.getEmployeeById(ID));
        }
    };
}
