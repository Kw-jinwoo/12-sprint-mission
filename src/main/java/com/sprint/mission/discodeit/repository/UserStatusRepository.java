package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.UserStatus;

import java.util.Optional;
import java.util.UUID;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepository extends JpaRepository<UserStatus, UUID> {

//  UserStatus save(UserStatus userStatus);

//  Optional<UserStatus> findById(UUID id);

  Optional<UserStatus> findByUserId(UUID userId);

//  List<UserStatus> findAll();

  boolean existsById(@NonNull UUID id);

  void deleteById(@NonNull UUID id);

  void deleteByUserId(UUID userId);
}
