package org.aplication.chatwebsocket.controller;

import org.aplication.chatwebsocket.model.MessageEntity;
import org.aplication.chatwebsocket.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/chat/{chatId}")
    public MessageEntity sendMessagePrivate(MessageEntity request){
        MessageEntity message = chatService.sendMessagePrivate(request);

        return new MessageEntity(message.getId(),
                message.getChat(),
                message.getSender(),
                message.getText(),
                message.getCreatedAt()
        );
    }
}