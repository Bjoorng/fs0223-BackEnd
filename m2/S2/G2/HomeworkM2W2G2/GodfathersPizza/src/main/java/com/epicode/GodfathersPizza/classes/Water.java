package com.epicode.GodfathersPizza.classes;

import jakarta.persistence.Entity;

@Entity
public class Water extends Drink {

	public Water() {
		super("Water (0.5l)", 1.29, 0.0);
	}

}
