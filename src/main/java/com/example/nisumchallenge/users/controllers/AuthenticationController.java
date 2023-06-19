package com.example.nisumchallenge.users.controllers;

import com.example.nisumchallenge.users.dtos.LoginRequestDto;
import com.example.nisumchallenge.users.dtos.LoginResponseDto;
import com.example.nisumchallenge.users.utils.JwtUtilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

  private final JwtUtilService jwtUtilService;
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginRequestDto loginRequestDto) {
    log.info("Autenticando al usuario {}", loginRequestDto.getUser());

    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
      loginRequestDto.getUser(),
      loginRequestDto.getPassword()
    ));

    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getUser());
    final String jwt = jwtUtilService.generateToken(userDetails);
    return ResponseEntity.ok(LoginResponseDto.builder().token(jwt).build());
  }

}
