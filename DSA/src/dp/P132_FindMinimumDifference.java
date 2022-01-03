package dp;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P132_FindMinimumDifference {
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
		int[] input = {1,2,3,4,5};
		assertTrue(findMinDiff(input)==1);	
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,2,3,4,5,6,7};
		assertTrue(findMinDiff(input)==0);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {1};
		assertTrue(findMinDiff(input)==1);
	}
	
	/* Find the sum of values in input using n * (n+1) / 2
	 * return sum % 2
	 * 
	 * 
	 * 
	 */
	
	private int findMinDiff(int[] input) {
	    int sum = (input.length * (input.length + 1))/2;
		return sum%2;
	}
}
