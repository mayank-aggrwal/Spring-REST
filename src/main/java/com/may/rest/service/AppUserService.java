package com.may.rest.service;

import com.may.rest.dto.UserDto;
import com.may.rest.entity.AppUser;
import com.may.rest.mapper.UserMapper;
import com.may.rest.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserService extends CrudService<AppUser, UserDto, Long, AppUserRepository, UserMapper> {

    protected AppUserService(AppUserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    public UserDto update(Long id, UserDto user) {
        user.setId(id);
        return save(user);
    }

}
