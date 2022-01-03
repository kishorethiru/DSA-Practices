package sdetmeet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class Remove5 {
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
		int n =-12535;
		Assert.assertTrue(removeFive(n)== -1235);
	}

	@Test
	public void testData02() { // Negative
		int n =5000;
		Assert.assertTrue(removeFive(n)== 0);
	}

	@Test
	public void testData03() { // Edge
		int n = 15958;
		Assert.assertTrue(removeFive(n)== 1958);
	}
	
	/*1) initialize a boolean isNegative as false
	 *2) if input is negative and update isNegative as true and 
	 *   multiply input * -1
	 *3) Initialize a int as max
	 *4) Iterate the input
	 *    if current element is 5,
	 *       concate the value before the current index and after current index
	 *       parse and compare, store the max
	 *       (if negative min compare, else max compare)
	 *    else continue
	 *5. return max
	 *Time : O(n)
	 *Space : O(1) 
	 * 
	 */
	private int removeFive(int n) {
		boolean isNegative = false;
		if(n<0) {
			isNegative = true;
			n *= -1;
		}
		String input = n+"";
		int val = isNegative ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
		for(int i = 0; i<input.length();i++) {
			if(input.charAt(i)=='5') {
				val = isNegative ? Math.min(Integer.parseInt(input.substring(0,i)+input.substring(i+1)), val) : Math.max(val, Integer.parseInt(input.substring(0,i)+input.substring(i+1))); 
			}
		}
		return isNegative ? val*-1: val;
	}
}
