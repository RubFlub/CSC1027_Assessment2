package part01;

import java.util.Scanner;

public class QUBMuseum {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// Initialise the data.
		initialiseAnnualSchedule();
		initialiseExhibits();
		
		// Set up the main menu.
		Menu mainMenu = new Menu("QUB Museum", Resources.MAIN_OPTIONS);
		int choice = 0;
		boolean quit = false;
		while (!quit) {
			System.out.println();
			choice = mainMenu.getUserChoice();
			quit = processMainMenuChoice(choice);
		} 

		System.out.println("Goodbye!");
	}
	
	/**
	 * Processes a choice selection in the main menu.
	 * @param choice - the user's choice.
	 * @return true if the user chooses quit, false otherwise.
	 */
	private static boolean processMainMenuChoice(int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			ArtifactManager.manageArtifacts();
			break;
		case 2:
			ExhibitManager.manageExhibits();
			break;
		case 3:
			ScheduleManager.manageAnnualSchedule();
			break;
		case 4:
			quit = true;
		}
		return quit;
	}
	
	/**
	 * Initialises the monthly schedules within the annual schedule.
	 */
	private static void initialiseAnnualSchedule() {
		for (int i = 0; i < Resources.MAX_MONTHS; i++) {
			try {
				MonthSchedule schedule = new MonthSchedule();
				ScheduleManager.annualSchedule.add(schedule);
			} catch (Exception ex) {
				System.out.println("Could not create MonthSchedule instance.");
				System.out.println(ex);
			}
		}
	}
	
	/**
	 * Initialises the exhibits within the system, and adds the relevant default artifacts.
	 */
	private static void initialiseExhibits() {
		for (int i = 0; i < Resources.INITIAL_EXHIBIT_NAMES.length; i++) {
			Exhibit exhibit = null;
			try {
				// Get the data for the exhibit.
				String name = Resources.INITIAL_EXHIBIT_NAMES[i];
				
				// Create exhibit and add to ArrayList.
				exhibit = new Exhibit(name);
				ExhibitManager.addExhibit(exhibit);
				
				// Add exhibit to relevant schedule.
				int MAX_EXHIBITS = MonthSchedule.MAX_EXHIBITS;
				int schedule = i / MAX_EXHIBITS;
				int position = i % MAX_EXHIBITS;
				ScheduleManager.annualSchedule.get(schedule).setExhibit(position, exhibit);
			} catch (Exception ex) {
				System.out.println("Could not create Exhibit instance.");
				System.out.println(ex);
			}
			
			try {
				// Add relevant artifacts to the exhibit.
				int startIndex = i * 5;
				for (int j = startIndex; j < startIndex + 5; j++) {
					Artifact artifact = null;
					try {
						// Get the data for the artifact.
						Object[] artifactArray = Resources.INITIAL_ARTIFACTS[j];
						String name = artifactArray[0].toString();
						ArtifactType type = (ArtifactType)artifactArray[1];
						int engagementTime = (int)artifactArray[2];
						String sign = artifactArray[3].toString();
						
						// Create artifact and add to ArrayList.
						artifact = new Artifact(name, type, engagementTime, sign);
						ArtifactManager.addArtifact(artifact);
					} catch (Exception ex) {
						System.out.println("Could not create Artifact instance.");
						System.out.println(ex);
					}
					boolean addArtifact = exhibit.addArtifactToRoute(artifact);
					if (!addArtifact) {
						throw new Exception("Artifact value cannot be null.");
					}
				}
			} catch (Exception ex) {
				System.out.println("Could not add Artifact to Exhibit.");
				System.out.println(ex);
			}
		}
	}
	
	
}