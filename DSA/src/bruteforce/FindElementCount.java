package bruteforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindElementCount 
{
	/*
	 * Given an integer array arr, count how many elements x there are, 
		such that x + 1 is also in arr. If there are duplicates in arr, count them separately.
		
		Example 1:
		
		Input: arr = [1,2,3]
		Output: 2
		Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
		Example 2:
		
		Input: arr = [1,1,3,3,5,5,7,7]
		Output: 0
		Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
		Example 3:
		
		Input: arr = [1,3,2,3,5,0]
		Output: 3
		Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
		Example 4:
		
		Input: arr = [1,1,2,2]
		Output: 2
		Explanation: Two 1s are counted cause 2 is in arr.
		Example 5:
		
		Input: arr = [1,1,2]
		Output: 2
		Explanation: Both 1s are counted because 2 is in the array.
	 */
	
	/*
	 * 1. Did I understand the problem? Yes
	 
        What is the input(s)? int[]  
        What is the expected output? int 
        Do I have any constraints to solve the problem? No 
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
        1,2,3
        1,1,3,3,5,5,7,7
       -1,1,0,-3
        
		2. Test data set
		        Minimum  3 data set including positive, negative and edge
		        Validate with the interviewer if the data set is fine by his/ her assumptions
		
		3. Do I know to solve it?
		        Yes- great is there an alternate ? Yes
		        No - can I break the problem into sub problems?
		
		4. Ask for hint (if you dont know how to solve this
		5.  Do I know alternate solutions as well - Yes
				Approach 1 : Bruteforce using two for loops
		        Approach 2 : Using List DS
		        Approach 3 : Using Map
		
		6. If you know the alternate solution find out the O-notations (performance)
				Approach 1 : Bruteforce using two for loops - O(n^2)
		        Approach 2 : Using List DS - O(n)
		        Approach 3 : Using Map
	 * 
	 */
	
	@Test
	public void testData01()
	{
		int[] data = {1,2,3};
		int op     = 2;
		Assert.assertTrue(findElementCount(data)==op);	
		Assert.assertTrue(findElementCountWithList(data)==op);
		Assert.assertTrue(findElementCountWithHashmap(data)==op);
	}
	@Test
	public void testData02()
	{
		int[] data = {1,1,3,3,5,5,7,7};
		int op     = 0;
		Assert.assertTrue(findElementCount(data)==op);
		Assert.assertTrue(findElementCountWithList(data)==op);
		Assert.assertTrue(findElementCountWithHashmap(data)==op);
		
	}
	@Test
	public void testData03()
	{
		int[] data = {-1,1,0,-3};
		int op     = 2;
		Assert.assertTrue(findElementCount(data)==op);
		Assert.assertTrue(findElementCountWithList(data)==op);
		Assert.assertTrue(findElementCountWithHashmap(data)==op);
	}
	
	/* Pseudocode - Bruteforce using two for loops
	 * If input array length is > 2 return 0
	 * Create a variable count
	 * Iterate the data
	 *    Iterate the data again in a inner loop
	 *    if data[i]+1 = data[j] and i != j increment the index and move to next index
	 * return count
	 * Time : O(n^2)
	 * Space : O(1)
	 */
	private int findElementCount(int[] data) {
		if(data.length < 2) return 0;
		int count = 0;
		for (int i = 0; i < data.length; i++) 
		{
			for (int j = 0; j < data.length; j++) 
			{
				if((data[i]+1)==data[j] && i!=j) 
				{ 
					count++;
					break;
				}
				
			}
		}
		return count;
	}
	
	/* Pseudocode Using List
	 * If input length is less than 2 return 0
	 * Create a list and add the items from array to list
	 * Create a variable count
	 * Iterate the array
	 *   if list contains current value +1 
	 *   increment the count
	 * Return 0 
	 * Time : O(n) + O (n) => O(n)
	 * Space : O(n)
	 */
	
	private int findElementCountWithList(int[] data)
	{
		if(data.length < 2) return 0;
		int count = 0;
		List<Integer> inputData = new ArrayList<>();
		for (int i : data) 
			 inputData.add(i);
		for (int i : data) 
			if(inputData.contains(i+1)) count++;
		return count;	
	}
	
	/* Pseudocode - Using HashMap
	 * If array length is less than 2 return 0
	 * Push the items and its occurrences into hash map as K,V
	 * Create a variable with count as 0
	 * Iterate the array
	 *   Check if the map contains current element value + 1
	 *    if present get the value of current element and add to count
	 * return count
	 *  
	 *  Time : O(n)
	 *  Space : O(n)
	 */
	
	private int findElementCountWithHashmap(int[] data)
	{
		if (data.length < 2)
			return 0;
		int count = 0;
		Map<Integer, Integer> inputData = new HashMap<Integer, Integer>();
		for (int i : data) {
			inputData.put(i, inputData.getOrDefault(i, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> eachItem : inputData.entrySet()) {
			if (inputData.containsKey(eachItem.getKey() + 1))
				count += eachItem.getValue();
		}
		return count;
	}
	
	

}
