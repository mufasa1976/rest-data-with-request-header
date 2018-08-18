package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.springframework.hateoas.core.Relation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Relation(value = "mandator", collectionRelation = "mandators")
public class MandatorResource extends BaseResource {
  @NotNull
  @Size(max = 255)
  private String mandator;

  @Builder
  @JsonCreator
  public MandatorResource(
      @JsonProperty("version") Integer version,
      @JsonProperty("lastModifiedAt") ZonedDateTime lastModifiedAt,
      @JsonProperty("mandator") String mandator) {
    super(version, lastModifiedAt);
    this.mandator = mandator;
  }
}
