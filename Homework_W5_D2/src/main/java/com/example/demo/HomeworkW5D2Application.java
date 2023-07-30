package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.classes.*;
import com.classes.runner.ItemRunner;

@SpringBootApplication
public class HomeworkW5D2Application {

	public static void main(String[] args) {
		SpringApplication.run(ItemRunner.class, args);
		
		Pizza p = new Pizza();
		Drink d = new Drink();
		Item i = new Item("Shirt", 25.9);
		p.setName("Margherita");
		p.setPrice(15.9);
		p.setCalories(900.0);
		d.setName("Coca-Cola");
		d.setPrice(8.0);
		d.setCalories(1500.0);
		System.out.println(i.toString());
		System.out.println(p.toString());
		System.out.println(d.toString());
	}

}
