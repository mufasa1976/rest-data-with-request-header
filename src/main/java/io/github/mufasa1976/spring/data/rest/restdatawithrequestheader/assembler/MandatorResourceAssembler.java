package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.assembler;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.MandatorEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.representation.rest.MandatorController;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.resource.MandatorResource;
import org.springframework.stereotype.Component;

@Component
public class MandatorResourceAssembler extends BaseResourceAssembler<MandatorEntity, MandatorResource> {
  public MandatorResourceAssembler() {
    super(MandatorController.class, MandatorResource.class);
  }

  @Override
  protected MandatorResource toResourceWithoutSelfLink(MandatorEntity entity) {
    return MandatorResource.builder()
                           .version(entity.getVersion())
                           .lastModifiedAt(entity.getLastModifiedAt())
                           .mandator(entity.getMandator())
                           .build();
  }
}
