package part01;

import java.util.Scanner;

/**
 * Generic manager class, used to create the main manager classes
 * for the system.
 */
public abstract class Manager {
	protected static Scanner input = new Scanner(System.in);
	
	/**
	 * Gets an integer input from the user.
	 * @param inputName - name of the input.
	 * @param min - minimum value for the input.
	 * @return the input
	 */
	protected static int getIntegerInput(String inputName, int min) {
		boolean valid = false;
		int value = 0;
		do {
			System.out.print("Enter " + inputName + ": ");
			try {
				value = input.nextInt();
				if (value >= min) {
					valid = true;
				} else {
					System.out.println(
							"The " + inputName + " must be greater than or equal to " + min + "."
						);
				}
				input.nextLine();
			} catch (Exception ex) {
				System.out.println("The " + inputName + " must be an integer.");
				input.nextLine();
			}
		} while (!valid);
		return value;
	}
	
	/**
	 * Gets an integer input from the user.
	 * @param inputName - name of the input.
	 * @param min - minimum value for the input.
	 * @param max - maximum value for the input.
	 * @return the input
	 */
	protected static int getIntegerInput(String inputName, int min, int max) {
		boolean valid = false;
		int value = 0;
		do {
			System.out.print("Enter " + inputName + ": ");
			try {
				value = input.nextInt();
				if (value >= min && value <= max) {
					valid = true;
				} else if (value <= max) {
					System.out.println(
							"The " + inputName + " must be greater than or equal to " + min + "."
						);
				} else {
					System.out.println(
							"The " + inputName + " must be less than or equal to " + max + "."
						);
				}
				input.nextLine();
			} catch (Exception ex) {
				System.out.println("The " + inputName + " must be an integer.");
				input.nextLine();
			}
		} while (!valid);
		return value;
	}
	
	/**
	 * Gets a string input from the user.
	 * @param inputName - name of the input.
	 * @return the input
	 */
	protected static String getStringInput(String inputName) {
		String str = null;
		do {
			System.out.print("Enter " + inputName + ": ");
			str = input.nextLine();
			if (Resources.isStringNullOrEmpty(str)) {
				System.out.println("The " + inputName + " must not be empty.");
			}
		} while (Resources.isStringNullOrEmpty(str));
		
		return str;
	}
	
	/**
	 * Processes a choice selection in an exhibit page menu.
	 * @param choice - the user's choice.
	 * @return true if the user chooses quit, false otherwise.
	 */
	protected static boolean processPageMenuChoice(int choice) {
		// Exit.
		if (choice == -1) {
			return true;
		}
		
		return false;
	}
}
