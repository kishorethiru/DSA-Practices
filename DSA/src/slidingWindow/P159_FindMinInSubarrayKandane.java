package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class P159_FindMinInSubarrayKandane {
	
	@Test
	public void testData01(){            // Positive
		int[] input = {-3,2,5,-1};
		Assert.assertTrue(findMinInSubarrayKandane(input) == -3);
	}

	@Test
	public void testData02(){			 // Negative
		int[] input = {3,2,-5,0};
		Assert.assertTrue(findMinInSubarrayKandane(input) == -5);
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {-3,-2,-5,-1};
		Assert.assertTrue(findMinInSubarrayKandane(input) == -11);
	}
	
	/* 
	 * Initialize windowSum and maxSum as firstELement in input
	 * Iterate the input
	 *  	Find the windowSum between windowSum + currentIndex value and currentIndex value
	 *  	Find the minSum between windowSum and minSum
	 * Return minSum 
	 * Time : O(n)
	 * Space : O(1)
	 */
	private int findMinInSubarrayKandane(int[] input) {
		if(input.length == 0) throw new RuntimeException("Invalid input");
		int windowSum = input[0], minSum = input[0];
		for (int i = 1; i < input.length; i++) {
			windowSum = Math.min(windowSum+input[i], input[i]);
			minSum   = Math.min(minSum, windowSum);
		}
		return minSum;
		
	}
}
