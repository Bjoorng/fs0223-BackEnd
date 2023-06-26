package it.epicode.be;

import java.util.Scanner;

public class Helloworld {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main (String[] args){
		System.out.println(multiply(2,55));
		System.out.println(concat("Vuole Ballare", "La Samba"));
		System.out.println(concatAge("Mario", 34));
		
		String[] array = new String[5];
        array[0] = "Come";
        array[1] = "Quando";
        array[2] = "Fuori";
        array[3] = "Piove";
        array[4] = "Sium";
        
        String newString = scan.nextLine();
        
        String[] bigArray = new String[array.length + 1];
        
        for (int i = 0; i < 3; i++) {
            bigArray[i] = array[i];
        }
        
        bigArray[3] = newString;
        
        for (int i = 3; i < array.length; i++) {
            bigArray[i + 1] = array[i];
        }
        
        for (String elemento : bigArray) {
            System.out.println(elemento);
        }
        
        String a = scan.nextLine();
        String b = scan.nextLine();
        String c = scan.nextLine();
        System.out.println(a + " " + b + " " + c);
        System.out.println(c + " " + b + " " + a);
        
        System.out.println(rectangle(12.5, 55.8));
        System.out.println(evensOdds(5));
        System.out.println(triangle());
	}
	
	private static int multiply (int x, int y){
		int result = x*y;
		return result;
	}
	
	private static String concat (String a, String b){
		String concatted = a + " " + b;
		return concatted;
	}
	
	private static String concatAge (String a, int b){
		String age = a + " " + b;
		return age;
	}

	private static double rectangle(double a, double b) {
		double result = (a+b)*2;
		return result;
	}
	
	private static int evensOdds (int a) {
		int result = a%2;
		return result;
	}
	
	private static double triangle () {
		System.out.println("First Side:");
		String sideA = scan.nextLine();
		Double sideADub = Double.parseDouble(sideA);
		System.out.println("Second Side:");
		String sideB = scan.nextLine();
		Double sideBDub = Double.parseDouble(sideB);
		System.out.println("Third Side:");
		String sideC = scan.nextLine();
		Double sideCDub = Double.parseDouble(sideC);
		
		double p = (sideADub+sideBDub+sideCDub)/2;
		
		double area = Math.sqrt(p * (p - sideADub) * (p - sideBDub) * (p - sideCDub));
		
		return area;
	}
}



