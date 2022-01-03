package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class P175_FindIndexOfTargetInRotationalArray {
	
	/*Given the array nums after the rotation and an integer target, 
	 * return the index of target if it is in nums, or -1 if it is not in nums.
	You must write an algorithm with O(log n) runtime complexity.
 
	Example 1:
	
	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
	 * 
	 */
	
	/*	1. 
	    Input(s)? int[], int
	    Output ? int
	    Constraints ? time O(log n)  
	
		2. Test data set
		
		        Positive : [4,5,6,7,0,1,2], target = 0
		        Negative : [4,5,6,7,0,1,2], target = 3
		        Edge     : [5,6,7,8,0,1,2,3,4] target = 7
		
		3. Approaches
		        Approach 1 : Bruteforce
		        Approach 2 : Two Pointers
		        Approach 3 : Binary Search
		
		4. O-Notations
				Approach 1 : Bruteforce - Time O(n)
		        Approach 2 : Two Pointers - Time O(n/2)
		        Approach 3 : Binary Search - Time O(log n)
		
		5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		Assert.assertTrue(findTargetOfIndexBS(nums,target)==4);
	}


	@Test
	public void testData02(){			 // Negative
		int[] nums = {4,5,6,7,0,1,2};
		int target = 3;
		Assert.assertTrue(findTargetOfIndexBS(nums,target)==-1);
	}

	@Test
	public void testData03(){			 // Edge
		int[] nums = {5,6,7,8,0,1,2,3,4};
		int target = 2;
		Assert.assertTrue(findTargetOfIndexBS(nums,target)==6);
	}
	
	@Test
	public void testData04(){			 // Edge
		int[] nums = {5,6,7,8,0,1,2,3,4};
		int target = 7;
		Assert.assertTrue(findTargetOfIndexBS(nums,target)== 2);
	}
	
	@Test
	public void testData05(){			 // Edge
		int[] nums = {2,3,0,1};
		int target = 2;
		Assert.assertTrue(findTargetOfIndexBS(nums,target)== 0);
	}

	
	/* Initialize low as 0 and high as nums.length - 1 
	   Iterate the input till low crosses high
	   	Find the midpoint
		check if midpoint value equals target then return midpoint
		check if low and mid range is sorted 
	   		check if target within range high = mid -1
	   		if not low = mid +1
	   	if not,check if target is within range of mid and high low = mid +1
	   		if not high = mid -1
	   return -1
	   Time : O(log n)
	   Space :O(1)
	 * 
	 */
	private int findTargetOfIndexBS(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==target) return mid; 
			if(nums[low]<=nums[mid]) // Range is sorted
				if(nums[low] <= target  && nums[mid] > target ) high =mid-1;
				else low = mid+1;
			else
				if(nums[mid] < target && nums[high] >= target) low = mid +1;
				else high = mid-1;
		}
		return -1;
	}

}
