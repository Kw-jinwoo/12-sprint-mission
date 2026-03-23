package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    // Create
    void create(User user);

    // Read
    User findById(UUID id);
    List<User> findAll();

    // Update
    User updateById(UUID id, String username, String email, String password, String nickname);

    // Delete
    void deleteById(UUID id);
}
