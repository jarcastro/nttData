package com.ntt.prueba.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {

	
	@Bean
	@ConfigurationProperties("datasource.ntt")
	@Primary
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("datasource.ntt.configuration")
	@Primary
	public HikariDataSource nttDataSource() {
		return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean("jdbcTemplatentt")
	@Primary
	public NamedParameterJdbcTemplate jdbcTemplate(@Qualifier("nttDataSource") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}
