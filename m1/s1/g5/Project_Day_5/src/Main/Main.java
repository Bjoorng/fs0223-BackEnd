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

		Element[] player = generateArray();
		playSomething(player, scan);
		scan.close();
	}

	private static void playSomething(Element[] e, Scanner scan) {
		System.out.println("\u001B[46mChoose A Number Between 1 And 5 To Play Something Or 0 To Exit\u001B[0m");
		while (scan.hasNextInt()) {
			int input = Integer.parseInt(scan.nextLine());

			if (input == 0) {
				break;
			}
			if (input >= 1 && input <= 5) {
				if (e[input - 1] instanceof Audio) {
					e[input - 1].play();
					System.out
							.println("\u001B[46mPress 1 To Change The Volume. Press 0 If Everything's Fine.\u001B[0m");
					int audioMod = Integer.parseInt(scan.nextLine());
					switch (audioMod) {
					case 0:
						break;
					case 1:
						e[input - 1].volumeControl();
						e[input - 1].play();
						break;
					default:
						System.out.println("\u001B[46mError: Invalid Input\u001B[0m");
					}
					System.out.println("\u001B[45mEnjoy Your Piece Of Content\u001B[0m");
				} else if (e[input - 1] instanceof Video) {
					boolean options = true;
					e[input - 1].play();
					while (options) {
						System.out.println(
								"\u001B[46mPress 1 To Change The Volume or 2 To Change The Brightness. Press 0 If Everything's Fine.\u001B[0m");
						int videoMod = Integer.parseInt(scan.nextLine());
						switch (videoMod) {
						case 0:
							options = false;
							break;
						case 1:
							System.out.println("\u001B[46mChange The Volume\u001B[0m");
							e[input - 1].volumeControl();
							e[input - 1].play();
							break;
						case 2:
							System.out.println("\u001B[46mChange The Brightness\u001B[0m");
							e[input - 1].brightnessControl();
							e[input - 1].play();
							break;
						default:
							System.out.println("\u001B[46mError: Invalid Input\u001B[0m");
						}
					}
					System.out.println("\u001B[45mEnjoy Your Piece Of Content\u001B[0m");
				} else if (e[input - 1] instanceof Image) {
					e[input - 1].play();
					System.out.println(
							"\u001B[46mPress 1 To Change The Brightness. Press 0 If Everything's Fine.\u001B[0m");
					int imageMod = Integer.parseInt(scan.nextLine());
					switch (imageMod) {
					case 0:
						break;
					case 1:
						e[input - 1].brightnessControl();
						e[input - 1].play();
						break;
					default:
						System.out.println("\u001B[46mError: Invalid Input\u001B[0m");
					}
					System.out.println("\u001B[45mEnjoy Your Piece Of Content\u001B[0m");
				}
			} else {
				System.out.println("\u001B[41mValue Not Recognized");
			}
			System.out.println("\u001B[46mChoose A Number Between 1 And 5 To Play Something Or 0 To Exit\u001B[0m");
		}
		System.out.println("\u001B[43mThe Cycle Has Ended. Enjoy The Rest Of Your Day\u001B[0m");
	}

	private static Element[] generateArray() {
		Element[] e = new Element[5];
		int media;
		String title;
		int length;

		for (int i = 0; i < 5; i++) {
			System.out.print(
					"\u001B[30;42mChoose The Type Of The Element You Want To Create: 1) Audio, 2) Video, 3) Image\u001B[0m ");
			media = Integer.parseInt(scan.nextLine());

			switch (media) {
			case 1:
				System.out.print("\u001B[30;42mInsert The Title For Your New Audio Item:\u001B[0m ");
				title = scan.nextLine();
				System.out.print("\u001B[30;42mEnter Audio duration:\u001B[0m ");
				length = Integer.parseInt(scan.nextLine());
				e[i] = new Audio(title, length);
				break;
			case 2:
				System.out.print("\u001B[30;42mInsert The Title For Your New Video Item:\u001B[0m ");
				title = scan.nextLine();
				System.out.print("\u001B[30;42mEnter This Video's Duration:\u001B[0m ");
				length = Integer.parseInt(scan.nextLine());
				e[i] = new Video(title, length);
				break;
			case 3:
				System.out.print("\u001B[30;42mInsert The Title For Your New Image Item:\u001B[0m ");
				title = scan.nextLine();
				e[i] = new Image(title);
				break;
			default:
				System.out.println("\u001B[41mValue Not Recognized\u001B[0m");
				i--;
			}
		}
		return e;
	}

}
