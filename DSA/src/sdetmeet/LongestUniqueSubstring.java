package sdetmeet;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class LongestUniqueSubstring {
	/*
		Problem Statement
		Longest Substring without repeating character
		Given a string s, find the length of the longest substring without repeating characters.
		Example 1:
		
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
		Example 2:
		
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:
		
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		Example 4:
		
		Input: s = ""
		Output: 0
	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? int
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 :  Sliding Window + HashMap
	
	   4.  O - Notation 
			 Approach 1 : Sliding Window + HashMap - Time - O(n), Space - O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "abcabcbb";
		Assert.assertTrue(findLongestSubstring(s) == 3);
	}

	@Test
	public void testData02() { // Negative
		String s = "bbbbbbb";
		Assert.assertTrue(findLongestSubstring(s) == 1);
	}

	@Test
	public void testData03() { // Edge
		String s = "nestttresent";
		Assert.assertTrue(findLongestSubstring(s) == 4);
	}
	
	/* Precheck : if s is empty return  0
	 * 1.Initialize a Hashmap with characater as key and integer as value
	 * 2.Initialize maxValue, left and right as 0
	 * 3.Iterate till right< s.length
	 *     Insert the value of right to the map a=> 1
	 *     until(map.size != right-left+1)
	 *       remove the value of left from map
	 *       increment left
	 *    Update the max value with right-left+1
	 *    increment right++
	 * 4. return max
	 *   
	 * Time : O(n)
	 * Space : O(n)       
	 * 
	 */
	private int findLongestSubstring(String s) {
		if(s.isEmpty())  return 0;
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0, len = 0;
		while(right < s.length()) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
			while(map.size() != (right-left) +1){
				char removeChar = s.charAt(left);
				if(map.get(removeChar)> 1 )
					map.put(removeChar, map.get(removeChar)-1);
				else map.remove(removeChar);
				left++;
			}
			len = Math.max((right-left)+1, len);
			right++;
		}
		return len;
	}
}
