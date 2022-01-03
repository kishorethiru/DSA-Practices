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
public class P170_Check_A_Appears_Before_B_LC_2124 {
	/*	
	 *   * https://leetcode.com/discuss/general-discussion/1660937/weekly-contest-274
		 * Leet Code Link : https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
		 * Leet Code Problem Number : 2124. Check if All A's Appears Before All B's
		  
		  Problem Statement
		  Given a string s consisting of only the characters 'a' and 'b', return true if every 'a' 
		  appears before every 'b' in the string. Otherwise, return false.
			
		*/

	/*
	   1. 
	  	  Input(s) ? String
		  Output ? boolean
		  Constraint(s) ? Optimized
	   
	   2. Test data
			Positive : aaabbb => true
			Negative : aaa    => false
			Edge     : aaaab  => true
	
	   3.  Approaches Known 
			 Approach 1 : Single pass with a pointer
	
	   4.  O - Notation 
			 Approach 1 : Approach 1 : Single pass with a pointer Time : O(n), Space : O(n) 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		Assert.assertTrue(isAAppearBeforeB("aaabbb"));
	}

	@Test
	public void testData02() { // Negative
		Assert.assertFalse(isAAppearBeforeB("aaa"));
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(isAAppearBeforeB("aaab"));
	}
	
	/* Pseudocode 
	 * 1. Check if string dont have b return false
	 * 2. Initialize a variable index as 0
	 * 3. Iterate till b is found
	 * 4. Iterate till length
	 *     if 'a' is present return false
	 *     increment index
	 * 5. Return true
	 * 
	 * Time : O(n) - Contains + O(n)  => O(n)
	 * Space : O(1)
	 */
	private boolean isAAppearBeforeB(String s) {
		if(!s.contains("b")) return false;
		int index = 0;
		while(index < s.length() && s.charAt(index) == 'a') index++;
		while(index < s.length()) if(s.charAt(index++) == 'a') return false;
		return true;
	}

	
}
