package sdetmeet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class SearchInRotatedArray {
	/*
		Problem Statement
		There is an integer array nums sorted in ascending order (with distinct values).
		Prior to being passed to your function, nums is rotated at an unknown pivot index
		 k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
		Given the array nums after the rotation and an integer target, 
		return the index of target if it is in nums, or -1 if it is not in nums.
		You must write an algorithm with O(log n) runtime complexity.

		Example 1:
		
		Input: nums = [4,5,6,7,0,1,2], target = 0
		Output: 4
		Example 2:
		
		Input: nums = [4,5,6,7,0,1,2], target = 3
		Output: -1
		Example 3:
		
		Input: nums = [1], target = 0
		Output: -1
			
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int
		  Output ? int
		  Constraint(s) ? O(log n) runtime complexity.
	   
	   2. Test data
			Positive :  nums = [4,5,6,7,0,1,2], target = 0
			Negative :	[4,5,6,7,0,1,2], target = 3
			Edge     :  []
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {4,5,6,7,0,1,2};
		int target = 0;
		Assert.assertTrue(findIndex(input, target) == 4);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {4,5,6,7,0,1,2};
		int target = 3;
		Assert.assertTrue(findIndex(input, target) == -1);
	}	

	@Test
	public void testData03() { // Edge
		int[] input = {1,2,3,4,5,6,7,8,9,0};
		int target = 9;
		Assert.assertTrue(findIndex(input, target) == 8);
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {5,1,2,3,4};
		int target = 5;
		Assert.assertTrue(findIndex(input, target) == 0);
	}


	/* 1.If input.length == 1, if nums[0] == target return 0 else -1
	 * 2.Initialize low as 0, high as input.length - 1
	 * 3.Iterate till low<=high 
		 *  a)Find mid point
		 *  b) if mid value  == target return mid
		 *  c) if (low and mid range values are sorted)
		 *     	Check if the value lies in between the range the move high = mid-1
		 *     	else low =  mid +1
		 *  d) if un sorted 
		 *     	check if the value lies between mid and high if yes low = mid+1
		 *     	else high = mid-1
	 * 4. return -1  
	 * Time : O(log n)
	 * Space : O(1)
	 */
	private int findIndex(int[] input, int target) {
		if(input.length == 1) return input[0] == target ? 0 : -1;
		int low = 0, high = input.length - 1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(input[mid] == target) return mid;
			if(input[low]<=input[mid]) {// sorted
				if(target >= input[low] && input[mid]>target) high = mid-1;
				else low = mid+1;
			}
			else { // unsorted
				if(input[mid] < target && input[high]>=target)low = mid+1; 
				else high = mid-1;
			}			
		}
		return -1;
	}
}
