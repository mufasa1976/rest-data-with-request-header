package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.exception;

import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.stream.Collectors;

@ResponseStatus(HttpStatus.CONFLICT)
public class RowAlreadyExistsException extends RuntimeException {
  public RowAlreadyExistsException(Class<? extends BaseEntity> entityClass, Map<String, Object> tuples) {
    super(String.format("The're already exists a Row of Class %s with the following Characteristics: %s",
        entityClass.getSimpleName(),
        tuples.entrySet()
              .stream()
              .map(entry -> entry.getKey() + "=" + entry.getValue())
              .collect(Collectors.joining(","))));
  }
}
