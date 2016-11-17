package me.shaobin.bean;

public class Cricle {
	
	private double r;
	private double s;

	public Cricle(double r) {
		this.r = r;
		this.s = Math.PI * r * r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getS() {
		return s;
	}

}
