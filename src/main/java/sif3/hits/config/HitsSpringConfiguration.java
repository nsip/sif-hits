package sif3.hits.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(value = { DatabaseConfiguration.class, DynamicDatabaseConfiguration.class, SharedDatabaseConfiguration.class })
@ComponentScan(basePackages = { "sif3.hits.service", "sif3.hits.audit", "sif3.hits.domain.converter", "sif3.hits.domain.dao", "sif3.hits.domain.helper", "sif3.hits.domain.shared.dao" })
@EnableTransactionManagement
public class HitsSpringConfiguration {

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

}
