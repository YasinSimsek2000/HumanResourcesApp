package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.entity.Department;
import com.example.HumanResourcesApp.entity.Employee;
import com.example.HumanResourcesApp.entity.Notification;
import com.example.HumanResourcesApp.entity.Project;
import com.example.HumanResourcesApp.service.EmployeeService;
import com.example.HumanResourcesApp.service.ManagerService;
import com.example.HumanResourcesApp.service.NotificationService;
import com.example.HumanResourcesApp.service.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/getNotifications")
    public ResponseEntity<Object> getNotifications ()  {
        return new ResponseEntity<>(notificationService.getAllNotifications(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sendNotificationToAllEmployees", method = RequestMethod.POST)
    public ResponseEntity<Object> sendNotificationToAllEmployees (@RequestBody Notification notification)  {
        notification.getEmployees().addAll(employeeService.getEmployees());
        for (Employee employee : employeeService.getEmployees()) {
            employee.getNotifications().add(notification);
            employeeService.updateEmployee(employee.getId(), employee);
        }
        notificationService.createNotification(notification);
        return new ResponseEntity<>("The notification was send successfully.", HttpStatus.OK);
    }

    @RequestMapping(value = "/sendNotificationToEmployees", method = RequestMethod.POST)
    public ResponseEntity<Object> sendNotificationToEmployees (@RequestBody Object[] data)  {
        notificationService.sendNotificationToEmployees((Notification) data[0], (ArrayList<Long>) data[1]);
        notificationService.createNotification((Notification) data[0]);
        return new ResponseEntity<>("The notification was send successfully.", HttpStatus.OK);
    }
}
