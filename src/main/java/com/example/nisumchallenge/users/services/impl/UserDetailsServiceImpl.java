package com.example.nisumchallenge.users.services.impl;

import com.example.nisumchallenge.users.entities.UserEntity;
import com.example.nisumchallenge.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserRecord userRecord = getByUser(username);

    if (userRecord == null) {
      throw new UsernameNotFoundException(username);
    }
    return User
      .withUsername(username)
      .password(userRecord.password())
      .roles(userRecord.roles().toArray(new String[0]))
      .build();
  }

  public record UserRecord(String username, String password, Set<String> roles) {}

  public UserRecord getByUser(String username) {
    UserEntity userEntityDB = userRepository.findByEmail(username);
    return new UserRecord(userEntityDB.getName(), userEntityDB.getPassword(), Set.of("ADMIN"));
  }

}
