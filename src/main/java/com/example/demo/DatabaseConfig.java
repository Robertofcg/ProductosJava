package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Autowired
    private Dotenv dotenv;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dotenv.get("DATABASE_DRIVER_CLASS"));
        dataSource.setUrl(dotenv.get("DATABASE_URL"));
        dataSource.setUsername(dotenv.get("DATABASE_USERNAME"));
        dataSource.setPassword(dotenv.get("DATABASE_PASSWORD"));
        return dataSource;
    }
}