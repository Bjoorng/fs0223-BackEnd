package project_day_3;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		isEven();
		isLeap();
		printNum();
		divide();
		countdown();
	}

	private static void isEven() {
		System.out.println("Check If The Number Of Characters Is Even Or Odd");
		String string = scan.nextLine();
		int sLength = string.length();
		if (sLength % 2 == 0) {
			System.out.println(string + " Has An Even Number Of Characters");
		} else {
			System.out.println(string + " Has An Odd Number Of Characters");
		}
	}

	private static void isLeap() {
		System.out.println("Check If The Year Is A Leap Year");
		int year = Integer.parseInt(scan.nextLine());
		if (year % 4 == 0) {
			System.out.println(year + " Is A Leap Year");
		} else if (year % 100 == 0 && year % 400 == 0) {
			System.out.println(year + " Is A Leap Year");
		} else {
			System.out.println(year + " Is Not A Leap Year");
		}
	}

	private static void printNum() {
		System.out.println("Choose The Number To Write Between 0 and 3");
		int print = Integer.parseInt(scan.nextLine());
		switch (print) {
		case 0:
			System.out.println("ZERO");
			break;
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		default:
			System.out.println("The Number Didn't Match Any Of The Cases Of The Switch");
		}
	}

	private static void divide() {
		System.out.println("Write A String To Split Or Type :q To Move On");
		String input;
		do {
			input = scan.nextLine();
			String array[] = input.split("");
			if (!input.equals(":q")) {
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i] + ",");
				}
				System.out.println();
			} else {
				System.out.println("The Cycle Has Ended");
			}
		} while (!input.equals(":q"));
	}

	private static void countdown() {
		System.out.println("Choose Where To Start The Count From");
		int count = Integer.parseInt(scan.nextLine());
		for (int i = count; i >= 0; i--) {
			System.out.println(i);
		}
	}
}
