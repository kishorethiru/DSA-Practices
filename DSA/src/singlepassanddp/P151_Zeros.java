package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P151_Zeros {
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
		int[] input = {1,2,4,0,0,7,5};
		Assert.assertTrue(formNumber(input));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,0,2,4,0,5,7};
		Assert.assertTrue(formNumber(input));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {1,7,2,0,4,5,0};
		Assert.assertFalse(formNumber(input));
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {0,7,0,7};
		Assert.assertFalse(formNumber(input));
	}
	
	@Test
	public void testData05() { // Edge
		int[] input = {0,0,0,7};
		Assert.assertFalse(formNumber(input));
	}
	
	@Test
	public void testData06() { // Edge
		int[] input = {0,1,0,7,0,0,7};
		Assert.assertTrue(formNumberWithSubstring(input));
	}
	
	private boolean formNumber(int[] nums) {
		String val = "007";
		String toForm = "";
		for(int i : nums) {
			if(i == 0 || i == 7) toForm += i+"";
			if(toForm.length() == 3) return toForm.equals(val);
		}
		return false;
	}
	
	private boolean formNumberWithSubstring(int[] nums) {
		String val = "007";
		String toForm = "";
		for(int i : nums) {
			if(i == 0 || i == 7) toForm += i+"";
		}
		int len = toForm.length();
		return (toForm.replace(val, "").length() == len) ? false : true ;
	}
}
