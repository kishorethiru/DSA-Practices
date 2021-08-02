package queues;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P69_ReverseKElements {
	
/*  
 *  	1. 
    Input(s)? int[], int
    Output ? int[]
    Constraints ? Use Stacks and Queue 

	2. Test data set
	
	        Positive : 
	        Negative :
	        Edge     :
	
	3. Known Approaches
	        Approach 1 :Bruteforce 
	
	4. O-Notations
	
	5. Pseudocode
 * 
 */


@Test
public void testData01(){            // Positive
	int[] nums = {2,4,6,8,10};
	int k = 3;
	Assert.assertTrue(Arrays.equals(reverseKElements(nums,k), new int[] {6,4,2,8,10}));
}


@Test
public void testData02(){			 // Negative
	int[] nums = {2,4,6,8,10};
	int k = 0;
	Assert.assertTrue(Arrays.equals(reverseKElements(nums,k), new int[] {2,4,6,8,10}));
}

@Test
public void testData03(){			 // Edge
	int[] nums = {2,4,6,8,10};
	int k = 5;
	Assert.assertTrue(Arrays.equals(reverseKElements(nums,k), new int[] {10,8,6,4,2}));
}

/*
 * Pseudo code
 * Create a stack & queue
 * Traverse through the array until k
 *         Add elements of array to the stack
 * Traverse through the stack
 *         Pop the elements and add it to the queue
 * If k is lesser than length    
 *         Add the remaining elements to the queue
 * Return the queue
 */

private int[] reverseKElements(int[] nums, int k) {
	Stack<Integer> inputStack = new Stack<>();
	ArrayDeque<Integer> inputQueue = new ArrayDeque<>();
	for (int i = 0; i < k; i++) {
		inputStack.push(nums[i]);
	}
	while(!inputStack.isEmpty()) inputQueue.offer(inputStack.pop());
	for (int i = k; i < nums.length; i++) {
		inputQueue.offer(nums[i]);
	}
	int[] op = new int[nums.length];
	for (int i = 0; i < op.length; i++) {
		op[i] = inputQueue.poll();
	}
	return op;
}
}
