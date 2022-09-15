package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Notification;
import java.util.ArrayList;

public class Subject {
    private final EmployeeObserver employeeObserver = new EmployeeObserver();
    private Notification notification;

    public Notification getNotification() { return notification; }
    public void setNotification(Notification notification) { this.notification = notification; }

    public void notifyAllObservers(EmployeeService employeeService){
        employeeObserver.newNotificationAll(employeeService, this.notification);
    }

    public void notifyAllObservers(EmployeeService employeeService, ArrayList<Long> employeeList){
        employeeObserver.newNotification(employeeService, this.notification, employeeList);
    }
}
