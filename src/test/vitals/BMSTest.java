package vitals;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class BMSTest {
	
	private BMS bms = new BMS();
	private float maxTemp = bms.getTempUpperLimit();
	private float minTemp = bms.getTempLowerLimit();
	private float maxSoc  = bms.getSocUpperLimit();
	private float minSoc  = bms.getSocLowerLimit();
	private float maxCR   = bms.getChargeRateUpperLimit();
	private Random random = new Random();

	@Test
	public void tempAboveLimit_Failure() {
		assert(bms.checkBattery(maxTemp + 1, maxSoc, maxCR)==false);
	}
	
	@Test
	public void tempBelowLimit_Failure() {
		assert(bms.checkBattery(minTemp - 1, maxSoc, maxCR)==false);
	}
	
	@Test
	public void tempWithinLimit_Success() {
		float randomTempWithinRange = minTemp + random.nextFloat() * (maxTemp - minTemp);
		assert(bms.checkBattery(randomTempWithinRange, maxSoc, maxCR)==true);
	}
	
	@Test
	public void socAboveLimit_Failure() {
		assert(bms.checkBattery(maxTemp, maxSoc + 1, maxCR)==false);
	}
	
	@Test
	public void socBelowLimit_Failure() {
		assert(bms.checkBattery(maxTemp, minSoc - 1, maxCR)==false);
	}
	
	@Test
	public void socWithinLimit_Success() {
		float randomSocWithinRange = minSoc + random.nextFloat() * (maxSoc - minSoc);
		assert(bms.checkBattery(maxTemp, randomSocWithinRange, maxCR)==true);
	}
	
	@Test
	public void crAboveLimit_Failure() {
		assert(bms.checkBattery(maxTemp, maxSoc, maxCR + 1)==false);
	}
	
	@Test
	public void crWithinLimit_Success() {
		float randomCRWithinRange = random.nextFloat() * (maxCR);
		assert(bms.checkBattery(maxTemp, maxSoc, randomCRWithinRange)==true);
	}
}
