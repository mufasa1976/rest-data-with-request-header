package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.service;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.MandatorQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.MandatorResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;

import java.util.Optional;
import java.util.UUID;

public interface MandatorService {
  PagedResources<MandatorResource> findAll(Pageable pageable, MandatorQuery query);

  Optional<MandatorResource> findByReference(UUID reference);

  MandatorResource create(MandatorResource resource);

  void delete(UUID reference);
}
