package com.example.nisumchallenge.users.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
public class UserResponseDto {
  private String id;
  private String name;
  private String email;
  private String password;
  private List<PhoneDto> phones;
  private String token;
  private Boolean isActive;
}
