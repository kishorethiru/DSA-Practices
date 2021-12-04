package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class PositionOfLargeGroups {
	/*
		Problem Statement
		LC : 890  Positions of Large Groups 
		https://leetcode.com/problems/positions-of-large-groups/
		
			In a string s of lowercase letters, these letters form consecutive groups of the same character.
			For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
			A group is identified by an interval [start, end], where start and end denote the start and 
			end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].
			
			A group is considered large if it has 3 or more characters.
			Return the intervals of every large group sorted in increasing order by start index.
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? List<List<Integer>>
		  Constraint(s) ? Solve in time optimized
	   
	   2. Test data
			Positive : "aabbcaccc"
			Negative : "aabbccdc"
			Edge     : "abcdddeeeeaabbbcd"
	
	   3.  Approaches Known 
			 Approach 1 : Bruteforce, Using two for loops and iterating each
			 Approach 2 : Using two pointers approach
	
	   4.  O - Notation 
			 Approach 1 : Time O(n^2), Space : O(n)
			 Approach 2 : Time O(n), Space : O(n) 
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "aabbcaccc";
		List<List<Integer>> returnVal = new ArrayList<>();
		returnVal.add(Arrays.asList(6,8));
		Assert.assertTrue(largeGroupPositions(input).equals(returnVal));
	}

	@Test
	public void testData02() { // Negative
		String input = "aabbccdc";
		List<List<Integer>> returnVal = new ArrayList<>();
		Assert.assertTrue(largeGroupPositions(input).equals(returnVal));
	}

	@Test
	public void testData03() { // Edge
		String input = "abcdddeeeeaabbbcd";
		List<List<Integer>> returnVal = new ArrayList<>();
		returnVal.add(Arrays.asList(3,5));
		returnVal.add(Arrays.asList(6,9));
		returnVal.add(Arrays.asList(12,14));
		Assert.assertTrue(largeGroupPositions(input).equals(returnVal));
	}
	
	/* Pseudocode - Two Pointer Approach
	 * 
	 * 1. Create a return List<List<Integer>> as retList
	 * 2. If string length is less than 3 return empty retList
	 * 3. Initialize left as 0 and right as 1
	 * 4. Iterate till right < input
	 * 		a) if left and right char equals increment right++
	 * 		b) else if the distance between right and left is >=3 add 
	 *         the index to retList, assign the value of right to left
	 *         and increment right
	 * 5. if both left and right values are same and distance between them
	 * 	  is >=3 add left and right to retList
	 * 6. return retList
	 * 
	 * Time  : O(n)
	 * Space : O(n)
	 *         
	 */
	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> retList = new ArrayList<>();
		if (s.length() < 3)
			return retList;
		int left = 0, right = 1;
		while (right < s.length()) {
			if (s.charAt(left) == s.charAt(right))
				right++;
			else {
				if ((right - left) - 1 >= 2)
					retList.add(Arrays.asList(left, right - 1));
				left = right++;
			}
		}
		if (s.charAt(left) == s.charAt(right - 1) && right - left - 1 >= 2)
			retList.add(Arrays.asList(left, right - 1));
		return retList;
	}
}
