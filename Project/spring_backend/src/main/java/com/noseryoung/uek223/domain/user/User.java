package com.noseryoung.uek223.domain.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.noseryoung.uek223.core.generic.AbstractEntity;
import com.noseryoung.uek223.domain.role.Role;

import com.noseryoung.uek223.domain.userprofile.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

@Entity
@Table(name = "users")
@Log4j2
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class User extends AbstractEntity implements Serializable {

    @Column(name = "username")
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy ="user")
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @JsonBackReference
    private UserProfile profile;

    public User(UUID id, String username, String email, String password, Set<Role> roles) {
        super(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @PrePersist
    public void logAddUserAttempt() {
        log.debug("Trying to add new User");
    }

    @PostPersist
    public void logAddUserSuccess() {
        log.debug("Successfully added new User");
    }

    @PreRemove
    public void logRemoveUserAttempt() {
        log.debug("Trying to remove User with ID " + getId());
    }

    @PostRemove
    public void logRemoveUserSuccess() {
        log.debug("Successfully remove User with ID " + getId());
    }

    @PreUpdate
    public void logUpdateUserAttempt() {
        log.debug("Trying to update User with ID " + getId());
    }

    @PostUpdate
    public void logUpdateUserSuccess() {
        log.debug("Successfully updated User with ID " + getId());
    }
}
