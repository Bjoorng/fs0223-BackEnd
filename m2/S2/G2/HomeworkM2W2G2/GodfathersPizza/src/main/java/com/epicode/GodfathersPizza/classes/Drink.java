package com.epicode.GodfathersPizza.classes;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "drink")
public abstract class Drink extends FoodItem {

	public Drink(String name, Double price, Double calories) {
		super(name, price, calories);
	}

}
