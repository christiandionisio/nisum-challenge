package com.example.nisumchallenge.users.services.impl;

import com.example.nisumchallenge.users.builder.UserBuilder;
import com.example.nisumchallenge.users.dtos.UserRequestDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;
import com.example.nisumchallenge.users.entities.UserEntity;
import com.example.nisumchallenge.users.repository.UserRepository;
import com.example.nisumchallenge.users.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserResponseDto createUser(UserRequestDto requestDto) {
    requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
    UserEntity entityBD = userRepository.save(UserBuilder.buildUserEntity(requestDto));
    return UserBuilder.buildUserResponseDto(entityBD);
  }
}
