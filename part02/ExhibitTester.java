package part02;

import part01.Artifact;
import part01.ArtifactType;
import part01.Exhibit;

public class ExhibitTester extends Tester {
	
	public ExhibitTester() {
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
		Exhibit testExhibit = null;
		String output = null;
		
		// E1
		try {
			testExhibit = new Exhibit("Test Exhibit");
			output = testExhibit.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"E1",
				"Successful construction with valid parameters.", 
				"Exhibit [id=0, name=Test Exhibit, route=[]]",
				output
			);
		
		// E2
		try {
			testExhibit = new Exhibit(null);
			output = testExhibit.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"E2",
				"Failed construction with null name", 
				"Exhibit name cannot be null or empty.",
				output
			);
		
		// E3
		try {
			testExhibit = new Exhibit("");
			output = testExhibit.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"E3",
				"Failed construction with empty name", 
				"Exhibit name cannot be null or empty.",
				output
			);
	}
	
	/**
	 * Tests the getters.
	 */
	private void getterTests() {
		Exhibit testExhibit = null;
		try {
			testExhibit = new Exhibit("Test Exhibit");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		// Add artifacts.
		Artifact testArtifact1 = null;
		Artifact testArtifact2 = null;
		
		try {
			testArtifact1 = new Artifact("Test Artifact 1", ArtifactType.PAINTING, 15, "Test Sign");
			testArtifact2 = new Artifact("Test Artifact 2", ArtifactType.FOSSIL, 5, "Test Sign");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		testExhibit.addArtifactToRoute(testArtifact1);
		testExhibit.addArtifactToRoute(testArtifact2);
		
		// E4
		printFormattedTest(
				"E4",
				"Get ID from method.", 
				"1",
				Integer.toString(testExhibit.getId())
			);
		
		// E5
		printFormattedTest(
				"E5",
				"Get name from method.", 
				"Test Exhibit",
				testExhibit.getName()
			);
		
		// E6
		printFormattedTest(
				"E6",
				"Get route from method.", 
				"[Artifact [id=3, name=Test Artifact 1, type=Painting, engagementTime=15], Artifact [id=4, name=Test Artifact 2, type=Fossil, engagementTime=5]]",
				testExhibit.getRoute().toString()
			);
		
		// E7
		printFormattedTest(
				"E7",
				"Get total engagement time from method.", 
				"20",
				Integer.toString(testExhibit.getTotalEngagementTime())
			);
	}
	
	/**
	 * Tests the setters.
	 */
	private void setterTests() {
		Exhibit testExhibit = null;
		try {
			testExhibit = new Exhibit("Test Exhibit");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		// Add artifacts.
		Artifact testArtifact1 = null;
		Artifact testArtifact2 = null;
		
		try {
			testArtifact1 = new Artifact("Test Artifact 1", ArtifactType.PAINTING, 15, "Test Sign");
			testArtifact2 = new Artifact("Test Artifact 2", ArtifactType.FOSSIL, 5, "Test Sign");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		testExhibit.addArtifactToRoute(testArtifact1);
		testExhibit.addArtifactToRoute(testArtifact2);
		
		// E8
		printFormattedTest(
				"E8",
				"Successful set of name.", 
				"true abc123",
				testExhibit.setName("abc123") + " " + testExhibit.getName()
			);
		
		// E9
		printFormattedTest(
				"E9",
				"Failed set of null name.", 
				"false abc123",
				testExhibit.setName(null) + " " + testExhibit.getName()
			);
		
		// E10
		printFormattedTest(
				"E10",
				"Failed set of empty name.", 
				"false abc123",
				testExhibit.setName("") + " " + testExhibit.getName()
			);
		
		// E11
		testExhibit.getRoute().remove(testArtifact1);
		testExhibit.getRoute().remove(testArtifact2);
		Artifact testArtifact3 = null;
		try {
			testArtifact3 = new Artifact("Test Artifact 1", ArtifactType.PAINTING, 15, "Test Sign");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		printFormattedTest(
				"E11",
				"Successful add of artifact to route.", 
				"true [Artifact [id=7, name=Test Artifact 1, type=Painting, engagementTime=15]]",
				testExhibit.addArtifactToRoute(testArtifact3) + " " + testExhibit.getRoute().toString()
			);
		
		// E12
		printFormattedTest(
				"E11",
				"Failed add of null artifact to route.", 
				"false [Artifact [id=7, name=Test Artifact 1, type=Painting, engagementTime=15]]",
				testExhibit.addArtifactToRoute(null) + " " + testExhibit.getRoute().toString()
			);
	}
}
