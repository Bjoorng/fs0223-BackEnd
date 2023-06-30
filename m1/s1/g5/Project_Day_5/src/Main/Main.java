package Main;
import java.util.Scanner;

import Classes.*;

public class Main {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String textBlock = """ 
							///////////*///////////////((((((((///((//((((((((((((((/////((,//(/(///(/((/,**
							%%%%%%##((//***,,,*/,*****,,,,**/(,,,,,.,,....,**......,,....,/,.,,,*//*,***#,..
							.....*.........  ..*.,,,,,,..,(((/..,,..,.....,,,.............*...,,***,,***....
							 ....*.........   */.,*,.,,,,,,.,*...,..,,.....,,............./......,,**,**....
							  ...*......      .*,,*,,,,,,,,,.*..,,,,,,*,.,,/,............./......,,*,,,,....
							 ....*.. ..,      .*,,,,,,,,,,,,,/,*(%&&&&&&&&%%#/*.,........./.......,,,..,....
							.....*.. .....    .*,,,,*,,,,/(#&%%###(#%##%##%&&&&&&&%&(,....(,......,,,..,/...
							....,*.. .....    ,*,,**/(&%%((%#####%#(%%#%##%%&&&&&&&&&&#%*.(,........,..,#,..
							,...*/............*/,/%%%###((((####%%##%#%%%%&&&&&%&%%%%%&%&&&*.,,.,,,,,..,#*,.
							//*,,*.. ........./#%#(###((##((((#%##%%%%%%%#*(%%%%###%%%&%&%%%%%%(*,,,,,,,##,.
							/*,.**..........,(%#(%((####%(#((##(#%%%%%%%#/#(,.(%%%%%&%%%%%%#%(.,((/*,**%&#*,
							,...#/........*###%##%#(((#(((%####%#%%%%%#%&/(%(##%(#%%%##(((&&%/,*%(,##/,/%#*,
							,...**......,,/%##########(((((##%%%##%%##&&&@&%#/(##%%%(#####%(#/*#(,(#(#%/##%,
							,...**,....,*#%%%#(###((#(##(((##(((#%#(#&##(#/(####%%((#(#####(/(*%*/%%#/#(%%%,
							....*/,.,,,*#%#####(####((((/(((##(#%(((/**(**(#((*/##//((###%(#%((((**(&#((/#%(
							....***,,,,/%%###//((//(/(/*/((#######(/,,/,.,,....,&* ,.*/**/#(/(((/(**,,,///((
							...,***,,,*(((###(#(((((/////(((//((#((/**,..*##&%*(&. (###*.,,,,*,*/**,,...,**#
							..,*//*,,,/%%((#%##(((///*(*(///*//(///((**##&@&&%#%&%%&#@@%@@&/**,,.,,,,.....,,
							.,,,//,,,,/#(((##%%#(#((/***,*,*///((//(%#((#%&&&#./#,*%&%&&@@@@&&%(/,,,**,..,.*
							,,**/(,,*,/#(/((##%%%(#//*,*,,,/*//((/*/(##*,*//, //......*#&&&%#/(///*.......,/
							.,,*/#,,,,*(##((/((%%%#(*,,.,,,*,,,(**(**((/,*/,*%%%%/*,..,*(//*,,,,.,........,(
							,,***(,,,,/%%###//((%%%%%**...,,,,(/,*/,////(*,...,,,*,*,*,,/(/*,.*,,.........*(
							,,,,*(,,/&&#(/(%#////(#%%#(,,,..*.,,*///,*//*,....,.*..*,..,.,*,,,,.,*........*(
							.,,,,(*%%(#%&@@&#%/**//(#(((,,,....,,****,*,.,.......*.,.,.,...,,,,,,,..    .,/#
							.,,,/&&&&%%#/((&@%(/(///(/#((,*,.,...,,*,,, .,,......*,**.,,,...*,,,.,...   ,/(%
							.,,#&&&@@@@@%#/(#&%#(*/(////*(**,.*,..,.,,,,....,.....,..,,*,,.,..,,.....  ,*#(#
							,,#%%#%%%&@@@&///###///((///////*,,,,,,,,,..,........,,...,..,,.,****/*.. .#/#(#
							*/%%%%%%&%%%@@%//*(#///(#((/***//,,,...,,.,*.,.,........ .. ..***//(((/#.. #(((#
							(#%%&&@@@@&&&&%########%%%%%%#////,.,,,..,,*//*/,*,,.,,,.    (%%#%#%%%%%#,,/&%%&
							/(%&&&&@&&&&&&%%%%#%%%%%%%%%&&&%%#//(,*,,*(#(///*##//#(,,.....%###########(.*##%
							,,,#%%&%@&%#(///*/**/**/////*/////((#(/((/((//((*(#######(...**#################
							..*/**//****,,,,,,,,.,,,,,,,,,,,,,,,,,,,,,,,,,,,*,,,,,*****#/#&#&*,,,,,,,.,,,...
							""";
		
		System.out.println(textBlock);
		
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
		
		Element[] player = new Element[5];

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
			generateArray(e);
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
		
		private static void generateArray(Element[] e) {
			for (int i = 0; i < 5; i++) {
	        	
	            System.out.print("Select the item type (1 = Audio, 2 = Video, 3 = Image): ");
	            int type = Integer.parseInt(scan.nextLine());

	            switch (type) {
	                case 1:
	                	System.out.print("Insert The Title For Your New Media Item: ");
	                	String title = scan.nextLine();
	                    System.out.print("Enter Audio duration: ");
	                    int length = Integer.parseInt(scan.nextLine());

	                    e[i] = new Audio(title, length);
	                    break;
	                case 2:
	                	System.out.print("Insert The Title For Your New Media Item: ");
	                	title = scan.nextLine();
	                    System.out.print("Enter This Video's Duration: ");
	                    length = Integer.parseInt(scan.nextLine());

	                    e[i] = new Video(title, length);
	                    break;
	                case 3:
	                	System.out.print("Insert The Title For Your New Media Item: ");
	                	title = scan.nextLine();
	                	System.out.print("Enter This Image's Brightness: ");
	                	int brightness = Integer.parseInt(scan.nextLine());
	                	e[i] = new Image(title, brightness);
	                    break;
	                default:
	                    System.out.println("Value Not Recognized");
	                    i--;
	            }
	        }
		}
}
