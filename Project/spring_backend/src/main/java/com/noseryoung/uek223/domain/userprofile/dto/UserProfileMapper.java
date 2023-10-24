package com.noseryoung.uek223.domain.userprofile.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.noseryoung.uek223.core.generic.AbstractMapper;
import com.noseryoung.uek223.domain.userprofile.UserProfile;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper extends AbstractMapper<UserProfile, UserProfileDTO> {
}
