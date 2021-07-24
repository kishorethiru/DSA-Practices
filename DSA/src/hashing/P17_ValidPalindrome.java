package hashing;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P17_ValidPalindrome 
{
	/*
	 * Valid Palindrome after deleting one or zero character

		Given a string s, return true if the s can be palindrome after 
		deleting at most one character from it.
		 
		Example 1:
		Input: s = "aba"
		Output: true
		
		Example 2:
		Input: s = "abca"
		Output: true
		Explanation: You could delete the character 'c'.
		
		Example 3:
		Input: s = "abc"
		Output: false
	 * 
	 */
	
	/* 1. Problem Observation 
	 *     1. Input - String
	 *     2. Output - boolean
	 *     3. Constraint - No
	 * 2. Test Data
	 *    
	 *     Positive
	 *     String s = "aba"
	 *     
	 *     Negative
	 *     String s = "abc"
	 *     
	 *     Edge
	 *     String s = "abca"
	 * 
	 * 3.  Approach to solve
	 *  	
	 *     Approach 1 : Using Set 
	 * 
	 * 4. Big O Notation
	 *    	Approach 1 : Using Set Time - O(n), Space O(n)
	 *   
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void testData01() // Positive
	{
		String s = "aba";
		Assert.assertTrue(isPalindrome(s) == true);
	}
	
	@Test
	public void testData02() // Negative
	{
		String s = "abc";
		Assert.assertTrue(isPalindrome(s) == false);
	}
	
	@Test
	public void testData03() // Negative
	{
		String s = "abcabcd";
		Assert.assertTrue(isPalindrome(s) == true);
	}
	
	/* Create a set
	 * Iterate the input
	 * 		Push the item to set, if already exists remove from set
	 * if set size is > 2, return false
	 * if set size is 1 or 2 return true;
	 * Time : O(n)
	 * Space : O(n)
	 */

	private boolean isPalindrome(String s) {
		if (s.length() < 2)
			return true;
		Set<Character> inputSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!inputSet.add(s.charAt(i)))
				inputSet.remove(s.charAt(i));
		}
		if (inputSet.size() > 2)
			return false;
		return true;
	}


}
