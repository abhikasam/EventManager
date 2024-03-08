package com.example.EventManager.repository;

import com.example.EventManager.model.AUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AUserRepository extends JpaRepository<AUser, Integer> {
}
