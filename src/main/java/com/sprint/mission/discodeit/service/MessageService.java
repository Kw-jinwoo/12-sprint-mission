package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    /// Create
    void create(Message message);

    /// Read
    Message findById(UUID id);
    List<Message> findByUserId(UUID id);
    List<Message> findByChannelId(UUID id);
    List<Message> findAll();

    /// Update
    void updateById(UUID id, String content);

    /// Delete
    void deleteById(UUID id);
}
