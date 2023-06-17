package com.example.nisumchallenge.users.repository;

import com.example.nisumchallenge.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
