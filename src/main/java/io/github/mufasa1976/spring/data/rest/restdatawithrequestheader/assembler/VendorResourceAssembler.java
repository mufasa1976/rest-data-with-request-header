package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.assembler;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.VendorEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.representation.rest.VendorController;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.VendorResource;
import org.springframework.stereotype.Component;

@Component
public class VendorResourceAssembler extends BaseResourceAssembler<VendorEntity, VendorResource> {
  private final MandatorResourceAssembler mandatorResourceAssembler;

  public VendorResourceAssembler(MandatorResourceAssembler mandatorResourceAssembler) {
    super(VendorController.class, VendorResource.class);
    this.mandatorResourceAssembler = mandatorResourceAssembler;
  }

  @Override
  protected VendorResource toResourceWithoutSelfLink(VendorEntity entity) {
    return VendorResource.builder()
                         .version(entity.getVersion())
                         .lastModifiedAt(entity.getLastModifiedAt())
                         .mandator(mandatorResourceAssembler.toResource(entity.getMandator()))
                         .name(entity.getName())
                         .build();
  }
}
