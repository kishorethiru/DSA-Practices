package recursion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P127_FindNoOfOnes {
	/*
		Problem Statement
		Given the int[] containing 0's and 1's in the unsorted manner.
		Find the count of 1's in the array
		
		1. n <= 0 
		2. [0,1,1] 2,1,0
		3. 
	
	*/

	/*
	   1. 
	  	  Input(s) ? int 
		  Output ? int
		  Constraint(s) ? Use recursion
	   
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

		int input = 1011;
		Assert.assertTrue(countOne(input) == 3);
	}

	@Test
	public void testData02() { // Negative
		int input = 0;
		Assert.assertTrue(countOne(input) == 0);
	}

	@Test
	public void testData03() { // Edge
		int input = 1011001111;
		Assert.assertTrue(countOne(input) == 7);
	}
	
	private int countOne(int input) {
		if (input == 0)
			return 0;
		return (input % 10) + countOne(input / 10);
	}
	
}
