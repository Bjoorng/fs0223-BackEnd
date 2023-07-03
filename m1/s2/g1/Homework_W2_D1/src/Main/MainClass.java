package Main;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.BancaException;
import Classes.ContoCorrente;
import Classes.ContoOnLine;

public class MainClass {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Logger log = LoggerFactory.getLogger(MainClass.class);

		int[] arrayNum = new int[5];
		generateRandomArray(arrayNum);
		modArray(arrayNum, scanner);

		System.out.println("Array iniziale:");
		printArray(arrayNum);
		
		getKilometers();

		gestisciContoCorrente();
        gestisciContoOnLine();
		
	}

	public static void generateRandomArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10) + 1;
		}
		System.out.println(array);
	}

	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void modArray(int[] array, Scanner scanner) {
		int position, value;
		do {
			try {
				System.out.print("\nInserisci il numero da aggiungere (0 per uscire): ");
				value = Integer.parseInt(scanner.nextLine());
				if (value == 0) {
					break;
				}
				System.out.print("Inserisci la posizione (1-5) dove vuoi aggiungerlo: ");
				position = Integer.parseInt(scanner.nextLine()) - 1;

				if (position < 0 || position >= array.length) {
					System.out.println("Errore: La posizione deve essere tra 1 e " + array.length);
				} else if (value < 1 || value > 10) {
					System.out.println("Errore: Il numero da inserire deve essere tra 1 e 10.");
				} else {
					array[position] = value;
					System.out.println("Array aggiornato:");
					printArray(array);
				}
			} catch (Exception e) {
				System.out.println("Errore: Inserire un valore intero valido.");
				scanner.nextLine();
			}
		} while (true);
		System.out.println("Programma terminato.");
		scanner.close();
	}

	public static void getKilometers() {
		double kmPercorsi, litriConsumati, kmPerLitro;
		do {
			try {
				System.out.print("Inserisci il numero di km percorsi (0 per uscire): ");
				kmPercorsi = Double.parseDouble(scanner.nextLine());
				if (kmPercorsi == 0) {
					break;
				}
				System.out.print("Inserisci i litri di carburante consumati: ");
				litriConsumati = Double.parseDouble(scanner.nextLine());
				if (litriConsumati == 0) {
					throw new ArithmeticException("Errore: Divisione per 0 non consentita.");
				}
				kmPerLitro = kmPercorsi / litriConsumati;
				System.out.println("Consumo: " + kmPerLitro + " km/litro");
			} catch (Exception e) {
				System.out.println("Errore: Inserire un valore numerico valido diverso da 0.");
				scanner.nextLine();
			}
		} while (true);
		System.out.println("Programma terminato.");
		scanner.close();
	}

	public static void gestisciContoCorrente() {
		try {
			scanner = new Scanner(System.in);

			System.out.print("Inserisci il nome del titolare del conto corrente: ");
			String titolareConto = scanner.nextLine();

			System.out.print("Inserisci il saldo iniziale del conto corrente: ");
			double saldoIniziale = scanner.nextDouble();

			ContoCorrente conto1 = new ContoCorrente(titolareConto, saldoIniziale);
			System.out.println("Saldo conto: " + conto1.restituisciSaldo());

			System.out.print("Inserisci l'importo da prelevare dal conto corrente: ");
			double importoPrelevato = scanner.nextDouble();
			conto1.preleva(importoPrelevato);

			System.out.println("Saldo conto dopo il prelievo: " + conto1.restituisciSaldo());
			scanner.close();
		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}
	}

	public static void gestisciContoOnLine() {
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Inserisci il nome del titolare del conto online: ");
			String titolareConto = scanner.nextLine();

			System.out.print("Inserisci il saldo iniziale del conto online: ");
			double saldoIniziale = scanner.nextDouble();

			System.out.print("Inserisci il massimo importo prelevabile dal conto online: ");
			double maxPrelievo = scanner.nextDouble();

			ContoOnLine conto2 = new ContoOnLine(titolareConto, saldoIniziale, maxPrelievo);
			conto2.stampaSaldo();

			System.out.print("Inserisci l'importo da prelevare dal conto online: ");
			double importoPrelevato = scanner.nextDouble();
			conto2.preleva(importoPrelevato);

			conto2.stampaSaldo();
			scanner.close();
		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}
	}
}
