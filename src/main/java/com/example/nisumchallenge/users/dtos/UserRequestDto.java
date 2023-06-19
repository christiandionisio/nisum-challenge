package com.example.nisumchallenge.users.dtos;

import com.example.nisumchallenge.users.utils.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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

  @NotBlank(message = "El campo name no debe ir vacio")
  @Schema(name = "name", description = "Name for user creation", example = "Christian")
  private String name;

  @Pattern(regexp = Constants.EMAIL_FORMAT, message = "El formato del correo electrónico no es válido")
  @Schema(name = "email", description = "Email for user creation", example = "christian@gmail.com")
  private String email;

  @Pattern(regexp = Constants.PASSWORD_FORMAT, message = "La contraseña debe tener por lo menos una mayúscula y un caracter especial")
  @Pattern(regexp = Constants.PASSWORD_MIN_SIZE, message = "La contraseña debe tener al menos 8 caracteres")
  @Schema(name = "password", description = "Password for user creation", example = "Admin$2023")
  private String password;

  @Schema(name = "phones", description = "Phones list for user creation")
  private List<PhoneDto> phones;
}
