package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class P40_FindNoOfOnes {
	
	/* 
	 * Given a sorted array find the number of ones in the array
	 * [0,1,1,1,1,1] output = 5
	 * [0,0,0,0,0] output = 0
	 * [0,0,0,0,0,1] output = 1
	 */
	/*	1. 
    Input(s)? int[]
    Output ? int
    Constraints ? Time  

	2. Test data set
	
	        Positive : [0,1,1,1,1,1] output = 5
	        Negative : [0,0,0,0,0] output = 0
	        Edge     : [0,0,0,0,0,1] output = 1
	
	3. Known Approaches
	        Approach 1 : Bruteforce 
	        Approach 2 : Two Ptr
	
	4. O-Notations
	
	5. Pseudocode
	 * 
	 */
	@Test
	public void testData01(){            // Positive
		int[] nums = {0,1,1,1,1,1};
		Assert.assertTrue(findNumberOfOnes(nums)==5);
		Assert.assertTrue(findNumberOfOnesTwoPtr(nums)==5);
		Assert.assertTrue(findNumberOfOnesBS(nums)==5);
	}


	@Test
	public void testData02(){			 // Negative
		int[] nums = {0,0,0,0,0};
		Assert.assertTrue(findNumberOfOnes(nums)==0);
		Assert.assertTrue(findNumberOfOnesTwoPtr(nums)==0);
		Assert.assertTrue(findNumberOfOnesBS(nums)==0);
	}

	@Test
	public void testData03(){			 // Edge
		int[] nums = {0,0,0,0,0,0,1};
		Assert.assertTrue(findNumberOfOnes(nums)==1);
		Assert.assertTrue(findNumberOfOnesTwoPtr(nums)==1);
		Assert.assertTrue(findNumberOfOnesBS(nums)==1);
	}
	@Test
	public void testData04(){			 // Edge
		int[] nums = {1,1,1,1,1,1,1};
		Assert.assertTrue(findNumberOfOnes(nums)==7);
		Assert.assertTrue(findNumberOfOnesTwoPtr(nums)==7);
		Assert.assertTrue(findNumberOfOnesBS(nums)==7);
	}
	
	/* Pseudocode - Bruteforce
	 * Iterate the array 
	 *   if current element is 1, find the diff of length and i and return
	 * return 0 
	 * Time : O(n)
	 * Space : O(1)
	 */
	
	private int findNumberOfOnes(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				return nums.length - i;
		}
		return 0;
	}
	
	/* Pseudocode - Two Pointers
	 * Initialize left as 0, right as length -1
	 * Iterate till left < right
	 *   if left element is 1, return length - left
	 *   if right element is 0, return length-right-1
	 *   increment left decrement right
	 * return 0  
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */
	private int findNumberOfOnesTwoPtr(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (nums[left] == 1)
				return nums.length - left;
			if (nums[right] == 0)
				return nums.length - right - 1;
			left++;
			right--;
		}
		return 0;
	}
	
	/* Pseudocode - Binary Search
	 * Initialize low and high as length -1
	 * Iterate till low crosses high
	 *  find midpoint 
	 *  if midpoint = 1 and mid -1 value = 0 return length - mid
	 *  if(mid value = 0) low = mid+1
	 *  else high + 1
	 * return length-low 
	 * Time : O(log n)
	 * Space : O(1) 
	 * 
	 */
	
	private int findNumberOfOnesBS(int[] nums) {
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==1 && mid-1<0) return nums.length-mid;
			else if (nums[mid]==1 && nums[mid-1]==0)return nums.length-mid;
			if(nums[mid]==0)low = mid+1;
			else high = mid-1;
		}
		return nums.length-low;
	}
	
	
	
	

}
