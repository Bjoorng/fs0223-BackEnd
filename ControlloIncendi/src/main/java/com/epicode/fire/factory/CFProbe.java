package com.epicode.fire.factory;

import com.epicode.fire.factory.classes.Probe;

public class CFProbe implements IAProbe{

	@Override
	public Probe createProbe(long id, double latitude, double longitude) {
		Probe sen = new Probe();
		sen.setId();
		sen.setLatitude();
		sen.setLongitude();
		return sen;
	}

}
