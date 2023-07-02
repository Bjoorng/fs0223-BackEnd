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

		// System.out.println(textBlock);

		Element[] player = generateArray();
		playSomething(player, scan);
		scan.close();
	}

	private static void playSomething(Element[] e, Scanner scan) {
		System.out.println("Choose A Number Between 1 And 5 To Play Something Or 0 To Exit");

		while (scan.hasNextInt()) {
			int input = Integer.parseInt(scan.nextLine());

			if (input == 0) {
				break;
			}
			if (input >= 1 && input <= 5) {
				if (e[input - 1] instanceof Audio) {
					e[input - 1].play();
					System.out.println("Press 1 To Change The Volume. Press 0 If Everything's Fine.");
					e[input - 1].volumeControl();
					e[input - 1].play();
				} else if (e[input - 1] instanceof Video) {
					boolean options = true;
					e[input - 1].play();
					while (options) {
						System.out.println(
								"Press 1 To Change The Volume or 2 To Change The Brightness. Press 0 If Everything's Fine.");
						int mod = Integer.parseInt(scan.nextLine());
						switch (mod) {
						case 0:
							options = false;
							break;
						case 1:
							System.out.println("Change The Volume");
							e[input - 1].volumeControl();
							e[input - 1].play();
							break;
						case 2:
							System.out.println("Change The Brightness");
							e[input - 1].brightnessControl();
							e[input - 1].play();
							break;
						default:
							System.out.println("Error: Invalid Input");
						}
					}
					System.out.println("Enjoy Your Piece Of Content");
				} else if (e[input - 1] instanceof Image) {
					e[input - 1].play();
					System.out.println("Press 1 To Change The Brightness. Press 0 If Everything's Fine.");
					e[input - 1].brightnessControl();
					e[input - 1].play();
				}
			} else {
				System.out.println("Value Not Recognized");
			}
			System.out.println("Choose A Number Between 1 And 5 To Play Something Or 0 To Exit");
		}
		System.out.println("The Cycle Has Ended. Enjoy The Rest Of Your Day");
	}

	private static Element[] generateArray() {
		Element[] e = new Element[5];
		int media;
		String title;
		int length;
		int brightness;

		for (int i = 0; i < 5; i++) {
			System.out.print("Select the item type (1 = Audio, 2 = Video, 3 = Image): ");
			media = Integer.parseInt(scan.nextLine());

			switch (media) {
			case 1:
				System.out.print("Insert The Title For Your New Audio Item: ");
				title = scan.nextLine();
				System.out.print("Enter Audio duration: ");
				length = Integer.parseInt(scan.nextLine());
				e[i] = new Audio(title, length);
				break;
			case 2:
				System.out.print("Insert The Title For Your New Video Item: ");
				title = scan.nextLine();
				System.out.print("Enter This Video's Duration: ");
				length = Integer.parseInt(scan.nextLine());
				e[i] = new Video(title, length);
				break;
			case 3:
				System.out.print("Insert The Title For Your New Image Item: ");
				title = scan.nextLine();
				e[i] = new Image(title);
				break;
			default:
				System.out.println("Value Not Recognized");
				i--;
			}
		}
		return e;
	}

}
