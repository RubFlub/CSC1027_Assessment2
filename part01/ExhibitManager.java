package part01;

import java.util.ArrayList;

/**
 * Manages the exhibits within the system.
 */
public class ExhibitManager extends Manager {
	/**
	 * The maximum amount of exhibits that can exist within the system.
	 */
	private static final int TOTAL_EXHIBITS = Resources.MAX_MONTHS * MonthSchedule.MAX_EXHIBITS;
	
	/**
	 * ArrayList to hold the exhibits within the system.
	 */
	private static ArrayList<Exhibit> exhibitList = new ArrayList<Exhibit>(TOTAL_EXHIBITS);
	
	/**
	 * Allows the user to manage exhibits within the system.
	 */
	public static void manageExhibits() {
		System.out.println();
		Menu exhibitMenu = new Menu("Exhibits", Resources.EXHIBIT_OPTIONS);
		int choice = 0;
		boolean back = false;
		while (!back) {
			System.out.println();
			choice = exhibitMenu.getUserChoice();
			back = processExhibitMenuChoice(choice);
		}
	}
	
	/**
	 * Gets the exhibit list.
	 * @return the exhibit list.
	 */
	public static ArrayList<Exhibit> getExhibitList() {
		return exhibitList;
	}
	
	
	/**
	 * Allows the user to view a set of exhibits.
	 * @param exhibits - exhibits to be shown.
	 */
	private static void viewExhibits(ArrayList<Exhibit> exhibits) {
		try {
			int choice = 0;
			boolean back = false;
			while (!back) {
				// Format each exhibit.
				String[] options = new String[exhibits.size()];
				for (int i = 0; i < exhibits.size(); i++) {
					Exhibit exhibit = exhibits.get(i);
					options[i] = exhibit.getName() + " (" + exhibit.getTotalEngagementTime() + " mins)";
				}
				
				// Generate the menu.
				// This is done within the loop so that it will update should
				// an exhibit be deleted.
				PageMenu menu = new PageMenu("Exhibits", options, 10);
				
				System.out.println();
				choice = menu.getUserChoice();
				back = processPageMenuChoice(choice);
				
				// If an exhibit is selected, load it.
				if (!back) {
					Exhibit chosenExhibit = exhibits.get(choice - 1);
					selectExhibit(chosenExhibit);
				}
			}
		} catch (Exception ex) {
			System.out.println("Could not view exhibits.");
			System.out.println(ex);
		}
		return;
	}
	
	/**
	 * Allows the user to search for exhibits based on criteria.
	 */
	private static void searchExhibits() {
		System.out.println();
		Menu menu = new Menu("Search Exhibits", Resources.EXHIBIT_SEARCH_OPTIONS);
		int choice = 0;
		boolean quit = false;
		while (!quit) {
			choice = menu.getUserChoice();
			System.out.println();
			quit = processSearchExhibitsMenuChoice(choice);
		} 
	}
	
	/**
	 * Allows the user to find a specific exhibit by ID.
	 */
	private static void viewExhibitByID() {
		int id = getIntegerInput("ID", 0);
		
		// Use a linear search to find the exhibit.
		Exhibit searchedExhibit = null;
		for (int i = 0; i < exhibitList.size(); i++) {
			Exhibit exhibit = exhibitList.get(i);
			if (exhibit.getId() == id) {
				searchedExhibit = exhibit;
				break;
			}
		}
		
		// If the exhibit cannot be found, respond accordingly.
		if (searchedExhibit == null) {
			System.out.println("Could not find an exhibit with that ID.");
			return;
		}
		
		selectExhibit(searchedExhibit);
	}
	
	/**
	 * Allows the user to find exhibits by name.
	 */
	private static void viewExhibitByName() {
		System.out.print("Enter name (may be partial): ");
		String name = input.nextLine();
		
		// Get all exhibits that match the input.
		ArrayList<Exhibit> validExhibits = new ArrayList<Exhibit>();
		for (Exhibit exhibit : exhibitList) {
			if (exhibit.getName().toLowerCase().contains(name.toLowerCase())) {
				validExhibits.add(exhibit);
			}
		}
		
		// If there are none, return.
		if (validExhibits.size() == 0) {
			System.out.println("No exhibit could be found containing that phrase.");
			return;
		}

		viewExhibits(validExhibits);
	}
	
