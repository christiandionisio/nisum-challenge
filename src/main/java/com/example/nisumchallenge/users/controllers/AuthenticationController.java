package com.example.nisumchallenge.users.controllers;

import com.example.nisumchallenge.users.dtos.LoginRequestDto;
import com.example.nisumchallenge.users.dtos.LoginResponseDto;
import com.example.nisumchallenge.users.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Authentication", description = "Authentication Managemet APIs")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/login")
  @Operation(summary = "Authenticate a user",
    description = "Post a LoginRequestDto object. The response is LoginResponseDto object with token.")
  @ApiResponse(responseCode = "200",
    content = { @Content(schema = @Schema(implementation = LoginResponseDto.class), mediaType = "application/json") })
  @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
  @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginRequestDto loginRequestDto) {
    return ResponseEntity.ok(authenticationService.login(loginRequestDto));
  }

}
