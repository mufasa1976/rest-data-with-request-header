package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.PrimaryKeyBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends PrimaryKeyBaseEntity> extends JpaRepository<T, Long>, QuerydslPredicateExecutor<T> {
}
