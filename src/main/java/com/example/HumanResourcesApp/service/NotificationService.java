package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Notification;
import com.example.HumanResourcesApp.repository.IManagerRepository;
import com.example.HumanResourcesApp.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService{

    @Autowired
    INotificationRepository notificationRepository;

    @Autowired
    IManagerRepository managerRepository;

    @Override
    public void newMessage(Notification notification, Long to) {
        notification.setManager(managerRepository.findById(to).get());
        notificationRepository.save(notification);
    }

    @Override
    public void deleteMessage(Long ID) { notificationRepository.deleteById(ID); }

    @Override
    public List<Notification> getMessages() { return notificationRepository.findAll(); }
}
