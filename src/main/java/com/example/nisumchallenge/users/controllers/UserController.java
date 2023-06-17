package com.example.nisumchallenge.users.controllers;

import com.example.nisumchallenge.users.dtos.UserRequestDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  @PostMapping
  public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
    return UserResponseDto.builder().build();
  }

}
