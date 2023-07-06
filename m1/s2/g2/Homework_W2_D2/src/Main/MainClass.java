package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass {

	static Scanner scanner = new Scanner(System.in);
	static Logger log = LoggerFactory.getLogger(MainClass.class);

	public static void main(String[] args) {

		System.out.println("Choose The Number Of Words To Insert (n): ");
		int n = scanner.nextInt();
		scanner.nextLine();

		Set<String> allWords = new HashSet<>();
		Set<String> duplicateWords = new HashSet<>();

		System.out.println("Now Insert Your " + n + " Words: ");
		addWord(n, scanner, allWords, duplicateWords);
		scanner.close();

		printDuplicateWords(duplicateWords);
		printDistinctWordsCount(allWords);
		printDistinctWords(allWords);

		n = scanner.nextInt();
		scanner.nextLine();

		List<Integer> randomNumbers = getNumbers(n);
		List<Integer> randomReverse = getReverse(randomNumbers);
		List<Integer> randomBoth = ;
		printOrder(randomNumbers);
		printReverse(randomReverse);
	}

	// Esercizio#1

	private static void addWord(int n, Scanner scanner, Set<String> allWords, Set<String> duplicateWords) {
		if (n <= 0) {
			return;
		}
		String word = scanner.nextLine();
		if (!allWords.add(word)) {
			duplicateWords.add(word);
		}
		addWord(n - 1, scanner, allWords, duplicateWords);
	}

	private static void printDuplicateWords(Set<String> duplicateWords) {
		log.info("Duplicated Words:");
		for (String word : duplicateWords) {
			log.info(word);
		}
	}

	private static void printDistinctWordsCount(Set<String> allWords) {
		log.info("Number Of Distinct Words: " + allWords.size());
	}

	private static void printDistinctWords(Set<String> allWords) {
		log.info("List Of Distinct Words:");
		for (String word : allWords) {
			log.info(word);
		}
	}

	// Esercizio#2

	private static List<Integer> getNumbers(int n) {
		List<Integer> randNums = new ArrayList<>();
		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			int randomNum = rand.nextInt(101);
			randNums.add(randomNum);
		}
		Collections.sort(randNums);
		return randNums;
	}

	private static List<Integer> getReverse(List<Integer> list ) {
    	List<Integer> normal = new ArrayList<>(list);
		List<Integer> reversed = new ArrayList<>(list);
    	Collections.reverse(reversed);
		return reversed;
	}

	private static void printByPosition(List<Integer> list, int n, boolean bool) {
		log.info("Press 1 To Print The Even Positions Or 2 To Print The Odd Ones");
		boolean b = true;
		n = Integer.parseInt(scanner.nextLine());
		switch (n) {
		case 1:
			for (int i = 0; i < list.size(); i++) {
				if (b && i % 2 == 0) {
					log.info(list.get(i) + "");
				}
			}
			break;
		case 2:
			for (int i = 0; i < list.size(); i++) {
				if (!b && i % 2 != 0) {
					log.info(list.get(i) + "");
				}
			}
		case 0:
			break;
		default:
			log.info("Insert A Valid Number");
		}
	}
}
