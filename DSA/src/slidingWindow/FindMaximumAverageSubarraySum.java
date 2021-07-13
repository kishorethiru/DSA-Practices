package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class FindMaximumAverageSubarraySum 
{
	/*
	 * You are given an integer array nums consisting of n elements, and an integer k.

		Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
		
		 
		
		Example 1:
		
		Input: nums = [1,12,-5,-6,50,3], k = 4
		Output: 12.75000
		Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
		Example 2:
		
		Input: nums = [5], k = 1
		Output: 5.00000
	 * 
	 */
	
	/*1. Did I understand the problem? Yes
        What is the input(s)? int[], int
        What is the expected output? double
        Do I have any constraints to solve the problem? O(n)
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
		

		2. Test data set
		        Minimum  3 data set including positive, negative and edge
		        Validate with the interviewer if the data set is fine by his/ her assumptions
		
		3. Do I know to solve it?
		        Yes- great is there an alternate ?
		        No - can I break the problem into sub problems?
		
		4. Ask for hint (if you dont know how to solve this
		5.  Do I know alternate solutions as well
		        Yes- what are those?
		        No- that is still fine, proceed to solve by what you know
		
		6. If you know the alternate solution find out the O-notations (performance)
	 * 
	 */
	
	@Test
	public void testData01()
	{
		int[] input = {1,12,-5,-6,50,3};
		int k = 4;
		Assert.assertTrue(findMaxAverageSum(input,k) == 12.75000);	
	}
	@Test
	public void testData02()
	{
		int[] input = {5,6,7,8,1,4};
		int k = 1;
		Assert.assertTrue(findMaxAverageSum(input,k) == 8.00000);	
	}
	@Test
	public void testData03()
	{
		int[] input = {1,1,1,1,1,0};
		int k = 2;
		Assert.assertTrue(findMaxAverageSum(input,k) == 1.00000);	
	}
	
	/* If k  <= 0, throws exception
	 * Initialize double variables maxSum and currentSum
	 * Iterate the input till the k, add to the maxSum
	 * Assign maxSum to currentSum
	 * Iterate the input from target to input length
	 *   Remove the count of first element and add the current element to the currentSum
	 *   Compare maxSum and currentSum and store the max value to maxSum
	 * return the maxSum/k  
	 * 
	 */
	
	private double findMaxAverageSum(int[] input, int k) {
		if(k <= 0) throw new RuntimeException("Invalid Input");
		double maxSum = 0, currentSum = 0;
	    for(int i = 0; i < k;i++){
	        maxSum += input[i];
	    }
	        currentSum = maxSum;
	    for(int i = k; i < input.length; i++){
	    	currentSum    = currentSum-input[i-k] + input[i];
	        maxSum = Math.max(currentSum, maxSum);  
	    }
	     return maxSum/k;
	}
}
