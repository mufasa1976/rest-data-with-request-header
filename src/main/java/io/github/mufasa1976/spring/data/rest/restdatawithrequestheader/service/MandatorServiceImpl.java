package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.exception.RowAlreadyExistsException;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.exception.RowNotFoundException;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.MandatorEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.MandatorQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories.MandatorRepository;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.MandatorResource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.QMandatorEntity.mandatorEntity;

@Service
@RequiredArgsConstructor
public class MandatorServiceImpl implements MandatorService {
  private final MandatorRepository mandatorRepository;
  private final ResourceAssembler<MandatorEntity, MandatorResource> resourceAssembler;
  private final PagedResourcesAssembler<MandatorEntity> pagedResourcesAssembler;

  @Override
  public PagedResources<MandatorResource> findAll(Pageable pageable, MandatorQuery query) {
    Page<MandatorEntity> page = mandatorRepository.findAll(mapQuery(query), pageable);
    return pagedResourcesAssembler.toResource(page, resourceAssembler);
  }

  private Predicate mapQuery(MandatorQuery query) {
    BooleanBuilder queryBuilder = new BooleanBuilder();
    // mandator
    Optional.ofNullable(query)
            .map(MandatorQuery::getMandator)
            .map(mandatorEntity.mandator::containsIgnoreCase)
            .ifPresent(queryBuilder::and);
    return queryBuilder;
  }

  @Override
  public Optional<MandatorResource> findByReference(UUID reference) {
    return mandatorRepository.findOptionalByReference(reference)
                             .map(resourceAssembler::toResource);
  }

  @Override
  @Transactional
  public MandatorResource create(MandatorResource resource) {
    if (mandatorRepository.existsByMandator(resource.getMandator())) {
      throw new RowAlreadyExistsException(MandatorEntity.class, Collections.singletonMap("mandator", resource.getMandator()));
    }
    MandatorEntity entity = MandatorEntity.builder()
                                          .mandator(resource.getMandator())
                                          .build();
    entity = mandatorRepository.saveAndFlush(entity);
    return resourceAssembler.toResource(entity);
  }

  @Override
  @Transactional
  public void delete(UUID reference) {
    mandatorRepository.delete(
        mandatorRepository.findOptionalByReference(reference)
                          .orElseThrow(() -> new RowNotFoundException(MandatorEntity.class, reference)));
  }
}
