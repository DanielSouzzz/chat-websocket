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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "Operações relacionadas a usuários")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Cria um novo usuário", description = "Recebe um UserEntity válido e cria o usuário, retornando 201 com Location.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user) {
        UserEntity savedUser = userService.createUser(user);

        URI location = URI.create("/api/users/" + savedUser.getId());

        return ResponseEntity
                .created(location)
                .body(savedUser);
    }
}