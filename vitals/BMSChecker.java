package vitals;

import java.util.function.Function;
import static vitals.MonitorStates.*;

public interface BMSChecker extends Function<BMS, Boolean> {
	
	static BMSChecker checkTemp(float temp) {
		return bms -> checkInRange(TEMP,temp, bms.getTempLowerLimit(), bms.getTempUpperLimit());
	}
	
	static BMSChecker checkSOC(float soc) {
		return bms -> checkInRange(SOC,soc, bms.getSocLowerLimit(), bms.getSocUpperLimit());
	}
	
	static BMSChecker checkChargeRate(float cr) {
		return bms -> checkInRange(CR,cr, cr, bms.getChargeRateUpperLimit());
	}
	
	static void printFailure(String text) {
		System.out.println(text);
	}
	
	static Boolean checkInRange(MonitorStates state, float value,float low, float high) {
		if(value<low) {
			printFailure(state.toString() + IS_BELOW_ALLOWED_LIMIT.toString());
			return false;
		}
		if(value>high) {
			printFailure(state.toString() + IS_ABOVE_ALLOWED_LIMIT.toString());
			return false;
		}
		return true;
	}
	
	default BMSChecker and (BMSChecker other) {
		return bms -> this.apply(bms) && other.apply(bms);
	}
}