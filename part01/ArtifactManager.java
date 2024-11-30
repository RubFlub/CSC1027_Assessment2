package part01;

import java.util.ArrayList;

/**
 * Manages the artifacts within the system.
 */
public class ArtifactManager extends Manager {
	/**
	 * ArrayList to hold the artifacts within the system.
	 */
	private static ArrayList<Artifact> artifactList = new ArrayList<Artifact>();
	
	/**
	 * Allows the user to manage artifacts within the system.
	 */
	public static void manageArtifacts() {
		System.out.println();
		Menu artifactMenu = new Menu("Artifacts", Resources.ARTIFACT_OPTIONS);
		int choice = 0;
		boolean back = false;
		while (!back) {
			System.out.println();
			choice = artifactMenu.getUserChoice();
			back = processArtifactMenuChoice(choice);
		}
	}
	
	/**
	 * Adds an artifact to the system.
	 * @param artifact - artifact to add
	 */
	public static void addArtifact(Artifact artifact) {
		int insertionIndex = findInsertionIndex(artifact);
		artifactList.add(insertionIndex, artifact);
	}
	
	/**
	 * Gets the artifact list.
	 * @returns the artifact list.
	 */
	public static ArrayList<Artifact> getArtifactList() {
		return artifactList;
	}
	
	/**
	 * Allows the user to view a set of artifacts.
	 * @param artifacts - artifacts to be shown.
	 */
	private static void viewArtifacts(ArrayList<Artifact> artifacts) {
		try {
			int choice = 0;
			boolean back = false;
			
			// Are there any artifacts?
			if (artifacts.size() == 0) {
				System.out.println("There are no artifacts.");
				return;
			}
			while (!back) {
				// Format each artifact.
				String[] options = new String[artifacts.size()];
				for (int i = 0; i < artifacts.size(); i++) {
					Artifact artifact = artifacts.get(i);
					options[i] = artifact.getName() + " (" + artifact.getEngagementTime() + " mins)";
				}
				
				// Generate the menu.
				// This is done within the loop so that it will update should
				// an artifact be deleted.
				PageMenu menu = new PageMenu("Artifacts", options, 10);
				
				System.out.println();
				choice = menu.getUserChoice();
				back = processPageMenuChoice(choice);
				
				// If an artifact is selected, load it.
				if (!back) {
					Artifact chosenArtifact = artifacts.get(choice - 1);
					selectArtifact(chosenArtifact);
				}
			}
		} catch (Exception ex) {
			System.out.println("Could not view artifacts.");
			System.out.println(ex);
		}
		return;
	}
	
	/**
	 * Allows the user to search for artifacts based on criteria.
	 */
	private static void searchArtifacts() {
		System.out.println();
		Menu menu = new Menu("Search Artifacts", Resources.ARTIFACT_SEARCH_OPTIONS);
		int choice = 0;
		boolean quit = false;
		while (!quit) {
			choice = menu.getUserChoice();
			System.out.println();
			quit = processSearchArtifactsMenuChoice(choice);
		} 
	}
	
	/**
	 * Allows the user to find a specific artifact by ID.
	 */
	private static void viewArtifactByID() {
		int id = getIntegerInput("ID", 0);
		
		// Use a linear search to find the artifact.
		Artifact searchedArtifact = null;
		for (int i = 0; i < artifactList.size(); i++) {
			Artifact artifact = artifactList.get(i);
			if (artifact.getId() == id) {
				searchedArtifact = artifact;
				break;
			}
		}
		
		// If the artifact cannot be found, respond accordingly.
		if (searchedArtifact == null) {
			System.out.println("Could not find an artifact with that ID.");
			return;
		}
		
		selectArtifact(searchedArtifact);
	}
	
	/**
	 * Allows the user to find artifacts by name.
	 */
	private static void viewArtifactByName() {
		System.out.print("Enter name (may be partial): ");
		String name = input.nextLine();
		
		// Get all artifacts that match the input.
		ArrayList<Artifact> validArtifacts = new ArrayList<Artifact>();
		for (Artifact artifact : artifactList) {
			if (artifact.getName().toLowerCase().contains(name.toLowerCase())) {
				validArtifacts.add(artifact);
			}
		}
		
		// If there are none, return.
		if (validArtifacts.size() == 0) {
			System.out.println("No artifact could be found containing that phrase.");
			return;
		}

		viewArtifacts(validArtifacts);
	}
	
