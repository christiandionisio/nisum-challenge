package com.example.nisumchallenge.users.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class UserResponseDto {
  private String id;
  private String name;
  private String email;
  private String password;
  private String phone;
}
