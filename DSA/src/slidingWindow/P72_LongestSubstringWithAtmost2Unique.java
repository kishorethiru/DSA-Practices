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
	 * Iterate till left less than input length
	 *     
	 *   
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 */
	private int findLongestSubstring(String input) {
 		Map<Character,Integer> inputMap = new HashMap<>();
		int left = 0, right = 0, maxCount = Integer.MIN_VALUE;
		while(left < input.length()) {
			maxCount = Math.max(maxCount, right-left+1);
			while(inputMap.size() <= 2 && right < input.length()) {
				inputMap.put(input.charAt(right), inputMap.getOrDefault(input.charAt(right), 0)+1);
				maxCount = Math.max(maxCount, right++ - left+1);
			}
			if(inputMap.get(input.charAt(left))> 1) inputMap.put(input.charAt(left), 
					inputMap.getOrDefault(input.charAt(left), 0)-1);
			else inputMap.remove(input.charAt(left));
			left++;
		}
		return maxCount;
	}
	
	
}
