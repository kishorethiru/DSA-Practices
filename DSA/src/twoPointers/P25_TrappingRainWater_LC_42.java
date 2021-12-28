package twoPointers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P25_TrappingRainWater_LC_42 {
	/*
	 * https://leetcode.com/problems/trapping-rain-water/
	 * 42. Trapping Rain Water
		Problem Statement
			Given n non-negative integers representing an elevation map where the 
			width of each bar is 1, compute how much water it can trap after raining.
		
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[]  
		  Output ? int
		  Constraint(s) ? Optimized
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
				Approach 1 : BruteForce
				Approach 2 : PrefixSuffix
				Approach 3 : Two Ptrs
	   4.  O - Notation 
			 	Approach 1 : BruteForce  - Time : O(n^2) Space : O(1)
				Approach 2 : PrefixSuffix- Time : O(3n) Space : O(n)
				Approach 3 : Two Ptrs    - Time : O(n) Space : O(1)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		Assert.assertTrue(trappingRainWaterBruteforce(input)==6);
		Assert.assertTrue(trappingRainWaterPrefixSuffix(input)==6);
		Assert.assertTrue(trappingRainWaterTwoPtr(input)==6);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,1,1,1,1,1,1,1,1};
		Assert.assertTrue(trappingRainWaterBruteforce(input)==0);
		Assert.assertTrue(trappingRainWaterPrefixSuffix(input)==0);
		Assert.assertTrue(trappingRainWaterTwoPtr(input)==0);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {4,2,0,3,2,5};
		Assert.assertTrue(trappingRainWaterBruteforce(input)==9);
		Assert.assertTrue(trappingRainWaterPrefixSuffix(input)==9);
		Assert.assertTrue(trappingRainWaterTwoPtr(input)==9);
	}
	
	/* Pseudocode - Bruteforce
	 * Initialize a variable count as 0
	 * Iterate the input from 1 to n-1
	 *   for the current index find the rightmax - iterate till right end including current index value
	 *   for the current index find the left - iterate till left end including current index value
	 *   find the minimum of the both and subtract current index value - add to count
	 * return count
	 * Time : O(n^2)
	 * Space : O(1)
	 */
	private int trappingRainWaterBruteforce(int[] input){
		int count = 0;
		for (int i = 1; i < input.length-1; i++) {
			// finding right max
			int rightMax = 0;
			int leftMax = 0;
			for(int j = i; j<input.length;j++) {
				rightMax = Math.max(rightMax, input[j]);
			}
			for(int j = i; j>=0;j--) {
				leftMax = Math.max(leftMax, input[j]);
			}
			count += Math.min(rightMax, leftMax) - input[i];
		}
		return count;
	}
	
	/* Pseudocode -PrefixSuffix Sum
	 * Create two array as prefix and suffix 
	 * Iterate the array from 0 to n
	 *  compare the currentValue and max value update max value and push to current index. 
	 * Iterate the array from n to 0
	 *  compare the currentValue and max value update max value and push to current index.
	 * Iterate the input
	 *   For the current index find the min of both in prefix and suffix and subtract current index value
	 *   and add to count
	 * return count
	 * Time : O(3n) -> O(n)
	 * Space : O(2n) -> O(n)
	 */
	private int trappingRainWaterPrefixSuffix(int[] input){
		int count = 0;
		int[] prefixVal = new int[input.length];
		int[] suffixVal = new int[input.length];
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			max = Math.max(max, input[i]);
			prefixVal[i] = max ;
		}
		max = 0;
		for (int i = input.length-1; i >= 0; i--) {
			max = Math.max(max, input[i]);
			suffixVal[i] = max;
		}
		for (int i = 0; i < input.length; i++) {
			count += Math.min(prefixVal[i], suffixVal[i])-input[i];
		}
		return count;
	}
	
	/* Initialize two pointer left and right
	 * Initialize variables as leftMax, rightMax and count
	 * Iterate till left<right
	 *    findLmax and update it
	 *    find max and update it
	 *    lmax< rMax - Get the diff between lmax and current left value and add to count
	 *    else get rmax diff and add to count
	 * return count
	 * 
	 *  Time : O(n)
	 *  Space : O(n)
	 *  
	 */
	private int trappingRainWaterTwoPtr(int[] input) {
		int left = 0, right = input.length - 1;
		int count = 0;
		int leftMax = 0, rightMax = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, input[left]);
			rightMax = Math.max(rightMax, input[right]);
			if (leftMax < rightMax)
				count += leftMax - input[left++];
			else
				count += rightMax - input[right--];
		}
		return count;
	}
}
