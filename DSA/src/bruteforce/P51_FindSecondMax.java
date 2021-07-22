package bruteforce;

import org.junit.Assert;
import org.junit.Test;

public class P51_FindSecondMax {
	
	/* In the given array find the second max element
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
	
	5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {2,3,4,1};
		Assert.assertTrue(findSecondMax(input)==3);
	}


	@Test(expected = RuntimeException.class)
	public void testData02(){			 // Negative
		int[] input = {1,1,1,1};
		Assert.assertTrue(findSecondMax(input)==1);
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {-1,-2,-4,0};
		Assert.assertTrue(findSecondMax(input)==-1);
	}
	
	@Test
	public void testData04(){			 // Edge
		int[] input = {8,9,2,3,5,6,7,10,11,14,13};
		Assert.assertTrue(findSecondMax(input)==13);
	}
	
	/* If input length is 1 return exception
	 * Initialize two variables max and secondSum
	 * Iterate the input from 2,
	 *  if current element is greater then max, assign max to secondSum and max as currentElement
	 *  else if current element is > secondSum Update second sum
	 * Check if both max and secondSum are same, if yes throw exception
	 * return secondSum 
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */

	private int findSecondMax(int[] input) {
		if (input.length < 2)
			throw new RuntimeException("Invalid Input");
		int max = input[0], secondMax = input[1];
		max = Math.max(max, secondMax);
		secondMax = Math.min(max, secondMax);
		for (int i = 2; i < input.length; i++) {
			if (input[i] > max) {
				secondMax = max;
				max = input[i];
			} else if (secondMax < input[i])
				secondMax = input[i];
		}
		if (max == secondMax)
			throw new RuntimeException("Invalid Input");
		return secondMax;
	}
	
}
