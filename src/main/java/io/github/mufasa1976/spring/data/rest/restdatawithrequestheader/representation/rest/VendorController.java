package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.representation.rest;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.VendorQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.VendorResource;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vendors")
public class VendorController extends BaseCrudController<VendorResource, VendorQuery> {
  private final VendorService vendorService;

  @Override
  public VendorResource create(@RequestBody VendorResource resource) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ResponseEntity<VendorResource> update(@PathVariable(REFERENCE) UUID reference, @RequestBody VendorResource resource) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(@PathVariable(REFERENCE) UUID reference) {
    throw new UnsupportedOperationException();
  }

  @Override
  public PagedResources<VendorResource> findAll(Pageable pageable, VendorQuery query) {
    return vendorService.findAll(pageable, getMandators(), query);
  }

  @Override
  public ResponseEntity<VendorResource> findByReference(@PathVariable(REFERENCE) UUID reference) {
    return vendorService.findByReference(reference, getMandators())
                        .map(ResponseEntity::ok)
                        .orElseGet(ResponseEntity.notFound()::build);
  }
}
