package org.aplication.chatwebsocket.controller;

import org.aplication.chatwebsocket.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/chat")
    public ChatMessage sendMessage(ChatMessage message){
        return new ChatMessage(message.getFrom(), message.getText(), Instant.now());
    }
}