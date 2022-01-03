package recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P129_ReverseString {
	/*
		Problem Statement
		Reverse the string by recursion
		1. 
	
	*/

	/*
	   1. 
	  	  Input(s) ? String  
		  Output ? String
		  Constraint(s) ? Using recursion
	   
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
		String s = "recursion";
		Assert.assertTrue(reverseString(s).equals("noisrucer"));
	}

	@Test
	public void testData02() { // Negative
		String s = "";
		Assert.assertTrue(reverseString(s).equals(""));
	}

	@Test
	public void testData03() { // Edge
		String s = "reverse value";	
		Assert.assertTrue(reverseString(s).equals("eulav esrever"));
	}
	
	/*
	 * if the string length is empty return empty string
	 * return last char at String + call reverseString after removing the last char from string
	 */

	private String reverseString(String s) {
		if(s.length()==0) return "";
		return s.charAt(s.length()-1) + reverseString(s.substring(0,s.length()-1));

	}
}
