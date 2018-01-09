/**
 * 
 */
package core;

/**
 * @author eeo072
 * This Date class was taken from the version used in the Chapter 8 lecture
 * and modified to accept a String parameter
 */
import java.util.Scanner;

public class Date implements Comparable<Date> {

	private int month;
	private int day;
	private int year;

	/**
	 * This Date object is made using input line parsed from text file
	 * 
	 * @param dateEntry
	 *            String is the aforementioned input line
	 */
	public Date(String dateEntry) {
		Scanner in = new Scanner(dateEntry.replaceAll(",", ""));
		this.month = 0;
		String a = in.next().substring(0, 3);
		if (a.equals("Jan")) {
			this.month = 1;
		}
		if (a.equals("Feb")) {
			this.month = 2;
		}
		if (a.equals("Mar")) {
			this.month = 3;
		}
		if (a.equals("Apr")) {
			this.month = 4;
		}
		if (a.equals("May")) {
			this.month = 5;
		}
		if (a.equals("Jun")) {
			this.month = 6;
		}
		if (a.equals("Jul")) {
			this.month = 7;
		}
		if (a.equals("Aug")) {
			this.month = 8;
		}
		if (a.equals("Sep")) {
			this.month = 9;
		}
		if (a.equals("Oct")) {
			this.month = 10;
		}
		if (a.equals("Nov")) {
			this.month = 11;
		}
		if (a.equals("Dec")) {
			this.month = 12;
		}
		int tempD = in.nextInt();
		int tempY = in.nextInt();
		lookUpYear(tempY);
		lookUpDay(tempD);
		in.close();
	}

	/**
	 * This method compares two date objects.
	 * 
	 * @param other
	 *            a Date object used for comparison
	 * @return -1 if other is greater than the first date object; 1 if other is
	 *         smaller than the first date object; 0 if other and first date object
	 *         are equal.
	 */
	public int compareTo(Date other) {
		if (this.year < other.year)
			return -1;
		if (this.year > other.year)
			return 1;
		if (this.month < other.month)
			return -1;
		if (this.month > other.month)
			return 1;
		if (this.day < other.day)
			return -1;
		if (this.day > other.day)
			return 1;
		return 0;
	}

	/**
	 * Ensures that the year from the input is valid.
	 * 
	 * @param yr
	 *            an integer extracted from the input.
	 */
	private void lookUpYear(int yr) {
		if (yr >= 1) {
			this.year = yr;
		} else {
			this.year = 0;
		}
	}

	/**
	 * Ensures that the day from the input is valid.
	 * 
	 * @param d
	 *            an integer extracted from the input.
	 */
	private void lookUpDay(int dy) {

		boolean leapYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
		this.day = dy;
		if (dy > 31) {
			this.day = 0;
		}
		if (dy > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
			this.day = 0;
		}
		if (dy > 28 && (month == 2 && leapYear == false)) {
			this.day = 0;
		}
		if (dy > 29 && (month == 2 && leapYear == true)) {
			this.day = 0;
		}
	}

	/**
	 * Converts the month from a int to String.
	 * 
	 * @param m
	 *            the int representing the unconverted month value.
	 */
	private String monthName(int m) {
		String monthName = "";
		if (m == 1) {
			monthName = "January";
		}
		if (m == 2) {
			monthName = "February";
		}
		if (m == 3) {
			monthName = "March";
		}
		if (m == 4) {
			monthName = "April";
		}
		if (m == 5) {
			monthName = "May";
		}
		if (m == 6) {
			monthName = "June";
		}
		if (m == 7) {
			monthName = "July";
		}
		if (m == 8) {
			monthName = "August";
		}
		if (m == 9) {
			monthName = "September";
		}
		if (m == 10) {
			monthName = "October";
		}
		if (m == 11) {
			monthName = "November";
		}
		if (m == 12) {
			monthName = "December";
		}
		return monthName;
	}

	/**
	 * Returns day
	 * 
	 * @return an int representing this.day.
	 */
	public int returnDay() {
		return this.day;
	}

	/**
	 * Returns month
	 * 
	 * @return an int representing this.month.
	 */
	public int returnMonth() {
		return this.month;
	}

	/**
	 * Returns year
	 * 
	 * @return an int representing this.year.
	 */
	public int returnYear() {
		return this.year;
	}

	/**
	 * Shows the final parsed date after being refined by the above methods.
	 * 
	 * @return String that prints out the date in the format specified by lab
	 *         instructions. If the date is invalid, "Invalid date" is returned.
	 */
	public String toString() {
		if (day <= 0 || month <= 0 || year <= 0)
			return "Invalid Date";
		else
			return "Date: " + monthName(this.month) + " " + this.day + ", " + this.year;
	}
}
