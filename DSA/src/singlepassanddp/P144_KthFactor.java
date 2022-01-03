package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P144_KthFactor {
	/*
		Problem Statement
		Given two positive integers n and k. Find the k th factor of the n
		
	
	*/

	/*
	   1. 
	  	  Input(s) ? int,int
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : n = 12,k = 3
			Negative : n = 4, k = 4	
			Edge     : n = 1000 k = 3
	
	   3.  Approaches Known 
			 Approach 1 : Using the while loop
	
	   4.  O - Notation 
			 Approach 1 : Using the while loop 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int n = 12, k = 3;
		Assert.assertTrue(findKthFactor(n,k) == 4);
	}

	@Test
	public void testData02() { // Negative
		int n = 4, k = 4;
		Assert.assertTrue(findKthFactor(n,k) == -1);

	}

	@Test
	public void testData03() { // Edge
		int n = 12, k = 3;
		Assert.assertTrue(findKthFactor(n,k) == 4);
	}	
	
	/* Initialize div as 2
	 * if k is 1 return 1
	 * Iterate till k != 1
	 *   if div > n return -1
	 *   if n % div == 0 then decrement k
	 *   increment div
	 * return div
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */
	
	private int findKthFactor(int n, int k) {
		int div = 2;
		if(k==1) return 1;
		while(k!=1){
			if(div>n) return -1;
			if(n % div == 0) k--;
			div++;
		}
		
		return div;
	}
}
