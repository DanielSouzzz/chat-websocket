package org.aplication.chatwebsocket.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private ChatEntity chat;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private UserEntity receiver;

    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public MessageEntity() {
    }

    public MessageEntity(ChatEntity chat, UserEntity sender, String text) {
        this.chat = chat;
        this.sender = sender;
        this.text = text;
    }

    public MessageEntity(Long id, ChatEntity chat, UserEntity sender, String text, LocalDateTime createdAt) {
        this.id = id;
        this.chat = chat;
        this.sender = sender;
        this.text = text;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getText() {
        return text;
    }

    public UserEntity getSender() {
        return sender;
    }

    public ChatEntity getChat() {
        return chat;
    }

    public Long getId() {
        return id;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(chat, that.chat) && Objects.equals(sender, that.sender) && Objects.equals(text, that.text) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chat, sender, text, createdAt);
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", chat=" + chat +
                ", sender=" + sender +
                ", text='" + text + '\'' +
                ", time=" + createdAt +
                '}';
    }

}
