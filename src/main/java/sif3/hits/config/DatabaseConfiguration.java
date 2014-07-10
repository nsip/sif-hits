package sif3.hits.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class DatabaseConfiguration {
  private static final Logger L = LoggerFactory.getLogger(DatabaseConfiguration.class);

  @Bean
  public static PropertyPlaceholderConfigurer databasePropertyPlaceholderConfigurer() {
    PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
    try {
      propertyPlaceholderConfigurer.setProperties(databaseProperties().getObject());
    } catch (IOException e) {
      DatabaseConfiguration.L.error("Error reading database properties", e);
    }
    propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
    return propertyPlaceholderConfigurer;
  }

  @Bean(name = "databaseProperties")
  public static PropertiesFactoryBean databaseProperties() {
    PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
    ClassPathResource properties = new ClassPathResource("sifhits.database.properties");
    if (!properties.exists() || !properties.isReadable()) {
      properties = new ClassPathResource("sifhits.internal.database.properties");
      DatabaseConfiguration.L.info("Using internal properties.");
    } else {
      DatabaseConfiguration.L.info("Using external properties.");
    }
    propertiesFactoryBean.setLocation(properties);
    propertiesFactoryBean.setIgnoreResourceNotFound(true);
    return propertiesFactoryBean;
  }
}
