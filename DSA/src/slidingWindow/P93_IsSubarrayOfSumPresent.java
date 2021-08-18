package slidingWindow;

import org.junit.Assert;
import org.junit.Test;
public class P93_IsSubarrayOfSumPresent {
	/*
		Problem Statement
		
		Given an int array [1,4,20,3,10,5] and target sum 33.
		If target subarray sum is found, return true else false
		Time : 20 Minutes 
		- Write another 2 test data (edge and neg)
		- Pseudo Code for Optimised Solution
		- Code, Debug
		- Time everything 
		- Do it yourself !! 
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int 
		  Output ? boolean
		  Constraint(s) ? Optimized
	   
	   2. Test data
			Positive : 1,4,20,3,10,5, T = 33
			Negative : 1,4,20,3,10,5, T = 60	
			Edge     : 4,7,11,21      T = 21
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,4,20,3,10,5};
		int target = 33;
		Assert.assertTrue(isSumPresentInSubarray(input,target));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,4,20,3,10,5};
		int target = 60;
		Assert.assertFalse(isSumPresentInSubarray(input,target));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {4,7,11,21};
		int target = 22;
		Assert.assertTrue(isSumPresentInSubarray(input,target));
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {4,7,11,3,2,4};
		int target = 2;
		Assert.assertTrue(isSumPresentInSubarray(input,target));
	}
	
	// Template filling and TC - 4 mins

	/* Pseudocode - Sliding Window
	 * 1.Create Two pointer left,right as 0
	 * 2.Initialize variable sum as 0
	 * 3.Iterate till right < length and left < length
	 *   a) Add the right value to sum
	 *   b) If sum > greater than target increment left and remove its value from sum
	 *   c) If sum matches target return true;
	 * 4.return false
	 * 
	 * Time  - 3 mins
	 */
	
	/*  Time Complexity - O(n)
	 *  Space Complexity - O(1)
	 * 
	 */
	private boolean isSumPresentInSubarray(int[] input, int target) {
		if(input.length == 0) return false;
		int left = 0, right = 0; // Create Two pointer left,right as 0
		int sum = 0; // Initialize variable sum as 0
		// Iterate till right < length and left < length
		while(left<input.length && right < input.length) {
			sum += input[right++]; // Add the right value to sum
			while(sum>target){    
				sum -= input[left++]; // Substract left value from sum and increment left 
			}
			if(sum==target) return true;	// If sum matches target return true
		}
		return false;
	}
	
	// Code and Debug - 10 Mins
}
