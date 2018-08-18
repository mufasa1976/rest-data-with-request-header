package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.representation.rest;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.MandatorQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.MandatorResource;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.service.MandatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mandators")
public class MandatorController extends BaseCrudController<MandatorResource, MandatorQuery> {
  private final MandatorService mandatorService;

  @Override
  public MandatorResource create(@RequestBody MandatorResource resource) {
    return mandatorService.create(resource);
  }

  @Override
  public ResponseEntity<MandatorResource> update(@PathVariable(REFERENCE) UUID reference, @RequestBody MandatorResource resource) {
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(resource);
  }

  @Override
  public void delete(@PathVariable(REFERENCE) UUID reference) {
    mandatorService.delete(reference);
  }

  @Override
  public PagedResources<MandatorResource> findAll(Pageable pageable, MandatorQuery query) {
    return mandatorService.findAll(pageable, query);
  }

  @Override
  public ResponseEntity<MandatorResource> findByReference(@PathVariable(REFERENCE) UUID reference) {
    return mandatorService.findByReference(reference)
                          .map(ResponseEntity::ok)
                          .orElseGet(ResponseEntity.notFound()::build);
  }
}
