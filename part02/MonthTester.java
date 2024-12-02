package part02;

import part01.Month;

public class MonthTester extends Tester {
	
	public MonthTester() {
		return;
	}
	
	/**
	 * Execute tests.
	 */
	public void executeTests() {
		String output = null;
		
		// M1
		try {
			output = Month.get(5).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"M1",
				"Get month from index.", 
				"June",
				output
			);
		
		// M2
		try {
			output = Month.get(-1).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"M2",
				"Fail to get month from index less than zero.", 
				"Invalid value for index: -1",
				output
			);
		
		// M3
		try {
			output = Month.get(0).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"M3",
				"Get month from index zero.", 
				"January",
				output
			);
		
		// M4
		try {
			output = Month.get(12).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"M4",
				"Fail to get month from index greater than max index (11).", 
				"Invalid value for index: 12",
				output
			);
		
		// M5
		try {
			output = Month.get(11).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"M5",
				"Get month from max index (11).", 
				"December",
				output
			);
	}
}
