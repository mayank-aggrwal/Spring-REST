package com.may.rest.api;

import com.may.rest.entity.AppUser;
import com.may.rest.dto.UserDto;
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
    public UserDto get(@PathVariable("userId") long userId) {
        return service.get(userId);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto user) {
        return service.save(user);
    }

    @PutMapping("{userId}")
    public UserDto update(@PathVariable("userId") long userId, @RequestBody UserDto user) {
        return service.update(userId, user);
    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable("userId") long userId) {
        service.delete(userId);
    }
}
