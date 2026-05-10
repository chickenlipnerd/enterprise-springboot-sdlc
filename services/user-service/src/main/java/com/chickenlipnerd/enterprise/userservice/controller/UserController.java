package com.chickenlipnerd.enterprise.userservice.controller;

import com.chickenlipnerd.enterprise.userservice.model.UserSummary;
import com.chickenlipnerd.enterprise.userservice.service.UserApplicationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping
    public List<UserSummary> listUsers() {
        return userApplicationService.listUsers();
    }

    @GetMapping("/{username}")
    public UserSummary getUser(@PathVariable String username) {
        return userApplicationService.getUser(username);
    }
}
