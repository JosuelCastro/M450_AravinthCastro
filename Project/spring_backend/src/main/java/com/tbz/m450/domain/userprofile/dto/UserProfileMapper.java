package com.tbz.m450.domain.userprofile.dto;

import com.tbz.m450.core.generic.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.tbz.m450.domain.userprofile.UserProfile;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper extends AbstractMapper<UserProfile, UserProfileDTO> {
}
