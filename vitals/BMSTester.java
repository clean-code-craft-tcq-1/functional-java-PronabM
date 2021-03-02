package vitals;

import java.util.Random;

public class BMSTester {
	
	private BMS bms;
	private float maxTemp;
	private float minTemp;
	private float maxSoc;
	private float minSoc;
	private float maxCR;
	private Random random = new Random();
	
	public BMSTester(BMS bms) {
		this.bms = bms;
		this.maxTemp = bms.getTempUpperLimit();
		this.minTemp = bms.getTempLowerLimit();
		this.maxSoc  = bms.getSocUpperLimit();
		this.minSoc  = bms.getSocLowerLimit();
		this.maxCR   = bms.getChargeRateUpperLimit();
	}

	public void tempAboveLimit_Failure() {
		assert(bms.checkBattery(maxTemp + 1, maxSoc, maxCR)==false);
	}
	
	public void tempBelowLimit_Failure() {
		assert(bms.checkBattery(minTemp - 1, maxSoc, maxCR)==false);
	}
	
	public void tempWithinLimit_Success() {
		float randomTempWithinRange = minTemp + random.nextFloat() * (maxTemp - minTemp);
		assert(bms.checkBattery(randomTempWithinRange, maxSoc, maxCR)==true);
	}
	
	public void socAboveLimit_Failure() {
		assert(bms.checkBattery(maxTemp, maxSoc + 1, maxCR)==false);
	}
	
	public void socBelowLimit_Failure() {
		assert(bms.checkBattery(maxTemp, minSoc - 1, maxCR)==false);
	}
	
	public void socWithinLimit_Success() {
		float randomSocWithinRange = minSoc + random.nextFloat() * (maxSoc - minSoc);
		assert(bms.checkBattery(maxTemp, randomSocWithinRange, maxCR)==true);
	}
	
	public void crAboveLimit_Failure() {
		assert(bms.checkBattery(maxTemp, maxSoc, maxCR + 1)==false);
	}
	
	public void crWithinLimit_Success() {
		float randomCRWithinRange = random.nextFloat() * (maxCR);
		assert(bms.checkBattery(maxTemp, maxSoc, randomCRWithinRange)==true);
	}
	
	public void allParamOutsideLimit_Failure() {
		assert(bms.checkBattery(maxTemp + 1, minSoc - 1, maxCR + 1)==false);
	}
}