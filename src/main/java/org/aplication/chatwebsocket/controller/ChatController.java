package org.aplication.chatwebsocket.controller;

import jakarta.validation.Valid;
import org.aplication.chatwebsocket.model.ChatEntity;
import org.aplication.chatwebsocket.service.ChatService;
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
@RequestMapping("/api/chats")
@Tag(name = "Chats", description = "Operações relacionadas a chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @PostMapping
    @Operation(summary = "Cria um novo chat", description = "Recebe um ChatEntity válido e cria o chat, retornando 201 com Location.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Chat criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ChatEntity> createChat(@Valid @RequestBody ChatEntity chat){
        ChatEntity savedChat = chatService.createChat(chat);

        URI location = URI.create("/api/chats/" + savedChat.getId());

        return ResponseEntity
                .created(location)
                .body(savedChat);
    }
}