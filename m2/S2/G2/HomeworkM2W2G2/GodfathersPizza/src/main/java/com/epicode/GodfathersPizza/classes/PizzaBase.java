package com.epicode.GodfathersPizza.classes;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "pizza")
public abstract class PizzaBase extends FoodItem {

	public PizzaBase(String name, Double price, Double calories) {
		super(name, price, calories);
	}

}
