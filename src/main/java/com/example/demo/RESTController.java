package com.example.demo;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    private final NotificationRepository CrudRepository;

    RESTController (NotificationRepository CrudRepository) {
        this.CrudRepository = CrudRepository;
    }
    
    @PostMapping("/notifications")
    Notification newNotification(@RequestBody Notification newNotification) {
        newNotification.setStatus("PENDING");
        return CrudRepository.save(newNotification);
    }

    @GetMapping("/notifications/{id}")
    Notification getNotification(@PathVariable Long id) {
        return CrudRepository.findById(id).orElse(null);
    }
}
