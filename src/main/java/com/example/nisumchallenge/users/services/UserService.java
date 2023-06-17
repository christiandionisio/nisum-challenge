package com.example.nisumchallenge.users.services;

import com.example.nisumchallenge.users.dtos.UserRequestDto;
import com.example.nisumchallenge.users.dtos.UserResponseDto;

public interface UserService {

  UserResponseDto createUser(UserRequestDto requestDto);

}
