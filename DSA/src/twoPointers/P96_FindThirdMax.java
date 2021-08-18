package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P96_FindThirdMax {
	/*
		Problem Statement
			Given integer array nums, return the third maximum number in this array.
			If the third maximum does not exist, return the maximum number.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? int
		  Constraint(s) ? O(n) and no sorting
	   
	   2. Test data
			Positive : 3,2,1
			Negative : 2,2,3,1	
			Edge     : -2147483648, 2, 1
	
	   3.  Approaches Known 
			 Approach 1 : Using two pass
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {3,2,1};
		Assert.assertTrue(findThirdMax(input)==1);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {2,2,3,1};
		Assert.assertTrue(findThirdMax(input)==1);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {-2147483648, 2, 1};
		Assert.assertTrue(findThirdMax(input)== -2147483648);
	}

	/* Pseudocode 
	 * 1.Create a variable max as MIN VALUE
	 * 2.Create a boolean as isMinValPresent as false.
	 * 3.Iterate the input and find the max value in it.
	 * 4.If inputLength is 2 return max
	 * 5.Create two more pointers as secondMax and thirdMax.
	 * 6.Iterate the input
	 *   a)if currentValue is lessThan max and greater than secondMax
	 *     - Assign secondMax to thirdMax
	 *     - secondMax as currentValue
	 *   b)else currentValue < secondMax and > thirdMax
	 *     - Assign thirdMax as currentValue.
	 *   c)if any current value has Integer.MIN_VALUE make as true
	 * 7.if thirdMax is still Integer.MIN_VALUE && isMinValPresent is false , return max
	 * 8.Check if secondMax == thirdMax return max else thirdMax
	 * 
	 * Time : O(2n) -> O(n)
	 * Space : O(1)
	 */
	private int findThirdMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		boolean isMinValPresent = false;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(nums[i], max);
		}
		if (nums.length == 2)
			return max;
		int secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == Integer.MIN_VALUE)
				isMinValPresent = true;
			if (nums[i] < max && nums[i] > secondMax) {
				thirdMax = secondMax;
				secondMax = nums[i];
			} else if (nums[i] < secondMax && nums[i] > thirdMax) {
				thirdMax = nums[i];
			}
		}
		if (thirdMax == Integer.MIN_VALUE && !isMinValPresent)
			return max;
		return (secondMax == thirdMax) ? max : thirdMax;
	}
	
	
}
