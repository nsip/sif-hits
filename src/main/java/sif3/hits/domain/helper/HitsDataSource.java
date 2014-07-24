package sif3.hits.domain.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

public class HitsDataSource extends AbstractDataSource implements InitializingBean {
  
  protected static final Logger L = LoggerFactory.getLogger(HitsDataSource.class);

  private String defaultDataSource;
  private boolean lenientFallback = true;
  private DataSourceLookup dataSourceLookup;
  private Map<String, DataSource> resolvedDataSources;
  private DataSource resolvedDefaultDataSource;
  
  public void setDefaultTargetDataSource(String defaultDataSource) {
    this.defaultDataSource = defaultDataSource;
  }

  public void setLenientFallback(boolean lenientFallback) {
    this.lenientFallback = lenientFallback;
  }

  public void setDataSourceLookup(DataSourceLookup dataSourceLookup) {
    this.dataSourceLookup = (dataSourceLookup != null ? dataSourceLookup : new JndiDataSourceLookup());
  }

  public void afterPropertiesSet() {
    this.resolvedDataSources = new HashMap<String, DataSource>();
    this.resolvedDefaultDataSource = resolveSpecifiedDataSource(this.defaultDataSource);
  }

  protected DataSource resolveSpecifiedDataSource(String dataSource) throws IllegalArgumentException {
    return this.dataSourceLookup.getDataSource(dataSource);
  }

  public Connection getConnection() throws SQLException {
    return determineTargetDataSource().getConnection();
  }

  public Connection getConnection(String username, String password) throws SQLException {
    return determineTargetDataSource().getConnection(username, password);
  }

  public <T> T unwrap(Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    return determineTargetDataSource().unwrap(iface);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return (iface.isInstance(this) || determineTargetDataSource().isWrapperFor(iface));
  }

  protected DataSource determineTargetDataSource() {
    L.error("WHAT IS HAPPENING?");
    String lookupKey = determineCurrentLookupKey();
    DataSource dataSource = this.resolvedDataSources.get(lookupKey);
    if (dataSource == null && lookupKey != null) {
      L.info("Resolving DataSource for lookup key : " + lookupKey);
      dataSource = resolveSpecifiedDataSource(lookupKey);
    }
    if (dataSource == null && (this.lenientFallback || lookupKey == null)) {
      dataSource = this.resolvedDefaultDataSource;
    }
    if (dataSource == null) {
      throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
    } else {
      resolvedDataSources.put(lookupKey, dataSource);
    }
    return dataSource;
  }

  private String determineCurrentLookupKey() {
    return HitsDatabaseContext.getDatabase();
  }

}