	/**
	 * Allows the user to view artifacts by type.
	 */
	private static void viewArtifactByType() {
		ArtifactType type = getTypeInput();
		
		// Get all artifacts that match the input.
		ArrayList<Artifact> validArtifacts = new ArrayList<Artifact>();
		for (Artifact artifact : artifactList) {
			if (artifact.getType() == type) {
				validArtifacts.add(artifact);
			}
		}
		
		// If there are none, return.
		if (validArtifacts.size() == 0) {
			System.out.println("No artifact could be found with that type.");
			return;
		}
		
		viewArtifacts(validArtifacts);
	}
	
	/**
	 * Gets an artifact type input from the user.
	 * @return the artifact type
	 */
	private static ArtifactType getTypeInput() {
		// Get the string for each artifact type.
		ArtifactType[] ENUMS = ArtifactType.values();
		String[] options = new String[ENUMS.length];
		for (int i = 0; i < ENUMS.length; i++) {
			options[i] = ENUMS[i].toString();
		}
		
		// Set up the menu.
		Menu menu = new Menu("Artifact Type", options);
		int choice = 0;
		while (choice == 0) {
			choice = menu.getUserChoice();
		}
		
		// Get the chosen artifact type.
		ArtifactType type = null;
		try {
			type = ArtifactType.get(choice - 1); 
		} catch (Exception ex) {
			System.out.println("Could not get type.");
			System.out.println(ex);
		}
		return type;
	}
	
