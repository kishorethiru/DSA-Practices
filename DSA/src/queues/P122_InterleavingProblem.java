package queues;

import java.util.ArrayDeque;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P122_InterleavingProblem {
	
	
	/*
	 *  1. 
    Input(s)? int[]
    Output ? int[]
    Constraints ?  Use queues	 

	2. Test data set
	
	        Positive :
	        Negative :
	        Edge     :
	
	3. Known Approaches
	        Approach 1 :Bruteforce 
	
	4. O-Notations
	
	5. Pseudocode
	 * 
	 * 
	 */
	
	@Test
	public void testData01() // Positive
	{
		int[] input = {1,3,5,7,2,4,6,8};
		Assert.assertTrue(Arrays.equals(interleaveArray(input), new int[] {1,2,3,4,5,6,7,8}));
		
	}
	
	@Test
	public void testData02() // Negative
	{
		int[] input = {};
		Assert.assertTrue(Arrays.equals(interleaveArray(input), new int[] {}));
	}
	
	@Test
	public void testData03() // Edge
	{
		int[] input = {1,2};
		Assert.assertTrue(Arrays.equals(interleaveArray(input), new int[] {1,2}));
	}
	
	/*
	 *  Create a queue
	 *  Iterate the queue till n/2
	 *  	Add the i value to queue
	 *  	Add the i+n/2 value to queue  
	 *  Create an int array and add element from queue to array
	 *  return that int array
	 * 
	 */
	private int[] interleaveArray(int[] input) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int p1 =0, p2 = input.length/2;
		while(p1<input.length/2){
			queue.offer(input[p1++]);
			queue.offer(input[p2++]);
		}
		for (int i = 0; i < input.length; i++) {
			input[i] = queue.poll();
		}	
		return input;
	}
	
	

}
