package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P104_CircularPrinterWheel {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? int
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
		String input = "BZA";
		Assert.assertTrue(calculatePrinterTime(input)==4);
	}

	@Test
	public void testData02() { // Negative
		String input = "A";
		Assert.assertTrue(calculatePrinterTime(input)==0);
	}

	@Test
	public void testData03() { // Edge
		String input = "VMGR";
		Assert.assertTrue(calculatePrinterTime(input)==31);
	}
	
	@Test
	public void testData04() { // Edge
		String input = "NMZ";
		Assert.assertTrue(calculatePrinterTime(input)==27);
	}
	
	@Test
	public void testData05() { // Edge
		String input = "OAO";
		Assert.assertTrue(calculatePrinterTime(input)==36);
	}

	/* Create a char previous Value as "A"
	 * Initialize count as 0.
	 * Iterate the input
	 * 	 Calculate the distance by abs 26 - (prev - currentValue)
	 *   if distance > 26 ,again distance  = 26-distance.
	 *   add distance to count 
	 *   prev = currentChar 
	 *   
	 *  Time : O(n)
	 *  Space : O(1)
	 * 
	 */
	private int calculatePrinterTime(String input) {
		int prev = 'A'-'A'+1;
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			int distance = 26 - (Math.abs(prev - (input.charAt(i) - 'A' +1)));
			if(distance>13) distance = 26 - distance;
			count += distance;
			prev = (input.charAt(i)-'A') + 1;	
		}
		return count;
	}
}
