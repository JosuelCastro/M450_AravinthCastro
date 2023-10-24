package com.noseryoung.uek223.domain.userprofile;

import com.noseryoung.uek223.domain.user.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.noseryoung.uek223.domain.userprofile.dto.UserProfileDTO;
import com.noseryoung.uek223.domain.userprofile.dto.UserProfileMapper;

@Validated
@Log4j2
@RestController
@EnableTransactionManagement
@RequestMapping("/userprofile")
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;

    @Autowired
    public UserProfileController(UserProfileService userProfileService, UserProfileMapper userProfileMapper) {
        this.userProfileService = userProfileService;
        this.userProfileMapper = userProfileMapper;
    }

    @GetMapping
    public ResponseEntity<UserProfileDTO> getProfileById(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        HttpStatus status = HttpStatus.OK;
        UserProfile profile = userDetails.getProfile();
        return new ResponseEntity<>(userProfileMapper.toDTO(profile), status);
    }


    @PutMapping
    @PreAuthorize("hasAuthority('USER_MODIFY')")
    public ResponseEntity<UserProfileDTO> updateProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, @Valid @RequestBody UserProfileDTO profileDTO) {
        UserProfile profile = userProfileService.updateById(userDetails.getProfile().getId(), userProfileMapper.fromDTO(profileDTO));
        return new ResponseEntity<>(userProfileMapper.toDTO(profile), HttpStatus.OK);
    }
}
