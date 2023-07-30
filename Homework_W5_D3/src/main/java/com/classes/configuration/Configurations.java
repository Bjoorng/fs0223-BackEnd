package com.classes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.classes.Menu;
import com.classes.drinks.*;
import com.classes.pizzas.*;
import com.classes.toppings.*;

@Configuration
@PropertySource("classpath:application.properties")
public class Configurations {

	@Bean("menu")
	@Scope("singleton")
	public Menu menu() {
		return new Menu();
	}
	
	@Bean("pizzaMargherita")
    @Scope("singleton")
    public PizzaMargherita pizzaMargherita() {
        return new PizzaMargherita();
    }

    @Bean("pizzaHawaiian")
    @Scope("singleton")
    public PizzaHawaiian pizzaHawaiian() {
        return new PizzaHawaiian();
    }

    @Bean("pizzaPepperoni")
    @Scope("singleton")
    public PizzaPepperoni pizzaPepperoni() {
        return new PizzaPepperoni();
    }
    
    @Bean("wine")
    @Scope("singleton")
    public Wine wine() {
    	return new Wine();
    }
    
    @Bean("water")
    @Scope("singleton")
    public Water water() {
    	return new Water();
    }
    
    @Bean("pepsi")
    @Scope("singleton")
    public Pepsi pepsi() {
    	return new Pepsi();
    }
    
    @Bean("cocaCola")
    @Scope("singleton")
    public CocaCola cocaCola() {
    	return new CocaCola();
    }
    
    @Bean("fanta")
    @Scope("singleton")
    public Fanta fanta() {
    	return new Fanta();
    }
    
    @Bean("anchovies")
    @Scope("singleton")
    public Anchovies anchovies() {
    	return new Anchovies();
    }
    
    @Bean("pineapple")
    @Scope("singleton")
    public Pineapple pineapple() {
    	return new Pineapple();
    }
    
}
