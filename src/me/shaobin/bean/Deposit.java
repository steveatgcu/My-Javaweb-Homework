package me.shaobin.bean;

public class Deposit {

	public Deposit(int year, double capital,double rate) {
		super();
		this.year = year;
		this.capital = capital;
		this.rate = rate;
		interest = capital*year*rate;
	}

	private double interest;
	private int year;
	private double rate;
	private double capital;

	public double getInterest() {
		return interest;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
