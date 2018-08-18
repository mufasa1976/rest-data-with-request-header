package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.representation.rest;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.BaseQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.BaseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static lombok.AccessLevel.PROTECTED;

@RequiredArgsConstructor(access = PROTECTED)
public abstract class BaseController<RESOURCE extends BaseResource, QUERY extends BaseQuery> {
  private final static String MANDATOR_HEADER = "x-mandator";

  final static String REFERENCE = "reference";

  @Autowired(required = false)
  private HttpServletRequest httpServletRequest;

  @GetMapping
  public abstract PagedResources<RESOURCE> findAll(Pageable pageable, @ModelAttribute QUERY query);

  @GetMapping("{" + REFERENCE + "}")
  public abstract ResponseEntity<RESOURCE> findByReference(UUID reference);

  Set<String> getMandators() {
    Enumeration<String> mandatorHeaders = Optional.ofNullable(httpServletRequest)
                                                  .map(request -> request.getHeaders(MANDATOR_HEADER))
                                                  .orElse(Collections.emptyEnumeration());
    return new HashSet<>(Collections.list(mandatorHeaders));
  }
}
