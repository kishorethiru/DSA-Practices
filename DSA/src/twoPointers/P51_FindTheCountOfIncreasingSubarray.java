package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P51_FindTheCountOfIncreasingSubarray {
	/*
		Problem Statement
		
		Count the number of strictly increasing subarray of a specified size k in an array of size N .
		Example 1:
		int[] nums = [ 5,3,5,7,8] and k=3 , 
		The answer is 2 as [3,5,7] and [5,7,8] are the sub arrays.
		Example 2:
		int[] nums = [ 5,3,5,7,8] and k=2 , 
		The answer is 3 as [3,5] and [5,7] and [7,8] are the sub arrays.
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int 
		  Output ? int
		  Constraint(s) ? Time Optimized 
	   
	   2. Test data
			Positive :
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
		int[] input = {5,3,5,7,8};
		int k = 3;
		Assert.assertTrue(findCountOfIncreasingSubarray(input,k)==2);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {5,4,3,2,1};
		int k = 2;
		Assert.assertTrue(findCountOfIncreasingSubarray(input,k) == 0);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {5,3,5,7,8};
		int k = 2;
		Assert.assertTrue(findCountOfIncreasingSubarray(input,k)==3);
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {5,3,5,7,8};
		int k = 6;
		Assert.assertTrue(findCountOfIncreasingSubarray(input,k)==0);
	}
	@Test
	public void testData05() { // Edge
		int[] input = {5,3,5,2,3,4};
		int k = 2;
		Assert.assertTrue(findCountOfIncreasingSubarray(input,k)==3);
	}
	// 5 Mins
	
	/*  
	 * 
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 * 
	 */
	private int findCountOfIncreasingSubarray(int[] nums, int k) {
		if(k > nums.length) return 0;
		if(k == 1) return nums.length;
		int count = 0, right;
		int counter = 1;
		for (right = 1; right < nums.length; right++) {
			if(nums[right]>nums[right-1]) {
				counter++;
			}
			else {
				if(counter>=k) {
				count += counter-(k-1);
				counter = 1;
				}
			}	
		}
		if(counter != 1)count += counter-(k-1);
		return count;
		
	}
	
	
}
