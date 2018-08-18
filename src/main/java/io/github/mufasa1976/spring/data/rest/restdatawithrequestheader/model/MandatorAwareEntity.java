package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model;

import java.util.UUID;

public interface MandatorAwareEntity {
  void setMandator(MandatorEntity mandator);

  MandatorEntity getMandator();

  UUID getReference();
}
