package com.example.nisumchallenge.users.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
public class UserRequestDto {

  private String name;

  @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "El formato del correo electrónico no es válido")
  private String email;

  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).+$", message = "El formato de la clave no es válido")
  @Pattern(regexp = "^.{8,}$", message = "La cadena debe tener al menos 8 caracteres")
  private String password;

  private List<PhoneDto> phones;
}
