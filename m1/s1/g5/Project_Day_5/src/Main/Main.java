package Main;
import java.util.Scanner;

import Classes.*;

public class Main {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Insert A Song's Title And It's Duration");
		Audio song = new Audio(scan.nextLine(), Integer.parseInt(scan.nextLine()));
		System.out.println(song.getTitle() + " - " + song.getLength());
		
		System.out.println("Insert A Video's Title And It's Duration");
		Video video = new Video(scan.nextLine(), Integer.parseInt(scan.nextLine()));
		System.out.println(video.getTitle() + " - " + video.getLength());
		
		System.out.println("Insert An Image's Title And It's Brightness");
		Image img = new Image(scan.nextLine(), Integer.parseInt(scan.nextLine()));
		System.out.println(img.getTitle());
		
		System.out.println("Insert Another Video's Title And It's Duration");
		Video video2 = new Video(scan.nextLine(), Integer.parseInt(scan.nextLine()));
		System.out.println(video2.getTitle() + " - " + video2.getLength());
		
		System.out.println("Insert Another Song's Title And It's Duration");
		Audio song2 = new Audio(scan.nextLine(), Integer.parseInt(scan.nextLine()));
		System.out.println(song2.getTitle() + " - " + song2.getLength());
		
		playAudio(song);
		playVideo(video);
		volumeDwnAudio(song2);
		volumeUpAudio(song2);
		volumeDwnVideo(video2);
		volumeUpVideo(video2);
		showImg(img);
		
		Element[] player = {song, video, img, video2, song2};
		playSomething(player);
	}
		
		private static void volumeUpAudio(Audio a) {
			a.volumeUp();
		}
		
		private static void volumeDwnAudio(Audio a) {
			a.volumeDwn();
		}
	
		private static void volumeUpVideo(Video v) {
			v.volumeUp();
		}
		
		private static void volumeDwnVideo(Video v) {
			v.volumeDwn();
		}

		private static void playAudio(Audio a) {
			a.play();
		}
		
		private static void playVideo(Video v) {
			v.play();
		}
		
		private static void showImg(Image i) {
			i.play();
		}
		
		private static void playSomething(Element[] e) {
			System.out.println("Choose A Number Between 1 And 5 To Play Something Or 0 To Exit");
			int input = Integer.parseInt(scan.nextLine());
			while(input != 0) {
				switch(input) {
					case 1:
						e[0].play();
						break;
					case 2:
						e[1].play();
						break;
					case 3:
						e[2].play();
						break;
					case 4:
						e[3].play();
						break;
					case 5:
						e[4].play();
						break;
					default:
						System.out.println("Value Not Recognized");
				}
				System.out.println("Choose A Number Between 1 And 5 To Play Something Or 0 To Exit");
		        input = Integer.parseInt(scan.nextLine());
			}
			System.out.println("The Cycle Has Ended");
			scan.close();
		}
}
