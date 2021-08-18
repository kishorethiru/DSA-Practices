package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P95_ContainerWithMostWater {
	/*
		Problem Statement
		Given n non-negative integers a1, a2, ..., an , where each represents a 
		point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
		of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis 
		forms a container, such that the container contains the most water.

		Notice that you may not slant the container.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? int
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive : 1,8,6,2,5,4,8,3,7
			Edge     : 1,2,1  	
			Edge     : 4,3,2,1,4
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,8,6,2,5,4,8,3,7};
		Assert.assertTrue(maxArea(input) == 49);
	}

	@Test
	public void testData02() { // Edge
		int[] input = {1,2,1};
		Assert.assertTrue(maxArea(input) == 2);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {4,3,2,1,4};
		Assert.assertTrue(maxArea(input) == 16);
	}
	
	/* Pseudocode - Two Pointers
	 * 1. Initialize two pointers left as 0 and right as length - 1.
	 * 2. Initialize a max variable as Integer min value.
	 * 3. Iterate till left < right
	 *    [To find area of rectangle which is the area of the container - L * B]
	 *    a) get the max value of left and right(B) multiple by right-left (L) and store as area
	 *    b) find the max of area and max
	 *    c) if left value <= right value, left++ else right--
	 * 4. return max 
	 */  
	
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int max = Integer.MIN_VALUE;
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			max = Math.max(area, max);
			if (height[left] <= height[right])
				left++;
			else
				right--;
		}
		return max;
	}
}
