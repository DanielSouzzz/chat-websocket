package org.aplication.chatwebsocket.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message_status")
public class MessageStatus {
    @EmbeddedId
    private MessageStatusId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("messageId")
    @JoinColumn(name = "message_id")
    private MessageEntity message;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "is_read")
    private Boolean isRead = false;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    public MessageStatus() {}

    public MessageStatus(MessageStatusId id, MessageEntity message, UserEntity user, Boolean isRead) {
        this.id = id;
        this.message = message;
        this.user = user;
        this.isRead = isRead;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }

    public void setReadAt(LocalDateTime readAt) {
        this.readAt = readAt;
    }

    public MessageStatusId getId() {
        return id;
    }

    public void setId(MessageStatusId id) {
        this.id = id;
    }
}
