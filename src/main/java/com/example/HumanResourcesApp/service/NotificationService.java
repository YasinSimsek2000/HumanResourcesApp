package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Notification;
import com.example.HumanResourcesApp.repository.IEmployeeRepository;
import com.example.HumanResourcesApp.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements INotificationService{

    @Autowired
    INotificationRepository notificationRepository;

    @Autowired
    EmployeeService employeeService;

    Subject subject = new Subject();

    @Override
    public void createNotification(Notification notification) { notificationRepository.save(notification); }

    @Override
    public void deleteNotification(Long ID) { notificationRepository.deleteById(ID);}

    @Override
    public List<Notification> getAllNotifications() { return notificationRepository.findAll(); }

    public void sendNotificationToAllEmployees (Notification notification)  {
        subject.setNotification(notification);
        subject.notifyAllObservers(employeeService);
    }

    public void sendNotificationToEmployees (Notification notification, ArrayList<Long> employeeList)  {
        subject.setNotification(notification);
        subject.notifyAllObservers(employeeService, employeeList);
    }
}
