package org.aplication.chatwebsocket.controller;

import org.aplication.chatwebsocket.model.MessageEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/chat")
    public MessageEntity sendMessage(MessageEntity message){
        return new MessageEntity(message.getId(),
                message.getChat(),
                message.getSender(),
                message.getText(),
                message.getCreatedAt()
        );
    }
}