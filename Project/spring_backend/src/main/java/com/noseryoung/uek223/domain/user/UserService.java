package com.noseryoung.uek223.domain.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.noseryoung.uek223.core.generic.AbstractService;

public interface UserService extends UserDetailsService, AbstractService<User> {
  User register(User user);

  User registerUser(User user);
}
