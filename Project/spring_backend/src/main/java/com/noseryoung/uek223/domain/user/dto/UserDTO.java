package com.noseryoung.uek223.domain.user.dto;

import java.util.Set;
import java.util.UUID;

import com.noseryoung.uek223.core.generic.AbstractDTO;
import com.noseryoung.uek223.domain.role.dto.RoleDTO;

import com.noseryoung.uek223.domain.userprofile.UserProfile;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserDTO extends AbstractDTO {

    private String username;

    @Email
    private String email;

    @Valid
    private Set<RoleDTO> roles;

    private UserProfile profile;

    public UserDTO(UUID id, String username, String email, Set<RoleDTO> roles, UserProfile profile) {
        super(id);
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.profile = profile;
    }

}
