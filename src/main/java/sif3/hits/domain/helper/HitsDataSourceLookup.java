package sif3.hits.domain.helper;

import java.beans.PropertyVetoException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Component
public class HitsDataSourceLookup implements DataSourceLookup {

  private boolean shared = false;

  public HitsDataSourceLookup(Properties databaseProperties, boolean shared) {
    this.databaseProperties = databaseProperties;
    this.shared = shared;
  }

  private Properties databaseProperties;

  @Override
  public DataSource getDataSource(String dataSourceName) throws DataSourceLookupFailureException {
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    String format = databaseProperties.getProperty("hits.connection.format");
    if (!shared && dataSourceName != null && format != null) {
      cpds.setJdbcUrl(MessageFormat.format(format, dataSourceName));
    } else if (!shared && dataSourceName != null) {
      cpds.setJdbcUrl(dataSourceName);
    } else {
      cpds.setJdbcUrl(databaseProperties.getProperty("hits.connection.url"));
    }
    cpds.setUser(databaseProperties.getProperty("hits.connection.username"));
    cpds.setPassword(databaseProperties.getProperty("hits.connection.password"));
    try {
      cpds.setDriverClass(databaseProperties.getProperty("hibernate.connection.driver_class"));
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }

    cpds.setInitialPoolSize(getIntegerProperty("hits.c3p0.acquire_increment"));
    cpds.setAcquireIncrement(getIntegerProperty("hits.c3p0.acquire_increment"));
    cpds.setMaxPoolSize(getIntegerProperty("hits.c3p0.max_size"));
    cpds.setMinPoolSize(getIntegerProperty("hits.c3p0.min_size"));
    cpds.setMaxStatements(getIntegerProperty("hits.c3p0.max_statements"));

    return cpds;
  }

  private Integer getIntegerProperty(String property) {
    String value = databaseProperties.getProperty(property);
    return Integer.parseInt(value, 10);
  }

}
