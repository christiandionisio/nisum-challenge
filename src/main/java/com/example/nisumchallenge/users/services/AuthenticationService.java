package com.example.nisumchallenge.users.services;

import com.example.nisumchallenge.users.dtos.LoginRequestDto;
import com.example.nisumchallenge.users.dtos.LoginResponseDto;

public interface AuthenticationService {
  LoginResponseDto login(LoginRequestDto loginRequestDto);
}
