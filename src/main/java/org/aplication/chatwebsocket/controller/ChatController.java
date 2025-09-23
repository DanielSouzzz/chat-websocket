package org.aplication.chatwebsocket.controller;

import org.aplication.chatwebsocket.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/chat")
    public ChatMessage sendMessage(ChatMessage message){
        System.out.println("Mensagem recebida: "+ message.getText());
        return message;
    }
}
