package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class P27_MoveOddNumbersToRight 
{
//	Given an int[], move all the odd numbers to the right
	
	/*
	 * 1. Input = int[]
	 *    output = int[]
	 *    Constraints = ?
	 * 3. Alternative approach - Yes
	 * 4. Hints - No
	 * 5. Alternate solutions
	 *          Approach 1 - Using two for loops
	 *          Approach 2 - Using two pointers 
	 *          
	 * 6. Big - O Notations
	 * 			Approach 1 - Using two for loops - O(n^2), O(n)
	 *          Approach 2 - Using two pointers - O(n), O(1)
	 */

//	2)
	@Test 
	public void testData01() // Positive
	{
		int[] input = {2,1,3,6,8,0};
		int[] output = {2,0,8,6,3,1};
		Assert.assertTrue(Arrays.equals(moveOddToRight(input), output));
		
	}
	
	@Test 
	public void testData02() // Negative
	{
		int[] input = {2,4,6,8,2};
		int[] output = {2,4,6,8,2};
		Assert.assertTrue(Arrays.equals(moveOddToRight(input), output));
	}
	
	@Test 
	public void testData03() // Edge
	{
		int[] input = {1,3,5,7,9,0};
		int[] output = {0,3,5,7,9,1};
		Assert.assertTrue(Arrays.equals(moveOddToRight(input), output));
	}
	
	@Test 
	public void testData04() // Edge
	{
		int[] input = {-3,-1,-5,-2,-4,-6};
		int[] output = {-6,-4,-2,-5,-1,-3};
		Assert.assertTrue(Arrays.equals(moveOddToRight(input), output));
	}
	/* Pseudocode -Bruteforce
	 * 1. Create two list oddNum and evenNum
	 * 2. Iterate the input
	 *       a)push odd numbers to oddNum list
	 *       b)push even numbers to evenNum list
	 * 3. Merge evenNum list with oddNum list.
	 * 4. return the evenNum list converting to array
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 * 
	 */
	
	private int[] moveOddToRightBruteForce(int[] input)
	{
		List<Integer> oddList = new ArrayList<>();
		List<Integer> evenList = new ArrayList<>();
		for (int i = 0; i < input.length; i++) 
		{
			if(input[i]%2 == 0) evenList.add(input[i]);
			else oddList.add(input[i]);
		}
		evenList.addAll(oddList);
		int index = 0; 
		for (Integer val : evenList) {
			input[index++] = val; 
		}
		return input;
	}
	
	
	/* Pseudocode - Two pointers
	 * 1. If input length < 2, return the input
	 * 2. Initialize Two pointers left = 0, right = input.length -1
	 * 3. Traverse the input till left < right
	 *    	a) if right index value is an odd number, decrement right
	 *      b) else if left value is a odd number, swap left and right value, 
	 *      	increment left, decrement right
	 *      c) else left ++
	 * 4. return input[]
	 * 
	 * Time : Worst/Medium case - O(n), Best Case - O(n/2) 
	 * Space : O(1)
	 */
	
	private int[] moveOddToRight(int[] input) {
		if(input.length < 2) return input;
		int left = 0, right = input.length - 1;
		while (left < right) {
			if (input[right] % 2 != 0)
				right--;
			else if (input[left] % 2 != 0) {
				int temp = input[left];
				input[left++] = input[right];
				input[right--] = temp;
			} else
				left++;
		}
		return input;
	}
	
	
}
