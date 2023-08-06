package com.main.classes;

import com.main.enums.DeviceState;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Laptop")
public class Laptop extends Devices{
	
	public Laptop() {
		this.setStatus(DeviceState.AVAILABLE);
	}
	
}
