package Classes;

import Interfaces.Volume;

public class Audio extends Element implements Volume {
	
	private int volume = 5;
	private int length;
	
	public Audio(String title, int length) {
		super(title);
		this.length = length;
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
		}else {
			this.volume++;
			System.out.println("Volume Has Been Raised To " + this.volume);
		}
	}
	
	@Override
	public void volumeDwn() {
		if(this.volume == 0){
			System.out.println("Volume Can't Be Lowered Anymore");
		}else {
			this.volume++;
			System.out.println("Volume Has Been Lowered To " + this.volume);
		}
	}

	@Override
	public void play() {
		for(int i = 0; i < this.length; i++) {
			System.out.print(this.title);
			for(int n = 0; n < this.volume; n++) {
				System.out.print(" ! ");
			}
			System.out.println();
		}
	}
	
}
