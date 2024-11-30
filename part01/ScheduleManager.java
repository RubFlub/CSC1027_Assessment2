package part01;

import java.util.ArrayList;

/**
 * Manages the monthly schedules within the system.
 */
public class ScheduleManager extends Manager {
	/**
	 * annualSchedule contains each monthly schedule.
	 */
	public static ArrayList<MonthSchedule> annualSchedule = new ArrayList<MonthSchedule>(Resources.MAX_MONTHS);
	
	/**
	 * Allows the user to manage the annual schedule within the system.
	 */
	public static void manageAnnualSchedule() {
		System.out.println();
		
		// Format the options.
		String[] options = new String[annualSchedule.size()];
		for (int i = 0; i < annualSchedule.size(); i++) {
			options[i] = annualSchedule.get(i).getMonth().toString();
		}
		
		try {
			PageMenu scheduleMenu = new PageMenu("Schedules", options, Resources.MAX_MONTHS);
			int choice = 0;
			boolean back = false;
			while (!back) {
				System.out.println();
				choice = scheduleMenu.getUserChoice();
				back = processPageMenuChoice(choice);
				
				if (!back) {
					MonthSchedule selectedSchedule = annualSchedule.get(choice - 1);
					selectSchedule(selectedSchedule);
				}
			}
		} catch (Exception ex) {
			System.out.println("Could not show schedules.");
			System.out.println(ex);
		}
	}
	
	/**
	 * Gets the annual schedule.
	 * @return the annual schedule.
	 */
	public static ArrayList<MonthSchedule> getAnnualSchedule() {
		return annualSchedule;
	}
	
	/**
	 * Selects a schedule.
	 * @param schedule - month's schedule that was selected
	 */
	private static void selectSchedule(MonthSchedule schedule) {
		Menu menu = new Menu("Options", Resources.SELECTED_SCHEDULE_OPTIONS);
		int choice = 0;
		boolean quit = false;
		while (!quit) {
			Exhibit[] exhibits = schedule.getExhibits();
			Exhibit exhibitOne = exhibits[0];
			Exhibit exhibitTwo = exhibits[1];
			Exhibit exhibitThree = exhibits[2];
			
			System.out.println();
			System.out.println(schedule.getMonth().toString());
			System.out.println("ID: " + schedule.getId());
			
			if (exhibitOne == null) {
				System.out.println("Exhibit Hall 1: None");
			} else {
				System.out.println(
						"Exhibit Hall 1: " + exhibitOne.getName() + " (" + exhibitOne.getTotalEngagementTime() + " minutes)"
					);
			}
			
			if (exhibitTwo == null) {
				System.out.println("Exhibit Hall 2: None");
			} else {
				System.out.println(
						"Exhibit Hall 2: " + exhibitTwo.getName() + " (" + exhibitTwo.getTotalEngagementTime() + " minutes)"
					);
			}
			
			if (exhibitThree == null) {
				System.out.println("Exhibit Hall 3: None");
			} else {
				System.out.println(
						"Exhibit Hall 3: " + exhibitThree.getName() + " (" + exhibitThree.getTotalEngagementTime() + " minutes)"
					);
				System.out.println();
				
			}
			
			choice = menu.getUserChoice();
			
			if (choice == 4) {
				return;
			}
			
			selectScheduleExhibit(schedule, choice - 1);
		}
	}
	
	/**
	 * Selects an exhibit in a schedule.
	 * @param schedule - the schedule.
	 * @param exhibit - selected exhibit.
	 * @param position - position of the exhibit in the schedule.
	 */
	private static void selectScheduleExhibit(MonthSchedule schedule, int position) {
		Menu menu = new Menu("Options", Resources.SELECTED_SCHEDULE_EXHIBIT_OPTIONS);
		
		boolean quit = false;
		int choice = 0;
		while (!quit) {
			Exhibit exhibit = schedule.getExhibits()[position];
			System.out.println();
			if (exhibit != null) {
				System.out.println(exhibit.getName());
				System.out.println("ID: \t\t" + exhibit.getId());
				System.out.println("Engage Time: \t" + exhibit.getTotalEngagementTime() + " minutes");
			} else {
				System.out.println("No exhibit is assigned to this hall.");
			}
			System.out.println();
			choice = menu.getUserChoice();
			quit = processScheduleExhibitChoice(choice, schedule, position);
		} 
	}
	
	/**
	 * Sets an exhibit to a position in a schedule.
	 * @param schedule - the schedule to be updated.
	 * @param position - position of the schedule to be updated.
	 */
	private static void setExhibit(MonthSchedule schedule, int position) {
		ArrayList<Exhibit> validExhibits = getValidExhibits();
		
		// Are there any valid exhibits?
		if (validExhibits.size() == 0) {
			System.out.println();
			System.out.println("There are no exhibits not assigned to a schedule.");
			System.out.println("To add an exhibit, create a new one, or unassign one from a schedule.");

			return;
		}
		
		// Format the ArrayList as a String array.
		String[] options = new String[validExhibits.size()];
		for (int i = 0; i < validExhibits.size(); i++) {
			Exhibit exhibit = validExhibits.get(i);
			options[i] = exhibit.getName() + " (" + exhibit.getTotalEngagementTime() + " mins)";
		}
		
		try {
			// Select what exhibit they want.
			PageMenu menu = new PageMenu("Exhibits", options, 10);
			
			System.out.println();
			int choice = menu.getUserChoice();
			boolean back = processPageMenuChoice(choice);
			
			if (back) {
				return;
			}
			
			// Add it to the schedule.
			Exhibit selectedExhibit = validExhibits.get(choice - 1);
			schedule.setExhibit(position, selectedExhibit);
			
			System.out.println();
			System.out.println("Added exhibit to schedule!");
			return;
		} catch (Exception ex) {
			System.out.println("Could not get exhibits.");
			System.out.println(ex);
		}
	}
	
	private static void unassignExhibit(MonthSchedule schedule, int position) {
		Exhibit exhibit = schedule.getExhibits()[position];
		if (exhibit == null) {
			System.out.println("There is already no exhibit assigned to this position.");
			return;
		}
		schedule.setExhibit(position, null);
		
		System.out.println();
		System.out.println("Exhibit unassigned!");
	}
	
	/**
	 * Returns an ArrayList of all exhibits not assigned to a schedule.
	 * @return ArrayList of valid schedules.
	 */
	private static ArrayList<Exhibit> getValidExhibits() {
		// Initialise the list of valid exhibits as the list of all exhibits.
		ArrayList<Exhibit> exhibitList = ExhibitManager.getExhibitList();
		ArrayList<Exhibit> validExhibits = new ArrayList<Exhibit>(exhibitList);
		
		// Remove each exhibit assigned to an schedule from the list.
		for (MonthSchedule schedule : annualSchedule) {
			for (Exhibit exhibit : schedule.getExhibits()) {
				validExhibits.remove(exhibit);
			}
		}
		
		return validExhibits;
	}
	
	/**
	 * Processes a choice of exhibit in a schedule.
	 * @param choice - choice made.
	 * @param schedule - the schedule.
	 * @param position - position of the exhibit.
	 * @return true if the user is quitting the menu.
	 */
	private static boolean processScheduleExhibitChoice(int choice, MonthSchedule schedule, int position) {
		switch(choice) {
		case 1:
			setExhibit(schedule, position);
			break;
		case 2:
			unassignExhibit(schedule, position);
			return true;
		case 3:
			return true;
		}
		
		return false;
	}
}
