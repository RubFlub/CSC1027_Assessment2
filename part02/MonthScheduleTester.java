package part02;

import java.lang.reflect.Field;

import part01.Exhibit;
import part01.MonthSchedule;
import part01.Month;

public class MonthScheduleTester extends Tester {
	
	public MonthScheduleTester() {
		return;
	}
	
	/**
	 * Execute tests.
	 */
	public void executeTests() {
		constructorTests();
		getterTests();
		setterTests();
	}
	
	/**
	 * Tests the constructor.
	 */
	private void constructorTests() {
		MonthSchedule testMonthSchedule = null;
		String output = null;
		
		// MS1
		try {
			testMonthSchedule = new MonthSchedule(Month.JANUARY);
			output = testMonthSchedule.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"MS1",
				"Successful construction with valid parameters.", 
				"MonthSchedule [id=0, month=January, exhibits=null null null]",
				output
			);
		
		// MS2
		try {
			testMonthSchedule = new MonthSchedule();
			output = testMonthSchedule.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"MS2",
				"Successful construction with default constructor.", 
				"MonthSchedule [id=1, month=February, exhibits=null null null]",
				output
			);
		
		// MS3
		try {
			testMonthSchedule = new MonthSchedule(null);
			output = testMonthSchedule.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"MS3",
				"Failed construction with null month.", 
				"Month cannot be null.",
				output
			);
		
		// Create more months.
		for (int i = 0; i < 10; i++) {
			try {
				new MonthSchedule();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		
		// MS4
		try {
			testMonthSchedule = new MonthSchedule(Month.APRIL);
			output = testMonthSchedule.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"MS4",
				"Failed construction with id being greater or equal to 12.", 
				"There may be only 12 instances of MonthSchedule.",
				output
			);
		
		// Reset ID.
		try {
			Field field = MonthSchedule.class.getDeclaredField("nextId");
			field.setAccessible(true);
			field.set(null, 0);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	/**
	 * Tests the getters.
	 */
	private void getterTests() {
		MonthSchedule testMonthSchedule = null;
		try {
			testMonthSchedule = new MonthSchedule(Month.JANUARY);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		Exhibit testExhibit1 = null;
		Exhibit testExhibit2 = null;
		Exhibit testExhibit3 = null;
		
		try {
			testExhibit1 = new Exhibit("Test Exhibit 1");
			testExhibit2 = new Exhibit("Test Exhibit 2");
			testExhibit3 = new Exhibit("Test Exhibit 3");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		testMonthSchedule.setExhibit(0, testExhibit1);
		testMonthSchedule.setExhibit(1, testExhibit2);
		testMonthSchedule.setExhibit(2, testExhibit3);
		
		// MS5
		printFormattedTest(
				"MS5",
				"Get ID from method.", 
				"0",
				Integer.toString(testMonthSchedule.getId())
			);
		
		// MS6
		printFormattedTest(
				"MS6",
				"Get month from method.", 
				"January",
				testMonthSchedule.getMonth().toString()
			);
		
		// MS7
		printFormattedTest(
				"MS7",
				"Get exhibits from method.",
				"Exhibit [id=3, name=Test Exhibit 1, route=[]] Exhibit [id=4, name=Test Exhibit 2, route=[]] Exhibit [id=5, name=Test Exhibit 3, route=[]]",
				exhibitsToString(testMonthSchedule.getExhibits())
			);
	}
	
	/**
	 * Tests the setters.
	 */
	private void setterTests() {
		MonthSchedule testSchedule = null;
		try {
			testSchedule = new MonthSchedule(Month.JANUARY);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		Exhibit testExhibit = null;
		try {
			testExhibit = new Exhibit("Test Exhibit");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		// MS8
		printFormattedTest(
				"MS8",
				"Successful set of month.", 
				"true January",
				testSchedule.setMonth(Month.JANUARY) + " " + testSchedule.getMonth().toString()
			);
		
		// MS9
		printFormattedTest(
				"MS9",
				"Failed set of null month.", 
				"false January",
				testSchedule.setMonth(null) + " " + testSchedule.getMonth().toString()
			);
		
		// MS10
		printFormattedTest(
				"MS10",
				"Successful set of exhibit.", 
				"true null Exhibit [id=6, name=Test Exhibit, route=[]] null",
				testSchedule.setExhibit(1, testExhibit) + " " + exhibitsToString(testSchedule.getExhibits())
			);
		
		testSchedule.setExhibit(1, null);
		
		// MS11
		printFormattedTest(
				"MS11",
				"Failed set of exhibit with position less than zero.", 
				"false null null null",
				testSchedule.setExhibit(-1, testExhibit) + " " + exhibitsToString(testSchedule.getExhibits())
			);
		
		// MS12
		printFormattedTest(
				"MS12",
				"Successful set of exhibit with position zero.", 
				"true Exhibit [id=6, name=Test Exhibit, route=[]] null null",
				testSchedule.setExhibit(0, testExhibit) + " " + exhibitsToString(testSchedule.getExhibits())
			);
		
		testSchedule.setExhibit(0, null);
		
		// MS13
		printFormattedTest(
				"MS13",
				"Failed set of exhibit with position greater than the max index (2).", 
				"false null null null",
				testSchedule.setExhibit(3, testExhibit) + " " + exhibitsToString(testSchedule.getExhibits())
			);
		
		// MS14
		printFormattedTest(
				"MS14",
				"Successful set of exhibit with position equal to the max index (2).", 
				"true null null Exhibit [id=6, name=Test Exhibit, route=[]]",
				testSchedule.setExhibit(2, testExhibit) + " " + exhibitsToString(testSchedule.getExhibits())
			);
	}
	
	private String exhibitsToString(Exhibit[] exhibits) {
		String str = "";
		for (int i = 0; i < exhibits.length; i++) {
			if (i != 0) {
				str += " ";
			}
			str += exhibits[i];
		}
		
		return str;
	}
}
