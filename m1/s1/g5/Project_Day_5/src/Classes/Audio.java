package Classes;

import java.util.Scanner;

import Interfaces.Volume;

public class Audio extends Element implements Volume {

	Scanner scan = new Scanner(System.in);
	protected int volume = 3;
	protected int length;

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
		if (this.volume == 5) {
			System.out.println("Volume Can't Be Raised Any Higher");
		} else {
			this.volume++;
			System.out.println("Volume Has Been Raised To:" + this.volume);
		}
	}

	@Override
	public void volumeDwn() {
		if (this.volume == 0) {
			System.out.println("Volume Can't Be Lowered Anymore");
		} else {
			this.volume--;
			System.out.println("Volume Has Been Lowered To:" + this.volume);
		}
	}

	@Override
	public void volumeControl() {
		while (true) {
			System.out.println("\u001B[42mPress 1 To Raise The Volume Or 2 To Lower It. Press 0 To Stop\u001B[0m");
			int choice = Integer.parseInt(scan.nextLine());

			switch (choice) {
			case 1:
				if (volume < 5) {
					volume++;
					System.out.println("\u001B[36;40mVolume Has Been Raised To: " + volume + "\u001B[0m");
				} else {
					System.out.println("\u001B[33;41mVolume Can't Be Raised\u001B[0m");
				}
				break;
			case 2:
				if (volume > 0) {
					volume--;
					System.out.println("\u001B[36;40mVolume Has Been Lowered To: " + volume + "\u001B[0m");
				} else {
					System.out.println("\u001B[33;41mVolume Can't Be Lowered\u001B[0m");
				}
				break;
			case 0:
				System.out.println("\u001B[43mExiting Volume Control\u001B[0m");
				return;

			default:
				System.out.println("\u001B[41mInvalid Choice\u001B[0m");
			}
		}
	}

	@Override
	public void play() {
		for (int i = 0; i < this.length; i++) {
			System.out.print(this.title);
			for (int n = 0; n < this.volume; n++) {
				System.out.print(" ! ");
			}
			System.out.println();
		}
	}

	@Override
	public void brightnessControl() {
	}

}
