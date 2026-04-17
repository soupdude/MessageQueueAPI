package com.example.demo;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    private final NotificationRepository CrudRepository;
    private final RabbitTemplate RabbitMQConfig;

    RESTController (NotificationRepository CrudRepository, RabbitTemplate RabbitMQConfig) {
        this.CrudRepository = CrudRepository;
        this.RabbitMQConfig = RabbitMQConfig;
    }
    
    @PostMapping("/notifications")
    Notification newNotification(@RequestBody Notification newNotification) {
        
        newNotification.setStatus("PENDING");
        CrudRepository.save(newNotification);
        RabbitMQConfig.convertAndSend( "notification-queue", newNotification);
        return newNotification;
    }

    @GetMapping("/notifications/{id}")
    Notification getNotification(@PathVariable Long id) {
        return CrudRepository.findById(id).orElse(null);
    }

}
