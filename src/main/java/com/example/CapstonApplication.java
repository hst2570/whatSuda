package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.nio.charset.Charset;

@SpringBootApplication
public class CapstonApplication extends WebMvcConfigurerAdapter {
	
	public static void main(String[] args) {
		SpringApplication.run(CapstonApplication.class, args);
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		if (!registry.hasMappingForPattern("/static/**")) {
//			registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//		}
//
//		if (!registry.hasMappingForPattern("/image/**")) {
//			registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
//		}
//	}

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		//결과 출력시 강제로 utf-8로 설정
		return new StringHttpMessageConverter(Charset.forName("utf-8"));
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("utf-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}
}
