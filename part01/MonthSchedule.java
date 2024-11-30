package part01;

/**
 * Represents a month's schedule in the annual museum exhibition plan.
 */
public class MonthSchedule {
	public static final int MAX_EXHIBITS = 3;
	private static int nextId = 0;
	private int id;
	private Month month;
	private Exhibit[] exhibits = new Exhibit[MAX_EXHIBITS];
	
	/**
	 * Default constructor for the month's schedule.
	 * This will automatically assign the month.
	 */
	public MonthSchedule() throws Exception {
		this(Month.get(nextId));
	}
	
	/**
	 * Parameterised constructor for the month's schedule.
	 * @param month - The month of the year the schedule is for.
	 * @throws Exception if there are more than 12 instances of MonthSchedule.
	 * @throws Exception if the month is null.
	 */
	public MonthSchedule(Month month) throws Exception {
		if (nextId >= Resources.MAX_MONTHS) {
			throw new Exception("There may be only " + Resources.MAX_MONTHS + " instances of MonthSchedule.");
		}
		
		if (!setMonth(month)) {
			throw new Exception("Month cannot be null.");
		}
		
		this.id = nextId;
		nextId++;
	};

	/**
	 * Gets the id.
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets the month.
	 * @return month
	 */
	public Month getMonth() {
		return this.month;
	}
	
	/**
	 * Gets the array of exhibits.
	 * @return exhibits
	 */
	public Exhibit[] getExhibits() {
		return this.exhibits;
	}
	
	/**
	 * Sets the month.
	 * @param month
	 * @return true if set is successful, false otherwise.
	 */
	public boolean setMonth(Month month) {
		if (month == null) {
			return false;
		}
		
		this.month = month;
		return true;
	}
	
	/**
	 * Sets a specified exhibit in the schedule.
	 * @param position - the position for which the schedule should be set.
	 * @param exhibit - the exhibit to be inserted.
	 * @return true if the set is successful, false otherwise.
	 */
	public boolean setExhibit(int position, Exhibit exhibit) {
		if (position < 0 || position >= MAX_EXHIBITS) {
			return false;
		}
		
		this.exhibits[position] = exhibit;
		return true;
	}
	
	/**
	 * Returns the string representation of the month schedule.
	 * @return the string representation of the month schedule.
	 */
	@Override
	public String toString() {
		return "MonthSchedule [id=" + id + ", month=" + month + ", exhibits=" + exhibits + "]";
	}
}
