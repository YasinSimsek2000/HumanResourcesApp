package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Notification;

import java.util.List;

public interface INotificationService {

    void newMessage (Notification notification, Long to);
    void deleteMessage (Long ID);
    List<Notification> getMessages ();
}
