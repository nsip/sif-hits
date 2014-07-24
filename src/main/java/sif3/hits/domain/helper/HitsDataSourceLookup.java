package sif3.hits.domain.helper;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Component
public class HitsDataSourceLookup implements DataSourceLookup {

  public HitsDataSourceLookup(Properties databaseProperties) {
    this.databaseProperties = databaseProperties;
  }
  
  private Properties databaseProperties;

  @Override
  public DataSource getDataSource(String dataSourceName) throws DataSourceLookupFailureException {
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    
    if (dataSourceName != null) {
      cpds.setJdbcUrl(dataSourceName);
    } else {
      cpds.setJdbcUrl(databaseProperties.getProperty("hits.connection.url"));
    }
    cpds.setUser(databaseProperties.getProperty("hits.connection.username"));
    cpds.setPassword(databaseProperties.getProperty("hits.connection.password"));

    cpds.setInitialPoolSize(getIntegerProperty("hits.c3p0.initial_size"));
    cpds.setAcquireIncrement(new Integer((String) props.getProperty("acquireIncrement")));
    cpds.setMaxPoolSize(new Integer((String) props.getProperty("maxPoolSize")));
    cpds.setMinPoolSize(new Integer((String) props.getProperty("minPoolSize")));
    cpds.setMaxStatements(new Integer((String) props.getProperty("maxStatements")));    
    
    
        hits.show_sql=false
        hits.c3p0.max_size=5
        hits.c3p0.min_size=0
        hits.c3p0.initial_size=1
        hits.c3p0.acquire_increment=1
        hits.c3p0.idle_test_period=300
        hits.c3p0.max_statements=0
        hits.c3p0.timeout=100

    
    return cpds;
  }
  
  private Integer getIntegerProperty(String property) {
    String value = databaseProperties.getProperty(property);
    return Integer.parseInt(value, 10);  
  }
  
  
}
