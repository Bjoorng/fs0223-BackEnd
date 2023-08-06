package com.main.classes;

import com.main.enums.DeviceState;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Tablet")
public class Tablet extends Devices{

	public Tablet() {
		this.setStatus(DeviceState.AVAILABLE);
	}
	
}
