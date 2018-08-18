package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MandatorQuery extends BaseQuery {
  private String mandator;

  @Builder
  public MandatorQuery(String mandator) {
    this.mandator = mandator;
  }
}
