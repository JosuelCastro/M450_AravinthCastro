package com.noseryoung.uek223.domain.user;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.noseryoung.uek223.core.generic.AbstractRepository;

@Repository
public interface UserRepository extends AbstractRepository<User> {
  Optional<User> findByEmail(String email);
}
