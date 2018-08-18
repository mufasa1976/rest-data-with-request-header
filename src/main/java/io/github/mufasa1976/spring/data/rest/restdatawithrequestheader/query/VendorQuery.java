package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VendorQuery extends BaseQuery {
  private String mandator;
  private String name;

  @Builder
  public VendorQuery(
      String mandator,
      String name) {
    this.mandator = mandator;
    this.name = name;
  }
}
