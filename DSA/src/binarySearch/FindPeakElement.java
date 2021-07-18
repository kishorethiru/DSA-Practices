package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class FindPeakElement {
	/*
	 * A peak element is an element that is strictly greater than its neighbors.

		Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
		
		You may imagine that nums[-1] = nums[n] = -∞.
		
		You must write an algorithm that runs in O(log n) time.
		
		 
		
		Example 1:
		
		Input: nums = [1,2,3,1]
		Output: 2
		Explanation: 3 is a peak element and your function should return the index number 2.
		Example 2:
		
		Input: nums = [1,2,1,3,5,6,4]
		Output: 5
		Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
	 * 
	 */
	
	/*
	 * 1. 
		    Input(s)? int[] 
		    Output ? int
		    Constraints ? less than O(n)  

		2. Test data set
		
		        Positive : 1,2,3,1
		        Negative : 1,1,1,1
		        Edge     : 1,2,1,3,5,6,4
		
		3. Known Approaches
		        Approach 1 :Bruteforce 
		        Approach 2 : Binary Search
		
		4. O-Notations
		
		5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {1,2,3,1};
		Assert.assertTrue(findPeakElement(input) == 2);
	}


	@Test
	public void testData02(){			 // Negative
		int[] input = {1,1,1,1};
		Assert.assertTrue(findPeakElement(input)== -1);
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {1,2,1,3,5,6,4};
		Assert.assertTrue(findPeakElement(input) == 5);
	}


	private int findPeakElement(int[] input) {
		int low = 0, high = input.length-1;
		while(low < high)
		{
			int mid = (low+high)/2;
			if(input[mid]>input[mid+1]) high = mid;
			else low =mid+1;
			
		}
			
		return (low == input.length-1) ? -1: low;
	}
}
