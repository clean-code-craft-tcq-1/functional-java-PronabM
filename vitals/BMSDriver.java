package vitals;

public class BMSDriver {
	public static void main(String[] args) {
		BMSTester tester = new BMSTester(new BMS());
		tester.tempAboveLimit_Failure();
		tester.tempBelowLimit_Failure();
		tester.tempWithinLimit_Success();
		tester.socAboveLimit_Failure();
		tester.socBelowLimit_Failure();
		tester.socWithinLimit_Success();
		tester.crAboveLimit_Failure();
		tester.crWithinLimit_Success();
    }
}
