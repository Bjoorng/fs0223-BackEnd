package com.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Topping extends Item{

	private Double calories;

	public Topping() {
		super();
	}

	public Topping(String name, Double price, Double calories) {
		super(name, price);
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		return "Topping [calories=" + calories + ", getCalories()=" + getCalories() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
