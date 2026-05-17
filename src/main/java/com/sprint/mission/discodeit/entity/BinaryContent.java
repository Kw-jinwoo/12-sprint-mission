package com.sprint.mission.discodeit.entity;

import com.sprint.mission.discodeit.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@Table(name = "binary_contents")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BinaryContent extends BaseEntity {

  @NotNull
  @Column(name = "file_name", nullable = false)
  private String fileName;

  @NotNull
  @Column(name = "size", nullable = false)
  private Long size;

  @NotNull
  @Column(name = "content_type", length = 100, nullable = false)
  private String contentType;

  @NotNull
  @Column(name = "bytes", nullable = false)
  private byte[] bytes;

}
