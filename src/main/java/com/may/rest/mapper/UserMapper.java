package com.may.rest.mapper;

import com.may.rest.dto.UserDto;
import com.may.rest.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper extends BaseMapper<AppUser, UserDto> {
}
