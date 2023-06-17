package com.example.nisumchallenge.users.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "USER_TABLE")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "uuid", unique = true)
  private String uuid;

  @Column(name = "name")
  private String name;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
  @ToString.Exclude
  List<PhoneEntity> phones;
}
