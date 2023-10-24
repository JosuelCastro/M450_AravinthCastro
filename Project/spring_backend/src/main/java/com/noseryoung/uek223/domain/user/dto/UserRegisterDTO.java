package com.noseryoung.uek223.domain.user.dto;

import java.util.UUID;

import com.noseryoung.uek223.core.generic.AbstractDTO;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserRegisterDTO extends AbstractDTO {

  private String username;

  @Email
  private String email;

  private String password;

  public UserRegisterDTO(UUID id, String username, String email, String password) {
    super(id);
    this.username = username;
    this.email = email;
    this.password = password;
  }
}
