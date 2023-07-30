package com.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Drink extends Item{

	private Double calories;
	
	public Drink() {
		super();
	}

	public Drink(String name, Double price, Double calories) {
		super(name, price);
		this.calories = calories;
		}
	
	@Override
	public String toString() {
		return "Drink [calories=" + calories + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}
	
}
