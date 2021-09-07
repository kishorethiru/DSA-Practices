package slidingWindow;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P128_FindMaxSubarrayofLessThanK {
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
		int[] input = {1,7,4,2,8,11,3};
		int k =16;
		Assert.assertTrue(Arrays.equals(findMaxSubarray(input, k),new int[]{1,7,4,2}));
		Assert.assertTrue(Arrays.equals(findMaxSubarraySlidingWindow(input, k),new int[]{1,7,4,2}));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,7,4,2,-11,3};
		int k =16;
		Assert.assertTrue(Arrays.equals(findMaxSubarray(input, k),new int[]{1, 7, 4, 2, -11, 3}));
		Assert.assertTrue(Arrays.equals(findMaxSubarraySlidingWindow(input, k),new int[]{1, 7, 4, 2, -11, 3}));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {1,-7,4,-2,5,3};
		int k = 3;
		Assert.assertTrue(Arrays.equals(findMaxSubarray(input, k),new int[]{1,-7,4,-2,5}));
		Assert.assertTrue(Arrays.equals(findMaxSubarraySlidingWindow(input, k),new int[]{1,-7,4,-2,5}));
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {1,7,4,2,7,11,3};
		int k = 21;
		Assert.assertTrue(Arrays.equals(findMaxSubarray(input, k),new int[]{1, 7, 4, 2}));
		Assert.assertTrue(Arrays.equals(findMaxSubarraySlidingWindow(input, k),new int[]{1, 7, 4, 2}));
	}
	
	
	private int[] findMaxSubarray(int[] input, int k) {
		int max = 0, startIndex = 0, endIndex = 0;
		for(int i = 0; i < input.length;i++) {
			int currentSum = input[i];
			for(int j = 0; j < input.length;j++) {
				currentSum += input[j];
				if(currentSum < k && max < (j-i+1)) {
					max = j-i+1;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		return Arrays.copyOfRange(input, startIndex, endIndex+1);
	}
	
	private int[] findMaxSubarraySlidingWindow(int[] input, int k) {
		int max = 0, startIndex = 0, endIndex = 0;
		int currentSum = 0;
		for(int i = 0; i < input.length;i++) {
			currentSum += input[i];
			if(currentSum < k && max < (i+1)) {
				max = i+1;
				startIndex = 0;
				endIndex = i;
			}	
		}
		currentSum -= input[0]; 
		for(int i=1, j = input.length-1; i <input.length; i++) {
			currentSum -= input[i];
			if(currentSum < k && max < (i-j)+1) {
				startIndex = i;
				endIndex = j;
			}	
		}
		return Arrays.copyOfRange(input, startIndex, endIndex+1);
	}
}
