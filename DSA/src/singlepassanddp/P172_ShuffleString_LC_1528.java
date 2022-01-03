/**
 * 
 */
package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P172_ShuffleString_LC_1528 {
	/*
		 * Leet Code Link : https://leetcode.com/problems/shuffle-string/
		 * Leet Code Problem Number :1528. Shuffle String
		  
		  Problem Statement
		  You are given a string s and an integer array indices of the same length. The string s will be shuffled such 
		  that the character at the ith position moves to indices[i] in the shuffled string.

		  Return the shuffled string.
			
		*/

	/*
	   1. 
	  	  Input(s) ? String, int[] 
		  Output ? String
		  Constraint(s) ? Time Optimized 
	   
	   2. Test data
			Positive : s = "codeleet", indices = [4,5,6,7,0,2,1,3] => "leetcode"
			Negative : s = "abc", indices = [0,1,2] => "abc"
			Edge     : s = "cab", indices = [2,0,1] => "abc"
	
	   3.  Approaches Known 
			 Approach 1 : Single Pass with new char array
	
	   4.  O - Notation 
			 Approach 1 : Single Pass with new char array Time : O(n), Space : O(n) 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		Assert.assertTrue(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}).equals("leetcode"));
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue(restoreString("abc", new int[] {0,1,2}).equals("abc"));
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(restoreString("cab", new int[] {2,0,1}).equals("abc"));
	}
	
	private String restoreString(String s, int[] indices) {
		char[] retVal = new char[indices.length];
        int index = 0;
        for(int i : indices) retVal[i] = s.charAt(index++);
        return new String(retVal);
	}
}
