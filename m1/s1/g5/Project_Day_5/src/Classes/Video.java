package Classes;

import java.util.Scanner;

import Interfaces.Brightness;
import Interfaces.Volume;

public class Video extends Element implements Brightness, Volume {

	Scanner scan = new Scanner(System.in);
	protected int brightness = 3;
	protected int volume = 3;
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
		if (this.volume == 5) {
			this.volume = 5;
			System.out.println("Volume Can't Be Raised Any Higher");
		} else {
			this.volume++;
			System.out.println("Volume Has Been Raised To " + this.volume);
		}
	}

	@Override
	public void volumeDwn() {
		if (this.volume == 0) {
			this.volume = 0;
			System.out.println("Volume Can't Be Lowered Anymore");
		} else {
			this.volume--;
			System.out.println("Volume Has Been Lowered To " + this.volume);
		}
	}

	@Override
	public void brightnessUp() {
		if (this.brightness == 5) {
			System.out.println("Brightness Can't Be Raised Any Higher");
		} else {
			this.brightness++;
			System.out.println("Brightness Has Been Raised To " + this.brightness);
		}
	}

	@Override
	public void brightnessDwn() {
		if (this.brightness == 0) {
			System.out.println("Brightness Can't Be Lowered Anymore");
		} else {
			this.brightness--;
			System.out.println("Brightness Has Been Lowered To " + this.brightness);
		}
	}

	@Override
	public void play() {
		for (int i = 0; i < this.length; i++) {
			System.out.print(this.title);
			for (int n = 0; n < this.brightness; n++) {
				System.out.print(" * ");
			}
			for (int m = 0; m < this.volume; m++) {
				System.out.print(" ! ");
			}
			System.out.println();
		}
	}

	@Override
	public void volumeControl() {
		int upDwn;
		do {
			System.out.println("\u001B[42mPress 1 To Raise The Volume Or 2 To Lower It. Press 0 To Stop\u001B[0m");
			upDwn = Integer.parseInt(scan.nextLine());

			switch (upDwn) {
			case 1:
				if (volume == 5) {
					System.out.println("\u001B[33;41mVolume Can't Be Raised\u001B[0m");
				} else {
					volume++;
					System.out.println("\u001B[36;40mVolume Has Been Raised To:" + volume + "\u001B[0m");
				}
				break;
			case 2:
				if (volume == 0) {
					System.out.println("\u001B[33;41mVolume Can't Be Lowered\u001B[0m");
				} else {
					volume--;
					System.out.println("\u001B[36;40mVolume Has Been Lowered To:" + volume + "\u001B[0m");
				}
				break;
			case 0:
				System.out.println("\u001B[43mExiting Volume Control\u001B[0m");
				break;
			default:
				System.out.println("\u001B[41mError: Invalid Input\u001B[0m");
			}
		} while (upDwn != 0);
	}

	@Override
	public void brightnessControl() {
		int upDwn;
		do {
			System.out.println("\u001B[42mPress 1 To Raise The Brightness Or 2 To Lower It. Press 0 To Stop\u001B[0m");
			upDwn = Integer.parseInt(scan.nextLine());

			switch (upDwn) {
			case 1:
				if (this.brightness == 5) {
					System.out.println("\u001B[33;41mBrightness Can't Be Raised\u001B[0m");
				} else {
					this.brightness++;
					System.out.println("\u001B[36;40mBrightness Has Been Raised To:" + this.brightness + "\u001B[0m");
				}
				break;
			case 2:
				if (this.brightness == 0) {
					System.out.println("\u001B[33;41mBrightness Can't Be Lowered\u001B[0m");
				} else {
					this.brightness--;
					System.out.println("\u001B[36;40mBrightness Has Been Lowered To:" + this.brightness + "\u001B[0m");
				}
				break;
			case 0:
				System.out.println("\u001B[43mExiting Brightness Control\u001B[0m");
				break;
			default:
				System.out.println("\u001B[41mError: Invalid Input\u001B[0m");
			}
		} while (upDwn != 0);
	}

}
