package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxClosestSum {
	
	/* 
	 * Given an integer array, find the index of sum of two numbers
	 * which is the less than the target k. And the sum should be max of all 
	 * 
	 */
	
	/* 1. 
    Input(s)? int[], int
    Output ?  int[2]
    Constraints ?  Time Optimized

	2. Test data set
	
	        Positive : 
	        Negative :
	        Edge     :
	
	3. Known Approaches
	        Approach 1 : 
	
	4. O-Notations
	
	5. Pseudocode
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {12,15,30,10,9};
		int k= 25;
		Assert.assertTrue(Arrays.equals(findMaxClosestSumHashMap(input,k), new int[] {1,4}));
	}


	@Test
	public void testData02(){			 // Negative
		int[] input = {12,15,30};
		int k= 25;
		Assert.assertTrue(Arrays.equals(findMaxClosestSum(input,k), new int[] {-1,-1}));
		
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {-2,-4,-5,0,3};
		int k= 0;
		Assert.assertTrue(Arrays.equals(findMaxClosestSum(input,k), new int[] {1,4}));
	}
	
	/* Initialize a variable count as Math.MIN_VALUE, index1 and index 2.
	 * Iterate the outer loop starting from 0
	 *   Iterate the the inner loop from 0
	 *    if i =! j, add to the sum,
	 *    	 if the sum < target and sum> minCount update the minCount and i and j 
	 * return index1 and index2;
	 *
	 * Time : O(n^2)
	 * Space : O(1)
	 */
	
	private int[] findMaxClosestSum(int[] input, int k) {
		if(input.length == 0) return new int[] {-1,-1};
		int minCount = Integer.MIN_VALUE, index1 = -1, index2 = -1;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (i != j) {
					int sum = input[i] + input[j];
					if (sum < k && sum > minCount) {
						minCount = sum;
						index1 = i;
						index2 = j;
					}
				}
			}
		}
		return new int[] { index1, index2 };
	}
	
	private int[] findMaxClosestSumHashMap(int[] input, int k) {
		if(input.length == 0) return new int[] {-1,-1};
		int minCount = Integer.MIN_VALUE, index1 = -1, index2 = -1;
		int minValue = Integer.MAX_VALUE;
		Map<Integer, Integer> inputMap = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			inputMap.put(input[i],i);
			minValue = Math.min(minValue, input[i]);
		}
		for (int i = 0; i < input.length; i++) {
			int diff = k-input[i];
			if(diff-->0) {
				while(diff == input[i] || !inputMap.containsKey(diff)){
					if(diff<minValue) break;
					diff--;
				}
				if(minCount< input[i]+diff) {
					index1 = inputMap.get(diff);
					index2 = i;
				}
			}
		}
		return new int[] { index1, index2 };
	}
	
	

}
