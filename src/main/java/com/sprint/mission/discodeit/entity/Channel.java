package com.sprint.mission.discodeit.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Channel {
    private UUID id;
    private Long createdAt;
    private Long updatedAt;

    private String channelName;
    private String description;
    private User owner;
    private List<User> userList;
    private List<Message> messageList;

    public Channel(String channelName, String description, User owner) {
        id = UUID.randomUUID();
        createdAt = System.currentTimeMillis();
        updatedAt = System.currentTimeMillis();
        this.channelName = channelName;
        this.description = description;
        this.owner = owner;
        userList = new ArrayList<>(List.of(owner));
        messageList = new ArrayList<>();
    }

    public UUID getId() { return id; }
    public Long getCreatedAt() { return createdAt; }
    public Long getUpdatedAt() { return updatedAt; }
    public String getChannelName() { return channelName; }
    public String getDescription() { return description; }
    public User getOwner() { return owner; }
    public List<User> getUserList() { return userList; }
    public List<Message> getMessageList() { return messageList; }

    public void update(String channelName, String description, User owner) {
        this.channelName = channelName;
        this.description = description;
        this.owner = owner;
        updatedAt = System.currentTimeMillis();
    }


    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", channelName='" + channelName + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", userList=" + userList +
                ", messageList=" + messageList +
                '}';
    }
}
