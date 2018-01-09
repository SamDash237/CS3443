/** 
 * 
 */
package core;

/**
 * @author samda This class determines the range between two valid dates
 */
public class DateRange {

	private String dr;

	/**
	 * Creates a DateRange object between two dates, assuming that date2 comes before
	 * date1.
	 * 
	 * @param date1
	 *            - Later date
	 * @param date2
	 *            - Earlier date
	 */
	DateRange(Date date1, Date date2) {
		dr = "DateRange: " + date2 + " - " + date1;
	}

	/**
	 * Shows the range between two dates.
	 * 
	 * @return dateRange String that explains the range
	 */
	public String toString() {
		return dr;
	}
}