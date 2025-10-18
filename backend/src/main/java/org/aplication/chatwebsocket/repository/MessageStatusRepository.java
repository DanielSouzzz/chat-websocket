package org.aplication.chatwebsocket.repository;

import org.aplication.chatwebsocket.model.MessageStatus;
import org.aplication.chatwebsocket.model.MessageStatusId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageStatusRepository extends JpaRepository<MessageStatus, MessageStatusId> {
}
