package sdetmeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class FindSumCombinations {
	/*
		Problem Statement
		
		The same number may be chosen from candidates an unlimited number of times.
		Two combinations are unique if the frequency of at least one of the chosen 
		numbers is different.
		It is guaranteed that the number of unique combinations that sum up to 
		target is less than 150 combinations for the given input.

		Example 1:
		
		Input: candidates = [2,3,6,7], target = 7
		Output: [[2,2,3],[7]]
		Explanation:
		2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
		7 is a candidate, and 7 = 7.
		These are the only two combinations.	
	*/

	/*
	   1. 
	      Input(s) ? int[], int  
		  Output ? Set<List<Integer>>
		  Constraint(s) ?
	   
	   2. Test data
			Positive : [2,3,6,7], target = 7
			Negative : [2,4] target = 3  
			Edge     : [2,4,3,6] target = 6
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {2,3,6,7};
		int target = 7;
		Set<List<Integer>> set = new HashSet<>(); 
		set.add(Arrays.asList(2,2,3));
		set.add(Arrays.asList(7));
		Assert.assertTrue(findSumCombinations(input,target).equals(set));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {2,4};
		int target = 3;
		Set<List<Integer>> set = new HashSet<>(); 
		Assert.assertTrue(findSumCombinations(input,target).equals(set));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {2,3,6,7};
		int target = 7;
		Set<List<Integer>> set = new HashSet<>(); 
		set.add(Arrays.asList(2,2,3));
		set.add(Arrays.asList(7));
		Assert.assertTrue(findSumCombinations(input,target).equals(set));
	}
	
	@Test
	public void testData04() { // Positive
		int[] input = {2,3,6,7,5};
		int target = 7;
		Set<List<Integer>> set = new HashSet<>(); 
		set.add(Arrays.asList(2,2,3));
		set.add(Arrays.asList(7));
		set.add(Arrays.asList(5,2));
		Assert.assertTrue(findSumCombinations(input,target).equals(set));
	}

	
	/**
	 * Pseudocode:
	 * 1. Initialize an array list 
	 * 2. Iterate through the array
	 * 3. Divide the target by current value and store in result
	 * 		a) add value to list result times
	 * 		
	 * 		
	 * 
	 * @param input
	 * @param target
	 * @return
	 */
	private Set<List<Integer>> findSumCombinations(int[] input, int target) {
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			int valuesInNum = target / input[i];
			while (valuesInNum != 0) {
				int sum = 0;
				List<Integer> list = new ArrayList<>();
				int valuesToDup = valuesInNum;
				while (valuesToDup != 0) {
					sum += input[i];
					list.add(input[i]);
					valuesToDup--;
				}
				if (sum == target) {
					set.add(list);
				} else {
					for (int j = 0; j < input.length; j++) {
						if (i != j) {
							sum += input[j];
							if (sum == target) {
								list.add(input[j]);
								set.add(list);
								sum -= input[j];
							} else if (sum > target)
								sum -= input[j];
							else if (sum < target)
								list.add(input[j]);
						}
					}
				}
				valuesInNum--;
			}
		}
		return set;
	}
}
