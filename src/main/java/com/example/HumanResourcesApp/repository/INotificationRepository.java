package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> { }
