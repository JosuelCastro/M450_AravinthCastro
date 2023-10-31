package com.tbz.m450.domain.user;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.tbz.m450.core.generic.AbstractRepository;

@Repository
public interface UserRepository extends AbstractRepository<User> {
  Optional<User> findByEmail(String email);
}
