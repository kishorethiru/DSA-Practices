package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P22_LongestCommonPrefix_LC_14 {
	/*
	 * https://leetcode.com/problems/longest-common-prefix/
	 * 14. Longest Common Prefix
	 * 
	 * 
		Problem Statement
		Write a function to find the longest common prefix string amongst an array of strings.
		If there is no common prefix, return an empty string "".
	
	*/

	/*
	   1. 
	  	  Input(s) ? String[] 
		  Output ? String
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :["flower","flow","flight"]
			Negative : ["dog","racecar","car"] 	
			Edge     :["fleed","flee","fleik","flip","flow","for"]
	
	   3.  Approaches Known 
			 Approach 1 :  Two Pointers
	
	   4.  O - Notation 
			 Approach 1 : O(n), O(1)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String[] input = {"flower","flow","flight"};
		Assert.assertTrue(longestCommonPrefix(input).equals("fl"));
	}

	@Test
	public void testData02() { // Negative
		String[] input = {"dog","racecar","car"};
		Assert.assertTrue(longestCommonPrefix(input).equals(""));
	}

	@Test
	public void testData03() { // Edge
		String[] input = {"fleed","flee","fleik","flip","flow","for"};
		Assert.assertTrue(longestCommonPrefix(input).equals("f"));
	}
	
	/* If input length is zero return empty ""
	 * If input length is 1 return empty input[0]
	 * Write a helper function to find the common prefix in the two strings
	 * Create a string ret
	 * Find the common chars in both 0 and 1 index values
	 * if the value is empty return ""
	 * Iterate from index 2 to end
	 *   call the helper function with currentVal and matched Val
	 *   if returned Value is ""
	 *      return  ""
	 *   else replace the matched word
	 * return ret
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		String ret;
		ret = returnMatch(strs[0], strs[1]);
		if (ret == "")
			return "";
		for (int i = 2; i < strs.length; i++) {
			String currRet = returnMatch(strs[i], ret);
			if (currRet == "")
				return "";
			else
				ret = currRet;
		}
		return ret;
	}
	
	/* Initialize two ptr one at 0 of one and at two
	 * Iterate till p1 and p2 is within the string length
	 *  If both index values are same append to StringBuilder
	 *  else break;
	 * return the appended value
	 * 
	 * Time : O(n or m)
	 * Space : O(1) 
	 * 
	 */
	public String returnMatch(String one, String two) {
		StringBuilder sb = new StringBuilder();
		int p1 = 0, p2 = 0;
		while (p1 < one.length() && p2 < two.length()) {
			if (one.charAt(p1) == two.charAt(p2)) {
				sb.append(one.charAt(p1));
				p1++;
				p2++;
			} else
				break;
		}
		return sb.toString();
	}
}
