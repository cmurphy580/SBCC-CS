package edu.sbcc.cs105;

import java.util.ArrayList;

public class TemperatureStats {
	private ArrayList <Double> data = new ArrayList <Double>();
	private double max;
	private double min;
	
	public TemperatureStats() {
		max = 0;
		min = 0;
	}
	public void addTemperature(double t) {
		data.add(t);
	}
	public void clearTemperatures() {
		data.clear(); 
	}
	public double getMaximumTemperature() {
		max = data.get(0);
		for (double value : data) {
			if (value > max) {
				max = value; 
			}
		}
		return max; 
	}
	public double getMinimumTemperature() {
		min = data.get(0);
		for (double value : data) {
			if (value < min) {
				min = value; 
			}
		}
		return min; 
	}
	public double getAverageTemperature() {
		double sum = 0.0;
		for (int i = 0; i < data.size(); i++) {
			sum += data.get(i);
		}
		return sum / data.size();
	}

}