	/**
	 * Selects an exhibit.
	 * @param exhibit - exhibit to be shown.
	 */
	private static void selectExhibit(Exhibit exhibit) {
		Menu menu = new Menu("Options", Resources.SELECTED_EXHIBIT_OPTIONS);
		int choice = 0;
		boolean quit = false;
		while (!quit) {
			System.out.println();
			System.out.println(exhibit.getName());
			System.out.println("ID: \t\t" + exhibit.getId());
			System.out.println("Engage Time: \t" + exhibit.getTotalEngagementTime() + " minutes");
			System.out.println();
			choice = menu.getUserChoice();
			quit = processSelectedExhibitChoice(choice, exhibit);
		} 
	}
	
	/**
	 * Creates a new exhibit in the system.
	 */
	private static void createNewExhibit() {
		// Is there room for any more exhibits?
		if (exhibitList.size() >= TOTAL_EXHIBITS) {
			System.out.println();
			System.out.println("The maximum amount of exhibits has been reached. (" + TOTAL_EXHIBITS + ")");
			System.out.println("Delete an exhibit to add another.");
			return;
		}
		
		System.out.println();
		System.out.println("Exhibit Name");
		System.out.println("+++++++++++++");
		String name = getStringInput("new exhibit's name");
		
		Exhibit exhibit = null;
		try {
			exhibit = new Exhibit(name);
		} catch (Exception ex) {
			System.out.println("Could not create Exhibit instance.");
			System.out.println(ex);
			return;
		}
		
		addExhibit(exhibit);
		
		System.out.println();
		System.out.println("New exhibit added!");
		
		return;
	}
	
	/**
	 * Allows a user to edit an exhibit's name.
	 * @param exhibit - exhibit to edit
	 */
	private static void editExhibitName(Exhibit exhibit) {
		String name = getStringInput("name");
		
		exhibit.setName(name);
		System.out.println("The exhibit's name has been updated.");
		
		// Update the position of the exhibit.
		exhibitList.remove(exhibit);
		addExhibit(exhibit);
	}
	
	/**
	 * Allows a user to edit the route.
	 * @param exhibit - the exhibit to be modified.
	 */
	private static void modifyRoute(Exhibit exhibit) {
		int choice = 0;
		boolean back = false;
		while (!back) {
			// Format each exhibit.
			System.out.println();
			ArrayList<Artifact> route = exhibit.getRoute();
			
			// Are there any artifacts in the route?
			if (route.size() == 0) {
				System.out.println("There are no artifacts in the route.");
				System.out.println();
			}
			
			for (int i = 0; i < route.size(); i++) {
				Artifact artifact = route.get(i);
				System.out.println(
						(i+1) + ". " + artifact.getName() + " (" + artifact.getEngagementTime() + " mins)"
					);
				System.out.println(artifact.getSign());
				System.out.println();
			}
			
			Menu menu = new Menu("Options", Resources.MODIFY_ROUTE_OPTIONS);
			
			choice = menu.getUserChoice();
			back = processRouteMenuChoice(choice, exhibit);
		}
	}
	
	/**
	 * Allows the user to select an artifact to add to a route.
	 * @param exhibit - the exhibit with the route being modified.
	 */
	private static void selectArtifactForRoute(Exhibit exhibit) {
		ArrayList<Artifact> validArtifacts = getValidArtifacts();
		
		// Are there any valid artifacts?
		if (validArtifacts.size() == 0) {
			// Allow to user to add a new artifact if they wish.
			System.out.println();
			System.out.println("There are no artifacts not assigned a route.");
			System.out.println("To add an artifact, create a new one, or unassign one from a route.");
			
			Menu menu = new Menu("Would you like to create one?", Resources.CONFIRM_OPTIONS);
			int choice = menu.getUserChoice();
			if (choice == 2) {
				return;
			}
			
			Artifact newArtifact = ArtifactManager.createNewArtifact();
			exhibit.addArtifactToRoute(newArtifact);
			return;
		}
		
		// Format the ArrayList as a String array.
		String[] options = new String[validArtifacts.size()];
		for (int i = 0; i < validArtifacts.size(); i++) {
			Artifact artifact = validArtifacts.get(i);
			options[i] = artifact.getName() + " (" + artifact.getEngagementTime() + " mins)";
		}
		
		try {
			// Select what artifact they want.
			PageMenu menu = new PageMenu("Artifacts", options, 10);
			
			System.out.println();
			int choice = menu.getUserChoice();
			boolean back = processPageMenuChoice(choice);
			
			if (back) {
				return;
			}
			
			// Add it to the route.
			Artifact selectedArtifact = validArtifacts.get(choice - 1);
			exhibit.addArtifactToRoute(selectedArtifact);
			
			System.out.println();
			System.out.println("Added artifact to route!");
			return;
		} catch (Exception ex) {
			System.out.println("Could not get artifacts.");
			System.out.println(ex);
		}
	}
	
