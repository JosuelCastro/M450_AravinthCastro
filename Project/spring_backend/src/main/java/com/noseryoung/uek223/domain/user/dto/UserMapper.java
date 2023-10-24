package com.noseryoung.uek223.domain.user.dto;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.noseryoung.uek223.core.generic.AbstractMapper;
import com.noseryoung.uek223.domain.user.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDTO> {
  User fromUserRegisterDTO(UserRegisterDTO dto);
}
