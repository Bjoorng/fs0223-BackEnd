package com.epicode.fire.factory.classes;

import com.epicode.fire.factory.interfaces.ISensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Probe implements ISensor{

	 private int smokeLevel;
	    private long id;
	    private double latitude;
	    private double longitude;
	    private ControlCenter cc;
		
	    public void setSmokeLevel(int smokeLevel) {
	    	this.smokeLevel = smokeLevel;
	    	if(smokeLevel > 5) {
	    		fireFinder();
	    	}
	    }
	    
	    @Override
		public void fireFinder() {
			cc.alarmTrigger(this);	
		}
}
