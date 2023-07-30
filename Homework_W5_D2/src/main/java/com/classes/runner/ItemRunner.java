package com.classes.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.classes.Drink;
import com.classes.Menu;
import com.classes.Pizza;
import com.classes.Topping;
import com.classes.configuration.Configurations;

@Component
public class ItemRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		configBean();
	}
	
	public void configBean() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(Configurations.class);
		
		Menu m = (Menu) appContext.getBean("menu");
		
		Pizza pM = (Pizza) appContext.getBean("pizzaMargherita");
		Pizza pP = (Pizza) appContext.getBean("pizzaPepperoni");
		Pizza pH = (Pizza) appContext.getBean("pizzaHawaiian");
		
		Drink cc = (Drink) appContext.getBean("cocaCola");
		Drink fa = (Drink) appContext.getBean("fanta");
		Drink pe = (Drink) appContext.getBean("pepsi");
		
		Topping an = (Topping) appContext.getBean("anchovies");
		Topping pi = (Topping) appContext.getBean("pineapple");
	}
}
