package bruteforce;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallNumber {
	/*
	 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
		Return the answer in an array
			Example 1:
			
			Input: nums = [8,1,2,2,3]
			Output: [4,0,1,1,3]
			Explanation: 
			For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
			For nums[1]=1 does not exist any smaller number than it.
			For nums[2]=2 there exist one smaller number than it (1). 
			For nums[3]=2 there exist one smaller number than it (1). 
			For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
			Example 2:
			
			Input: nums = [6,5,4,8]
			Output: [2,1,0,3]
			Example 3:
			
			Input: nums = [7,7,7,7]
			Output: [0,0,0,0]
			 
			
			Constraints:
			
			2 <= nums.length <= 500
			0 <= nums[i] <= 100
			Accepted
	 * 
	 */
	
	/*
	 * 1. Did I understand the problem? Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step
        
        Q: 
		1. Does the output array needs to be in same order?
	
        What is the input(s)? int[]
        What is the expected output? int[] 
        Do I have any constraints to solve the problem?try to do with O(n) 
        Do I have all the information to go to the next steps 
        How big is your test data set will be?
        [4,0,1,3] , [1,1,1] [2,5,-2,0]
		

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? No
        No - can I break the problem into sub problems?

4. Ask for hint (if you dont know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those? No
        No- that is still fine, proceed to solve by what you know
        
        Approach 1: Brute force
        Approach 2: Using sorting

6. If you know the alternate solution find out the O-notations (performance)
	 * Approach 1 : Brute force Time : O(n^2)
	 */
	
	@Test
	public void testData01()
	{
		int[] input = {4,0,1,1,3};
		int[] output = {4,0,1,1,3}; 
		int[] sorOutput = {0,1,1,3,4};
		Assert.assertArrayEquals(findNoOfSmallNumber(input), output);
		Assert.assertArrayEquals(findNoOfSmallNumberUsingSorting(input), sorOutput);
	}
	@Test
	public void testData02()
	{
		int[] input = {1,1,1};
		int[] output = {0,0,0}; 
		int[] sorOutput = {0,0,0};
		Assert.assertArrayEquals(findNoOfSmallNumber(input), output);
		Assert.assertArrayEquals(findNoOfSmallNumberUsingSorting(input), sorOutput);
	}
	@Test
	public void testData03()
	{
		int[] input = {2,5,-2,0};
		int[] output = {2,3,0,1}; 
		int[] sorOutput = {0,1,2,3}; 
		Assert.assertArrayEquals(findNoOfSmallNumber(input), output);
		Assert.assertArrayEquals(findNoOfSmallNumberUsingSorting(input), sorOutput);
	}
	
	/*
	 * Create a array of length n as retArr
	 * Iterate the input
	 *   initialize a variable count with 0
	 *   Iterate the input 
	 *   if outer loop element index and inner loop index is not same and
	 *      outer loop current value > inner loop current value, increment count
	 *   push to the  retArr
	 *  Return retArray
	 * Time: O(n^2)
	 * Space: O(n) + O(1) = > O(n^2)
	 */
	
	private int[] findNoOfSmallNumber(int[] data)
	{
		if ((data.length<2) || (data.length > 500)) throw new RuntimeException("Invalid Input");
		int[] retArr = new int[data.length];
		for (int i = 0; i < retArr.length; i++) 
		{
		  int count = 0;
		  for (int j = 0; j < retArr.length; j++) 
		  {
			  if(i!=j && data[i]>data[j]) count++;
			
		  }
		  retArr[i] = count;
		}
		return retArr;		
	}
	
	/*
	 * Sort the input
	 * Create a array retArr of length n
	 * Iterate the input from index 1
	 *  if current index element and current index -1 are same, then previous index count to 
	 *    current index in retArr
	 *  if current index element is greater than current index -1 element then add the count as index and push to ret Arr
	 * Return retArr
	 * Time : n log n + O(n) => n log n
	 * Space : O(n)
	 */
	
	private int[] findNoOfSmallNumberUsingSorting(int[] data)
	{
		Arrays.sort(data); // nlog n
		int[] retArr = new int[data.length];
		for (int i = 1; i < retArr.length; i++) //O(n) 
		{
			if(data[i-1] == data[i]) retArr[i] = retArr[i-1];
			else retArr[i] = i;	
		}
		return retArr;
		
	}
	
	
	
	

}
