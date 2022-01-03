package stacks;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P120_DailyTemperature {
	
	/*
	 *   Given an array of integers temperatures represents the daily temperatures, 
	 *   return an array answer such that answer[i] is the number of days
	 *    you have to wait after the ith day to get a warmer temperature. 
	 *    If there is no future day for which this is possible, keep answer[i] == 0 instead.
		
		Example 1:
		
		Input: temperatures = [73,74,75,71,69,72,76,73]
		Output: [1,1,4,2,1,1,0,0]
		Example 2:
		
		Input: temperatures = [30,40,50,60]
		Output: [1,1,1,0]
		Example 3:
		
		Input: temperatures = [30,60,90]
		Output: [1,1,0]
	 * 
	 * 
	 */
	
	/*   
	 * 1. 
    Input(s)? int[]
    Output ? int[]
    Constraints ?  

	2. Test data set
	
	        Positive : [73,74,75,71,69,72,76,73]
	        Negative : [30,30,30,30]
	        Edge : [30,40,50,60]
	        Edge     : [30,60,90]
	
	3. Known Approaches
	        Approach 1 :Bruteforce
	        Approach 2 :Two Ptrs 
	        Approach 3 :Using Stacks
	        
	
	4. O-Notations
	
	5. Pseudocode
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {73,74,75,71,69,72,76,73};
		dailyTemperatures(input);
		int[] output = {1,1,4,2,1,1,0,0};
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayBruteForce(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayTwoPtr(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDay(input), output));
	}


	@Test
	public void testData02(){			 // Negative
		int[] input = {30,30,30,30};
		int[] output = {0,0,0,0};
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayBruteForce(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayTwoPtr(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDay(input), output));
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {30,40,50,60};
		int[] output = {1,1,1,0};
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayBruteForce(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayTwoPtr(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDay(input), output));
	}
	
	@Test
	public void testData04(){			 // Edge
		int[] input = {30,60,90};
		int[] output = {1,1,0};
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayBruteForce(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayTwoPtr(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDay(input), output));
	}
	
	@Test
	public void testData05(){			 // Edge
		int[] input = {10,30,10,5,4,3,2,1,10,10,0};
		int[] output = {1,0,0,5,4,3,2,1,0,0,0};
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayBruteForce(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDayTwoPtr(input), output));
		Assert.assertTrue(Arrays.equals(getNextTemperatureDay(input), output));
	}
	
	/* Create a output array of length as input
	 * Iterate the input from starting index to last index -1
	 * 	 Iterate the input in the inner loop from i+1
	 *   	if the current element in  inner loop is greater than i
	 *      find the difference between the index and insert to op array
	 *      else insert -1
	 * return the array 
	 * 
	 */
	private int[] getNextTemperatureDayBruteForce(int[] input) {
		int[] op = new int[input.length];
		for (int i = 0; i < op.length-1; i++) {
			for (int j = i+1; j < op.length; j++) {
				if(input[j]>input[i]) {
					op[i] = (j-i);
					break;
				}			
			}
		}
		return op;
	}
	/* Create a output array of length input
	 * Initialize two ptr left as 0 and right as 1
	 * Iterate the input
	 * 	 move right ptr till it finds the value greater than left value
	 *   if found find the difference between left and right and add to op array
	 *   increment left and right as left+1	
	 * 
	 */
	private int[] getNextTemperatureDayTwoPtr(int[] input) {
		int[] op = new int[input.length];
		int left =0, right = 1;
		while(left<input.length-1) {
			while(input[right]<=input[left] && right++ < input.length-1);
			if(right < input.length)op[left] = right-left; 
			left++;
			right = left+1;
		}
		return op;	
	}
	
	/* 
	 * Create a output array of length input
	 * Create a stack
	 * Iterate the input
	 *   Add the current element to stack
	 *   Add a variable count as 0 and nextElement = i
	 *   Untill the next greater element is found && range is with input length || i != input length 
	 *       Add to stack, increment count
	 *   if(nextElement> input length) add 0 to the current index of output array
	 *   else 
	 *   	add count to the current index of output array
	 *       pop the element from the stack of count times
	 *
	 *return output array
	 *
	 *Time - O(n^2)
	 *Space- O(n)
	 * 
	 */

	private int[] getNextTemperatureDay(int[] input) {
		int[] op = new int[input.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			stack.push(input[i]);
			int count = 0;
			int nextEle = i;
			while (input[i] >= stack.peek() && ++nextEle < input.length) {
				stack.push(input[nextEle]);
				count++;
			}
			if (nextEle > input.length-1 || i == input.length - 1)
				op[i] = 0;
			else
				op[i] = count;
		}
		return op;
	}
	
	public int[] dailyTemperatures(int[] temperatures) {
	    Stack<Integer> stack = new Stack<>();
	    int[] ret = new int[temperatures.length];
	    for(int i = 0; i < temperatures.length; i++) {
	        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
	            int idx = stack.pop();
	            ret[idx] = i - idx;
	        }
	        stack.push(i);
	    }
	    return ret;
	}
	

}
