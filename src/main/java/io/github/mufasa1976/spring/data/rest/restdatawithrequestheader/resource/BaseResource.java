package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

import java.time.ZonedDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor(access = PROTECTED)
@EqualsAndHashCode(callSuper = false)
@ToString
public abstract class BaseResource extends ResourceSupport {
  private Integer version;
  private ZonedDateTime lastModifiedAt;
}
