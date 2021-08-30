package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P120_ATOI {
	/*
		Problem Statement
		Implement the myAtoi(string s) function, which converts a string to 
		a 32-bit signed integer (similar to C/C++'s atoi function).

		The algorithm for myAtoi(string s) is as follows:

		Read in and ignore any leading whitespace.
		Check if the next character (if not already at the end of the string) is '-' or '+'. 
		Read this character in if it is either. This determines if the final result is 
			negative or positive respectively. Assume the result is positive if neither is present.
		Read in next the characters until the next non-digit charcter or the end of 
			the input is reached. The rest of the string is ignored.
		Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
			If no digits were read, then the integer is 0. 
			Change the sign as necessary (from step 2).
		If the integer is out of the 32-bit signed integer range 
			[-231, 231 - 1], then clamp the integer so that it remains in the range. 
			Specifically, integers less than -231 should be clamped to -231, and 
			integers greater than 231 - 1 should be clamped to 231 - 1.
		Return the integer as the final result.
		Note:

		Only the space character ' ' is considered a whitespace character.
		Do not ignore any characters other than the leading whitespace or the
		 rest of the string after the digits.	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? int
		  Constraint(s) ? 0 <= s.length <= 200
						  s consists of English letters (lower-case and upper-case), 
						  digits (0-9), ' ', '+', '-', and '
	   
	   2. Test data
			Positive :  s = "   -42"
			Negative :	s = "words and 987" 
			Edge     :  s = "4193 with words"
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		Assert.assertTrue(convertStringToInt("   -42") == -42);
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue(convertStringToInt("words and 987") == 0);
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(convertStringToInt("4193 with words") == 4193);
	}

	
	private int convertStringToInt(String s) {
		s = s.trim();
		boolean isNegative = s.charAt(0) == '-' ? true : false;
		int index = (s.charAt(0) == '+'|| s.charAt(0) == '-') ? 1 : 0;
		for(; index < s.length(); index++) {
			if(s.charAt(index)==' ') continue;
			else if(Character.isDigit(s.charAt(index))) break;
			else return 0;
		}
		StringBuilder sb = new StringBuilder();
	    for(int i = index;i<s.length();i++){
	        char current =s.charAt(i);
	        if(Character.isDigit(current)){
	             if(Integer.valueOf(current)!=0) sb.append(current);    
	        }
	        else break;
	    }
	    double parsed = Double.parseDouble(sb.toString());
	    int ret;
	    if(isNegative){
	      parsed = parsed * -1;
	      ret = parsed < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) parsed;
	    }
	    else {
	      ret = parsed > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)parsed; 
	    }
	    return ret;
	}
}
