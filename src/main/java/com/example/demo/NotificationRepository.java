package com.example.demo;

public interface NotificationRepository extends org.springframework.data.repository.CrudRepository<Notification, Long> {
    
    Notification findByStatus(String status);


}
