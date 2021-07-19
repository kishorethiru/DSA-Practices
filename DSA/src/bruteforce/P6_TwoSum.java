package bruteforce;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P6_TwoSum 
{
	
	/* Problem Statement
	  * Given a array of integers return the indices which equals the target value
	  * 1. Did I understand the problem? yes or no

	        If no ask the person to provide with more details with examples
	        If yes go to the next step

	        What is the input(s)? int[] , int 
	        What is the expected output? int[]
	        Do I have any constraints to solve the problem? Same number cannot be added twice
	        Do I have all the information to go to the next steps?  Yes
	        How big is your test data set will be? 
			1,2,3,4,0,5 target 5 
			1,2,3  target 6
			1,4,5,6 target 10
			

	2. Test data set
	        Minimum  3 data set including positive, negative and edge
	        Validate with the interviewer if the data set is fine by his/ her assumptions

	3. Do I know to solve it?
	        Yes- great is there an alternate ? Yes, Using hashmap
	        No - can I break the problem into sub problems?

	4. Ask for hint (if you dont know how to solve this
	5.  Do I know alternate solutions as well
	        Yes- what are those?
	        No- that is still fine, proceed to solve by what you know
	        Approach 1 : Using Bruteforce using two for loops 
	        Approach 2 :Using HashMapSinglePass
	        
	6.      Approach 1 : Using Bruteforce using two for loops - O(n^2)
			Approach 2 : Using HashMapSinglePass - O(n)  
			
			
	  */
	@Test
	public void testData01()
	{
		int[] input = {1,2,3,4,0,5};
		int target = 5;
		Assert.assertArrayEquals(findIndexofTwoSum(input,target), new int[] {0,3});	
		Assert.assertArrayEquals(findIndexOfSumHashMap(input,target), new int[] {1,2});
	}
	
	@Test
	public void testData02()
	{
		int[] input = {1,2,3};
		int target = 6;
		Assert.assertArrayEquals(findIndexofTwoSum(input,target), new int[] {});
		Assert.assertArrayEquals(findIndexOfSumHashMap(input,target), new int[] {});
		
	}
	@Test
	public void testData03()
	{
		int[] input = {1,4,5,6};
		int target = 10;
		Assert.assertArrayEquals(findIndexofTwoSum(input,target), new int[] {1,3});	
		Assert.assertArrayEquals(findIndexOfSumHashMap(input,target), new int[] {1,3});
	}
	
	/*
	 * if data length is less than 2, return empty {}
	 * Iterate the data starting from index i
	 *    Iterate the data again from i+1
	 *    if  i + j equals target return the i and j in a array
	 * return {}
	 * 
	 * Time : O(n^2)
	 * Space : O(1)
	 * 
	 */
	
	private int[] findIndexofTwoSum(int[] input, int target) {
		if(input.length < 2) return new int[] {};
		for (int i = 0; i < input.length-1; i++) 
		{
			for (int j = i+1; j < input.length; j++) 
			{
				if(input[i]+input[j]==target) return new int[] {i,j};
			}
		}
		return new int[] {};
	}
	
	/* Pseudocode - Hashmap
	 * 
	 * if data length is less than 2, return empty {}
	 * Create a map as Value as key and index of element as value
	 * Iterate the input
	 * 	Check if the difference of target - current element is present in map
	 *   if present return the value of difference and current index
	 *   
	 * Time : O(n)
	 * Space : O(n) 
	 */
	
	private int[] findIndexOfSumHashMap(int[] data, int target)
	{
		if(data.length < 2) return new int[] {};
		Map<Integer, Integer> inputData = new HashMap<>();
		for (int i = 0; i < data.length; i++) 
		{
			int diff = target - data[i];
			if(inputData.containsKey(diff)) return new int[] {inputData.get(diff),i};
			else inputData.put(data[i],inputData.getOrDefault(data[i],0)+1);
		}
		return new int[] {};		
	}
	
	
}
