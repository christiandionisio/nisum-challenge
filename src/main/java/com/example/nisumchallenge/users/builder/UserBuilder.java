package com.example.nisumchallenge.users.builder;

import com.example.nisumchallenge.users.dtos.UserRequestDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;
import com.example.nisumchallenge.users.entities.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {

  public static UserEntity buildUserEntity(UserRequestDto requestDto) {
    return UserEntity.builder()
      .uuid(UUID.randomUUID().toString())
      .name(requestDto.getName())
      .email(requestDto.getEmail())
      .password(requestDto.getPassword())
      .phone(requestDto.getPhone())
      .build();
  }

  public static UserResponseDto buildUserResponseDto(UserEntity userEntity) {
    return UserResponseDto.builder()
      .id(userEntity.getUuid())
      .name(userEntity.getName())
      .email(userEntity.getEmail())
      .password(userEntity.getPassword())
      .phone(userEntity.getPhone())
      .build();
  }

}
