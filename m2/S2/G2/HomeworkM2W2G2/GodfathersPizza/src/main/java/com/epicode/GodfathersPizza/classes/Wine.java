package com.epicode.GodfathersPizza.classes;

import jakarta.persistence.Entity;

@Entity
public class Wine extends Drink {

	public Wine() {
		super("Wine (0.75l, 13%)", 7.49, 607.0);
	}

}
