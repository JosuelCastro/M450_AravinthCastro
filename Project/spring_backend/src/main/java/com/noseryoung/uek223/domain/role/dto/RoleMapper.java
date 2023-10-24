
package com.noseryoung.uek223.domain.role.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.noseryoung.uek223.core.generic.AbstractMapper;
import com.noseryoung.uek223.domain.role.Role;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends AbstractMapper<Role, RoleDTO> {
}
