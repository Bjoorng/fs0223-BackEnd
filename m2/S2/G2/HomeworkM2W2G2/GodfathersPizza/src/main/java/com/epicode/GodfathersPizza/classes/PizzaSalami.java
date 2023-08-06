package com.epicode.GodfathersPizza.classes;

import jakarta.persistence.Entity;

@Entity
public class PizzaSalami extends PizzaBase {

	public PizzaSalami() {
		super("Pizza Salami (tomato, cheese, salami)", 5.99, 1160.0);
	}

}
