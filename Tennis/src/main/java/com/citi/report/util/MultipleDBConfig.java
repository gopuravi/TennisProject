package com.citi.report.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Configuration
@Component
public class MultipleDBConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasources.datasource-1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	} 
	

	@Bean
	public JdbcTemplate dataSource1JdbcTemplate(@Qualifier("dataSource1")  DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
/*	@Bean
	@ConfigurationProperties(prefix = "spring.datasources.datasource-2") 
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public JdbcTemplate dataSource2JdbcTemplate( @Qualifier("dataSource2") DataSource ds) {
		return new JdbcTemplate(ds);
	} 
	*/
} 