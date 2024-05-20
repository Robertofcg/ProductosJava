package com.example.demo.Conexion;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

	@org.springframework.beans.factory.annotation.Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@org.springframework.beans.factory.annotation.Value("${spring.datasource.username}")
	private String dataSourceUsername;

	@org.springframework.beans.factory.annotation.Value("${spring.datasource.password}")
	private String dataSourcePassword;

	@org.springframework.beans.factory.annotation.Value("${spring.datasource.driver-class-name}")
	private String dataSourceDriverClassName;

    @Bean
    DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceDriverClassName);
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);
		return dataSource;
	}
}