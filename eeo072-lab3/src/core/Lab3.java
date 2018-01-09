/** 
 * 
 */
package core;

/**
 * @author eeo072
 */
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab3 {

	/**
	 * @param args
	 *            This main method reads a file, which consists of one date on each
	 *            line. Each date is stored in a Date object. If the next date is
	 *            later than the previous date, a DateRange object is created from
	 *            the two dates. All DateRange objects are printed out.
	 */
	public static void main(String[] args) {

		Date dateOne = null;
		Scanner in = null;
		try {
			in = new Scanner(new File("dates.txt"));
		} catch (FileNotFoundException exception) {
			System.err.println("failed to open dates.txt");
			System.exit(1);
		}

		while (in.hasNextLine()) {
			String line = in.nextLine();
			Date date = new Date(line);
			System.out.println(date);

			if (dateOne != null) {
				DateRange daterange = new DateRange(date, dateOne);
				if (date.compareTo(dateOne) == 1)
					System.out.println(daterange);
			}
			dateOne = date;
		}
	}
}