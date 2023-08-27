package com.epicode.fire.observers;

import java.util.Observable;

import lombok.Data;

@Data
@SuppressWarnings("deprecation")
public class ProbeObserver extends Observable{
	
	private long id;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	
	private ProbeObserver(long id, double latitude, double longitude) {
		super();
		this.id = id;
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.smokeLevel = 0;
	}
	
	  public void setSmokeLevel(int smokeLevel) {
	        this.smokeLevel = smokeLevel;
	        if (smokeLevel > 5) {
	        	notifySensore();
	        }
	    }
	    
	    private void notifySensore() {
	        setChanged();
	        notifyObservers(this);
	    }
}
