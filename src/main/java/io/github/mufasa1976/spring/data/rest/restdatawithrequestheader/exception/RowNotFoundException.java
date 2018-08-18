package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.exception;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RowNotFoundException extends RuntimeException {
  public RowNotFoundException(Class<? extends BaseEntity> entityClass, UUID reference) {
    super(String.format("Entity of Class %s not found by Reference %s", entityClass.getSimpleName(), reference));
  }
}
