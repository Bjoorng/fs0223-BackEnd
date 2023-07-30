package com.classes.pizzas;

import com.classes.Pizza;

public class PizzaHawaiian extends Pizza {

	public PizzaHawaiian() {
		super();
	}

	public PizzaHawaiian(String name, Double price, Double calories) {
		super("Hawaaian", 1000.0, 800000.0);
	}

	@Override
	public String toString() {
		return "PizzaHawaiian [toString()=" + super.toString() + "]";
	}
}
