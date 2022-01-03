package recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P130_DecodeString {
	/*
		Problem Statement
		
		Given an encoded string, return its decoded string.
		The encoding rule is: k[encoded_string], where the encoded_string inside 
		the square brackets is being repeated exactly k times. Note that k is
		guaranteed to be a positive integer.
		You may assume that the input string is always valid; No extra white spaces, 
		square brackets are well-formed, etc.
		Furthermore, you may assume that the original data does not contain any 
		digits and that digits are only for those repeat numbers, k. For example, 
		there won't be input like 3a or 2[4].
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? String 
		  Constraint(s) ? Use recursion
	   
	   2. Test data
			Positive : 3[a]2[bc]
			Negative : 3[a2[c]]
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
		String s = "3[a]2[bc]";
		Assert.assertTrue(decodeString(s).equals("aaabcbc"));
	}

	@Test
	public void testData02() { // Negative
		String s = "a[a]dd[bc]";
		System.out.println(decodeString(s));
		Assert.assertTrue(decodeString(s).equals("aaddbc"));
	}

	@Test
	public void testData03() { // Edge
		String s = "3[a2[c]]";
		Assert.assertTrue(decodeString(s).equals("accaccacc"));
	}
	
	@Test
	public void testData04() { // Edge
		String s = "100[leetcode]";
		System.out.println(decodeString(s));
//		Assert.assertTrue(decodeString(s).equals("accaccacc"));
	}

	/*
	 *  Find the first index of the closing bracket 
        If the index is -1 (no match), return the entire string as it is
        Then, find the associated opening bracket index
        Find the substring (content) between the open and close
        Find the number before the open bracket
        Put inside a String Buffer, expand the content 
        StringBuilder insert (String before the number) before the expanded content
        StringBuilder append (String after the closing bracket) 
	 */
	private String decodeString(String s) {
		if (!s.contains("]"))
			return s;
		int closeIndex = s.indexOf(']');
		int openIndex = s.substring(0, closeIndex).lastIndexOf('[');
		int k = 1;
		StringBuilder digits = new StringBuilder();
		int getIndex = openIndex - 1;
		if (getIndex >= 0 && Character.isLetter(s.charAt(getIndex))) {
			digits.insert(0, s.charAt(getIndex--));
		} else {
			while (getIndex >= 0 && Character.isDigit(s.charAt(getIndex))) {
				digits.insert(0, s.charAt(getIndex--));
			}
			k = Integer.parseInt(digits.toString());
		}
		String subStr = (k != 1) ? s.substring(openIndex + 1, closeIndex)
				: digits.toString() + s.substring(openIndex + 1, closeIndex);
		String strToAppend = "";
		while (k != 0) {
			strToAppend += subStr;
			k--;
		}
		int diff = digits.length() == 0 ? 1 : digits.length();
		s = s.substring(0, openIndex - diff) + strToAppend + s.substring(closeIndex + 1, s.length());
		return decodeString(s);
	}
	
	
	   
	 
}
