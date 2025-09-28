package org.aplication.chatwebsocket.service;

import org.aplication.chatwebsocket.model.ChatEntity;
import org.aplication.chatwebsocket.model.MessageEntity;
import org.aplication.chatwebsocket.model.MessageStatus;
import org.aplication.chatwebsocket.model.UserEntity;
import org.aplication.chatwebsocket.repository.ChatRepository;
import org.aplication.chatwebsocket.repository.MessageRepository;
import org.aplication.chatwebsocket.repository.MessageStatusRepository;
import org.aplication.chatwebsocket.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final MessageStatusRepository messageStatusRepository;
    private final UserRepository userRepository;

    public ChatService(ChatRepository chatRepository, MessageRepository messageRepository, MessageStatusRepository messageStatusRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.messageStatusRepository = messageStatusRepository;
        this.userRepository = userRepository;
    }

    public MessageEntity sendMessagePrivate(MessageEntity request) {
        ChatEntity chat = chatRepository.findById(request.getId()).orElseThrow();
        UserEntity sender = userRepository.findById(request.getSender().getId()).orElseThrow();

        var message = new MessageEntity();
        message.setChat(chat);
        message.setSender(sender);
        message.setText(request.getText());

        message = messageRepository.save(message);

        var messageStatus = new MessageStatus();
        messageStatus.setMessage(message);
        messageStatus.setUser(sender);
        messageStatus.setRead(false);
        messageStatus.setReadAt(null);

        messageStatusRepository.save(messageStatus);

        return message;
    }
}
