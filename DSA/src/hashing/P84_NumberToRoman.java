package hashing;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P84_NumberToRoman {
	/*
		Problem Statement
		Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

		Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		For example, 2 is written as II in Roman numeral, just two one's added together. 
		12 is written as XII, which is simply X + II. The number 27 is written as XXVII, 
		which is XX + V + II.
		
		Roman numerals are usually written largest to smallest from left to right. 
		However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
		
		I can be placed before V (5) and X (10) to make 4 and 9. 
		X can be placed before L (50) and C (100) to make 40 and 90. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
		Given an integer, convert it to a roman numeral.
	
	*/

	/*
	   1. 
	  	  Input(s) ? Number
		  Output ? String
		  Constraint(s) ? 1 <=n<= 3999
	   
	   2. Test data
			Positive : 3
			Negative :	0, 4000
			Edge     : 1994
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int n = 3;
		Assert.assertTrue(convertNumbertoRoman(n).equals("III"));
	}

	@Test
	public void testData02() { // Negative
		int n = 4000;
		Assert.assertTrue(convertNumbertoRoman(n).equals(""));
	}

	@Test
	public void testData03() { // Edge
		int n = 1994;
		Assert.assertTrue(convertNumbertoRoman(n).equals("MCMXCIV"));
	}

	
	/* Create two arrays int[] and String[] for mapping roman chars and correspoding values of size 13
	 * Create a Stringbuilder sb
	 * initialize i as 0
	 * Iterate the n till becomes zero
	 *  if the n > value[i]
	 *    append to Sb and subtract value from n
	 * return sb as String
	 * 
	 * Time : O(n)
	 * Space : O(13)
	 * 
	 */
	private String convertNumbertoRoman(int n) {
		if(n<0 || n>3999) return "";
		String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		StringBuilder sb = new StringBuilder();
		int currentIndex = 0;
		while(n > 0) {
			while(n>=value[currentIndex]) {
				n -= value[currentIndex];
				sb.append(romanValues[currentIndex]);
			}
			currentIndex++;			
		}
		return sb.toString();
	}
}
