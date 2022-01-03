package undef;

import org.junit.Assert;
import org.junit.Test;

public class P62_CharacterReprogramming {
	
	/* A control device has 4 buttons U,D,L,R. Their movement needs to be reduced
	 * by deleting unnecessary movements
	 * 
	 */
	
	/*
	 * 
	 * 1. 
    Input(s)? String
    Output ?  int
    Constraints ?  Time Optimized

	2. Test data set
	
	        Positive : URDR
	        Negative : UUUU
	        Edge     : LULURRDDR
	
	3. Known Approaches
	        Approach 1 :Bruteforce 
	
	4. O-Notations

5. Pseudocode
	 */
	
	@Test
	public void testData01(){            // Positive
		String input = "URDR";
		Assert.assertTrue(getMaxDeletion(input)==2);
	}


	@Test
	public void testData02(){			 // Negative
		String input = "UUUU";
		Assert.assertTrue(getMaxDeletion(input)==0);
	}

	@Test
	public void testData03(){			 // Edge
		String input = "LULURRDDR";
		Assert.assertTrue(getMaxDeletion(input)==8);
	}
	
	@Test
	public void testData04(){			 // Edge
		String input = "UDRLRRRLLLL";
		Assert.assertTrue(getMaxDeletion(input)==10);
	}
	
	/* 
	 * Create a variable count as 0 
	 * Iterate the input
	 *  If the current element in D,L add -1 to the count
	 *  If the current element in U,R add  1 to the count
	 * If the count == input length return 0 else return length - count
	 * Time : O(n)
	 * Space : O(1)
	 */

	private int getMaxDeletion(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == 'U'|| input.charAt(i) == 'R' ) count += 1;
			else count -= 1;
		}
		count = Math.abs(count);
		return input.length()-count;
	}

}
