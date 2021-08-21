package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P97_CeasarCipher {
	/*
		Problem Statement
		Julius Caesar protected his confidential information by encrypting it using a cipher. 
		Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end 
		of the alphabet, just rotate back to the front of the alphabet. 
		In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? String
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
		String input = "middle-Outz";
		Assert.assertTrue(caesarCipher(input, 2).equals("okffng-Qwvb"));
	}

	@Test
	public void testData02() { // Edge
		String input = "www.abc.xy";
		Assert.assertTrue(caesarCipher(input, 87).equals("fff.jkl.gh"));

	}

	@Test
	public void testData03() { // Negative
		String input = "--.##.--";
		Assert.assertTrue(caesarCipher(input, 87).equals("--.##.--"));
	}

	private String caesarCipher(String s, int k) {
		StringBuilder sb = new StringBuilder();
		k %= 26;
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (Character.isLetter(current)) {
				int val = (int) current;
				if (Character.isLowerCase(current) && val + k > 122) {
					val = (val + k) - 26;
				} else if (Character.isUpperCase(current) && val + k > 90) {
					val = (val + k) - 26;
				} else
					val += k;
				char rotated = (char) val;
				sb.append(rotated);
			} else
				sb.append(current);
		}
		return sb.toString();
	}
}
