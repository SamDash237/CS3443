/**
 * 
 */
package core;

import java.util.Arrays;

/**
 * @author eeo072
 * This Grades object processes the data from the text file used in Lab2
 * getName returns the student's name
 * length shows how many grades each student has
 * average is the average grade for each student
 * median is the median grade each student has(if the list has no median, the middle two grades are added and divided by two)
 * maximum is the highest grade a student has
 * minimum is the lowest grade a student has
 */
public class Grades {
	private String name;
	private int[] gradeArr;
	
public Grades (String name1, int[] gradeArr1){
	name = name1; 
    gradeArr = gradeArr1;
}

public String toString() {
    return (String) name + " " + Arrays.toString(gradeArr);
}

public String getName() {
    return name;
}

public int length() {
    return gradeArr.length;
}

public double average() {
	double total = 0; 
    double average = 0.0;
    int i = 0;
    while (i < gradeArr.length) {
        int grade = gradeArr[i];  
        total += grade;
        i++;                   
    }
    average = total / gradeArr.length;
    return (double) average;
}

public double median()      {

    Arrays.sort(gradeArr);    
    double median= 0.0; 
    if (gradeArr.length%2 == 0)
        median= ((double)gradeArr[gradeArr.length/2-1] + (double)gradeArr[gradeArr.length/2])/2;
    else
        median= (double) gradeArr[gradeArr.length/2];

    return (double) median;
}

public int minimum() { 
    int bottomGrade = gradeArr[0];
    for (int i = 0; i < gradeArr.length; i++) {
        int grade = gradeArr[i];
        if (grade < bottomGrade)
            bottomGrade = grade;
    }
    return bottomGrade;
}

public int maximum() { 
    int topGrade = gradeArr[0];
    for (int grade : gradeArr) {
        if (grade > topGrade)
            topGrade = grade;
    }
    return topGrade;
}

}
