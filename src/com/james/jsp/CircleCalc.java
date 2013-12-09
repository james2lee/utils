package com.james.jsp;

public class CircleCalc {

	private double r = 0;
	private String unit = "";
	
	public CircleCalc() {}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getArea(){
		return r*r*3.14+"平方"+unit;
	}

}
