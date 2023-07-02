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
		while (true) {
			System.out.println("\u001B[42mPress 1 To Raise The Brightness Or 2 To Lower It. Press 0 To Stop\u001B[0m");
			int choice = Integer.parseInt(scan.nextLine());

			switch (choice) {
			case 1:
				if (brightness < 5) {
					brightness++;
					System.out.println("\u001B[36;40mBrightness Has Been Raised To: " + brightness + "\u001B[0m");
				} else {
					System.out.println("\u001B[33;41mBrightness Can't Be Raised\u001B[0m");
				}
				break;
			case 2:
				if (brightness > 0) {
					brightness--;
					System.out.println("\u001B[36;40mBrightness Has Been Lowered To: " + brightness + "\u001B[0m");
				} else {
					System.out.println("\u001B[33;41mBrightness Can't Be Lowered\u001B[0m");
				}
				break;
			case 0:
				System.out.println("\u001B[43mExiting Brightness Control\u001B[0m");
				return;

			default:
				System.out.println("\u001B[41mInvalid Choice\u001B[0m");
			}
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
