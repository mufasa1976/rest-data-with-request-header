package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class PrimaryKeyBaseEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(insertable = false, updatable = false)
  private Long id;
}
