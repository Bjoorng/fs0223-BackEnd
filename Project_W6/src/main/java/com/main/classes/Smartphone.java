package com.main.classes;

import com.main.enums.DeviceState;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Smartphone")
public class Smartphone extends Devices{
	
	public Smartphone() {
		this.setStatus(DeviceState.AVAILABLE);
	}
	
}
