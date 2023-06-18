package com.example.nisumchallenge.users.controllers;

import com.example.nisumchallenge.users.dtos.UserRequestDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;
import com.example.nisumchallenge.users.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto requestDto) {
    UserResponseDto responseDto = userService.createUser(requestDto);
    return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(responseDto.getId())
        .toUri())
      .body(responseDto);
  }

}
