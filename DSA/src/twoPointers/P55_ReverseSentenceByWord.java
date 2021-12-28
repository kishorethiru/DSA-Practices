package twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P55_ReverseSentenceByWord {
	/*
		Problem Statement
		Given the sentence, reverse only the word in it
	*/

	/*
	   1. 
	     Input(s) ? String 
		  Output ? String
		  Constraint(s) ? time optimized
	   
	   2. Test data
			Positive : Today is a beautiful day
			Negative : today
			Edge     : Today is always beautiful
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "Today is a beautiful day";
		String op = reverseWordTwoPtr(input);
		Assert.assertTrue(reverseWordTwoPtr(input).equals("day beautiful a is Today"));
	}

	@Test
	public void testData02() { // Negative
		String input = "Today";
		Assert.assertTrue(reverseWord(input).equals("Today"));
	}

	@Test
	public void testData03() { // Edge
		String input = "Today is always beautiful";
		Assert.assertTrue(reverseWordTwoPtr(input).equals("beautiful always is Today"));
	}

	/* Create a new StringBuilder 
	 * Convert the string to String array spliting by " "
	 * Iterate from end and append to String builder
	 * return the StringBuilder to String
	 * 
	 */
	private String reverseWord(String input) {
		StringBuilder sb = new StringBuilder();
		String[] words = input.split(" ");
		for(int i = words.length-1; i > 0; i--) {
				sb.append(words[i]);
				sb.append(" ");
		}
		sb.append(words[0]);
		return sb.toString();
	}
	
	private String reverseWordTwoPtr(String input) {
		String[] words = input.split(" ");
		int left = 0, right = words.length-1;
		while(left<right) {
			String temp = words[left];
			words[left++] = words[right];
			words[right--] = temp;
		}
		return String.join(" ", words);
	}
}
