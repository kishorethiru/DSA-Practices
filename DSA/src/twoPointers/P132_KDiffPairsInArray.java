package twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P132_KDiffPairsInArray {
	/*
		Problem Statement
		Given an array of integers nums and an integer k, return the number of
		unique k-diff pairs in the array.

		A k-diff pair is an integer pair (nums[i], nums[j]), 
		where the following are true:

		0 <= i < j < nums.length
		|nums[i] - nums[j]| == k
		Notice that |val| denotes the absolute value of val.
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int 
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : [3,1,4,1,5], k = 2
			Negative : [1,2,3,4,5], k = 6	
			Edge     : [1,2,4,4,3,3,0,9,2,3], k = 3
	
	   3.  Approaches Known 
			 Approach 1 : Using HashMap and Set
			 Approach 2 : Using TwoPtrs and Set
			 
	
	   4.  O - Notation 
			 Approach 1 : Using HashMap and Set Time - O(nlogn) Space :O(n * 2) 
			 Approach 2 : Using TwoPtrs and Set Time - O(nlogn) Space :O(n * 2)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = { 3, 1, 4, 1, 5 };
		Assert.assertTrue(findPairs(input, 2) == 2);
	}

	@Test
	public void testData02() { // Negative
		int[] input = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 };
		Assert.assertTrue(findPairs(input, 2) == 0);
	}

	@Test
	public void testData03() { // Edge
		int[] input = { 1, 2, 3, 4, 5 };
		Assert.assertTrue(findPairs(input, 3) == 2);
	}

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0, right = 1;
		Set<Set<Integer>> op = new HashSet<>();
		while (right < nums.length) {
			int dif = Math.abs(nums[right] - nums[left]);
			if (right == left)
				right++;
			else if (dif == k) {
				Set<Integer> tempSet = new HashSet<>();
				tempSet.add(nums[left]);
				tempSet.add(nums[right]);
				right++;
				op.add(tempSet);
			} else if (dif < k)
				right++;
			else
				left++;
		}
		return op.size();
	}
	
	public int findPairsUsingHM(int[] nums, int k) {
		Set<Set<Integer>> op = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		for (int i = 0; i < nums.length; i++) {
			int diff = nums[i] + k;
			if (map.containsKey(diff) && i != map.get(diff)) {
				Set<Integer> tempSet = new HashSet<>();
				tempSet.add(nums[i]);
				tempSet.add(diff);
				op.add(tempSet);
			}
		}
		return op.size();

	}
}
