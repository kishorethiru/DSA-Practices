package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P158_IsOddPairsPresent {
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

		int[] input = {2,7,4,6,3,1};
		Assert.assertTrue(oddNumber(input));
//		int[] output = {};
//		Assert.assertTrue();
	}

	@Test
	public void testData02() { // Negative
		int[] input = {-1,1};
		Assert.assertFalse(oddNumber(input));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {-1,2};
		Assert.assertTrue(oddNumber(input));
	}
	
	private boolean isOddPairsPresent(int[] nums) {
		int oddCount = 0, evenCount = 0;
		for(int i : nums) {
			if(i%2 == 0) evenCount++;
			else oddCount++;
		}
//		if(oddCount % 2 != 0 && evenCount % 2 !=0) return true;
		return false;
	}
	
	public boolean oddNumber(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1)
            return false;
        // Initialize count of odd & even
        int odd_count = 0, even_count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                even_count++;
            else
                odd_count++;
        }
        // 3 -3
        if (even_count - odd_count == 0) {
            return true;
        }
        return false;
    }
	
}
