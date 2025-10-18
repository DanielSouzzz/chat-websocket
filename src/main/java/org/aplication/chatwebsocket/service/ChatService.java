package org.aplication.chatwebsocket.service;

import jakarta.validation.Valid;
import org.aplication.chatwebsocket.model.ChatEntity;
import org.aplication.chatwebsocket.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public ChatEntity createChat(@Valid ChatEntity chat) {
        return chatRepository.save(chat);
    }
}