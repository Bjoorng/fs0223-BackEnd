package com.epicode.fire.proxy;

import com.epicode.fire.observers.ProbeObserver;

public class CProbeProxy implements IProbeProxy{

	ProbeObserver sensor;
	
	public CProbeProxy(ProbeObserver probe) {
		super();
		this.sensor = sensor;
		alarm(sensor);
	}
	
	@Override
	public String alarm(ProbeObserver probe) {
		String alarm_url = "http://host/alarm?sensorId="+probe.getId()+"&lat="+probe.getLatitude()+"&lon="+probe.getLongitude()+"&smokeLevel="+probe.getSmokeLevel()+"]";
		System.out.println(alarm_url);
		return alarm_url;
	}

}
