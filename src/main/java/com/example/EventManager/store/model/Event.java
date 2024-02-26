package com.example.EventManager.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    @NotNull(message = "Name must not be empty")
    private String eventName;
    private boolean isAvailable;
}
