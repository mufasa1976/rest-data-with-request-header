package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "reference"))
@Getter
@EqualsAndHashCode
@ToString
public abstract class BaseEntity implements ReferenceAwareEntity {
  @Version
  @Column(nullable = false)
  private Integer version;

  @NotNull
  @Column(updatable = false)
  private UUID reference = UUID.randomUUID();

  @LastModifiedDate
  @Column(nullable = false)
  private ZonedDateTime lastModifiedAt;
}
