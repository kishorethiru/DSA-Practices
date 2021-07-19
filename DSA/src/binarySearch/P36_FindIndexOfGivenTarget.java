package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class P36_FindIndexOfGivenTarget {
	/*
	 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0
	 */
	
	
	
	
	@Test
	public void testData01(){            // Positive
		int[] nums = {1,3,5,6};
		int k = 5;
		Assert.assertTrue(findIndexOfK(nums,k)== 2);
	}


	@Test
	public void testData02(){			 // Negative
		int[] nums = {1,3,5,6};
		int k = 2;
		Assert.assertTrue(findIndexOfK(nums,k)== 1);
	}

	@Test
	public void testData03(){			 // Edge
		int[] nums = {1,3,5,6};
		int k = 7;
		Assert.assertTrue(findIndexOfK(nums,k)== 4);
	}
	
	@Test
	public void testData04(){			 // Edge
		int[] nums = {1,3,5,6,7};
		int k = 4;
		Assert.assertTrue(findIndexOfK(nums,k)== 2);
	}

	/* Initialize low as 0 and high as length -1
	 * Iterate the input till low crosses high
	 *  find mid if mid value  == target return mid
	 *  if mid value > target high = mid-1
	 *  else low = mid+1
	 * return low;
	 *  
	 * 
	 */
	private int findIndexOfK(int[] nums, int k) {
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==k) return mid;
			if(nums[mid] > k) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

}
