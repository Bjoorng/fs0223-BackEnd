package Classes;

import java.util.Scanner;

import Interfaces.Brightness;

public class Image extends Element implements Brightness {

	Scanner scan = new Scanner(System.in);
	protected int brightness = 3;

	public Image(String title) {
		super(title);
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
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
	public void brightnessControl() {
		int input = Integer.parseInt(scan.nextLine());
		while (input != 0) {
			System.out.println("Press 1 To Raise The Brightness Or 2 To Lower It. Press 0 To Stop");
			int upDwn = Integer.parseInt(scan.nextLine());
			while (upDwn != 0) {
				switch (upDwn) {
				case 1:
					if (this.brightness == 5) {
						this.brightness = 5;
						System.out.println("Brightness Can't Be Raised");
					} else {
						this.brightness++;
						System.out.println("Brightness Has Been Raised To:" + this.brightness);
					}
					break;
				case 2:
					if (this.brightness == 0) {
						this.brightness = 0;
						System.out.println("Brightness Can't Be Lowered");
					} else {
						this.brightness--;
						System.out.println("Brightness Has Been Lowered To:" + this.brightness);
					}
					break;
				default:
					System.out.println("Error");
				}
				System.out.println("Press 1 To Raise The Brightness Or 2 To Lower It. Press 0 To Stop");
				upDwn = Integer.parseInt(scan.nextLine());
			}

			System.out.println("Press 1 To Continue Adjusting Brightness or 0 To Exit Brightness Control");
			input = Integer.parseInt(scan.nextLine());
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

	@Override
	public void volumeControl() {
	}

}
