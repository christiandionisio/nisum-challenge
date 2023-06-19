package com.example.nisumchallenge.users.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  public static final String EMAIL_FORMAT = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
  public static final String PASSWORD_FORMAT = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).+$";
  public static final String PASSWORD_MIN_SIZE = "^.{8,}$";

}
