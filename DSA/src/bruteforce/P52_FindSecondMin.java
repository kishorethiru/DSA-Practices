package bruteforce;

import org.junit.Assert;
import org.junit.Test;

public class P52_FindSecondMin {
	
	/* In the given array find the second min element
	 *  
	 */
	
	/*
	 *  1. 
    Input(s)? int[] 
    Output ?  int
    Constraints ?  No inbuild sorting should be used 

	2. Test data set
	
	        Positive : [2,3,4,1]
	        Negative : [1,1,1,1]
	        Edge     : [-1,-2,-4,0]
	
	3. Known Approaches
	        Approach 1 :Swapping Technique 
	
	4. O-Notations
			Approach 1 :Swapping Technique - Time O(n), Space O(1)
	5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {2,3,4,1};
		Assert.assertTrue(findSecondMin(input)==2);
	}


	@Test(expected = RuntimeException.class)
	public void testData02(){			 // Negative
		int[] input = {1,1,1,1};
		Assert.assertTrue(findSecondMin(input)==1);
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {-1,-2,-4,0};
		Assert.assertTrue(findSecondMin(input)==-2);
	}
	
	@Test
	public void testData04(){			 // Edge
		int[] input = {8,9,2,3,5,6,7,10,11,14,13};
		Assert.assertTrue(findSecondMin(input)==3);
	}
	
	/* If input length is 1 return exception
	 * Initialize two variables min and secondMin
	 * Iterate the input from 2,
	 *  if current element is smaller then max, assign min to secondMin and min as currentElement
	 *  else if current element is < secondSum Update second min
	 * Check if both min and secondMin are same, if yes throw exception
	 * return secondMin 
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */

	private int findSecondMin(int[] input) {
		if (input.length < 2)
			throw new RuntimeException("Invalid Input");
		int min = Math.min(input[0], input[1]);
		int secondMin = Math.max(input[0], input[1]);
		for (int i = 2; i < input.length; i++) {
			if (input[i] < min) {
				secondMin = min;
				min = input[i];
			} else if (secondMin > input[i])
				secondMin = input[i];
		}
		if (min == secondMin)
			throw new RuntimeException("Invalid Input");
		return secondMin;
	}
	
}