	/**
	 * Selects an artifact.
	 * @param artifact - artifact to be shown.
	 */
	private static void selectArtifact(Artifact artifact) {
		Menu menu = new Menu("Options", Resources.SELECTED_ARTIFACT_OPTIONS);
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
			quit = processSelectedArtifactChoice(choice, artifact);
		} 
	}
	
	/**
	 * Creates a new artifact in the system.
	 * @return the new artifact.
	 */
	public static Artifact createNewArtifact() {
		System.out.println();
		System.out.println("Artifact Name");
		System.out.println("+++++++++++++");
		String name = getStringInput("new artifact's name");
		
		System.out.println();
		ArtifactType type = getTypeInput();
		
		System.out.println();
		System.out.println("Engagement Time");
		System.out.println("+++++++++++++++");
		int time = getIntegerInput("new artifact's engagement time", 1);
		
		System.out.println();
		System.out.println("Sign Text");
		System.out.println("++++++++++");
		String sign = getStringInput("new artifact's sign text");
		
		Artifact artifact = null;
		try {
			artifact = new Artifact(name, type, time, sign);
		} catch (Exception ex) {
			System.out.println("Could not create Artifact instance.");
			System.out.println(ex);
			return null;
		}
		
		addArtifact(artifact);
		
		System.out.println();
		System.out.println("New artifact added!");
		
		return artifact;
	}
	
	/**
	 * Allows a user to edit an artifact.
	 * @param artifact - artifact to edit
	 */
	public static void editArtifact(Artifact artifact) {
		int choice = 0;
		boolean back = false;
		while (!back) {
			System.out.println();
			Menu menu = new Menu("Edit Artifact", Resources.EDIT_ARTIFACT_OPTIONS);
			choice = menu.getUserChoice();
			back = processEditArtifactMenuChoice(choice, artifact);
			
			// Update the position of the artifact.
			artifactList.remove(artifact);
			addArtifact(artifact);
		} 
	}
	
	/**
	 * Allows a user to edit an artifact's name.
	 * @param artifact - artifact to edit
	 */
	private static void editArtifactName(Artifact artifact) {
		String name = getStringInput("name");
		
		artifact.setName(name);
		System.out.println("The artifact's name has been updated.");
	}
	
	/**
	 * Allows a user to edit an artifact's type.
	 * @param artifact - artifact to edit.
	 */
	private static void editArtifactType(Artifact artifact) {
		ArtifactType type = getTypeInput();
		
		artifact.setType(type);
		System.out.println("The artifact's type has been updated.");
	}
	
	/**
	 * Allows a user to edit an artifact's engagement time
	 * @param artifact - artifact to edit.
	 */
	private static void editArtifactEngagementTime(Artifact artifact) {
		int time = getIntegerInput("Engagement Time", 1);
		
		artifact.setEngagementTime(time);
		System.out.println("The artifact's engagement time has been updated.");
	}
	
	/**
	 * Allows a user to edit an artifact's sign text.
	 * @param artifact - artifact to edit
	 */
	private static void editArtifactSign(Artifact artifact) {
		String sign = getStringInput("sign text");
		
		artifact.setSign(sign);
		System.out.println("The artifact's sign text has been updated.");
	}
	
	/**
	 * Uses binary search algorithm to find the insertion index of an artifact.
	 * @param artifact - the artifact to be inserted
	 * @returns the insertion index
	 */
	private static int findInsertionIndex(Artifact artifact) {
		int low = 0;
		int high = artifactList.size() - 1;
		String item = artifact.getName();
		
		// Use a binary search to find the insertion index.
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (artifactList.get(mid).getName().equals(item)) {
                return mid;
            } else if (artifactList.get(mid).getName().compareToIgnoreCase(item) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
		}
		
		return low;
	}
	
	/**
	 * Processes a choice selection in the artifact menu.
	 * @param choice - the user's choice.
	 * @return true if the user chooses quit, false otherwise.
	 */
	private static boolean processArtifactMenuChoice(int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			viewArtifacts(artifactList);
			break;
		case 2:
			searchArtifacts();
			break;
		case 3:
			createNewArtifact();
			break;
		case 4:
			quit = true;
			
		}
		return quit;
	}
	
	/**
	 * Processes a choice selection in the search artifact menu.
	 * @param choice - the user's choice
	 * @return true if the user chooses quit, false otherwise.
	 */
	private static boolean processSearchArtifactsMenuChoice(int choice) {
		switch (choice) {
		case 1:
			viewArtifactByID();
			break;
		case 2:
			viewArtifactByName();
			break;
		case 3:
			viewArtifactByType();
			break;
		case 4:
			return true;
		}
		
		return false;
	}
	
	/**
	 * Processes a choice selection in the selected artifact menu.
	 * @param choice - the user's choice
	 * @param artifact - the artifact selected
	 * @return true if the user chooses quit, false otherwise.
	 */
	private static boolean processSelectedArtifactChoice(int choice, Artifact artifact) {
		boolean quit = false;
		switch (choice) {
		case 1:
			editArtifact(artifact);
			break;
		case 2:
			quit = confirmArtifactDeletion(artifact);
			break;
		case 3:
			quit = true;
		}
		
		return quit;
	}
	
	
	/**
	 * Process a choice selection in the edit artifact menu.
	 * @param choice - the user's choice
	 * @param artifact - the artifact selected
	 * @return true if the user chooses quit, false otherwise
	 */
	private static boolean processEditArtifactMenuChoice(int choice, Artifact artifact) {
		switch (choice) {
		case 1:
			editArtifactName(artifact);
			break;
		case 2:
			editArtifactType(artifact);
			break;
		case 3:
			editArtifactEngagementTime(artifact);
			break;
		case 4:
			editArtifactSign(artifact);
			break;
		case 5:
			return true;
		}
		
		return false;
	}
	
	/**
	 * Confirms the deletion of an artifact.
	 * @param artifact - artifact to be deleted.
	 * @returns true if the artifact was deleted, false otherwise.
	 */
	private static boolean confirmArtifactDeletion(Artifact artifact) {
		System.out.println();
		Menu menu = new Menu("Confirm?", Resources.CONFIRM_OPTIONS);
		int choice = menu.getUserChoice();
		if (choice == 1) {
			artifactList.remove(artifact);
			return true;
		}
		return false;
	}
}
