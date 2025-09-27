package org.aplication.chatwebsocket.controller;

import org.aplication.chatwebsocket.model.MessageEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/chat/{chatId}")
    public MessageEntity sendMessagePrivate(MessageEntity message){
        return new MessageEntity(message.getId(),
                message.getChat(),
                message.getSender(),
                message.getText(),
                message.getCreatedAt()
        );
    }
}