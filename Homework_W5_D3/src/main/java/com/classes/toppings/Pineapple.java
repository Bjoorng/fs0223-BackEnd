package com.classes.toppings;

import com.classes.Topping;

public class Pineapple extends Topping{
	
	public Pineapple() {
		super();
	}

	public Pineapple(String name, Double price, Double calories) {
		super("Pineapple", 1.20, 200.0);
	}

	@Override
	public String toString() {
		return "Pineapple [toString()=" + super.toString() + "]";
	}
	
}
