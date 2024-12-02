package part02;

import part01.ArtifactType;

public class ArtifactTypeTester extends Tester {
	
	public ArtifactTypeTester() {
		return;
	}
	
	/**
	 * Execute tests.
	 */
	public void executeTests() {
		String output = null;
		
		// AT1
		try {
			output = ArtifactType.get(6).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"AT1",
				"Get ArtifactType from index.", 
				"Fossil",
				output
			);
		
		// AT2
		try {
			output = ArtifactType.get(-1).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"AT2",
				"Fail to get ArtifactType from index less than zero.", 
				"Invalid value for index: -1",
				output
			);
		
		// AT3
		try {
			output = ArtifactType.get(0).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"AT3",
				"Get ArtifactType from index zero.", 
				"Painting",
				output
			);
		
		// AT4
		try {
			output = ArtifactType.get(12).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"AT4",
				"Fail to get ArtifactType from index greater than max index (11).", 
				"Invalid value for index: 12",
				output
			);
		
		// AT5
		try {
			output = ArtifactType.get(11).toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"AT5",
				"Get ArtifactType from max index (11).", 
				"Other",
				output
			);
	}
}
