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
	public void volumeControl() {
		int input = Integer.parseInt(scan.nextLine());
		while (input != 0) {
			System.out.println("Press 1 To Raise The Volume Or 2 To Lower It. Press 0 To Stop");
			int upDwn = Integer.parseInt(scan.nextLine());
			while (upDwn != 0) {
				switch (upDwn) {
				case 1:
					if (this.volume == 5) {
						this.volume = 5;
						System.out.println("Volume Can't Be Raised");
					} else {
						this.volume++;
						System.out.println("Volume Has Been Raised To:" + this.volume);
					}
					break;
				case 2:
					if (this.volume == 0) {
						this.volume = 0;
						System.out.println("Volume Can't Be Lowered");
					} else {
						this.volume--;
						System.out.println("Volume Has Been Lowered To:" + this.volume);
					}
					break;
				default:
					System.out.println("Error");
				}
				System.out.println("Press 1 To Raise The Volume Or 2 To Lower It. Press 0 To Stop");
				upDwn = Integer.parseInt(scan.nextLine());
			}

			System.out.println("Press 1 To Continue Adjusting Volume or 0 To Exit Volume Control");
			input = Integer.parseInt(scan.nextLine());
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
