package com.example.nisumchallenge.users.builder;

import com.example.nisumchallenge.users.dtos.PhoneDto;
import com.example.nisumchallenge.users.dtos.UserRequestDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;
import com.example.nisumchallenge.users.entities.PhoneEntity;
import com.example.nisumchallenge.users.entities.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {

  public static UserEntity buildUserEntity(UserRequestDto requestDto) {

    LocalDateTime currentLocalDateTime = LocalDateTime.now();

    UserEntity userEntity = UserEntity.builder()
      .uuid(UUID.randomUUID().toString())
      .name(requestDto.getName())
      .email(requestDto.getEmail())
      .password(requestDto.getPassword())
      .createdDate(currentLocalDateTime)
      .lastLogin(currentLocalDateTime)
      .isActive(Boolean.TRUE)
      .token(UUID.randomUUID().toString())
      .build();

    List<PhoneEntity> phoneEntities = requestDto.getPhones().stream()
      .map(phoneDto -> PhoneEntity.builder()
        .number(phoneDto.getNumber())
        .cityCode(phoneDto.getCityCode())
        .countryCode(phoneDto.getCountryCode())
        .userEntity(userEntity)
        .build())
      .toList();

    userEntity.setPhones(phoneEntities);

    return userEntity;
  }

  public static UserResponseDto buildUserResponseDto(UserEntity userEntity) {
    return UserResponseDto.builder()
      .id(userEntity.getUuid())
      .name(userEntity.getName())
      .email(userEntity.getEmail())
      .password(userEntity.getPassword())
      .phones(userEntity.getPhones().stream()
        .map(phoneEntity -> PhoneDto.builder()
          .id(phoneEntity.getId())
          .number(phoneEntity.getNumber())
          .cityCode(phoneEntity.getCityCode())
          .countryCode(phoneEntity.getCountryCode())
          .build())
        .toList())
      .isActive(userEntity.getIsActive())
      .token(userEntity.getToken())
      .created(userEntity.getCreatedDate())
      .modified(userEntity.getModifiedDate())
      .lastLogin(userEntity.getLastLogin())
      .build();
  }

}
