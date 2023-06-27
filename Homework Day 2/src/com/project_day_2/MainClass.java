package com.project_day_2;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the dimensions for your first Rectangle");
		System.out.print("Enter the length of the first rectangle: ");
        int length = scanner.nextInt();
        System.out.print("Enter the width of the first rectangle: ");
        int width = scanner.nextInt();
        
        System.out.println("Enter the dimensions for your second Rectangle");
        System.out.print("Enter the length of the first rectangle: ");
        int length2 = scanner.nextInt();
        System.out.print("Enter the width of the first rectangle: ");
        int width2 = scanner.nextInt();
        
        Rectangle rectangle = new Rectangle(length, width);
        Rectangle rectangle2 = new Rectangle(length2, width2);
        
        printRectangle(rectangle);
        
        getAll(rectangle, rectangle2);
        
        scanner.close();
	}
	
	public static void printRectangle (Rectangle r) {
		r.getPerimeter();
		r.getArea();
	}
	
	public static void getAll (Rectangle r, Rectangle r2) {
		int p = r.getPerimeter();
		int a =r.getArea();
		int p2 = r2.getPerimeter();
		int a2 = r2.getArea();
		
		int sumP = p + p2;
		int sumA = a + a2;
		
		System.out.println("The Perimeter of the first rectangle: " + p);
		System.out.println("The Area of the first rectangle: " + a);
		System.out.println("The Perimeter of the second rectangle is: " + p2);
		System.out.println("The Area of the second rectangle is: " + a2);
		System.out.println("The sum of the perimeters is: " + sumP);
		System.out.println("The sum of the areas is: " + sumA);
	}
}
