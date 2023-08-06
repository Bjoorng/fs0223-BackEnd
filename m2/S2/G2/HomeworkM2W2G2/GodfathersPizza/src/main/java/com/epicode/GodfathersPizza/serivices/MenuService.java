package com.epicode.GodfathersPizza.serivices;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.GodfathersPizza.classes.FoodItem;
import com.epicode.GodfathersPizza.classes.Menu;
import com.epicode.GodfathersPizza.repository.MenuRepository;

import lombok.Data;

@Data
@Service
public class MenuService {
	
	@Autowired MenuRepository menuRepo;
	
	@Autowired @Qualifier("menupizzeria") private ObjectProvider<Menu> menuProvider;

	public void stampaMenu() {
		System.out.println("***** Menu *****");
		System.out.println("Pizzas");
		
		menuProvider.getObject().getMenuPizza().forEach(p -> System.out.println(p.getMenuLine()));
		
		
		System.out.println();
		
		System.out.println("Drink");
		
		menuProvider.getObject().getMenuDrink().forEach(d -> System.out.println(d.getMenuLine()));
		
		System.out.println();
		
		System.out.println("***** FINE *****");
		
	}

	public void createFoodItem() {
		menuProvider.getObject()
			.getMenuPizza().forEach(p -> {
				menuRepo.save(p);
			});
		menuProvider.getObject()
			.getMenuDrink().forEach(p -> {
				menuRepo.save(p);
			});
	}
	
	public FoodItem create2(FoodItem food) {
		return menuRepo.save(food);
	}
	
	public void findAll() {
		menuRepo.findAll().forEach(o -> System.out.println(o));
	}

	public FoodItem findById(long id) {
		return menuRepo.findById(id).get();
	}

	public FoodItem updateFoodItem(Long id, FoodItem item) {
		return menuRepo.save(item);
	}
	
	public String removeFoodItem(Long id) {
		menuRepo.deleteById(id);
		return "Item Deleted";
	}

}
