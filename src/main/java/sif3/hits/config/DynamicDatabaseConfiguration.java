package sif3.hits.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import sif3.hits.domain.helper.HitsDataSource;
import sif3.hits.domain.helper.HitsDataSourceLookup;

@Configuration
@EnableJpaRepositories(basePackages = { "sif3.hits.domain.dao" }, entityManagerFactoryRef = "dynamicEntityManagerFactory", transactionManagerRef = "transactionManager")
public class DynamicDatabaseConfiguration {
  // private static final Logger L =
  // LoggerFactory.getLogger(DynamicDatabaseConfiguration.class);

  @Resource(name = "databaseProperties")
  private Properties databaseProperties;
  
  @Bean
  public DataSource dynamicDataSource() {
    HitsDataSource hitsDataSource = new HitsDataSource();
    hitsDataSource.setDataSourceLookup(new HitsDataSourceLookup(databaseProperties, false));
    hitsDataSource.setDefaultTargetDataSource(null);
    hitsDataSource.setLenientFallback(true);
    return hitsDataSource;
  }

  @Bean
  @Autowired
  public LocalContainerEntityManagerFactoryBean dynamicEntityManagerFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setPersistenceUnitName("sif3.hits.dynamic");
    factoryBean.setDataSource(dynamicDataSource);
    factoryBean.setPackagesToScan(new String[] { "sif3.hits.domain.model" });
    factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {});
    factoryBean.setJpaProperties(this.databaseProperties);
    factoryBean.setJpaDialect(new HibernateJpaDialect());
    return factoryBean;
  }

  @Bean
  @Autowired
  public PlatformTransactionManager transactionManager(@Qualifier("dynamicEntityManagerFactory") LocalContainerEntityManagerFactoryBean dynamicEntityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(dynamicEntityManagerFactory.getObject());
    return transactionManager;
  }
}
