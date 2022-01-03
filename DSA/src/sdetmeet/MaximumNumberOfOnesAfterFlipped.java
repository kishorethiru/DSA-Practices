package sdetmeet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class MaximumNumberOfOnesAfterFlipped {
	/*
		Problem Statement
		Given a binary array nums and an integer k, return the maximum number of
		consecutive 1's in the array if you can flip at most k 0's.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int 
		  Output ? int
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive : [1,1,1,0,0,0,1,1,1,1,0], k = 2
			Edge : [1,1,1,0,0,0,1,1,1,1,0], k = 4	
			Edge     : [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
	
	   3.  Approaches Known 
			 Approach 1 : Brute force
			 Approach 2 : Sliding Window
	
	   4.  O - Notation 
			 Approach 1 : Brute force Time : O(n^2), Space : O(1)
			 Approach 2 : Sliding Window Time : O(n), Space : O(1)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,1,1,0,0,0,1,1,1,1,0};
		int  k  = 2;
		Assert.assertTrue(maxNumberOfOnes(input, k) == 6);
		Assert.assertTrue(maxNumberOfOnesSlidingWindow(input, k) == 6);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,1,1,0,0,0,1,1,1,1,0};
		int  k  = 4;
		Assert.assertTrue(maxNumberOfOnes(input, k) == 11);
		Assert.assertTrue(maxNumberOfOnesSlidingWindow(input, k) == 11);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int  k  = 3;
		Assert.assertTrue(maxNumberOfOnes(input, k) == 10);
		Assert.assertTrue(maxNumberOfOnesSlidingWindow(input, k) == 10);
	}
	
	/* 1.Initialize a variable count as 0
	 * 2.Iterate the input from i 
	 *    Iterate the input till k becomes zero or till end of array
	 *    compare and store the max
	 *    if max value == lenth break  
	 * 3. return count
	 * 
	 * Time : O(n^2)
	 * Space : O(1)
	 * 
	 */
	private int maxNumberOfOnes(int[] input, int k) {
		int count = 0;
		for(int i = 0; i < input.length; i++) {
			int temp = k;
			int j = i;
			while(j < input.length && temp >=0){
				if(input[j]==0 && temp > 0) {
					temp--;
				}
				else if(temp==0 && input[j]==0) break;
				j++;
			}
			count = Math.max(count, j-i);
			if(count==input.length) break;	
		}
		return count;
	}
	
	/* Initialize variable left as 0 and right as 0
	 * temp as k
	 * Itearate till right < input.length
	 *   if value in right is 0 && k > 0 decrement --
	 *   while(temp != 0 ) increment left and if left value is 0 increment left
	 *   find the max of right-left
	 * return max
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 * 
	 */
	private int maxNumberOfOnesSlidingWindow(int[] nums, int k) {
		int left = 0, right = 0, temp = k, max = 0;
		while(right < nums.length) {
			if(nums[right] == 0) temp--;
			while(temp<0) {
				if(nums[left] == 0) temp++;
				left++;
			}
			max = Math.max(max, right-left+1);
			right++;
		}
		return max;
	}
}
