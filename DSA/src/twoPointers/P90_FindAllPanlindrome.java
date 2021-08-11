package twoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P90_FindAllPanlindrome {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
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

		String input = "aac";
		Assert.assertTrue(Arrays.equals(findAllPalindrome(input), new String[] {"aa","a","c"}));
	}
	
	@Test
	public void testData02() { // Positive

		String input = "abc";
		Assert.assertTrue(Arrays.equals(findAllPalindrome(input), new String[] {"a","b","c",}));
	}
	@Test
	public void testData03() { // Edge
		String input = "aabaab";
		Assert.assertTrue(Arrays.equals(findAllPalindrome(input), new String[] {"aa","a", "aba", "b", "aabaa", "baab"}));
	}

	/**
	 * @param input
	 * @return
	 */
	private String[] findAllPalindrome(String input) {
		Set<String> outputString = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			outputString.add(String.valueOf(input.charAt(i)));
			for (int j = i+1; j < input.length(); j++) {
				StringBuilder substr = new StringBuilder(input.substring(i, j+1));
				if(substr.toString().equals(substr.reverse().toString())) outputString.add(substr.toString());
			}
		}
		String[] op = new String[outputString.size()];
		int index = 0;
		for (String str : outputString) {
			op[index++] = str;
		}
		System.out.println(Arrays.toString(op));
		return op;
	}	
}
