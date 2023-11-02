package com.tbz.m450.domain.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testUserCreation() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setUsername("testUser");

        assertEquals("test@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals("testUser", user.getUsername());
    }
}
