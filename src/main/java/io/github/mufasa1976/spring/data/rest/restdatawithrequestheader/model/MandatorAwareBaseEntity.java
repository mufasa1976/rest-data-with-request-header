package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
abstract class MandatorAwareBaseEntity extends PrimaryKeyBaseEntity implements MandatorAwareEntity {
  @NotNull
  @ManyToOne
  @JoinColumn(name = "mandator")
  private MandatorEntity mandator;

  protected MandatorAwareBaseEntity() {
    super();
  }

  protected MandatorAwareBaseEntity(MandatorEntity mandator) {
    super();
    this.mandator = mandator;
  }
}
