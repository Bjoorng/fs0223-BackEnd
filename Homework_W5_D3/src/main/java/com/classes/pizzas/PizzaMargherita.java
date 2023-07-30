package com.classes.pizzas;

import com.classes.Pizza;

public class PizzaMargherita extends Pizza {

	public PizzaMargherita() {
		super();
	}

	public PizzaMargherita(String name, Double price, Double calories) {
		super("Margherita", 6.0, 250.0);
	}

	@Override
	public String toString() {
		return "PizzaMargherita [toString()=" + super.toString() + "]";
	}
}
