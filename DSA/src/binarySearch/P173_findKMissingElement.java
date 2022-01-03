package binarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P173_findKMissingElement {
	
	/*Given an array arr of positive integers sorted in a 
	 * strictly increasing order, and an integer k. Find the 
	 * kth positive integer that is missing from this array.
 
			Example 1:
			
			Input: arr = [2,3,4,7,11], k = 5
			Output: 9
			Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
			
			Example 2:
			
			Input: arr = [1,2,3,4], k = 2
			Output: 6
			Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

	 * 
	 */
	
	/*
	 * 1. 
    Input(s)? int[] , int
    Output ? int
    Constraints ? No Constraints  

	2. Test data set
	
	        Positive : [2,3,4,7,11], k = 5
	        Negative :  [2,3,4,7,11], k = -1 
	        Edge     : [1,2,3,4], k = 2
	
	3. Known Approaches
	        Approach 1 :Bruteforce 
	
	4. O-Notations
	
	5. Pseudocode
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {2,3,4,7,11};
		int k = 5;
		Assert.assertTrue(findKMissingElementBS(input,k)==9);
	}


	@Test
	public void testData02(){			 // Negative
		int[] input = {2,3,4,7,11};
		int k = 6;
		Assert.assertTrue(findKMissingElementBS(input,k)==10);
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {1,2,3,4};
		int k = 3;
		Assert.assertTrue(findKMissingElementBS(input,k)==7);
	}
	@Test
	public void testData04(){			 // Edge
		int[] input = {1,2,3,4};
		int k = 10;
		Assert.assertTrue(findKMissingElementBS(input,k) == 14);
	}

    /* 
     * Create a list 
     * Iterate from 1 to input lenght  + k
     *   Add the index to the k
     * Iterate the input
     *   Remove the current value from the list
     * return the kth value from list 
     * Time : O(n) + O(n) => O(n)
     * Space : O(n)
     */
	private int findKMissingElement(int[] input, int k) {
		List<Integer> numList =  new ArrayList<>();
		for (int i = 1; i <= input.length+k; i++) {
			numList.add(i);
		}
		for (int i = 0; i < input.length; i++) {
			Integer removeValue = input[i];
			numList.remove(removeValue);
		}
		int res = numList.get(k-1);
		return res;
	}
	
	/*
	 * Initialize two variables low as 0 and high as input length -1
	 * Iterate input till low crosses high
	 *    find mid point
	 *    if mid value - mid -1 < k, low = mid+1
	 *    else high = mid+1
	 * return low+k+1
	 * Time : O(log n)
	 * Space :O(1)
	 */
	
	private int findKMissingElementBS(int[] input, int k) {
		int low = 0, high = input.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if((input[mid] -mid-1) < k) low = mid+1;
			else high = mid-1;	
		}
		return high+k+1;
	}

	
	
}
