package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P28_CamelCaseMatching_LC_1023 {
	/*
	 * 
	 * https://leetcode.com/problems/camelcase-matching/
	 * 
	 * 1023. Camelcase Matching
	Problem Statement
	Given an array of strings queries and a string pattern, 
	return a boolean array answer where answer[i] is true if 
	queries[i] matches pattern, and false otherwise.

	A query word queries[i] matches pattern if you can insert 
	lowercase English letters pattern so that it equals the query. 
	You may insert each character at any position and you may not
	insert any characters.

*/

/*
   1. 
  	  Input(s) ? String[], String 
	  Output ? List<Boolean>
	  Constraint(s) ?
   
   2. Test data
		Positive :
		Negative :	
		Edge     :

   3.  Approaches Known 
		 Approach 1 : Using two ptr to matching string and return the boolean output

   4.  O - Notation 
		 Approach 1 : Time O(n), Space O(n) for output

   5.  Pseudocode	
   	

 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String[] input = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
		String pattern = "FB";
		Assert.assertTrue(camelMatch(input,pattern).equals(Arrays.asList(true,false,true,true,false)));
	}

	@Test
	public void testData02() { // Negative
		String[] input = {"FooBaR","FooBarTest","FootBBall","FrameBuffEr","ForceFeedBack"};
		String pattern = "FB";
		Assert.assertTrue(camelMatch(input,pattern).equals(Arrays.asList(false,false,false,false,false)));
	}

	@Test
	public void testData03() { // Edge
		String[] input = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
		String pattern = "FoBaT";
		Assert.assertTrue(camelMatch(input,pattern).equals(Arrays.asList(false,true,false,false,false)));
	}
	
	
	/* Create a list of boolean
	 * Iterate the input queries
	 *   Call isMatch method passing each value and pattern
	 *   add the return val to list
	 * return list
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 *    
	 * 
	 */
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> retList = new ArrayList<>();
		for (String eachQuery : queries) {
			retList.add(isMatch(eachQuery, pattern));
		}
		return retList;
	}
	
	
	/* Pseudocode - Two Pointers
	 * Initialize two pointers p1 and p2 as 0
	 * Iterate till p1 < s.length and p2 < pattern.length
	 *  if value of p1 and p2 is equal increment p1 and p2
	 *  if not matching and any upper case is present return false
	 *  else increment p1
	 * untill p1 is not check fully, increment and check if any uppercase is present
	 * else return true
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */
	public boolean isMatch(String s, String pattern) {
		int p1 = 0, p2 = 0;
		while (p1 < s.length() && p2 < pattern.length()) {
			if (s.charAt(p1) == pattern.charAt(p2)) {
				p1++;
				p2++;
			} else if (Character.isUpperCase(s.charAt(p1)))
				return false;
			else
				p1++;
		}
		while (p1 < s.length()) {
			if (Character.isUpperCase(s.charAt(p1++)))
				return false;
		}
		return p2 == pattern.length();

	}
}
