package com.epicode.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.epicode.main.classes.Building;
import com.epicode.main.classes.Reservation;
import com.epicode.main.classes.User;
import com.epicode.main.classes.WorkStation;

@Configuration
@PropertySource("classpath:application.properties")
public class ReservationConfig {
	
	@Bean("building")
    @Scope("singleton")
    public Building Building() {
        return new Building();
    }
	
	@Bean("workstation")
    @Scope("singleton")
    public WorkStation WorkStation() {
        return new WorkStation();
    }

	@Bean("reservation")
    @Scope("singleton")
    public Reservation Reservation() {
        return new Reservation();
    }

	@Bean("user")
    @Scope("singleton")
    public User user() {
        return new User();
    }
	
}
