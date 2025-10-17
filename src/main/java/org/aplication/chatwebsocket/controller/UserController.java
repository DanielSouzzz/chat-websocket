package org.aplication.chatwebsocket.controller;

import jakarta.validation.Valid;
import org.aplication.chatwebsocket.model.UserEntity;
import org.aplication.chatwebsocket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user){
        UserEntity savedUser = userService.createUser(user);

        URI location = URI.create("/api/users/" + savedUser.getId());

        return ResponseEntity
                .created(location)
                .body(savedUser);
    }

}
