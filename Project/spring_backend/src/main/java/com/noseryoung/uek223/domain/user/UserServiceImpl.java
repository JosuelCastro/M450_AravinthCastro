package com.noseryoung.uek223.domain.user;

import com.noseryoung.uek223.domain.userprofile.UserProfile;
import com.noseryoung.uek223.domain.userprofile.UserProfileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.noseryoung.uek223.core.generic.AbstractServiceImpl;

import java.security.SecureRandom;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserProfileService userProfileService;

  @Autowired
  public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, UserProfileService userProfileService) {
    super(repository);
    this.passwordEncoder = passwordEncoder;
    this.userProfileService = userProfileService;
  }

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return ((UserRepository) repository).findByEmail(email)
                                        .map(UserDetailsImpl::new)
                                        .orElseThrow(() -> new UsernameNotFoundException(email));
  }

  @Transactional
  @Override
  public User register(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    UserProfile profile = userProfileService.save(new UserProfile());
    profile.setUser(user);
    return save(user);
  }

  @Transactional
  @Override
  public User registerUser(User user){
    user.setPassword(getRandomSpecialChars(20).toString());
    return save(user);
  }

  public Stream<Character> getRandomSpecialChars(int count) {
    Random random = new SecureRandom();
    IntStream specialChars = random.ints(count, 33, 45);
    return specialChars.mapToObj(data -> (char) data);
  }

  @Transactional
  @Override
  public void deleteById(UUID id) throws NoSuchElementException {
    UUID profileId = super.findById(id).getProfile().getId();
    super.deleteById(id);
    userProfileService.deleteById(profileId);
  }

  @Transactional
  @Override
  public List<User> findAll(Pageable pageable) {
    return super.findAll(pageable);
  }

  @Override
  public User updateById(UUID id, User entity) throws NoSuchElementException {
    User old = findById(id);

    entity.setRoles(old.getRoles());

    if (entity.getPassword() == null) {
      entity.setPassword(old.getPassword());
    }

    if (entity.getEmail() == null) {
      entity.setEmail(old.getEmail());
    }

    if (entity.getUsername() == null) {
      entity.setUsername(old.getUsername());
    }

    return super.updateById(id, entity);
  }
}
