package vitals;

public enum MonitorStates {
	TEMP("Temperature"),
	SOC("State of Charge"),
	CR("Charge Rate"),
	IS_ABOVE_ALLOWED_LIMIT(" is above allowed limit."),
	IS_BELOW_ALLOWED_LIMIT(" is below allowed limit");
	
	private String displayText;
	
	private MonitorStates(String displayText) {
		this.displayText = displayText;
	}
	
	public String toString() {
		return this.displayText;
	}
}
