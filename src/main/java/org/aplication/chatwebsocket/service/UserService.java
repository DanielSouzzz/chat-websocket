package org.aplication.chatwebsocket.service;

import org.aplication.chatwebsocket.model.UserEntity;
import org.aplication.chatwebsocket.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity request){
        System.out.println(request);
        return userRepository.save(request);
    }
}
