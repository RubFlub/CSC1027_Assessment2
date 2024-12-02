package part02;

public abstract class Tester {
	/**
	 * Prints a formatted test case.
	 * @param testCase - the test case ID.
	 * @param description - description of the test case.
	 * @param expOutput - expected output.
	 * @param actOutput - actual output.
	 */
	protected void printFormattedTest(String testCase, String description, String expOutput, String actOutput) {
		System.out.println();
		System.out.println("===== Test Case " + testCase + " =====");
		System.out.println(description);
		System.out.println("Expected Output: " + expOutput);
		System.out.println("Actual Output: " + actOutput);
		System.out.println("Passed: " + expOutput.equals(actOutput));
	}
}
