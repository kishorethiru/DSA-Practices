package recursion;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P154_MutlipleTwoNums {
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
		System.out.println(multiplyTwoNums(4,4));
	}

	@Test
	public void testData02() { // Negative
		System.out.println(multiplyTwoNums(0,4));
	}

	@Test
	public void testData03() { // Edge
		System.out.println(multiplyTwoNums(4,1));
	}
	
	private int multiplyTwoNums(int a , int b) {
		if(b == 0 || a == 0) return 0;
		if(b == 1) return a;
		return a + multiplyTwoNums(a,b-1);
	}
}
