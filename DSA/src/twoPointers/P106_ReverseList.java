package twoPointers;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P106_ReverseList {
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
		Assert.assertTrue(reverseIntegerList(Arrays.asList(2,4,3,5)).equals(Arrays.asList(5,3,4,2)));
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue(reverseIntegerList(Arrays.asList(2,4,3,5,1)).equals(Arrays.asList(1,5,3,4,2)));
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(reverseIntegerList(Arrays.asList(2,4)).equals(Arrays.asList(4,2)));
	}

	
	/* initialize left as 0  and right as n-1;
	 * Iterate till left<right
	 *   Swap right and left index using temp
	 * return input
	 * Time - O(n/2)
	 * Space - O(1)
	 */
	private List<Integer> reverseIntegerList(List<Integer> input) {
		int left = 0, right = input.size()-1;
		while(left<right) {
			int temp = input.get(left);
			input.set(left++, input.get(right));
			input.set(right--, temp);
		}
		return input;
	}
}
