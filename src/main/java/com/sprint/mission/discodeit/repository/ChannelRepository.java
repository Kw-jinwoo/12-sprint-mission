package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.UUID;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, UUID> {

//  Channel save(Channel channel);

//  Optional<Channel> findById(UUID id);

//  List<Channel> findAll();

  boolean existsById(@NonNull UUID id);

  void deleteById(@NonNull UUID id);
}
