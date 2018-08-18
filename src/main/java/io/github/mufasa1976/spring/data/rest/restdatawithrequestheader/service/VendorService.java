package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.service;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.VendorQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.VendorResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface VendorService {
  PagedResources<VendorResource> findAll(Pageable pageable, Set<String> mandators, VendorQuery vendorQuery);

  Optional<VendorResource> findByReference(UUID reference, Set<String> mandators);
}
