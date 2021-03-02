package vitals;

import static vitals.BMSChecker.*;

public class BMS {
	private float tempUpperLimit = 45;
	private float tempLowerLimit = 0;
	private float socUpperLimit = 80;
	private float socLowerLimit = 20;
	private float chargeRateUpperLimit = 0.8f;
	
	public BMS(float tempUpperLimit, float tempLowerLimit, float socUpperLimit, float socLowerLimit,
			float chargeRateUpperLimit) {
		this.tempUpperLimit = tempUpperLimit;
		this.tempLowerLimit = tempLowerLimit;
		this.socUpperLimit = socUpperLimit;
		this.socLowerLimit = socLowerLimit;
		this.chargeRateUpperLimit = chargeRateUpperLimit;
	}
	
	public BMS() {}
	
	public float getTempUpperLimit() {
		return tempUpperLimit;
	}

	public float getTempLowerLimit() {
		return tempLowerLimit;
	}

	public float getSocUpperLimit() {
		return socUpperLimit;
	}

	public float getSocLowerLimit() {
		return socLowerLimit;
	}

	public float getChargeRateUpperLimit() {
		return chargeRateUpperLimit;
	}
	
	public boolean checkBattery(float temp, float soc, float chargeRate){
		return checkTemp(temp)
				.and(checkSOC(soc))
				.and(checkChargeRate(chargeRate))
				.apply(this);
	}
}