package org.aplication.chatwebsocket.model;

import jakarta.persistence.*;
import org.aplication.chatwebsocket.model.enums.Chat_Type;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "chats")
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Chat_Type chatType;

    private LocalDateTime createdAt;

    public ChatEntity() {
    }

    public ChatEntity(Long id, Chat_Type chatType, LocalDateTime createdAt) {
        this.id = id;
        this.chatType = chatType;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Chat_Type getChatType() {
        return chatType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChatType(Chat_Type chatType) {
        this.chatType = chatType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChatEntity that = (ChatEntity) o;
        return Objects.equals(id, that.id) && chatType == that.chatType && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatType, createdAt);
    }

    @Override
    public String toString() {
        return "ChatEntity{" +
                "id=" + id +
                ", chatType=" + chatType +
                ", created=" + createdAt +
                '}';
    }
}
