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

	@Bean
	@Scope("singleton")
	public Menu menu() {
		Menu m = new Menu();
		
		m.getMenuPizza().add(pizzaMargherita());
		m.getMenuPizza().add(pizzaHawaiian());
		m.getMenuPizza().add(pizzaPepperoni());
		m.getMenuDrink().add(water());
		m.getMenuDrink().add(wine());
		m.getMenuDrink().add(cocaCola());
		m.getMenuDrink().add(pepsi());
		m.getMenuToppings().add(anchovies());
		m.getMenuToppings().add(pineapple());
		return m;
	}
	
	@Bean
    @Scope("singleton")
    public PizzaMargherita pizzaMargherita() {
        return new PizzaMargherita();
    }

    @Bean
    @Scope("singleton")
    public PizzaHawaiian pizzaHawaiian() {
        return new PizzaHawaiian();
    }

    @Bean
    @Scope("singleton")
    public PizzaPepperoni pizzaPepperoni() {
        return new PizzaPepperoni();
    }
    
    @Bean
    @Scope("singleton")
    public Wine wine() {
    	return new Wine();
    }
    
    @Bean
    @Scope("singleton")
    public Water water() {
    	return new Water();
    }
    
    @Bean
    @Scope("singleton")
    public Pepsi pepsi() {
    	return new Pepsi();
    }
    
    @Bean
    @Scope("singleton")
    public CocaCola cocaCola() {
    	return new CocaCola();
    }
    
    @Bean
    @Scope("singleton")
    public Fanta fanta() {
    	return new Fanta();
    }
    
    @Bean
    @Scope("singleton")
    public Anchovies anchovies() {
    	return new Anchovies();
    }
    
    @Bean
    @Scope("singleton")
    public Pineapple pineapple() {
    	return new Pineapple();
    }
}
