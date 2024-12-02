package part02;

import java.lang.reflect.Field;

import part01.PageMenu;

public class PageMenuTester extends Tester {
	public PageMenuTester() {
		return;
	}
	
	public void executeTests() {
		String output = null;
		
		// PM1
		try {
			PageMenu menu = new PageMenu("Test Menu", null, 1);
			output = menu.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"PM1",
				"Successful construction with valid parameters.", 
				"PageMenu [itemsPerPage=1, pageNum=0, items=null, title=Test Menu]",
				output
			);
		
		// PM2
		try {
			PageMenu menu = new PageMenu("Test Menu", null, 0);
			output = menu.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"PM2",
				"Failed construction with items per page less than 1.", 
				"Items per page must be greater than zero.",
				output
			);
		
		// PM3
		try {
			PageMenu menu = new PageMenu("Test Menu", null, -1);
			output = menu.toString();
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"PM3",
				"Failed construction with items per page less than 1.", 
				"Items per page must be greater than zero.",
				output
			);
		
		Field field = null;
		try {
			field = PageMenu.class.getDeclaredField("itemsPerPage");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		field.setAccessible(true);
		
		// PM4
		try {
			PageMenu menu = new PageMenu("Test Menu", null, 2);
			output = menu.setItemsPerPage(1) + " " + Integer.toString((int) field.get(menu));
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"PM4",
				"Failed construction with items per page less than 1.", 
				"true 1",
				output
			);
		
		// PM5
		try {
			PageMenu menu = new PageMenu("Test Menu", null, 2);
			output = menu.setItemsPerPage(0) + " " + Integer.toString((int) field.get(menu));
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"PM5",
				"Failed construction with items per page less than 1.", 
				"false 2",
				output
			);
		
		// PM6
		try {
			PageMenu menu = new PageMenu("Test Menu", null, 2);
			output = menu.setItemsPerPage(-1) + " " + Integer.toString((int) field.get(menu));
		} catch (Exception ex) {
			output = ex.getMessage();
		}
		printFormattedTest(
				"PM6",
				"Failed construction with items per page less than 1.", 
				"false 2",
				output
			);
	}
}
