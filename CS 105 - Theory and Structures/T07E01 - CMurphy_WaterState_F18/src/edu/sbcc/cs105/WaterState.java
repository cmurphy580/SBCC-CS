package edu.sbcc.cs105;

public class WaterState {
	private double waterTemperature;
	private boolean isCelcius;
	
	public WaterState(String temperature) {
		if (temperature != null) {
			String tempNumber = temperature.substring(0,  temperature.length()-1);
			waterTemperature = Double.parseDouble(tempNumber);
			if (temperature.charAt(temperature.length()-1) == 'C') {
				isCelcius = true; 
			} else {
				isCelcius = false;
			}
		}
	}
	public MatterState getState() {
		if (isCelcius == true && waterTemperature < 1 || isCelcius == false && waterTemperature < 32) {
			return MatterState.SOLID;
		} else if (isCelcius == true && waterTemperature > 99 || isCelcius == false && waterTemperature > 212) {
			return MatterState.GAS;
		} else {
			return MatterState.LIQUID;
		}
	}
}
