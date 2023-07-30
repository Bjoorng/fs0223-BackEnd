package com.classes.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.classes.Drink;
import com.classes.Menu;
import com.classes.Pizza;
import com.classes.Topping;
import com.classes.configuration.Configurations;
import com.classes.service.ServiceMenu;

@Component
public class ItemRunner implements CommandLineRunner{

	@Autowired private ServiceMenu service;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Run...");
		
		Pizza pm = service.createPizzaMargherita();
		Pizza ph = service.createPizzaHawaiian();
		Pizza pp = service.createPizzaPepperoni();
		Drink dwi = service.createDrinkWine();
		Drink dwa = service.createDrinkWater();
		Drink dpe = service.createDrinkPepsi();
		Drink dcc = service.createDrinkCocaCola();
		Drink dfa = service.createDrinkFanta();
		Topping an = service.createToppingAnchovies();
		Topping pi = service.createToppingPineapple();
		
		service.addPizzas(pm);
		service.addPizzas(ph);
		service.addPizzas(pp);
		service.addDrinks(dwi);
		service.addDrinks(dwa);
		service.addDrinks(dpe);
		service.addDrinks(dcc);
		service.addDrinks(dfa);
		service.addToppings(an);
		service.addToppings(pi);
		
		service.printMenu();
	}
}