	/**
	 * Allows the user to modify an artifact in a route.
	 * @param exhibit - the exhibit with the route being modified.
	 */
	private static void modifyArtifactInRoute(Exhibit exhibit) {
		ArrayList<Artifact> route = exhibit.getRoute();
		
		// Are there any artifacts to modify?
		if (route.size() == 0) {
			System.out.println();
			System.out.println("There are no artifacts to modify in the route.");
			return;
		}
		
		// Format each artifact in route.
		String[] options = new String[route.size()];
		for (int i = 0; i < route.size(); i++) {
			Artifact artifact = route.get(i);
			options[i] = artifact.getName() + " (" + artifact.getEngagementTime() + " mins)";
		}
		
		try {
			// Select what artifact they want.
			PageMenu menu = new PageMenu("Route", options, 10);
			
			System.out.println();
			int choice = menu.getUserChoice();
			boolean back = processPageMenuChoice(choice);
			
			if (back) {
				return;
			}
			
			// Select artifact.
			Artifact selectedArtifact = route.get(choice - 1);
			selectRouteArtifact(exhibit, selectedArtifact);
			
			return;
		} catch (Exception ex) {
			System.out.println("Could not modify route.");
			System.out.println(ex);
		}
	}
	
	/**
	 * Selects an artifact within a route.
	 * @param exhibit - the exhibit it is within.
	 * @param artifact - the artifact selected.
	 */
	private static void selectRouteArtifact(Exhibit exhibit, Artifact artifact) {
		Menu menu = new Menu("Options", Resources.SELECTED_ROUTE_ARTIFACT_OPTIONS);
		int choice = 0;
		boolean quit = false;
		while (!quit) {
			System.out.println();
			System.out.println(artifact.getName());
			System.out.println("ID: \t\t" + artifact.getId());
			System.out.println("Engage Time: \t" + artifact.getEngagementTime() + " minutes");
			System.out.println("Type: \t\t" + artifact.getType().toString());
			System.out.println("Sign: \t\t" + artifact.getSign());
			System.out.println();
			choice = menu.getUserChoice();
			quit = processSelectedRouteArtifactChoice(choice, exhibit, artifact);
		} 
	}
	
	/**
	 * Returns an ArrayList of all artifacts not assigned to an exhibit.
	 * @return ArrayList of valid artifacts.
	 */
	private static ArrayList<Artifact> getValidArtifacts() {
		// Initialise the list of valid artifacts as the list of all artifacts.
		ArrayList<Artifact> artifactList = ArtifactManager.getArtifactList();
		ArrayList<Artifact> validArtifacts = new ArrayList<Artifact>(artifactList);
		
		// Remove each artifact assigned to an exhibit from the list.
		for (Exhibit exhibit : exhibitList) {
			for (Artifact artifact : exhibit.getRoute()) {
				validArtifacts.remove(artifact);
			}
		}
		
		return validArtifacts;
	}
	
	/**
	 * Changes the position of an artifact in the route.
	 * @param exhibit - the exhibit being modified.
	 * @param artifact - the artifact being modified.
	 */
	private static void changePositionOfArtifact(Exhibit exhibit, Artifact artifact) {
		ArrayList<Artifact> route = exhibit.getRoute();
		
		// Can the position actually be moved?
		if (route.size() == 1) {
			System.out.println();
			System.out.println("The position cannot be changed as there is only one artifact in the route.");
			return;
		}
		
		int newPosition = getIntegerInput("new position", 1, route.size());
		route.remove(artifact);
		route.add(newPosition - 1, artifact);
		
		System.out.println("Position changed!");
	}
	
	private static void unassignArtifact(Exhibit exhibit, Artifact artifact) {
		ArrayList<Artifact> route = exhibit.getRoute();
		
		route.remove(artifact);
		System.out.println();
		System.out.println("Artifact unassigned!");
	}
	
