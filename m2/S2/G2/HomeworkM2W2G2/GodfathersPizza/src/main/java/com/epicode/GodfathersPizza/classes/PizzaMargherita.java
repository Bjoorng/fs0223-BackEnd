package com.epicode.GodfathersPizza.classes;

import jakarta.persistence.Entity;

@Entity
public class PizzaMargherita extends PizzaBase {

	public PizzaMargherita() {
		super("Pizza Margherita (tomato, cheese)", 4.99, 1104.0);
	}

}
