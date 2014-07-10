package sif3.hits.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(DatabaseConfiguration.class)
@ComponentScan(basePackages = { "sif3.hits.service", "sif3.hits.audit", "sif3.hits.domain.converter", "sif3.hits.domain.dao" })
@EnableJpaRepositories(basePackages = { "sif3.hits.service", "sif3.hits.audit", "sif3.hits.domain.converter", "sif3.hits.domain.dao" })
@EnableTransactionManagement
public class HitsSpringConfiguration {

  @Resource(name = "databaseProperties")
  private Properties databaseProperties;

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setPersistenceUnitName("sif3.hits");
    factoryBean.setDataSource(this.dataSource());
    factoryBean.setPackagesToScan(new String[] { "sif3.hits.domain.model" });
    factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {
    });
    factoryBean.setJpaProperties(this.databaseProperties);
    factoryBean.setJpaDialect(new HibernateJpaDialect());
    return factoryBean;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(this.databaseProperties.getProperty("hibernate.connection.driver_class"));
    dataSource.setUrl(this.databaseProperties.getProperty("hibernate.connection.url"));
    dataSource.setUsername(this.databaseProperties.getProperty("hibernate.connection.username"));
    dataSource.setPassword(this.databaseProperties.getProperty("hibernate.connection.password"));
    return dataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(this.entityManagerFactory().getObject());
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }
}
