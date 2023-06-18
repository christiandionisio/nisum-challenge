package com.example.nisumchallenge.users.services.impl;

import com.example.nisumchallenge.users.dtos.PhoneDto;
import com.example.nisumchallenge.users.dtos.UserRequestDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;
import com.example.nisumchallenge.users.entities.PhoneEntity;
import com.example.nisumchallenge.users.entities.UserEntity;
import com.example.nisumchallenge.users.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  UserServiceImpl userService;

  @Test
  void createUserTestOk() {

    Mockito.when(userRepository.save(Mockito.any()))
      .thenReturn(dummyUserEntity());

    UserResponseDto responseDto = userService.createUser(dummyUserRequestDto());

    Assertions.assertNotNull(responseDto);
  }

  private UserRequestDto dummyUserRequestDto() {
    return UserRequestDto.builder()
      .name("Christian")
      .email("christian@gmail.com")
      .phones(List.of(PhoneDto.builder().build()))
      .build();
  }

  private UserEntity dummyUserEntity() {
    return UserEntity.builder()
      .phones(List.of(PhoneEntity.builder().build()))
      .build();
  }

}