package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Notification;
import java.util.List;

public interface INotificationService {
    void createNotification (Notification notification);
    void deleteNotification (Long ID);
    List<Notification> getAllNotifications ();
}
