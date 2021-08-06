package slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P72_LongestSubstringWithAtmost2Unique {
	/*
		Problem Statement
		Given a string s, find the length of longest substring t that has contains atmost 
		2 distinct characters
	
	*/

	/*
	   1. 
	  	  Input(s) ?   String
		  Output ? int
		  Constraint(s) ? No
	   
	   2. Test data
			Positive : "aaabbccd"
			Negative : "aaaaaa"	
			Edge     : "aabbccddeeff"
	
	   3.  Approaches Known 
			 Approach 1 : Using sliding window
	
	   4.  O - Notation 
			 Approach 1 :  Using sliding window -O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "aaabbccd";
		Assert.assertTrue(findLongestSubstring(input)==5);
	}

	@Test
	public void testData02() { // Negative
		String input = "aaaaaa";
		Assert.assertTrue(findLongestSubstring(input)==6);
	}

	@Test
	public void testData03() { // Edge
		String input = "aabbccd";
		Assert.assertTrue(findLongestSubstring(input)==4);
	}
	
	@Test
	public void testData04() { // Edge
		String input = "aabbcddddddzccaaaaa";
		Assert.assertTrue(findLongestSubstring(input)==7);
	}
	
	/* 
	 * Create a map
	 * Initialize left as 0 and right as 0, maxCount as Integer.MIN_VALUE
	 * Iterate till right less than input length
	 * 		Add the right index char to the map
	 * 		Untill map size > 2 , remove the left item from map increment left
	 * 		find the max by finding difference on right-left+1
	 * 		increment right 
	 * return maxCount
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 */
	private int findLongestSubstring(String s) {
 		Map<Character,Integer> inputMap = new HashMap<>();
		int left = 0, right = 0, maxCount = Integer.MIN_VALUE;
		while(right < s.length()) {
			inputMap.put(s.charAt(right), inputMap.getOrDefault(s.charAt(right), 0)+1);
			while(inputMap.size() > 2) {
				if(inputMap.get(s.charAt(left))>1) {
					inputMap.put(s.charAt(left), inputMap.getOrDefault(s.charAt(left), 0)-1);
				}
				else inputMap.remove(s.charAt(left));
				left++;
			}
			maxCount = Math.max(maxCount, right-left+1);
			right++;			
		}
		return maxCount;
	}
	
	
}
