package singlepassanddp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P142_FindMissingSmallestPositiveNumber {
	/*
		Problem Statement
		
		Given array of integer, find the smallest missing positive number 
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : {}
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int[] input = {2,7,8,9,4,3};
		Assert.assertTrue(findSmallestMissingNumber(input)==1);
		Assert.assertTrue(findSmallestMissingNumberUsingSet(input)==1);
	}

	@Test(expected = RuntimeException.class)
	public void testData02() { // Negative
		int[] input = {1,2,3,4};
		Assert.assertTrue(findSmallestMissingNumber(input) == 1);
		Assert.assertTrue(findSmallestMissingNumberUsingSet(input)==1);
	}
	
	@Test
	public void testData03() { // Edge
		int[] input = {-4,-3,-2,1,2,3,4,5,5,7};
		Assert.assertTrue(findSmallestMissingNumber(input) ==6);
		Assert.assertTrue(findSmallestMissingNumberUsingSet(input)==6);
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {-4,-3,-2,2,3,4,5,6,7};
		Assert.assertTrue(findSmallestMissingNumber(input) ==1);
		Assert.assertTrue(findSmallestMissingNumberUsingSet(input)==1);

	}

	/**
	 * @param input
	 * @return
	 */
	
	/* 
	 * Time - O(nlogn) + O(n) + O(n) -> O(nlogn)
	 * Space - O(n)
	 *  
	 */
	private int findSmallestMissingNumber(int[] input) {
		Arrays.sort(input);
		if (input[0] > 1)
			return 1;
		if (input[input.length - 1] <= 0)
			throw new RuntimeException("No positive missing element");
		int[] checkArr = null;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > 0) {
				checkArr = Arrays.copyOfRange(input, i, input.length);
				break;
			}
		}
		if (checkArr[0] > 1)
			return 1;
		for (int i = 1; i < checkArr.length; i++) {
			if (checkArr[i] - checkArr[i - 1] > 1) {
				return checkArr[i - 1] + 1;
			}
		}
		throw new RuntimeException("No positive missing element");
	}
	
	/* Create a hashset
	 * Create min and max values
	 * Add the positive items to the set, find min and max
	 * If min is greater than 1 return 1
	 * Iterate till min reaches max
	 *   if set not contains min+1 return min+1
	 *   increment min
	 * return max + 1
	 * 
	 * Time : O(2n) => O(n)
	 * Space : O(n)
	 */
	
	private int findSmallestMissingNumberUsingSet(int[] input) {
		Set<Integer> inputSet = new HashSet<>();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int eachVal : input) {
			if(eachVal > 0) {
			min = Math.min(eachVal, min);
			max = Math.max(eachVal, max);
			inputSet.add(eachVal);
			}	
		}
		if(min > 1) return 1;
		while(min<max) {
			if(!inputSet.contains(min+1)) return min+1;
			min++;
		}
		return max+1;
	}
}
