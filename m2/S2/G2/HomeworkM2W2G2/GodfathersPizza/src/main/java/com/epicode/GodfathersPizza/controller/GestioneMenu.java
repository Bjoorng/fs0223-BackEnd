package com.epicode.GodfathersPizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epicode.GodfathersPizza.classes.FoodItem;
import com.epicode.GodfathersPizza.classes.Menu;
import com.epicode.GodfathersPizza.configurations.MenuConfiguration;
import com.epicode.GodfathersPizza.serivices.MenuService;

@RestController
@RequestMapping("/api")
public class GestioneMenu {
	
	@Autowired MenuService menuService;
	AnnotationConfigApplicationContext appContext;
	@Autowired Menu menu;

	public GestioneMenu() {
		appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		menu = (Menu) appContext.getBean("menu");
	}
	
	public void stampaMenu() {
		System.out.println("***** Menu *****");
		System.out.println("Pizzas");
		
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuLine()));
		
		System.out.println();
		
		System.out.println("Drink");
		
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuLine()));
		
		System.out.println();
		
		System.out.println("***** FINE *****");
		
	}
	
	@GetMapping("/")
	public String getHome() {
		return "Home";
	}
	
//	@GetMapping("/")
//	public ModelAndView getMenu() {
//		List<FoodItem> listaOggetti = (List<FoodItem>) menuService.getMenuRepo().findAll();
//		ModelAndView model = new ModelAndView("menu");
//		model.addObject("lista", listaOggetti);
//		return model;
//	}
	
	@GetMapping("/test")
	public ResponseEntity<List<FoodItem>> getHomeTest() {
		List<FoodItem> listaContatti = (List<FoodItem>) menuService.getMenuRepo().findAll();
		ResponseEntity<List<FoodItem>> resp = new ResponseEntity<List<FoodItem>>(listaContatti, HttpStatus.OK);
		return resp;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {
		try {
			FoodItem fd = menuService.findById(id);
			return new ResponseEntity<FoodItem>(fd, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createItem(@RequestBody FoodItem item) {
		try {
			FoodItem fI = menuService.create2(item);
			return new ResponseEntity<FoodItem>(fI, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody FoodItem food) {
		try {
			FoodItem c = menuService.updateFoodItem(id, food);
			return new ResponseEntity<FoodItem>(c, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeContact(@PathVariable Long id) {
		try {
			String msg = menuService.removeFoodItem(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
