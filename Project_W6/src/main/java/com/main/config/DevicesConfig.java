package com.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.main.classes.Laptop;
import com.main.classes.Smartphone;
import com.main.classes.Tablet;

@Configuration
@PropertySource("classpath:application.properties")
public class DevicesConfig {

	@Bean("smartPhoneBean")
	@Scope("prototype")
	public Smartphone smartphone() {
		return new Smartphone();
	}
	
	@Bean("tabletBean")
	@Scope("prototype")
	public Tablet tablet() {
		return new Tablet();
	}
	
	@Bean("laptopBean")
	@Scope("prototype")
	public Laptop laptop() {
		return new Laptop();
	}
}
