package org.aplication.chatwebsocket.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email(message = "Formato de email inválido")
    @NotBlank
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdat;

    @OneToMany(mappedBy = "sender")
    private List<MessageEntity> messages = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        this.createdat = LocalDateTime.now();
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdat = created_at;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(createdat, that.createdat) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, createdat, messages);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created_at=" + createdat +
                ", messages=" + messages +
                '}';
    }
}
