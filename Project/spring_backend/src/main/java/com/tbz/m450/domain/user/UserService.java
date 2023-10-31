package com.tbz.m450.domain.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tbz.m450.core.generic.AbstractService;

public interface UserService extends UserDetailsService, AbstractService<User> {
  User register(User user);

  User registerUser(User user);
}
