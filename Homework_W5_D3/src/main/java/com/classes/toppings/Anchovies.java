package com.classes.toppings;

import com.classes.Topping;

public class Anchovies extends Topping{
	
	public Anchovies() {
		super();
	}

	public Anchovies(String name, Double price, Double calories) {
		super("Anchovies", 0.80, 92.0);
	}

	@Override
	public String toString() {
		return "Pineapple [toString()=" + super.toString() + "]";
	}
	
}