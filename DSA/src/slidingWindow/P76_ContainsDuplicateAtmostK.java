package slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P76_ContainsDuplicateAtmostK {
	/*
		Problem Statement
			Given an integer array nums and an integer k, return true if there are two distinct indices
		 	i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int 
		  Output ? boolean
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :[1,2,3,1], k = 3
			Negative :[1,2,3,1,2,3], k = 2
			Edge     : [1,0,1,1], k = 1
	
	   3.  Approaches Known 
			 Approach 1 : Using Two Ptr
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int[] input = {1,2,3,1};
		int k =3;
		Assert.assertTrue(isDuplicateContainsAtK(input,k));
		Assert.assertTrue(isDuplicateContainsAtKUsingMap(input,k));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,2,3,1,2,3};
		int k =2;
		Assert.assertFalse(isDuplicateContainsAtK(input,k));
		Assert.assertFalse(isDuplicateContainsAtKUsingMap(input,k));

	}

	@Test
	public void testData03() { // Edge
		int[] input = {1,0,1,1};
		int k =1;
		Assert.assertTrue(isDuplicateContainsAtK(input,k));
		Assert.assertTrue(isDuplicateContainsAtKUsingMap(input,k));
	}
	
	/* 
	 * Create pointer left and right
	 * Iterate the left till it reaches before length -1
	 *   right = left + 1;
	 *   Increment right untill right value equal to left value and right with length and right - left <=k
	 *   if right with length
	 *     if the abs is less than k, return true
	 * return false    
	 *   
	 * Time : O(n)
	 * Space : O(1)
	 */
	private boolean isDuplicateContainsAtK(int[] input, int k) {
		int left = 0, right;
		while (left < input.length - 1) {
			right = left + 1;
			while (right < input.length && input[right] != input[left] && Math.abs(right++ - left)<=k);
 			if (!(right >= input.length)){
				if (Math.abs(left - right) <= k) return true;
 			}
			left++;
		}
		return false;
	}
	
	/* Pseudocode - Using HashMap
	 * Create a HashMap
	 *  Iterate the input
	 *   if the current element is not in map
	 *   	Add to map
	 *   else get the previous count find its difference if its less than equal k return true
	 * Return false;
	 *  
	 * 
	 * 
	 */
	
	private boolean isDuplicateContainsAtKUsingMap(int[] input, int k) {
		Map<Integer, Integer> inputMap = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			if (!inputMap.isEmpty() && inputMap.containsKey(input[i])) {
				if (Math.abs(i - inputMap.get(input[i])) <= k)
					return true;
				inputMap.put(input[i], i);
			}
			else inputMap.put(input[i], i);
		}
		return false;
	}
}
