package project_day_4.Classes;

import project_day_4.Enums.Department;
import project_day_4.Enums.Level;

public class Employee {
	
	private String id;
	static int baseIncome = 1000;
	private double income;
	public double hourlyExtra;
	private Level level;
	public Department dp;
	
	public Employee(String id, Department dp) {
		this.id = id;
		this.dp = dp;
		this.income = baseIncome;
		this.hourlyExtra = 30;
		this.level = Level.OPERAIO;
	}

	public Employee(String id, int baseIncome, double income, double hourlyExtra, Level level, Department dp) {
		this.id = id;
		Employee.baseIncome = baseIncome;
		this.income = income;
		this.hourlyExtra = hourlyExtra;
		this.level = level;
		this.dp = dp;
	}

	public double getHourlyExtra() {
		return hourlyExtra;
	}

	public void setHourlyExtra(double hourlyExtra) {
		this.hourlyExtra = hourlyExtra;
	}

	public Department getDp() {
		return dp;
	}

	public void setDp(Department dp) {
		this.dp = dp;
	}

	public String getId() {
		return id;
	}

	public int getBaseIncome() {
		return baseIncome;
	}

	public double getIncome() {
		return income;
	}

	public Level getLevel() {
		return level;
	}
	
	public void printData(Employee e) {
		System.out.println("This Employee's id is: " + e.id);
		System.out.println("This Employee's Income is: " + e.income);
		System.out.println("This Employee's Hourly Extra is: " + e.hourlyExtra);
		System.out.println("This Employee's Level is: " + e.level);
		System.out.println("This Employee's Department is: " + e.dp);
	}
	
	public void promote(Employee e) {
		switch (e.level){
			case OPERAIO:
				e.level = Level.IMPIEGATO;
				e.income = baseIncome*1.2;
				System.out.println("The Employee Has Been Promoted To: " + e.level + " " + "His Income Now Is: " + e.income);
				break;
			case IMPIEGATO:
				e.level = Level.QUADRO;
				e.income = baseIncome*1.5;
				System.out.println("The Employee Has Been Promoted To: " + e.level + " " +  "His Income Now Is: " + e.income);
				break;
			case QUADRO:
				e.level = Level.DIRIGENTE;
				e.income = baseIncome*2;
				System.out.println("The Employee Has Been Promoted To: " + e.level + " " +  "His Income Now Is: " + e.income);
				break;
			default:
				System.out.println("The Employee Can't Be Promoted");
		}
	}
	
	public static double pay(Employee e) {
		return e.income;
	}
	
	public static double payExtra(Employee e, int n) {
		return e.income + (e.hourlyExtra*n);
	}
}

