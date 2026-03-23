package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Message {
    private UUID id;
    private Long createdAt;
    private Long updatedAt;

    private String content;
    private boolean isEdited;
    private User sendUser;
    private Channel channel;

    public Message(String content, User sendUser, Channel channel) {
        id = UUID.randomUUID();
        createdAt = System.currentTimeMillis();
        updatedAt = System.currentTimeMillis();
        this.content = content;
        isEdited = false;
        this.sendUser = sendUser;
        this.channel = channel;
    }

    public UUID getId() { return id; }
    public Long getCreatedAt() { return createdAt; }
    public Long getUpdatedAt() { return updatedAt; }
    public String getContent() { return content; }
    public boolean isEdited() { return isEdited; }
    public User getSendUser() { return sendUser; }
    public Channel getChannel() { return channel; }

    public void update(String content) {
        this.content = content;
        isEdited = true;
        updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", content='" + content + '\'' +
                ", isEdited=" + isEdited +
                ", sendUser=" + sendUser +
                ", channel=" + channel +
                '}';
    }
}
