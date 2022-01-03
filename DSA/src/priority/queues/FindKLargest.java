	package priority.queues;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class FindKLargest {
	/*
		Problem Statement
		Find the Kth Largest element in the given array
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
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

		int[] input = {};
		int[] output = {};
//		Assert.assertTrue();
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	private int findKMax(int[] input) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b.compareTo(a));
		return 0;
	}
}
