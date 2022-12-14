package com.example.ananymousChat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenerationTime;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "Chats")
public class Chat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "timestamp with time zone DEFAULT now()")
    private OffsetDateTime creationDateTime;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int lastUsernameUsed;

    @Column(nullable = false)
    private String UUID;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat")
    private List<ChatMessage> chatMessages;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat")
    private List<ChatUser> chatUsers;

    public Chat() {}

    public Chat(String name, OffsetDateTime creationDateTime, int lastUsernameUsed, String UUID, List<ChatMessage> chatMessages, List<ChatUser> chatUsers) {
        this.name = name;
        this.creationDateTime = creationDateTime;
        this.lastUsernameUsed = lastUsernameUsed;
        this.UUID = UUID;
        this.chatMessages = chatMessages;
        this.chatUsers = chatUsers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public int getLastUsernameUsed() {
        return lastUsernameUsed;
    }

    public void setLastUsernameUsed(int lastUsernameUsed) {
        this.lastUsernameUsed = lastUsernameUsed;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public List<ChatUser> getChatUsers() {
        return chatUsers;
    }

    public void setChatUsers(List<ChatUser> chatUsers) {
        this.chatUsers = chatUsers;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", lastUsernameUsed=" + lastUsernameUsed +
                ", UUID='" + UUID + '\'' +
                ", chatMessages=" + chatMessages +
                ", chatUsers=" + chatUsers +
                '}';
    }
}