package com.example.HumanResourcesApp.repository;

import com.example.HumanResourcesApp.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findById(Long id);
}