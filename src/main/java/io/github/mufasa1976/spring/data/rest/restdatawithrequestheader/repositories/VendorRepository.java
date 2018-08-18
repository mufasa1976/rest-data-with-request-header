package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.VendorEntity;

public interface VendorRepository extends BaseRepository<VendorEntity>, MandatorAwareRepository<VendorEntity> {
}
