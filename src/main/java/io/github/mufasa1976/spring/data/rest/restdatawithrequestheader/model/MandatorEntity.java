package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "mandators", uniqueConstraints = @UniqueConstraint(columnNames = "reference"))
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Builder
public class MandatorEntity extends BaseEntity {
  @Id
  @NotNull
  @Size(max = 255)
  @Column(updatable = false)
  private String mandator;
}
