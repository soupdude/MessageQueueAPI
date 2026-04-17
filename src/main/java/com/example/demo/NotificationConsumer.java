package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class NotificationConsumer {
    private final NotificationRepository repository;

    public NotificationConsumer(NotificationRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "notification-queue")
    public void receiveMessage(Notification notification) {
        System.out.println("Received message: " + notification);
        notification.setStatus("PROCESSED");
        repository.save(notification);
    }
}