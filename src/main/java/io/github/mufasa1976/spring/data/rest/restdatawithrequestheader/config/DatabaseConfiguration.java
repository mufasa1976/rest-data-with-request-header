package io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.config;

import com.querydsl.sql.SQLExceptionTranslator;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.BaseEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.MandatorEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.model.VendorEntity;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories.BaseRepository;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories.MandatorRepository;
import io.github.mufasa1976.spring.data.rest.restdatawithrequestheader.repositories.VendorRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Provider;
import javax.sql.DataSource;
import java.sql.Connection;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;

@Configuration
@EnableJpaRepositories(basePackageClasses = BaseRepository.class)
@EntityScan(basePackageClasses = BaseEntity.class)
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@EnableTransactionManagement
public class DatabaseConfiguration {
  @Bean
  public DateTimeProvider dateTimeProvider() {
    return () -> Optional.of(ZonedDateTime.now(ZoneOffset.UTC));
  }

  @Bean
  public Provider<Connection> connectionProvider(DataSource dataSource) {
    return new SpringConnectionProvider(dataSource);
  }

  @Bean
  public SQLExceptionTranslator sqlExceptionTranslator() {
    return new SpringExceptionTranslator();
  }

  @EventListener
  @Transactional
  public void databaseInit(ApplicationReadyEvent event) {
    ApplicationContext applicationContext = event.getApplicationContext();

    MandatorRepository mandatorRepository = applicationContext.getBean(MandatorRepository.class);
    MandatorEntity mandatorAT = mandatorRepository.saveAndFlush(
        MandatorEntity.builder()
                      .mandator("AT")
                      .build());
    MandatorEntity mandatorDE = mandatorRepository.saveAndFlush(
        MandatorEntity.builder()
                      .mandator("DE")
                      .build());

    VendorRepository vendorRepository = applicationContext.getBean(VendorRepository.class);
    vendorRepository.saveAndFlush(
        VendorEntity.builder()
                    .mandator(mandatorAT)
                    .name("Nokia")
                    .build());
    vendorRepository.saveAndFlush(
        VendorEntity.builder()
                    .mandator(mandatorDE)
                    .name("Huawei")
                    .build());
  }
}
