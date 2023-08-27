package com.epicode.fire.factory.classes;

import com.epicode.fire.factory.interfaces.IControlCenter;
import com.epicode.fire.factory.interfaces.ISensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlCenter implements IControlCenter{

	@Override
	public void alarmTrigger(Probe sensor) {
		long sensorId = sensor.getId();
		double latitude = sensor.getLatitude();
		double longitude = sensor.getLongitude();
		int smokeLevel = sensor.getSmokeLevel();
		String alarm = "Incendio rilevato: Sonda " + sensorId + " - Lat: " + latitude + " Lon: " + longitude + " Smoke: " + smokeLevel;
		String alarm_url = "http://host/alarm?sensorId="+sensorId+"&lat="+latitude+"&lon="+longitude+"&smokeLevel="+smokeLevel+"]";
		System.out.println(alarm);
        System.out.println(alarm_url);
	}
	
}
