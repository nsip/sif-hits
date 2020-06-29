package sif3.hits.domain.helper;

import java.beans.PropertyVetoException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class HitsDataSourceLookup implements DataSourceLookup {

	private static final Logger L = LoggerFactory.getLogger(HitsDataSourceLookup.class);

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
		L.debug("DataSource: " + dataSourceName + " => " + cpds.getJdbcUrl());
		cpds.setUser(databaseProperties.getProperty("hits.connection.username"));
		cpds.setPassword(databaseProperties.getProperty("hits.connection.password"));
		try {
			cpds.setDriverClass(databaseProperties.getProperty("hibernate.connection.driver_class"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		cpds.setInitialPoolSize(getIntegerProperty("hits.c3p0.acquire_increment", 1));
		cpds.setAcquireIncrement(getIntegerProperty("hits.c3p0.acquire_increment", 1));
		cpds.setMaxPoolSize(getIntegerProperty("hits.c3p0.max_size", 5));
		cpds.setMinPoolSize(getIntegerProperty("hits.c3p0.min_size", 0));
		cpds.setMaxStatements(getIntegerProperty("hits.c3p0.max_statements", 500));
		cpds.setIdleConnectionTestPeriod(getIntegerProperty("hits.c3p0.idle_test_period", 120));
		cpds.setPreferredTestQuery(databaseProperties.getProperty("hits.c3p0.test_statement", "select 1"));
		return cpds;
	}

	private Integer getIntegerProperty(String property, Integer defaultValue) {
		Integer result = defaultValue;
		String value = databaseProperties.getProperty(property);
		if (value != null) {
			Integer.parseInt(value, 10);
		}
		return result;
	}

}
