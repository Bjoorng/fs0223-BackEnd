package com.epicode.fire.factory;

import com.epicode.fire.factory.classes.ControlCenter;

public class CFControlCenter implements IAControlCenter{

	@Override
	public ControlCenter createControlCenter() {
		return new ControlCenter();
	}

}
