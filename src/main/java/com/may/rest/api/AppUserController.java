package com.may.rest.api;

import com.may.rest.entity.AppUser;
import com.may.rest.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class AppUserController {

    private final AppUserService service;

    @Autowired
    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping("{userId}")
    public AppUser get(@PathVariable("userId") long userId) {
        return service.get(userId);
    }

    @GetMapping
    public List<AppUser> getAll() {
        return service.getAll();
    }

    //TODO Replace AppUser persistent entity with a simple POJO or DTO object.
    @PostMapping
    public AppUser create(@RequestBody AppUser user) {
        return service.save(user);
    }

    //TODO Replace AppUser persistent entity with a simple POJO or DTO object.
    @PutMapping("{userId}")
    public AppUser update(@PathVariable("userId") long userId, @RequestBody AppUser user) {
        return service.update(userId, user);
    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable("userId") long userId) {
        service.delete(userId);
    }
}
