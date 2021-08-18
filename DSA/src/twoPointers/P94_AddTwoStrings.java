package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P94_AddTwoStrings {
	/*
		Problem Statement
		Given two non-negative integers, num1 and num2 represented as string, 
		return the sum of num1 and num2 as a string.

		You must solve the problem without using any built-in library for handling large 
		integers (such as BigInteger). You must also not convert the inputs to integers directly.
	
	*/

	/*
	   1. 
	  	  Input(s) ? 2 Strings 
		  Output ? String
		  Constraint(s) ? Do not use internal method to convert char to int
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : Using Two Pointers
	
	   4.  O - Notation 
			 Approach 1 : Using Two Pointers
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String one = "11";
		String two = "123";
		Assert.assertTrue(addTwoStrings(one,two).equals("134"));
	}

	@Test
	public void testData02() { // Negative
		String one = "";
		String two = "123";
		Assert.assertTrue(addTwoStrings(one,two).equals("123"));
	}

	@Test
	public void testData03() { // Edge
		String one = "199";
		String two = "123";
		Assert.assertTrue(addTwoStrings(one,two).equals("322"));
	}
	
	/*  Pseudocode : 
	 *  1. If num1 is empty, return num2
	 *  2. If num2 is empty, return num1.
	 *  3. Create two pointers p1 and p2 at the end of num1 and num2.
	 *  4. Create StringBuilder op and int carry as 0.
	 *  5. Iterate till p1 >= 0 and p2 >= 0
	 *     a) check if p1 is >= 0 if yes get the index value of p1 else as 0, same for p2.
	 *     b) add the value of p1Val + p2Val + carry as numToAdd.
	 *     c) if numToAdd > 9
	 *           - Calculate carry 
	 *           - Take the last digit 
	 *        else 
	 *           - Make carry as 0
	 *     d) Insert the numToAdd at 0 index.
	 *  6. If carry !=0 add to the 0 index of sb.
	 *  7. Return StringBuilder object op as String
	 *         
	 * Time : O(n)
	 * Space : O(n)
	 * 
	 */
	public String addTwoStrings(String num1, String num2) {
		if(num1.isEmpty()) return num2;
		if(num2.isEmpty()) return num1;
		int p1 = num1.length() - 1, p2 = num2.length() - 1;
		StringBuilder op = new StringBuilder();
		int carry = 0;
		while (p1 >= 0 || p2 >= 0) {
			int p1Val = (p1 >= 0) ? num1.charAt(p1--) - '0' : 0;
			int p2Val = (p2 >= 0) ? num2.charAt(p2--) - '0' : 0;
			int numToAdd = p1Val + p2Val + carry;
			if (numToAdd > 9) {
				carry = numToAdd / 10;
				numToAdd %= 10;
			} else
				carry = 0;
			op.insert(0, numToAdd);
		}
		if (carry != 0)
			op.insert(0, carry);
		return op.toString();
	}
}
