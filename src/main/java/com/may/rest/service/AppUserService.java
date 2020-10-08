package com.may.rest.service;

import com.may.rest.entity.AppUser;
import com.may.rest.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserService extends CrudService<AppUser, Long, AppUserRepository> {

    protected AppUserService(AppUserRepository repository) {
        super(repository);
    }

    public AppUser update(Long id, AppUser user) {
        user.setId(id);
        return save(user);
    }

}
