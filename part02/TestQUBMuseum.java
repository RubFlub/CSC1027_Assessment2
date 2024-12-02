package part02;

public class TestQUBMuseum {

	public static void main(String[] args) {
		ArtifactTester artifactTester = new ArtifactTester();
		ExhibitTester exhibitTester = new ExhibitTester();
		MonthScheduleTester monthScheduleTester = new MonthScheduleTester();
		MonthTester monthTester = new MonthTester();
		ArtifactTypeTester artifactTypeTester = new ArtifactTypeTester();
		PageMenuTester pageMenuTester = new PageMenuTester();
		
		artifactTester.executeTests();
		exhibitTester.executeTests();
		monthScheduleTester.executeTests();
		monthTester.executeTests();
		artifactTypeTester.executeTests();
		pageMenuTester.executeTests();
	}

}
