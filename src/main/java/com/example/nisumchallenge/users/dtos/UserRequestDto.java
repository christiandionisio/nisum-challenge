package com.example.nisumchallenge.users.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
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

  @Schema(name = "name", description = "Name for user creation", example = "Christian")
  private String name;

  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "El formato del correo electrónico no es válido")
  @Schema(name = "email", description = "Email for user creation", example = "christian@gmail.com")
  private String email;

  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).+$", message = "El formato de la clave no es válido")
  @Pattern(regexp = "^.{8,}$", message = "La cadena debe tener al menos 8 caracteres")
  @Schema(name = "password", description = "Password for user creation", example = "Admin$2023")
  private String password;

  @Schema(name = "phones", description = "Phones list for user creation")
  private List<PhoneDto> phones;
}
