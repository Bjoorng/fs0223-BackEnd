package com.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Pizza extends Item{

	private Double calories;
	
	public Pizza() {
		super();
	}

	public Pizza(String name, Double price, Double calories) {
		super(name, price);
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Pizza [calories=" + calories + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

}
