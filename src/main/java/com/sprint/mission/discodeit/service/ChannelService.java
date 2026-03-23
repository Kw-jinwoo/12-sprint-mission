package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface ChannelService {
    /// Create
    void create(Channel channel);

    /// Read
    Channel findById(UUID id);
    List<Channel> findAll();

    /// Update
    void updateById(UUID id, String channelName, String description, User owner);
    void addUser(UUID id, User user);
    void deleteUser(UUID id, User user);
    void addMessage();
    void updateMessage();
    void deleteMessage();

    /// Delete
    void deleteById(UUID id);
}
