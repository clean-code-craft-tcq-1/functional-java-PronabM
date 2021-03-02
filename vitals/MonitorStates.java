package vitals;

public enum MonitorStates {
	TEMP_OUT_OF_RANGE("Temperature is out of range!"),
	SOC_OUT_OF_RANGE("State of Charge is out of range!"),
	CR_OUT_OF_RANGE("Charge Rate is out of range!");
	
	private String displayText;
	
	private MonitorStates(String displayText) {
		this.displayText = displayText;
	}
	
	public String toString() {
		return this.displayText;
	}
}
