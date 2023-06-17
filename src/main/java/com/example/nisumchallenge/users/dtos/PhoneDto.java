package com.example.nisumchallenge.users.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class PhoneDto {

  private Integer id;
  private String number;
  private String cityCode;
  private String countryCode;


}
