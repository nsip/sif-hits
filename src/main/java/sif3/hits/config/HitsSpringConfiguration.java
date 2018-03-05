package sif3.hits.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import sif3.hits.dto.Version;

@Configuration
@Import(value = { DatabaseConfiguration.class, DynamicDatabaseConfiguration.class, SharedDatabaseConfiguration.class })
@ComponentScan(basePackages = { "sif3.hits.service", "sif3.hits.audit", "sif3.hits.domain.converter", "sif3.hits.domain.dao", "sif3.hits.domain.helper",
        "sif3.hits.domain.shared.dao" })
@EnableTransactionManagement
public class HitsSpringConfiguration {

    @Value("${sifServer.version}")
    private String sifServer = "18.3.0";
    @Value("${sifDatamodel.version}")
    private String sifDatamodel = "3.4.2";

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public Version versionBean() {
        Version version = new Version();
        version.setSifDatamodel(sifDatamodel);
        version.setSifServer(sifServer);
        return version;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholder() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setIgnoreResourceNotFound(false);
        placeholderConfigurer.setLocation(new ClassPathResource("sifhits.properties"));
        return placeholderConfigurer;
    }

}
