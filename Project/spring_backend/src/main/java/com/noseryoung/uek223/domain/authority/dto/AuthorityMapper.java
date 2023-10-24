package com.noseryoung.uek223.domain.authority.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.noseryoung.uek223.core.generic.AbstractMapper;
import com.noseryoung.uek223.domain.authority.Authority;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper extends AbstractMapper<Authority, AuthorityDTO> {
}

