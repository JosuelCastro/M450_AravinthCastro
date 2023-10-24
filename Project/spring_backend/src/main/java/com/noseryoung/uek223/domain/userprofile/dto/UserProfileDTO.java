package com.noseryoung.uek223.domain.userprofile.dto;

import java.net.URI;
import java.util.UUID;

import com.noseryoung.uek223.core.generic.AbstractDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserProfileDTO extends AbstractDTO {
    private String address;
    private String birthdate;
    private String profilePicture;

    public UserProfileDTO(UUID id, String address, String birthdate, String email, String profilePicture) {
        super(id);
        this.address = address;
        this.birthdate = birthdate;
        this.profilePicture = profilePicture;
    }
}
