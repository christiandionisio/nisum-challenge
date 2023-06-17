package com.example.nisumchallenge.users.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Builder
@Setter
@Getter
@ToString
@Table(name = "USER_TABLE")
public class UserEntity {
  @Id
  private Integer id;

  @Column(name = "uuid")
  private String uuid;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "phone")
  private String phone;
}
