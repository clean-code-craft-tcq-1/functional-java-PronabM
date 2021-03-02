package vitals;

import java.util.function.Function;

public interface BMSChecker extends Function<BMS, Boolean> {
	
	static BMSChecker checkTemp(float temp) {
		return bms -> {
			if (checkInRange(temp, bms.getTempLowerLimit(), bms.getTempUpperLimit()))
				return true;
			printFailure(MonitorStates.TEMP_OUT_OF_RANGE.toString());
			return false;
		};
	}
	
	static BMSChecker checkSOC(float soc) {
		return bms -> {
			if (checkInRange(soc, bms.getSocLowerLimit(), bms.getSocUpperLimit()))
				return true;
			printFailure(MonitorStates.SOC_OUT_OF_RANGE.toString());
			return false;
		};
	}
	
	static BMSChecker checkChargeRate(float cr) {
		return bms -> {
			if (checkInRange(cr, cr, bms.getChargeRateUpperLimit()))
				return true;
			printFailure(MonitorStates.CR_OUT_OF_RANGE.toString());
			return false;
		};
	}
	
	static void printFailure(String text) {
		System.out.println(text);
	}
	
	static Boolean checkInRange(float value,float low, float high) {
		return !(low>value || value>high);
	}
	
	default BMSChecker and (BMSChecker other) {
		return bms -> this.apply(bms) ? other.apply(bms) : false;
	}
}