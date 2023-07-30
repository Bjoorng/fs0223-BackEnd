package com.classes.drinks;

import com.classes.Drink;

public class Wine extends Drink {

	public Wine() {
		super();
	}

	public Wine(String name, Double price, Double calories) {
		super("Nero D'Avola", 20.0, 0.0);
	}

	@Override
	public String toString() {
		return "Water [toString()=" + super.toString() + "]";
	}
}