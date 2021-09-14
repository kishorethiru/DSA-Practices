package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P137_FindDuplicateNumber {
	/*
		Problem Statement
		Given an array of integers nums containing n + 1 integers where 
		each integer is in the range [1, n] inclusive.
		There is only one repeated number in nums, 
		return this repeated number.
		You must solve the problem without modifying the array nums and 
		uses only constant extra space.

 
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? int
		  Constraint(s) ? No extraspace
	   
	   2. Test data
			Positive : [1,2,3,4,4]
			Negative : [1,2,3]	
			Edge     : [1,2,3,4,4,4]
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,2,3,4,4};
		Assert.assertTrue(findDuplicateNumber(input)==4);
	}

	@Test(expected = RuntimeException.class)
	public void testData02() { // Negative
		int[] input = {1,2,3};
		Assert.assertTrue(findDuplicateNumber(input)==4);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {1,1,3,2};
		Assert.assertTrue(findDuplicateNumber(input)==1);
	}

	/* Pseudocode - Making value to negative
	 * [This logic is based on the statement that the input has 
	 *  only the values from 1- n-1 where n is length of arr]
	 * Iterate the input
	 *   Get the absolute value of number
	 *   Check if the value is already < 0 if yes return the absolute number 
	 *   Update the absolute value index * -1
	 * return 0 
	 * Time : O(n)
	 * Space : O(1)
	 */
	private int findDuplicateNumber(int[] input) {
		for(int i = 0; i< input.length; i++) {
			int abs = Math.abs(input[i]);
			if(abs > input.length -1) throw new RuntimeException("Invalid Input");
			if(input[abs] < 0) return i;
			else input[abs] *= -1;
		}
		return 0;
	}
}
