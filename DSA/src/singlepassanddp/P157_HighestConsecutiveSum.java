package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

public class P157_HighestConsecutiveSum 
{
	/*
	 * Given an array of integers, 
	 * return the highest sum of any consecutive elements in the array.
	 * 
	 * int[] a = {1,-5,2,-3,7,1};
	 * 
	 */
	
//	1. 
//    Input(s)? int[]
//    Output ? int
//    Constraints ?  
//
//2. Test data set
//
//        Positive : 1,-5,2,-3,7,1
//        Edge     : 1,-1,-1,-1
//        Edge     : -1,1,-2,-3,3 
//
//3. Known Approaches
//        Approach 1 :Bruteforce 
//
//4. O-Notations
//
//5. Pseudocode

@Test
public void testData01(){            // Positive
	
	int[] input = {1,-5,2,-3,7,1};
	Assert.assertTrue(findHighestSum(input) == 8);
}


@Test
public void testData02(){			 // Edge
	int[] input = {1,1,1,-5};
	Assert.assertTrue(findHighestSum(input) == 3);
}

@Test
public void testData03(){			 // Edge
	int[] input = {-1,1,-2,-3,3};
	Assert.assertTrue(findHighestSum(input) == 3);
}

@Test
public void testData04(){			 // Edge
	int[] input = {-1,-1,-2,-3,11};
	Assert.assertTrue(findHighestSum(input) == 11);
}


private int findHighestSum(int[] input) {
	int maxValue = Integer.MIN_VALUE;
	for (int i = 0; i < input.length; i++) {
		int currentMax = 0;
		for (int j = i; j < input.length; j++) {
			currentMax += input[j];
			maxValue = Math.max(currentMax, maxValue);
		}
	}		
	return maxValue;
}

/* Initialize variable left, currentSum and maxSum as  Integer.MIN_VALUE;
 * Iterate the input from 1
 *   Add the value of left index and currentValue
 * 
 */


}
