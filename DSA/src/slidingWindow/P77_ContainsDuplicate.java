package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P77_ContainsDuplicate {
	/*
		Problem Statement
		Given an integer array nums and two integers k and t, return true if 
		there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t 
		and abs(i - j) <= k
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int, int
		  Output ? boolean
		  Constraint(s) ?
	   
	   2. Test data
			Positive :	1,2,3,1], k = 3, t = 0
			Negative :	[1,5,9,1,5,9], k = 2, t = 3
			Edge     : [1,0,1,1], k = 1, t = 2
			Edge     : [-2147483648,2147483647]1, 1
	
	   3.  Approaches :  
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int[] input = {1,2,3,1};
		int k = 3, t = 0;
		Assert.assertTrue(containsNearbyAlmostDuplicate(input,t,k));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,5,9,1,5,9};
		int k = 2, t = 3;
		Assert.assertTrue(containsNearbyAlmostDuplicate(input,t,k));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {1,0,1,1};
		int k = 1, t = 2;
		Assert.assertTrue(containsNearbyAlmostDuplicate(input,t,k));
	}
	@Test
	public void testData04() { // Edge
		int[] input = {-2147483648,2147483647};
		int k = 1, t = 1;
		Assert.assertTrue(containsNearbyAlmostDuplicate(input,t,k));
	}

	private boolean containsNearbyAlmostDuplicate(int[] nums, int t, int k) {
		int left = 0, right;
		while (left < nums.length - 1) {
			right = left + 1;
			while (right < nums.length && Math.abs(nums[left] - nums[right]) > t) {
				right++;
			}
			if (!(right >= nums.length)) {
				if (Math.abs(left - right) <= k)
					return true;
			}
			left++;
		}
		return false;
	}
}
