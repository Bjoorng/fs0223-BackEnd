package com.classes.drinks;

import com.classes.Drink;

public class Pepsi extends Drink {

	public Pepsi() {
		super();
	}

	public Pepsi(String name, Double price, Double calories) {
		super("Pepsi", 8.0, 1200.0);
	}

	@Override
	public String toString() {
		return "Pepsi [toString()=" + super.toString() + "]";
	}
}
