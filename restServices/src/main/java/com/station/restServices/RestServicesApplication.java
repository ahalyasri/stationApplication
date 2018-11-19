package com.station.restServices;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class RestServicesApplication {

	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(RestServicesApplication.class, args);
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
	    return new JdbcTemplate(dataSource);
	}
}
