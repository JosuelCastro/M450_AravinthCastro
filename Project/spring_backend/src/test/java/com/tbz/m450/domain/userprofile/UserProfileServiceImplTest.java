package com.tbz.m450.domain.userprofile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserProfileServiceImplTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileServiceImpl userProfileService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUserProfile() {
        // Given
        UserProfile userProfile = new UserProfile();
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);

        // When
        UserProfile result = userProfileService.save(userProfile);

        // Then
        assertEquals(userProfile, result);
    }

    @Test
    public void testFindById() {
        // Given
        UUID userId = UUID.randomUUID();
        UserProfile userProfile = new UserProfile();
        when(userProfileRepository.findById(userId)).thenReturn(Optional.of(userProfile));

        // When
        UserProfile result = userProfileService.findById(userId);

        // Then
        assertEquals(userProfile, result);
    }

    @Test
    public void testExistsById() {
        // Given
        UUID userId = UUID.randomUUID();
        when(userProfileRepository.existsById(userId)).thenReturn(true);

        // When
        boolean exists = userProfileService.existsById(userId);

        // Then
        assertTrue(exists);
    }

    @Test
    public void testDeleteByIdThrowsExceptionWhenNotFound() {
        // Given
        UUID userId = UUID.randomUUID();
        when(userProfileRepository.findById(userId)).thenReturn(Optional.empty());

        // Then
        assertThrows(NoSuchElementException.class, () -> userProfileService.deleteById(userId));
    }

    @Test
    public void testUpdateByIdThrowsExceptionWhenNotFound() {
        // Given
        UUID userId = UUID.randomUUID();
        UserProfile userProfile = new UserProfile();
        when(userProfileRepository.findById(userId)).thenReturn(Optional.empty());

        // Then
        assertThrows(NoSuchElementException.class, () -> userProfileService.updateById(userId, userProfile));
    }
}
