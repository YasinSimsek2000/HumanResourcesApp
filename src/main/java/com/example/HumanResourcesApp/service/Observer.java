package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Notification;

import java.util.ArrayList;

public abstract class Observer {

    public abstract void newNotificationAll(EmployeeService employeeService, Notification notification);
    public abstract void newNotification(EmployeeService employeeService, Notification notification, ArrayList<Long> employeeList);
}

