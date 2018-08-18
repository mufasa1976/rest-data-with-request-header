package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.assembler;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.BaseEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.representation.rest.BaseController;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.BaseResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public abstract class BaseResourceAssembler<ENTITY extends BaseEntity, RESOURCE extends BaseResource> extends ResourceAssemblerSupport<ENTITY, RESOURCE> {
  private final Class<? extends BaseController> controllerClass;

  protected BaseResourceAssembler(Class<? extends BaseController> controllerClass, Class<RESOURCE> resourceType) {
    super(controllerClass, resourceType);
    this.controllerClass = controllerClass;
  }

  @Override
  public RESOURCE toResource(ENTITY entity) {
    RESOURCE resource = toResourceWithoutSelfLink(entity);
    addSelfLink(resource, getReference(entity));
    resource.add(createAdditionalLinks(entity));
    return resource;
  }

  protected void addSelfLink(RESOURCE resource, UUID reference) {
    resource.add(linkTo(methodOn(controllerClass).findByReference(reference)).withSelfRel());
  }

  protected UUID getReference(ENTITY entity) {
    return entity.getReference();
  }

  protected abstract RESOURCE toResourceWithoutSelfLink(ENTITY entity);

  protected Iterable<Link> createAdditionalLinks(ENTITY entity) {
    return Collections.emptyList();
  }
}
