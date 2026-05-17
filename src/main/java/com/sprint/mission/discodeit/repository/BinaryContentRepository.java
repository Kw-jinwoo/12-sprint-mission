package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.BinaryContent;

import java.util.List;
import java.util.UUID;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinaryContentRepository extends JpaRepository<BinaryContent, UUID> {

//  BinaryContent save(BinaryContent binaryContent);

//  Optional<BinaryContent> findById(UUID id);

  List<BinaryContent> findAllByIdIn(List<UUID> ids);

  boolean existsById(@NonNull UUID id);

  void deleteById(@NonNull UUID id);
}
