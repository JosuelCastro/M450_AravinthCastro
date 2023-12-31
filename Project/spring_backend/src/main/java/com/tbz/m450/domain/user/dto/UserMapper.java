package com.tbz.m450.domain.user.dto;


import com.tbz.m450.core.generic.AbstractMapper;
import com.tbz.m450.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDTO> {
  User fromUserRegisterDTO(UserRegisterDTO dto);
}
