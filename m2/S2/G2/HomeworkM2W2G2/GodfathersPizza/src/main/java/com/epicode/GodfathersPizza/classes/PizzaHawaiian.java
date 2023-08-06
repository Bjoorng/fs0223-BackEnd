package com.epicode.GodfathersPizza.classes;

import jakarta.persistence.Entity;

@Entity
public class PizzaHawaiian extends PizzaBase {

	public PizzaHawaiian() {
		super("Pizza Hawaiian (tomato, cheese, ham, pinapple)", 6.49, 1024.0);
	}

}
