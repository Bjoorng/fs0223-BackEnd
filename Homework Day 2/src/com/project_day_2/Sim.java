package com.project_day_2;
import java.util.ArrayList;
import java.util.List;

public class Sim {
	public int nTel;
	public double credit;
	public List<Calls> register;
	
	public Sim(int nTel, double credit) {
		this.nTel = nTel;
		this.credit = credit;
		this.register = new ArrList<>();
	}
	public int getNumber() {
		return nTel
	}
	public double getCredit() {
		return credit;
	}
	public List<Calls> getRegister(){
		return register;
	}
}
