package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String recipient;
    private String message;
    private String status;
    private String type;

    protected Notification() {}

    public Notification(String recipient, String message, String status, String type) {
        this.recipient = recipient;
        this.message = message;
        this.status = status;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "Notification[id=%d, recipient='%s', message='%s', status='%s', type='%s']",
                id, recipient, message, status, type);
    }

    public Long getId() {
        return id;
    }   

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }   

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}