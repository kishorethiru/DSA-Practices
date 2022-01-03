package sdetmeet;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class FindNumberOfSubarrays {
	/*
		Problem Statement
		
		Given an array of integers nums and an integer k, return the total number of
		continuous subarrays whose sum equals to k.
 
		Example 1:
		
		Input: nums = [1,1,1], k = 2
		Output: 2
		
		Example 2:
		
		Input: nums = [1,2,3], k = 3
		Output: 2
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int 
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : [1,1,1], k = 2
			Negative : [1,5,3,5,2,0] k = 4
			Edge     : [1,2,3], k = 3
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,1,1};
		int k = 2;
		Assert.assertTrue(findSubArrayCount(input,k) == 2);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,5,3,5,2,0};
		int k = 4;
		Assert.assertTrue(findSubArrayCount(input,k) == 0);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {1,2,3};
		int k = 3;
		Assert.assertTrue(findSubArrayCount(input,k) == 2);
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {-1,1,0};
		int k = 0;
		Assert.assertTrue(findSubArrayCount(input,k) == 3);
	}


	
	/*  
	 * Create a map and add 0 , 1 as in default
	 * Create variable count and sum
	 * Iterate the input
	 *   Add the current index value to sum
	 *   check if the sum - k value is present in map
	 *   if present get and add the value of key yto the count
	 *   increment value
	 * return count  
	 * Time : O(n)
	 * Space : O(n)
	 */
	private int findSubArrayCount(int[] input, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0, sum = 0;
		for(int i : input) {
			sum += i;
			count += map.getOrDefault(sum-k, 0);
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}
	
}
