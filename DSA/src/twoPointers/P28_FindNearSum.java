package twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P28_FindNearSum 
{
	
	/* 
	 * Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
 
		Example 1:
		Input: nums = [34,23,1,24,75,33,54,8], k = 60
		Output: 58
		Explanation: We can use 34 and 24 to sum 58 which is less than 60.
		Example 2:
		Input: nums = [10,20,30], k = 15
		Output: -1
		Explanation: In this case it is not possible to get a pair sum less that 15.
	 * 
	 */
	
	/*
	 * 1. Did I understand the problem?  Yes

        What is the input(s)? int[], int
        What is the expected output? int 
        Do I have any constraints to solve the problem? Bruteforce, TwoPtr 
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
        nums = [34,23,1,24,75,33,54,8], k = 60 // 58
        nums = [10,20,30], k = 15 // -1
        nums = [-1,-3,1,-2] k = -1 // -2
        

	2. Test data set
	        Minimum  3 data set including positive, negative and edge
	        Validate with the interviewer if the data set is fine by his/ her assumptions
	
	3. Do I know to solve it?
	        Yes- great is there an alternate ? Two ptr
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
		int[] input = {34,23,1,24,75,33,54,8};
		int target = 60;
		Assert.assertTrue(findNearSumTwoPtr(input,target)==58);
		
	}
	
	@Test
	public void testData02()
	{
		int[] input = {10,20,30};
		int target = 15;
		Assert.assertTrue(findNearSumTwoPtr(input,target)==-1);
		
	}
	
	@Test
	public void testData03()
	{
		int[] input = {-1,-3,1,-2};
		int target = -1;
		Assert.assertTrue(findNearSumTwoPtr(input,target) == -2);
		
	}
	
	@Test
	public void testData04()
	{
		int[] input = {10,20,-30};
		int target = -5;
		Assert.assertTrue(findNearSumTwoPtr(input,target)==-10);
		
	}
	/* Int maxSum = Add the first two index value
	 * Traverse the array 0 to length - 1
	 *   Traverse the same from 1 to end
	 *   Add value of i and j  
	 *   if sum >= k continue
	 *   else sum < k  && maxSum < sum , replace maxSum with sum 
	 *   Time : O(n^2)
	 *   Space : O(1)
	 */
	
	private int findNearSumBruteForce(int[] input, int target)
	{
		if (input.length < 2) return -1;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < input.length - 1; i++) {
			int sum = 0;
			for (int j = i + 1; j < input.length; j++) {
				sum = input[i] + input[j];
				if (sum < target) maxSum = Math.max(maxSum, sum);
			}
		}
		maxSum = (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
		System.out.println(maxSum);
		return maxSum;
	}
	
	/* Pseudocode - Two pointers
	 * Sort the input
	 * initialize two pointer left = 0 right = intput length -1
	 * initialize maxSum and assign Integer.MIN_VALUE
	 * Iterate in till (left<right)
	 * 	 initialize sum and add the sum of left and right
	 *   if value of left and value of right < target, compare and save the max value in maxSum, increment left
	 *   if sum > target right--;
	 *   else left++;
	 *   
	 *   Time : n log n + O(n) => nlog n
	 *   Space : n log n 
	 */
	
	private int findNearSumTwoPtr(int[] data, int target)
	{
		Arrays.sort(data);
		int maxSum = Integer.MIN_VALUE;
		int left = 0, right = data.length - 1;
		while (left < right) {
			int sum = data[left] + data[right];
			if (sum < target) {
				maxSum = Math.max(maxSum, sum);
				left++;
			} else if (sum > target)
				right--;
			else
				left++;
		}
		maxSum = (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
		return maxSum;
	}
	
	
	
	
	
	
	
	

}
