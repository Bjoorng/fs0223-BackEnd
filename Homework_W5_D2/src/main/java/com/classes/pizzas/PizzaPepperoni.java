package com.classes.pizzas;

import com.classes.Pizza;

public class PizzaPepperoni extends Pizza {

	public PizzaPepperoni() {
		super();
	}

	public PizzaPepperoni(String name, Double price, Double calories) {
		super("Pepperoni", 8.0, 900.0);
	}

	@Override
	public String toString() {
		return "PizzaPepperoni [toString()=" + super.toString() + "]";
	}
}
