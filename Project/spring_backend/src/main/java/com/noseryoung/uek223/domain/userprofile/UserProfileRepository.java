package com.noseryoung.uek223.domain.userprofile;

import com.noseryoung.uek223.domain.user.User;
import org.springframework.stereotype.Repository;

import com.noseryoung.uek223.core.generic.AbstractRepository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends AbstractRepository<UserProfile> {
    Optional<UserProfile> findUserProfileByUser(User user);
}

