package com.tbz.m450.domain.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void shouldRegisterUserWithoutPassword() {
        // Given
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        User result = userService.registerUser(user);

        // Then
        assertEquals(user.getEmail(), result.getEmail());
    }

    @Test
    void shouldFindUserById() {
        // Given
        UUID userId = UUID.randomUUID();
        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // When
        User result = userService.findById(userId);

        // Then
        assertEquals(userId, result.getId());
    }
}
