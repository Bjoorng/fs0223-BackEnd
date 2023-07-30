package com.classes.drinks;

import com.classes.Drink;

public class Fanta extends Drink {

	public Fanta() {
		super();
	}

	public Fanta(String name, Double price, Double calories) {
		super("Fanta", 8.0, 1200.0);
	}

	@Override
	public String toString() {
		return "Fanta [toString()=" + super.toString() + "]";
	}
}
