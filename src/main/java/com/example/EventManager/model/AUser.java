package com.example.EventManager.model;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table
public class AUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotNull(message = "Email should not be empty.")
    private String userEmail;
    @NotNull(message = "Password should not be empty.")
    private String password;
}
