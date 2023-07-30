package com.classes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.classes.Drink;
import com.classes.Item;
import com.classes.Menu;
import com.classes.Pizza;
import com.classes.Topping;

@Service
public class ServiceMenu {
	
	private List<Item> wholeMenu = new ArrayList<Item>();
	
	@Autowired @Qualifier("menu") private ObjectProvider<Menu> menu;
	@Autowired @Qualifier("pizzaMargherita") private ObjectProvider<Pizza> pizzaMargherita;
	@Autowired @Qualifier("pizzaHawaiian") private ObjectProvider<Pizza> pizzaHawaiian;
	@Autowired @Qualifier("pizzaPepperoni") private ObjectProvider<Pizza> pizzaPepperoni;
	@Autowired @Qualifier("wine") private ObjectProvider<Drink> wine;
	@Autowired @Qualifier("water") private ObjectProvider<Drink> water;
	@Autowired @Qualifier("pepsi") private ObjectProvider<Drink> pepsi;
	@Autowired @Qualifier("cocaCola") private ObjectProvider<Drink> cocaCola;
	@Autowired @Qualifier("fanta") private ObjectProvider<Drink> fanta;
	@Autowired @Qualifier("anchovies") private ObjectProvider<Topping> anchovies;
	@Autowired @Qualifier("pineapple") private ObjectProvider<Topping> pineapple;
	
	public Pizza createPizzaMargherita() {
		return pizzaMargherita.getObject();
	}
	
	public Pizza createPizzaHawaiian() {
		return pizzaHawaiian.getObject();
	}
	
	public Pizza createPizzaPepperoni() {
		return pizzaPepperoni.getObject();
	}
	
	public Drink createDrinkWine() {
		return wine.getObject();
	}
	
	public Drink createDrinkWater() {
		return water.getObject();
	}
	
	public Drink createDrinkPepsi() {
		return pepsi.getObject();
	}
	
	public Drink createDrinkCocaCola() {
		return cocaCola.getObject();
	}
	
	public Drink createDrinkFanta() {
		return fanta.getObject();
	}
	
	public Topping createToppingAnchovies() {
		return anchovies.getObject();
	}
	
	public Topping createToppingPineapple() {
		return pineapple.getObject();
	}
	
	public void addPizzas(Pizza pizza) {
		List<Pizza> menuPizza = menu.getObject().getMenuPizza();
		menuPizza.add(pizza);
		menuPizza.stream()
		.forEach(p -> {
			wholeMenu.add(p);
		});
	}
	
	public void addDrinks(Drink drink) {
		List<Drink> menuDrink = menu.getObject().getMenuDrink();
		menuDrink.add(drink);
		menuDrink.stream()
		.forEach(d -> {
			wholeMenu.add(d);
		});
	}
	
	public void addToppings(Topping topping) {
		List<Topping> menuToppings = menu.getObject().getMenuToppings();
		menuToppings.add(topping);
		menuToppings.stream()
		.forEach(t -> {
			wholeMenu.add(t);
		});
	}
	
	public void addItem(Item i) {
		if(i instanceof Pizza){
		List<Pizza> menuPizza = menu.getObject().getMenuPizza();
		menuPizza.add((Pizza) i);
		}else if(i instanceof Drink) {
			List<Drink> menuDrink = menu.getObject().getMenuDrink();
			menuDrink.add((Drink) i);
		}else if(i instanceof Topping) {
			List<Topping> menuToppings = menu.getObject().getMenuToppings();
			menuToppings.add((Topping) i);
		}else {
			System.out.println("The item can't be added to the list");
		}
	}
	
	public void printMenu() {
		wholeMenu.forEach(i -> {
			if (i instanceof Pizza) {
				System.out.println(i.getName());
				System.out.println(i.getPrice());
				System.out.println(((Pizza) i).getCalories());
			}else if(i instanceof Drink) {
				System.out.println(i.getName());
				System.out.println(i.getPrice());
				System.out.println(((Drink) i).getCalories());
			}
			else if(i instanceof Topping) {
				System.out.println(i.getName());
				System.out.println(i.getPrice());
				System.out.println(((Topping) i).getCalories());
			}else if(i instanceof Item) {
				System.out.println(i.getName());
				System.out.println(i.getPrice());
			}
		});
	}
}
