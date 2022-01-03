package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

public class P155_FirstUniqueCharacter {
	/*
		Problem Statement
		Given a string, return the 1 based index of first occurred unique character
	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? int
		  Constraint(s) ? 
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		String s= "statistics";
		Assert.assertTrue(findFirstUniqueCharacterIndex(s)==3);
	}

	@Test
	public void testData02() { // Negative
		String s= "bababa";
		Assert.assertTrue(findFirstUniqueCharacterIndex(s)==-1);
	}

	@Test
	public void testData03() { // Edge
		String s= "z";
		Assert.assertTrue(findFirstUniqueCharacterIndex(s)==1);
	}

	/* If s length is 1 return 1.
	 * Initialize new array of size 26.
	 * Iterate the input
	 * 	 Increment the value at array of the calculated ascii size of char
	 * Iterate the input
	 * 	 If the char value in array  = 1, return index+1.
	 * return -1
	 * 
	 * Time : O(2n) - O(n)
	 * Space : O(25)
	 * 
	 */
	private int findFirstUniqueCharacterIndex(String s) {
		if(s.length()==1) return 1;
		int[] ascii = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ascii[s.charAt(i)-'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if(ascii[s.charAt(i)-'a']==1) return i+1;
		}
		return -1;
	}
	
	private int findFirstUniqueCharacterIndexOptimized(String s) {
		for (int i = 0; i < s.length(); i++) {
			if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return i+1;
		}
		return -1;
	}
}
