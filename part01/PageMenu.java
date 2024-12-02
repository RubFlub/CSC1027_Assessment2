package part01;

import java.util.Arrays;

/**
 * Extended menu class to provide support for pages.
 */
public class PageMenu extends Menu {
	private int itemsPerPage = 0;
	private int pageNum = 0;
	
	/**
	 * Constructor for the page menu.
	 * @param title - title of the menu
	 * @param data - data for the menu.
	 * @param itemsPerPage - the amount of items to show in one page.
	 * @throws Exception if the items per page is not greater than zero.
	 */
	public PageMenu(String title, String data[], int itemsPerPage) throws Exception {
		super(title, data);
		
		if (!setItemsPerPage(itemsPerPage)) {
			throw new Exception("Items per page must be greater than zero.");
		}
	}
	
	/**
	 * Sets the items per page.
	 * @param items
	 * @return true if the set was successful, false otherwise.
	 */
	public boolean setItemsPerPage(int items) {
		// Is the number of items less than or equal to zero?
		if (items <= 0) {
			return false;
		}
		
		this.itemsPerPage = items;
		return true;
	}
	
	/**
	 * Displays the page.
	 */
	private void displayPage() {
		// Print the header of the page.
		System.out.println(this.title);
		for (int count = 0; count < this.title.length(); count++) {
			System.out.print("+");
		}
		
		// What page are we on?
		int amountOfPages = (int) Math.ceil((double) this.items.length / this.itemsPerPage);
		System.out.println();
		System.out.println("Page " + (this.pageNum + 1) + "/" + amountOfPages);
		
		// Calculate which options should be on the current page, and print them.
		int pageFirstOption = this.itemsPerPage * this.pageNum;
		int pageLastOption = Math.min(pageFirstOption + this.itemsPerPage - 1, items.length - 1);
		int maxLineLength = 24;
		for (int option = pageFirstOption; option <= pageLastOption; option++) {
			String line = (option + 1) + ". " + items[option];
			System.out.println(line);
			
			// Save the largest line length for formatting.
			if (line.length() > maxLineLength) {
				maxLineLength = line.length();
			}
		}
		
		// Print the page arrows.
		if (pageNum != 0) {
			System.out.print("<< [P]revious ");
		} else {
			System.out.print("              ");
		}
		
		for (int count = 0; count < maxLineLength - 24; count++) {
			System.out.print(" ");
		}
		
		if (pageNum != amountOfPages - 1) {
			System.out.print(" [N]ext >>");
		} else {
			System.out.print("          ");
		}
		
		System.out.println();
		System.out.println("Pick an option, or [E]xit.");
	}
	
	/**
	 * Allows the user to pick a choice in the menu.
	 */
	@Override
	public int getUserChoice() {
		boolean valid = false;
		int value = 0;
		String selection = "";
		displayPage();
		do {
			System.out.println();
			System.out.print("Enter selection: ");
			selection = input.next();
			try {
				value = Integer.parseInt(selection);
				if (value >= 1 && value <= items.length) {
					valid = true;
				} else {
					System.out.println(
							"The selection must be between 1 and " + items.length + "."
						);
				}
			} catch (Exception ex) {
				if (processSelection(selection)) {
					return -1;
				};
				input.nextLine();
			}
		} while (!valid);
		return value;
	}
	
	/**
	 * Process a selection if it is not a numerical choice.
	 * @param selection - the selection made.
	 * @returns true if the user selects exit, false otherwise
	 */
	private boolean processSelection(String selection) {
		// Convert to lowercase & get the first character.
		selection = selection.toLowerCase();
		
		// Go to the previous page.
		if (selection.equals("previous") || selection.equals("p")) {
			previousPage();
			return false;
		}
		
		// Go to the next page.
		if (selection.equals("next") || selection.equals("n")) {
			nextPage();
			return false;
		}
		
		// Exit
		if (selection.equals("exit") || selection.equals("e")) {
			return true;
		}
		
		System.out.println("That is not a valid selection.");
		return false;
	}
	
	/**
	 * Changes the page to the previous page.
	 */
	private void previousPage() {
		if (pageNum == 0) {
			System.out.println("There is no previous page.");
			return;
		}
		
		pageNum--;
		displayPage();
	}
	
	/**
	 * Changes the page to the next page.
	 */
	private void nextPage() {
		int amountOfPages = (int) Math.ceil((double) this.items.length / this.itemsPerPage);
		if (pageNum == amountOfPages - 1) {
			System.out.println("This is the last page.");
			return;
		}
		
		pageNum++;
		displayPage();
	}

	@Override
	public String toString() {
		return "PageMenu [itemsPerPage=" + itemsPerPage + ", pageNum=" + pageNum + ", items=" + Arrays.toString(items)
				+ ", title=" + title + "]";
	}
	
	
}
