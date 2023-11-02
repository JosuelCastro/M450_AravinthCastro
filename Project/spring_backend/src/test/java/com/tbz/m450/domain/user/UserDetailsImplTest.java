package com.tbz.m450.domain.user;

import com.tbz.m450.domain.role.Role;
import com.tbz.m450.domain.user.User;
import com.tbz.m450.domain.userprofile.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDetailsImplTest {

    private User user;
    private UserDetailsImpl userDetails;

    @BeforeEach
    public void setUp() {
        // Create a mock User and UserDetailsImpl for testing
        user = mock(User.class);
        when(user.getEmail()).thenReturn("test@example.com");
        when(user.getPassword()).thenReturn("password");

        UserProfile userProfile = mock(UserProfile.class);
        when(userProfile.getId()).thenReturn(java.util.UUID.randomUUID());
        when(user.getProfile()).thenReturn(userProfile);

        userDetails = new UserDetailsImpl(user);
    }

    @Test
    public void testGetPassword() {
        // Call getPassword and verify that it returns the expected password
        String password = userDetails.getPassword();
        assertEquals("password", password);
    }

    @Test
    public void testGetUsername() {
        // Call getUsername and verify that it returns the expected username (email)
        String username = userDetails.getUsername();
        assertEquals("test@example.com", username);
    }

    @Test
    public void testGetProfile() {
        // Call getProfile and verify that it returns the user's profile
        UserProfile profile = userDetails.getProfile();
        assertEquals(user.getProfile(), profile);
    }

    @Test
    public void testIsAccountNonExpired() {
        // Call isAccountNonExpired and verify that it returns true
        boolean accountNonExpired = userDetails.isAccountNonExpired();
        assertEquals(true, accountNonExpired);
    }

    @Test
    public void testIsAccountNonLocked() {
        // Call isAccountNonLocked and verify that it returns true
        boolean accountNonLocked = userDetails.isAccountNonLocked();
        assertEquals(true, accountNonLocked);
    }

    @Test
    public void testIsCredentialsNonExpired() {
        // Call isCredentialsNonExpired and verify that it returns true
        boolean credentialsNonExpired = userDetails.isCredentialsNonExpired();
        assertEquals(true, credentialsNonExpired);
    }

    @Test
    public void testIsEnabled() {
        // Call isEnabled and verify that it returns true
        boolean enabled = userDetails.isEnabled();
        assertEquals(true, enabled);
    }
}
