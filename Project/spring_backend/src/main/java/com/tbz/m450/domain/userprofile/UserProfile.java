package com.tbz.m450.domain.userprofile;

import java.io.Serializable;
import java.util.UUID;

import com.tbz.m450.core.generic.AbstractEntity;

import com.tbz.m450.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Entity
@Table(name = "user_profile")
@Log4j2
@NoArgsConstructor
@Getter
@Setter
public class UserProfile extends AbstractEntity implements Serializable {
    @Column(name = "address")
    private String address;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "profile_picture")
    private String profilePicture;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserProfile(UUID id, String address, String birthdate, String profilePicture) {
        super(id);
        this.address = address;
        this.birthdate = birthdate;
        this.profilePicture = profilePicture;
    }

    @PrePersist
    public void logAddUserProfileAttempt() {
        log.debug("Trying to add new UserProfile");
    }

    @PostPersist
    public void logAddUserProfileSuccess() {
        log.debug("Successfully added new UserProfile");
    }

    @PreRemove
    public void logRemoveUserProfileAttempt() {
        log.debug("Trying to remove UserProfile with ID " + getId());
    }

    @PostRemove
    public void logRemoveUserProfileSuccess() {
        log.debug("Successfully remove UserProfile with ID " + getId());
    }

    @PreUpdate
    public void logUpdateUserProfileAttempt() {
        log.debug("Trying to update UserProfile with ID " + getId());
    }

    @PostUpdate
    public void logUpdateUserProfileSuccess() {
        log.debug("Successfully updated UserProfile with ID " + getId());
    }
}
