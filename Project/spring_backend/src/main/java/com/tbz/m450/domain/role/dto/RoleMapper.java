
package com.tbz.m450.domain.role.dto;

import com.tbz.m450.core.generic.AbstractMapper;
import com.tbz.m450.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends AbstractMapper<Role, RoleDTO> {
}
