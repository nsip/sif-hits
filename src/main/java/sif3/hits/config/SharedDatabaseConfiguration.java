package sif3.hits.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {
        "sif3.hits.domain.shared.dao"}, entityManagerFactoryRef = "sharedEntityManagerFactory", transactionManagerRef = "sharedTransactionManager")
public class SharedDatabaseConfiguration {
    static final Logger L = LoggerFactory.getLogger(DynamicDatabaseConfiguration.class);

    @Resource(name = "databaseProperties")
    private Properties databaseProperties;

    @Bean()
    public LocalContainerEntityManagerFactoryBean sharedEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("sif3.hits.shared");
        factoryBean.setDataSource(this.sharedDataSource());
        factoryBean.setPackagesToScan(new String[]{"sif3.hits.domain.shared.model"});
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {
        });
        factoryBean.setJpaProperties(this.databaseProperties);
        factoryBean.setJpaDialect(new HibernateJpaDialect());
        return factoryBean;
    }

    @Bean
    public DataSource sharedDataSource() {
        HitsDataSource hitsDataSource = new HitsDataSource();
        hitsDataSource.setDataSourceLookup(new HitsDataSourceLookup(databaseProperties, true));
        hitsDataSource.setDefaultTargetDataSource(null);
        hitsDataSource.setLenientFallback(true);
        return hitsDataSource;
    }

    @Bean
    public PlatformTransactionManager sharedTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.sharedEntityManagerFactory().getObject());
        return transactionManager;
    }
}
