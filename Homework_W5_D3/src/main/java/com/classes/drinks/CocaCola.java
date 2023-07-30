package com.classes.drinks;

import com.classes.Drink;

public class CocaCola extends Drink {

	public CocaCola() {
		super();
	}

	public CocaCola(String name, Double price, Double calories) {
		super("Coca-Cola", 8.0, 1200.0);
	}

	@Override
	public String toString() {
		return "CocaCola [toString()=" + super.toString() + "]";
	}
}
