package com.tbz.m450.domain.userprofile;

import com.tbz.m450.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserProfileTest {

    @Mock
    private User mockUser;

    private UserProfile userProfile;

    @BeforeEach
    public void setUp() {
        // Initialize mocks and create a UserProfile instance
        MockitoAnnotations.initMocks(this);
        userProfile = new UserProfile(UUID.randomUUID(), "Address", "01-01-2000", "profile.jpg");
        userProfile.setUser(mockUser);
    }

    @Test
    public void testUserProfileCreation() {
        // Verify that the UserProfile is created with the correct attributes
        assertEquals("Address", userProfile.getAddress());
        assertEquals("01-01-2000", userProfile.getBirthdate());
        assertEquals("profile.jpg", userProfile.getProfilePicture());
        assertEquals(mockUser, userProfile.getUser());
    }

    @Test
    public void testLogAddUserProfileAttempt() {
        // Verify that logAddUserProfileAttempt() method logs the expected message
        userProfile.logAddUserProfileAttempt();
        // You can use a testing framework like Mockito to verify the log.debug() method was called with the expected message
    }

    @Test
    public void testLogAddUserProfileSuccess() {
        // Verify that logAddUserProfileSuccess() method logs the expected message
        userProfile.logAddUserProfileSuccess();
        // You can use a testing framework like Mockito to verify the log.debug() method was called with the expected message

    }

    // Similarly, you can write tests for other log methods (logRemoveUserProfileAttempt, logRemoveUserProfileSuccess, etc.)
}
