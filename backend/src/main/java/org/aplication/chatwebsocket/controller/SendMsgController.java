package org.aplication.chatwebsocket.controller;

import org.aplication.chatwebsocket.model.MessageEntity;
import org.aplication.chatwebsocket.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@RestController
public class SendMsgController {
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;

    public SendMsgController(SimpMessagingTemplate messagingTemplate, MessageService messageService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    @MessageMapping("/sendPrivateMessage")
    public void sendMessagePrivate(MessageEntity messageRequest){
        MessageEntity message = messageService.sendMessagePrivate(messageRequest);

        messagingTemplate.convertAndSendToUser(
                message.getReceiver().getId().toString(),
                "/queue/messages",
                message
        );

        messagingTemplate.convertAndSendToUser(
                message.getSender().getId().toString(),"/queue/messages", message);
    }
}