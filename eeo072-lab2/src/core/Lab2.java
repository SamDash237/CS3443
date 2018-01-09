/**
 * 
 */
package core;

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author eeo072
 * This lab reads a file, store the data into objects, and process the objects. The file is formatted in pairs of lines:
 * The first line in the pair has the student's name, the second has a list of grades. This data is stored in a
 * Grades object, which processes the data.
 */
public class Lab2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = null;
		 ArrayList<Integer> gradeListSize = new ArrayList<Integer>();
		try {
		    in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open data.txt");
		    System.exit(1);
		}
		while (in.hasNext()) {
		    String name = in.next();
		    while (in.hasNextInt()) {
		        int grade = in.nextInt();
		        gradeListSize.add(grade);
		    }
		    int[] gradeArr = new int[gradeListSize.size()];
	        for (int i = 0; i < gradeListSize.size(); i++) {
	            gradeArr[i] = gradeListSize.get(i);
		}    
	        Grades myGrade = new Grades(name, gradeArr);
	        testGrades(myGrade);
	        gradeListSize.clear();
	}

}

public static void testGrades(Grades grades) {
    System.out.println(grades.toString()); 
    System.out.printf("\tName:    %s\n", grades.getName());
    System.out.printf("\tLength:  %d\n", grades.length());
    System.out.printf("\tAverage: %.2f\n", grades.average());
    System.out.printf("\tMedian:  %.1f\n", grades.median());
    System.out.printf("\tMaximum: %d\n", grades.maximum());
    System.out.printf("\tMinimum: %d\n", grades.minimum());
	}
}