package com.epicode.fire.factory;

import com.epicode.fire.factory.classes.Probe;

public interface IAProbe {
	Probe createProbe(long id, double latitude, double longitude);
}
