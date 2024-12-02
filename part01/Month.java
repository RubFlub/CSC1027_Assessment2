package part01;

/**
 * Represents a month.
 */
public enum Month {
	JANUARY("January"),
	FEBRUARY("February"),
	MARCH("March"),
	APRIL("April"),
	MAY("May"),
	JUNE("June"),
	JULY("July"),
	AUGUST("August"),
	SEPTEMBER("September"),
	OCTOBER("October"),
	NOVEMBER("November"),
	DECEMBER("December");
	
	private static final Month[] ENUMS = Month.values();

	private String monthString;
	
	private Month(String monthString) {
		this.monthString = monthString;
	}
	
	/**
	 * Returns the specified month from an index.
	 * @param index the index of the specified value.
	 * @throws Exception if the index is out of bounds.
	 * @return the specified value.
	 */
	public static Month get(int index) throws Exception {
		if (index < 0 || index >= ENUMS.length) {
			throw new Exception("Invalid value for index: " + index);
		}
		return ENUMS[index];
	}
	
	/**
	 * Returns the string representation of the month.
	 * @return the string representation of the month.
	 */
	public String toString() {
		return this.monthString;
	}
}
