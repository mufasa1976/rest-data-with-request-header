package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vendors", uniqueConstraints = @UniqueConstraint(columnNames = { "mandator", "name" }))
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VendorEntity extends MandatorAwareBaseEntity {
  @NotNull
  @Size(max = 255)
  private String name;

  @Builder
  private VendorEntity(MandatorEntity mandator, String name) {
    super(mandator);
    this.name = name;
  }
}
