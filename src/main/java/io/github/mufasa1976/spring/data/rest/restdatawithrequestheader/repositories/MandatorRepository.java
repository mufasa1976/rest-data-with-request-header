package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.MandatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;
import java.util.UUID;

public interface MandatorRepository extends JpaRepository<MandatorEntity, String>, QuerydslPredicateExecutor<MandatorEntity> {
  Optional<MandatorEntity> findOptionalByReference(UUID reference);

  boolean existsByMandator(String mandator);
}
