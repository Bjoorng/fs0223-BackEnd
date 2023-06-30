package Classes;

import Interfaces.Brightness;
import Interfaces.Volume;

public class Video extends Element implements Brightness, Volume {
	
	protected int brightness = 5;
	protected int volume = 5;
	protected int length;
	
	public Video(String title, int length) {
		super(title);
		this.length = length;
	}
	
	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void volumeUp() {
		if(this.volume == 5){
			System.out.println("Volume Can't Be Raised Any Higher");
		}else{
			this.volume++;
			System.out.println("Volume Has Been Raised To " + this.volume);
		}
	}

	@Override
	public void volumeDwn() {
		if(this.volume == 0){
			System.out.println("Volume Can't Be Lowered Anymore");
		}else{
			this.volume--;
			System.out.println("Volume Has Been Lowered To " + this.volume);
		}
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

	@Override
	public void play() {
		for(int i = 0; i < this.length; i++) {
			System.out.print(this.title);
			for(int n = 0; n < this.brightness; n++) {
				System.out.print(" * ");
			}
			for(int m = 0; m < this.volume; m++) {
				System.out.print(" ! ");
			}
			System.out.println();
		}
	}
	
}
