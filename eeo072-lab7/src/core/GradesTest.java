package core;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
/**
 * @author eeo072
 * This GradesTest object runs a battery of tests on the average, median, and minimum functions within the Grades object.
 * Tests are centered primarily around parameter extremes and exceptional values. 
 */
public class GradesTest {
	
	/**
     * median method test case using null grade array. 
     * The correct behavior is a runtime error.
     */
	@Test
	public void testMedianNull() {
		Grades g1 = new Grades("test", null);
		boolean nullError = false;
        try {
            g1.median();
        } catch (NullPointerException e) {
            nullError = true;
        }
        assertTrue("should be a NullPointerException", nullError);
    }
	
	/**
     * median method test case using 3 elements. 
     * The correct behavior is the median of the numbers.
     */
	@Test
	public void testMedianEasy() {
		int[] grades = {20, 40, 60};
        Grades g1 = new Grades("test", grades);
        double median = 0.0;
        if(grades.length%2 == 0) {
        	median= ((double)grades[grades.length/2-1] + (double)grades[grades.length/2])/2;
        }else
            median= (double) grades[grades.length/2];
        assertEquals("Easy test failed", median, g1.median(),0.000001);
    }
	
	/**
     * median method test case with a long element array. 
     * The correct behavior is the median of the numbers.
     */
	@Test
	public void testMedianLong() {
		int[] grades = {87, 99, 96, 99, 86, 96, 77, 95, 70, 88, 99, 1, 12, 37, 49, 66};
        Grades g1 = new Grades("test", grades);
        Arrays.sort(grades); 
        double median = 0.0;
        if(grades.length%2 == 0) {
        	median= ((double)grades[grades.length/2-1] + (double)grades[grades.length/2])/2;
        }else
            median= (double) grades[grades.length/2];
        assertEquals("Long test failed", median, g1.median(), 0.000001);
    }
	
	/**
     * median method test case using negative values and unusually large positive values. 
     * The correct behavior is the median of the numbers.
     */
	@Test
	public void testMedianExceptional() {
		int[] grades = {33, -64, 12, -98, 79, -1456, 132946};
		Grades g1 = new Grades("test", grades);
		Arrays.sort(grades);
		double median = 0.0;
		if(grades.length%2 == 0)
        	median= ((double)grades[grades.length/2-1] + (double)grades[grades.length/2])/2;
        else 
            median= (double) grades[grades.length/2];
        assertEquals("Exceptional test failed", median, g1.median(),0.000001);
    }
	
	/**
     * average method test case using null grade array. 
     * The correct behavior is a runtime error.
     */
	@Test
	public void testAverageNull() {
		Grades g1 = new Grades("test", null);
		boolean nullError = false;
        try {
            g1.average();
        } catch (NullPointerException e) {
            nullError = true;
        }
        assertTrue("should be a NullPointerException", nullError);
    }
	
	/**
     * average method test case using 3 elements. 
     * The correct behavior is the average of the numbers, plus or minus roundoff.
     */
	@Test
	public void testAverageEasy() {
		int[] grades = {20, 40, 60};
        Grades g1 = new Grades("test", grades);
        double average = 0.0;
        for (int grade : grades) {
            average += grade;
        }
        average /= grades.length;
        assertEquals("Easy test failed", average, g1.average(),0.000001);
    }

	/**
     * average method test case with a long element array. 
     * The correct behavior is the average of the numbers, plus or minus roundoff.
     */
	@Test
	public void testAverageLong() {
		int[] grades = {87, 99, 96, 99, 86, 96, 77, 95, 70, 88, 99, 1, 12, 37, 49, 66};
        Grades g1 = new Grades("test", grades);
        double average = 0.0;
        for (int grade : grades) {
            average += grade;
        }
        average /= grades.length;
        assertEquals("Long test failed", average, g1.average(),0.000001);
    }
	
	/**
     * average method test case using negative values and unusually large positive values. 
     * The correct behavior is the average of the numbers, plus or minus roundoff.
     */
	@Test
	public void testAverageExceptional() {
		int[] grades = {33, -64, 12, -98, 79, -1456, 132946};
		Grades g1 = new Grades("test", grades);
		double average = 0.0;
        for (int grade : grades) {
            average += grade;
        }
        average /= grades.length;
        assertEquals("Long test failed", average, g1.average(),0.000001);
    }
	
	/**
     * minimum method test case using null grade array. 
     * The correct behavior is a runtime error.
     */
	@Test
	public void testMinimumNull() {
		Grades g1 = new Grades("test", null);
		boolean nullError = false;
        try {
            g1.minimum();
        } catch (NullPointerException e) {
            nullError = true;
        }
        assertTrue("should be a NullPointerException", nullError);
    }
	
	/**
     * minimum method test case using 3 elements. 
     * The correct behavior is the smallest of the numbers, plus or minus roundoff.
     */
	@Test
	public void testMinimumEasy() {
		int[] grades = {20, 40, 60};
        Grades g1 = new Grades("test", grades);
        int bottomGrade = grades[0];
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            if (grade < bottomGrade)
                bottomGrade = grade;
        }
        assertEquals("Easy test failed", bottomGrade, g1.minimum(),0.000001);
    }
	
	/**
     * minimum method test case with a long element array.. 
     * The correct behavior is the smallest of the numbers, plus or minus roundoff.
     */
	@Test
	public void testMinimumLong() {
		int[] grades = {87, 99, 96, 99, 86, 96, 77, 95, 70, 88, 99, 1, 12, 37, 49, 66};
        Grades g1 = new Grades("test", grades);
        int bottomGrade = grades[0];
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            if (grade < bottomGrade)
                bottomGrade = grade;
        }
        assertEquals("Long test failed", bottomGrade, g1.minimum(),0.000001);
    }
	
	/**
     * average method test case using negative values and unusually large positive values. 
     * The correct behavior is the average of the numbers, plus or minus roundoff.
     */
	@Test
	public void testMinimumExceptional() {
		int[] grades = {33, -64, 12, -98, 79, -1456, 132946};
		Grades g1 = new Grades("test", grades);
		int bottomGrade = grades[0];
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            if (grade < bottomGrade)
                bottomGrade = grade;
        }
        assertEquals("Long test failed", bottomGrade, g1.minimum(),0.000001);
    }
}
