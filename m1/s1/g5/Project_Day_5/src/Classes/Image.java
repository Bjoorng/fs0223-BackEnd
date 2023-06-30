package Classes;

import Interfaces.Brightness;

public class Image extends Element implements Brightness{

	private int brightness;
	
	public Image(String title, int brightness) {
		super(title);
		this.brightness = brightness;
	}
	
	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	@Override
	public void brightnessUp() {
		if(this.brightness == 5){
			System.out.println("Brightness Can't Be Raised Any Higher");
		}else{
			this.brightness++;
			System.out.println("Brightness Has Been Raised To " + this.brightness);
		}
	}
	
	@Override
	public void brightnessDwn() {
		if(this.brightness == 0){
			System.out.println("Brightness Can't Be Lowered Anymore");
		}else{
			this.brightness--;
			System.out.println("Brightness Has Been Lowered To " + this.brightness);
		}
	}

	public void show() {
		System.out.print(title);
		for (int i = 0; i < brightness; i++) {
			System.out.print(" * ");
		}
		System.out.println();
	}
	
	@Override
	public void play() {
		this.show();
	}

}
