package org.aplication.chatwebsocket.controller;

import org.aplication.chatwebsocket.model.MessageEntity;
import org.aplication.chatwebsocket.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMsgController {

    private final MessageService messageService;

    public SendMsgController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/chat/{chatId}")
    public MessageEntity sendMessagePrivate(MessageEntity request){

        return messageService.sendMessagePrivate(request);
    }
}