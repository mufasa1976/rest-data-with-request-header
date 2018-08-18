package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.VendorEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.VendorQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories.VendorRepository;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.VendorResource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.QVendorEntity.vendorEntity;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {
  private final VendorRepository vendorRepository;
  private final ResourceAssembler<VendorEntity, VendorResource> resourceAssembler;
  private final PagedResourcesAssembler<VendorEntity> pagedResourcesAssembler;

  @Override
  public PagedResources<VendorResource> findAll(Pageable pageable, Set<String> mandators, VendorQuery vendorQuery) {
    Page<VendorEntity> page = vendorRepository.findAll(mapQuery(vendorQuery, mandators), pageable);
    return pagedResourcesAssembler.toResource(page, resourceAssembler);
  }

  private Predicate mapQuery(VendorQuery vendorQuery, Set<String> mandators) {
    BooleanBuilder queryBuilder = new BooleanBuilder();
    Optional.ofNullable(vendorQuery)
            .map(VendorQuery::getName)
            .map(vendorEntity.name::containsIgnoreCase)
            .ifPresent(queryBuilder::and);
    Optional.ofNullable(mandators)
            .filter(m -> !m.isEmpty())
            .map(vendorEntity.mandator.mandator::in)
            .ifPresent(queryBuilder::and);
    return queryBuilder;
  }

  @Override
  public Optional<VendorResource> findByReference(UUID reference, Set<String> mandators) {
    return vendorRepository.findOptionalByReferenceAndMandator(reference, mandators)
                           .map(resourceAssembler::toResource);
  }
}
