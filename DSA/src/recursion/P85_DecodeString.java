package recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P85_DecodeString {
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
		String s = "a[a]d[bc]";
		Assert.assertTrue(decodeString(s).equals("aadbc"));
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
		if(!s.contains("]")) return s;
		int closeIndex = s.indexOf(']');
		int openIndex = s.substring(0, closeIndex).lastIndexOf('[');
		char prevChar = !Character.isDigit(s.charAt(openIndex-1)) ? s.charAt(openIndex-1) : ' ';
		int k = (prevChar == ' ') ? Character.getNumericValue(s.charAt(openIndex-1)) : 1;
		String subStr = (prevChar == ' ' ) ? s.substring(openIndex+1, closeIndex) :
			prevChar + s.substring(openIndex+1, closeIndex) ;
		String strToAppend = "";
		while(k!=0) {
			strToAppend += subStr;
			k--;
		}
		s = s.substring(0, openIndex-1)+ strToAppend + s.substring(closeIndex+1, s.length()); 
		return decodeString(s);
	}
	
	
	   
	 
}
