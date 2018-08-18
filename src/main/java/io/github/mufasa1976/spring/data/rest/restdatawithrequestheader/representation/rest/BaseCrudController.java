package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.representation.rest;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.query.BaseQuery;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.BaseResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

public abstract class BaseCrudController<RESOURCE extends BaseResource, QUERY extends BaseQuery> extends BaseController<RESOURCE, QUERY> {
  @PostMapping
  @ResponseStatus(CREATED)
  public abstract RESOURCE create(@RequestBody RESOURCE resource);

  @PutMapping("{" + REFERENCE + "}")
  public abstract ResponseEntity<RESOURCE> update(UUID reference, RESOURCE resource);

  @DeleteMapping("{" + REFERENCE + "}")
  @ResponseStatus(NO_CONTENT)
  public abstract void delete(UUID reference);
}
