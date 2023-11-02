package com.tbz.m450.domain.userprofile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tbz.m450.domain.userprofile.UserProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class UserProfileServiceTest {

    @Autowired
    private UserProfileService userProfileService;

    @MockBean
    private UserProfileRepository userProfileRepository;

    @Test
    void shouldSaveUserProfile() {
        // Given
        UserProfile userProfile = new UserProfile();
        userProfile.setAddress("123 Main St");

        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(userProfile);

        // When
        UserProfile result = userProfileService.save(userProfile);

        // Then
        assertEquals(userProfile.getAddress(), result.getAddress());
    }

    @Test
    void shouldFindUserProfileById() {
        // Given
        UUID profileId = UUID.randomUUID();
        UserProfile userProfile = new UserProfile();
        userProfile.setId(profileId);

        when(userProfileRepository.findById(profileId)).thenReturn(Optional.of(userProfile));

        // When
        UserProfile result = userProfileService.findById(profileId);

        // Then
        assertEquals(profileId, result.getId());
    }

}
