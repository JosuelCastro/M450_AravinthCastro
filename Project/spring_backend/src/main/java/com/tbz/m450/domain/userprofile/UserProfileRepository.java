package com.tbz.m450.domain.userprofile;

import com.tbz.m450.domain.user.User;
import com.tbz.m450.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends AbstractRepository<UserProfile> {
    Optional<UserProfile> findUserProfileByUser(User user);
}

