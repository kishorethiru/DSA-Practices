package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P75_FindTheAverageSalary {
	/*
		Problem Statement
		Given an array of unique integers salary where salary[i] is the salary of the employee i.
		Return the average salary of employees excluding the minimum and maximum salary.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? double
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :[4000,3000,1000,2000]
			Negative :[1000,2000]	
			Edge     :[1000,2000,3000]
	
	   3.  Approaches Known 
			 Approach 1 : Using min and max function
	
	   4.  O - Notation 
			 Approach 1 : Using min and max function
	
	   5.  Pseudocode	
	   	
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int[] input = {4000,3000,1000,2000};
		Assert.assertTrue(averageSalary(input)==2500.0000);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1000,2000};
		Assert.assertTrue(averageSalary(input)==0000.0000);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {3000,1000,2000};
		Assert.assertTrue(averageSalary(input)==2000.0000);

	}
	/* 
	 * Initialize count as 0 and min as MAX integer value and max as MIN integer value
	 * Iterate the input
	 *   Compare and find max and min using Math function
	 *   Add the current element to count
	 * Subtract the max and min value from count
	 * Return count by / length - 2;  
	 * Time : O(n)
	 * Space : O(1)
	 * 
	 */
	private double averageSalary(int[] salary) {
	    if(salary.length < 3 ) return 0.0;
		double count = 0;
		double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = 0; i < salary.length; i++) {
			count += salary[i];
			max = Math.max(max, salary[i]);
			min = Math.min(min, salary[i]);
		}
		count = count - (min + max);
		return count / (salary.length - 2);
	}
     
}
