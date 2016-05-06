package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.service.UserService;

@SpringBootApplication
public class CapstonApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(CapstonApplication.class, args);
	}
}
