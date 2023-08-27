package com.epicode.fire.observers;

import java.util.Observable;
import java.util.Observer;

import com.epicode.fire.proxy.CProbeProxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("deprecation")
public class CCObserver implements Observer{

	@Override
	public void update(Observable ob, Object probe) {
		ProbeObserver po = (ProbeObserver) ob;
		long idProbe = po.getId();
		double latitude = po.getLatitude();
		double longitude = po.getLongitude();
		int smokeLevel = po.getSmokeLevel();
		
		String notification = "Incendio rilevato: Sonda " + idProbe + " - Lat: " + latitude + " Lon: " + longitude + " Smoke: " + smokeLevel;
        String alarm_url = "http://host/alarm?sensorId="+idProbe+"&lat="+latitude+"&lon="+longitude+"&smokeLevel="+smokeLevel+"]";
        System.out.println(notification);
        
        CProbeProxy sp = new CProbeProxy(po);
	}
	
}
