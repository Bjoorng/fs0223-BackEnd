package com.classes.drinks;

import com.classes.Drink;

public class Water extends Drink {

	public Water() {
		super();
	}

	public Water(String name, Double price, Double calories) {
		super("Water", 2.0, 2.0);
	}

	@Override
	public String toString() {
		return "Water [toString()=" + super.toString() + "]";
	}
}