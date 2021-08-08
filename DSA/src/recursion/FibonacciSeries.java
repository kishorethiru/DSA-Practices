package recursion;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class FibonacciSeries {
	/*
		Problem Statement
		
		 Find the fibonacci series of given number n
		 
		 1. Base condition n - times 
		 2. 3 - 0 1 1 2
		 3. 10 or 0
		 4. Pattern -   
	
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
		System.out.println(findFibonacci(3));
	}

	@Test
	public void testData02() { // Negative
		System.out.println(findFibonacci(1));
	}

	@Test
	public void testData03() { // Edge
		System.out.println(findFibonacci(13));
	}
	
	private int findFibonacci(int n) {
		if(n == 0) return 0;
		if(n == 2 || n == 1) return 1;
		int  retVal= findFibonacci(n-1)+findFibonacci(n-2);
		return retVal;
	}
}
