package com.noseryoung.uek223.domain.userprofile;

import com.noseryoung.uek223.domain.user.User;
import com.noseryoung.uek223.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noseryoung.uek223.core.generic.AbstractServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserProfileServiceImpl extends AbstractServiceImpl<UserProfile> implements UserProfileService {

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        super(userProfileRepository);
    }

    @Transactional
    @Override
    public UserProfile save(UserProfile entity) {
        return super.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) throws NoSuchElementException {
        super.deleteById(id);
    }

    @Transactional
    @Override
    public UserProfile updateById(UUID id, UserProfile entity) throws NoSuchElementException {
        entity.setUser(findById(id).getUser());
        return super.updateById(id, entity);
    }

    @Override
    public UserProfile findById(UUID id) {
        return super.findById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return super.existsById(id);
    }
}