	/**
	 * Adds an exhibit to the system.
	 * @param exhibit - exhibit to add
	 */
	public static void addExhibit(Exhibit exhibit) {
		int insertionIndex = findInsertionIndex(exhibit);
		exhibitList.add(insertionIndex, exhibit);
	}
	
	/**
	 * Uses binary search algorithm to find the insertion index of an exhibit.
	 * @param exhibit - the exhibit to be inserted
	 * @returns the insertion index
	 */
	private static int findInsertionIndex(Exhibit exhibit) {
		int low = 0;
		int high = exhibitList.size() - 1;
		String item = exhibit.getName();
		
		// Use a binary search to find the insertion index.
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (exhibitList.get(mid).getName().equals(item)) {
                return mid;
            } else if (exhibitList.get(mid).getName().compareToIgnoreCase(item) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
		}
		
		return low;
	}
	
	/**
	 * Processes a choice selection in the exhibit menu.
	 * @param choice - the user's choice.
	 * @return true if the user chooses quit, false otherwise.
	 */
	private static boolean processExhibitMenuChoice(int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			viewExhibits(exhibitList);
			break;
		case 2:
			searchExhibits();
			break;
		case 3:
			createNewExhibit();
			break;
		case 4:
			quit = true;
			
		}
		return quit;
	}
	
	/**
	 * Processes a choice selection in the search exhibit menu.
	 * @param choice - the user's choice
	 * @return true if the user chooses quit, false otherwise.
	 */
	private static boolean processSearchExhibitsMenuChoice(int choice) {
		switch (choice) {
		case 1:
			viewExhibitByID();
			break;
		case 2:
			viewExhibitByName();
			break;
		case 3:
			return true;
		}
		
		return false;
	}
	
	/**
	 * Processes a choice selection in the selected exhibit menu.
	 * @param choice - the user's choice
	 * @param exhibit - the exhibit selected
	 * @return true if the user chooses quit, false otherwise.
	 */
	private static boolean processSelectedExhibitChoice(int choice, Exhibit exhibit) {
		boolean quit = false;
		switch (choice) {
		case 1:
			editExhibitName(exhibit);
			break;
		case 2:
			modifyRoute(exhibit);
			break;
		case 3:
			quit = confirmExhibitDeletion(exhibit);
			break;
		case 4:
			quit = true;
		}
		
		return quit;
	}
	
	/**
	 * Processes a choice selection for the route menu.
	 * @param choice - the choice selected
	 * @param exhibit - the exhibit being modified
	 * @return true if the user quits, false otherwise.
	 */
	private static boolean processRouteMenuChoice(int choice, Exhibit exhibit) {
		boolean quit = false;
		switch (choice) {
		case 1:
			selectArtifactForRoute(exhibit);
			break;
		case 2:
			modifyArtifactInRoute(exhibit);
			break;
		case 3:
			quit = true;
			break;
		}
		
		return quit;
	}
	
	/**
	 * Processes a choice selection for the route artifact menu.
	 * @param choice - the choice selected
	 * @param exhibit - the exhibit being modified
	 * @param artifact - the artifact being modified
	 * @return true if the user quits, false otherwise.
	 */
	private static boolean processSelectedRouteArtifactChoice(int choice, Exhibit exhibit, Artifact artifact) {
		boolean quit = false;
		switch (choice) {
		case 1:
			ArtifactManager.editArtifact(artifact);
			break;
		case 2:
			changePositionOfArtifact(exhibit, artifact);
			break;
		case 3:
			unassignArtifact(exhibit, artifact);
			quit = true;
			break;
		case 4:
			quit = true;
			break;
		}
		
		return quit;
	}

	/**
	 * Confirms the deletion of an exhibit.
	 * @param exhibit - exhibit to be deleted.
	 * @returns true if the exhibit was deleted, false otherwise.
	 */
	private static boolean confirmExhibitDeletion(Exhibit exhibit) {
		System.out.println();
		Menu menu = new Menu("Confirm?", Resources.CONFIRM_OPTIONS);
		int choice = menu.getUserChoice();
		if (choice == 1) {
			exhibitList.remove(exhibit);
			
			// Remove the exhibit from any schedule too.
			for (MonthSchedule schedule : ScheduleManager.getAnnualSchedule()) {
				Exhibit[] exhibits = schedule.getExhibits();
				for (int i = 0; i < exhibits.length; i++) {
					if (exhibits[i] == exhibit) {
						exhibits[i] = null;
						return true;
					}
				}
			}
			return true;
		}
		return false;
	}
}
