package slidingWindow;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class SlidingWindowMaximum {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
		  Constraint(s) ?
	   
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

		int[] input = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		maxSlidingWindow(input,k);
//		Assert.assertTrue();
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		int index = 0;
		int[] op = new int[nums.length];
		int left = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			max = Math.max(max, nums[i]);
			left++;
		}
		op[index++] = max;
		while (left <= nums.length - 1) {
			if (max > nums[left-k]) {
				max = Math.max(max, nums[left]);
				op[index++] = max;
			} else {
				int i = left - k+1;
				max = Integer.MIN_VALUE;
				for (; i <= left; i++)
					max = Math.max(max, nums[i]);
				op[index++] = max;
			}
			left++;
		}
		return Arrays.copyOf(op, index);

	}
}
