package part02;

import part01.Artifact;
import part01.ArtifactType;

/**
 * Tests the Artifact class.
 */
public class ArtifactTester extends Tester {
	
	public ArtifactTester() {
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
		Artifact testArtifact = null;
		String output = null;
		
		// A1
		try {
			testArtifact = new Artifact("Test Artifact", ArtifactType.PAINTING, 5, "Test Sign");
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A1",
				"Successful construction with valid parameters.", 
				"Artifact [id=0, name=Test Artifact, type=Painting, engagementTime=5]",
				output
			);
		
		// A2
		try {
			testArtifact = new Artifact(null, ArtifactType.PAINTING, 5, "Test Sign");
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A2",
				"Failed construction with null name", 
				"Exhibit name cannot be null or empty.",
				output
			);
		
		// A3
		try {
			testArtifact = new Artifact("", ArtifactType.PAINTING, 5, "Test Sign");
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A3",
				"Failed construction with empty name", 
				"Exhibit name cannot be null or empty.",
				output
			);
		
		// A4
		try {
			testArtifact = new Artifact("Test Artifact", ArtifactType.PAINTING, 0, "Test Sign");
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A4",
				"Failed construction with engagement time equal to 0.", 
				"Engagement time must be greater than 0.",
				output
			);
		
		
		// A5
		try {
			testArtifact = new Artifact("Test Artifact", ArtifactType.PAINTING, -1, "Test Sign");
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A5",
				"Failed construction with engagement time less than 0", 
				"Engagement time must be greater than 0.",
				output
			);
		
		// A6
		try {
			testArtifact = new Artifact("Test Artifact", null, 5, "Test Sign");
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A6",
				"Failed construction with null artifactType", 
				"Artifact type cannot be null.",
				output
			);
		
		// A7
		try {
			testArtifact = new Artifact("Test Artifact", ArtifactType.PAINTING, 5, null);
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A7",
				"Failed construction with null sign", 
				"Sign text cannot be null or empty.",
				output
			);
		
		// A8
		try {
			testArtifact = new Artifact("Test Artifact", ArtifactType.PAINTING, 5, "");
			output = testArtifact.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"A8",
				"Failed construction with empty sign", 
				"Sign text cannot be null or empty.",
				output
			);
	}
	
	/**
	 * Tests the getters.
	 */
	private void getterTests() {
		Artifact testArtifact = null;
		try {
			testArtifact = new Artifact("Test Artifact", ArtifactType.PAINTING, 5, "Test Sign");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		// A9
		printFormattedTest(
				"A9",
				"Get ID from method.", 
				"1",
				Integer.toString(testArtifact.getId())
			);
		
		// A10
		printFormattedTest(
				"A10",
				"Get name from method.", 
				"Test Artifact",
				testArtifact.getName()
			);
		
		// A11
		printFormattedTest(
				"A11",
				"Get type from method.", 
				"Painting",
				testArtifact.getType().toString()
			);
		
		// A12
		printFormattedTest(
				"A12",
				"Get engagement time from method.", 
				"5",
				Integer.toString(testArtifact.getEngagementTime())
			);
		
		// A13
		printFormattedTest(
				"A13",
				"Get sign from method.", 
				"Test Sign",
				testArtifact.getSign()
			);
	}
	
	/**
	 * Tests the setters.
	 */
	private void setterTests() {
		Artifact testArtifact = null;
		try {
			testArtifact = new Artifact("Test Artifact", ArtifactType.PAINTING, 5, "Test Sign");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		// A14
		printFormattedTest(
				"A14",
				"Successful set of name.", 
				"true abc123",
				testArtifact.setName("abc123") + " " + testArtifact.getName()
			);
		
		// A15
		printFormattedTest(
				"A15",
				"Failed set of null name.", 
				"false abc123",
				testArtifact.setName(null) + " " + testArtifact.getName()
			);
		
		// A16
		printFormattedTest(
				"A16",
				"Failed set of empty name.", 
				"false abc123",
				testArtifact.setName("") + " " + testArtifact.getName()
			);
		
		// A17
		printFormattedTest(
				"A17",
				"Successful set of type.", 
				"true Fossil",
				testArtifact.setType(ArtifactType.FOSSIL) + " " + testArtifact.getType().toString()
			);
		
		// A18
		printFormattedTest(
				"A18",
				"Failed set of null type.", 
				"false Fossil",
				testArtifact.setType(null) + " " + testArtifact.getType().toString()
			);
		
		// A19
		printFormattedTest(
				"A19",
				"Successful set of engagement time.", 
				"true 10",
				testArtifact.setEngagementTime(10) + " " + Integer.toString(testArtifact.getEngagementTime())
			);
		
		// A20
		printFormattedTest(
				"A20",
				"Failed set of engagement time equal to zero.", 
				"false 10",
				testArtifact.setEngagementTime(0) + " " + Integer.toString(testArtifact.getEngagementTime())
			);
		
		// A21
		printFormattedTest(
				"A21",
				"Failed set of engagement time less than zero.", 
				"false 10",
				testArtifact.setEngagementTime(-1) + " " + Integer.toString(testArtifact.getEngagementTime())
			);
		
		// A22
		printFormattedTest(
				"A22",
				"Successful set of sign.", 
				"true abc123",
				testArtifact.setSign("abc123") + " " + testArtifact.getSign()
			);
		
		// A23
		printFormattedTest(
				"A23",
				"Failed set of null sign.", 
				"false abc123",
				testArtifact.setSign(null) + " " + testArtifact.getSign()
			);
		
		// A24
		printFormattedTest(
				"A24",
				"Failed set of empty sign.", 
				"false abc123",
				testArtifact.setSign("") + " " + testArtifact.getSign()
			);
	}
}
