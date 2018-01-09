/** 
 * 
 */

package core;

/**
 * @author eeo072
 * This program reads a data file,  which consists of one length on each line.
 * Each length is stored in an appropriate Length object.
 * All the Length objects are stored in an ArrayList<Length>.
 * Each Length object is printed out. The minimum and maximum length is printed out.
 * The sums of the lengths are printed out in different ways at the bottom.
 */
import java.io.*;
import java.util.*;
import length.*;

public class Lab4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Length> len = new ArrayList<Length>();
		
		Scanner in = null;
		try {
		    in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException exception) {
		    throw new RuntimeException("failed to open data.txt");
		}

		while (in.hasNextDouble()) {
		    double value = in.nextDouble();
		    String unit = in.next();
		    Length length = null;
		    if (unit.equalsIgnoreCase("yard")||unit.equalsIgnoreCase("yards"))
		    	length = new Yards(value);
		    if (unit.equalsIgnoreCase("meter")||unit.equalsIgnoreCase("meters"))
		    	length = new Meters(value);
		    if (unit.equalsIgnoreCase("foot")||unit.equalsIgnoreCase("feet"))
		    	length = new Feet(value);
		    if (unit.equalsIgnoreCase("inch")||unit.equalsIgnoreCase("inches"))
		    	length = new Inches(value);
		    System.out.println(length);
		    len.add(length);
		}
		in.close();
		Length min = len.get(0);
		Length max = len.get(0);
		
		Yards sumY = new Yards(0);
		Meters sumM = new Meters(0);
		Feet sumF = new Feet(0);
		Inches sumI = new Inches(0);
		
		for (Length l : len){
			if (l.toMeters() < min.toMeters())
				min = l;
			if (l.toMeters() > max.toMeters())
				max = l;
			
			sumY.add(l);
			sumM.add(l);
			sumF.add(l);
			sumI.add(l);
		}
		
		System.out.println();
		System.out.println("Minimum is " + min.toString());
		System.out.println("Maximum is " + max.toString());
		System.out.println();
		
		System.out.println("Sum of Lengths Adding from First to Last");
		System.out.println(sumM);
		System.out.println(sumI);
		System.out.println(sumF);
		System.out.println(sumY);
		System.out.println();
		
		Yards sumY1 = new Yards(0);
		Meters sumM1 = new Meters(0);
		Feet sumF1 = new Feet(0);
		Inches sumI1 = new Inches(0);
		
		for (int i=len.size()-1; i>=0; i--){
			sumY1.add(len.get(i));
			sumM1.add(len.get(i));
			sumF1.add(len.get(i));
			sumI1.add(len.get(i));
		}
		System.out.println("Sum of Lengths Adding from Last to First");
		System.out.println(sumM1);
		System.out.println(sumI1);
		System.out.println(sumF1);
		System.out.println(sumY1);

	}

}
