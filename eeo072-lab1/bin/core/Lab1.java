/**
 * 
 */
package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author eeo072
 * This program reads  tokens from a file and 
 * prints out three values:
 * 1. Number of tokens that are numbers
 * 2. Number of tokens that are not numbers
 * 3. Sum of the number tokens
 */

public class Lab1 {

	/**
	 * @param args
	 * Each of the values to be returned is represented by a variable at the beginning of main.
	 * A while loop reads through every token in the file, and a nested try catch statement converts
	 * the strings to doubles if they are numbers. The subsequent while loop increments two counters if 
	 * a token turns out to be a double. One for the number of doubles, and one to add the values 
	 * of those doubles up. If the token is not a number, a different counter signifying that it is 
	 * not a number is  incremented. Finally, a printf statement returns the number of either type of 
	 * token, along with the sum of all the double tokens.
	 */
	
	public static void main(String[] args) {
		
		int numbers = 0;
		int notNumbers = 0;
		double sum = 0.0;
		
		Scanner in = null;
		try {
		    in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException e) {
		    System.err.println("failed to open data.txt");
		    System.exit(1);
		}
		
		
		while (in.hasNext()) {
		    String token = in.next();
		    try {
		        // token is number
		        double d = Double.parseDouble(token);
		        numbers += 1;
		        sum += d;
		    } catch (NumberFormatException e) {
		        // token is not number
		        notNumbers += 1;
		    }
		}
		
		System.out.printf("%d %d %.1f", numbers, notNumbers, sum);

	}

}
