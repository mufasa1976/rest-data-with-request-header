package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.MandatorAwareEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface MandatorAwareRepository<T extends MandatorAwareEntity> {
  @Query("SELECT mandatorAwareEntity FROM #{#entityName} mandatorAwareEntity WHERE mandatorAwareEntity.reference = :reference AND (mandatorAwareEntity.mandator.mandator IN ('', :mandators))")
  Optional<T> findOptionalByReferenceAndMandator(@NotNull @Param("reference") UUID reference, @Nullable @Param("mandators") Set<String> mandators);
}
