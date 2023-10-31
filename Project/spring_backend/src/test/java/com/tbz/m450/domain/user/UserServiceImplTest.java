package com.tbz.m450.domain.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tbz.m450.domain.user.User;
import com.tbz.m450.domain.user.UserRepository;
import com.tbz.m450.domain.user.UserServiceImpl;
import com.tbz.m450.domain.userprofile.UserProfile;
import com.tbz.m450.domain.userprofile.UserProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.UUID;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserProfileService userProfileService;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        // Given
        User user = new User();
        user.setPassword("rawPassword");

        UserProfile userProfile = new UserProfile();
        userProfile.setId(UUID.randomUUID());

        // When
        when(passwordEncoder.encode("rawPassword")).thenReturn("encodedPassword");
        when(userProfileService.save(any(UserProfile.class))).thenReturn(userProfile);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            savedUser.setProfile(userProfile);  // Ensure UserProfile is set in User
            return savedUser;
        });

        // Call the method under test
        User result = userService.register(user);

        // Then
        assertNotNull(result);
        assertEquals("encodedPassword", result.getPassword());
        assertNotNull(result.getProfile());
        assertEquals(userProfile.getId(), result.getProfile().getId());

        verify(passwordEncoder).encode("rawPassword");
        verify(userProfileService).save(any(UserProfile.class));
        verify(userRepository).save(any(User.class));
    }


    @Test
    void testLoadUserByUsername() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));

        UserDetails result = userService.loadUserByUsername("test@example.com");

        assertEquals("test@example.com", result.getUsername());
    }

    @Test
    void testLoadUserByUsernameNotFound() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserByUsername("test@example.com");
        });
    }
}
