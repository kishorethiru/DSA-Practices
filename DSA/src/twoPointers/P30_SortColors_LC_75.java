package twoPointers;

import org.junit.Assert;
import org.junit.Test;

public class P30_SortColors_LC_75 {
	
	/*
	 * 
	 * https://leetcode.com/problems/sort-colors/
	 * 
	 * 75. Sort Colors
	 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

	We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
	
	You must solve this problem without using the library's sort function.
	
	 
	Example 1:
	
	Input: nums = [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
	
	Example 2:
	
	Input: nums = [2,0,1]
	Output: [0,1,2]
	
	Example 3:
	
	Input: nums = [0]
	Output: [0]
	 * 
	 */
	
	/*
	 * 1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step
      
        What is the input(s)? int[]
        What is the expected output? int[] 
        Do I have any constraints to solve the problem? No Default Sort function  
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
		

		2. Test data set
		        Minimum  3 data set including positive, negative and edge
		        Validate with the interviewer if the data set is fine by his/ her assumptions
		
		3. Do I know to solve it?
		        Yes- great is there an alternate ? No
		        No - can I break the problem into sub problems?
		
		4. Ask for hint (if you dont know how to solve this
		5.  Do I know alternate solutions as well
		        Yes- what are those?
		        No- that is still fine, proceed to solve by what you know
		
		6. If you know the alternate solution find out the O-notations (performance)
		Brute Force - Time - O(n) + O(n) => O(1), Space - O(n)
		
	 * 
	 */
	
	@Test
	public void testData01()
	{
		int[] data = {2,0,2,1,1,0};
		int[] op = {0,0,1,1,2,2};
		Assert.assertArrayEquals(sortColorsThreePtrs(data), op);
	}
	
	@Test
	public void testData02()
	{
		int[] data = {2,0,1};
		int[] op = {0,1,2};
		Assert.assertArrayEquals(sortColorsThreePtrs(data), op);
	}
	
	@Test
	public void testData03()
	{
		int[] data = {1};
		int[] op = {1};
		Assert.assertArrayEquals(sortColorsThreePtrs(data), op);
	}
	
	/* Pseudo code
	 * Create two pointer for count1 and count 2 = 0
	 * Create a return array of length 
	 * Iterate the array
	 *  if current element  == 1, increment count1;
	 *  if current element  == 2, increment count2;
	 * Initialize index = input.length - (count1 + count2)
	 * Till count1 becomes push 1 to retArr
	 * Till count2 becomes push 2 to retArr
	 * return retArr
	 * 
	 */
	private int[] sortColorsBruteForce(int[] data) {
		if (data.length < 2)
			return data;
		int[] retArr = new int[data.length];
		int count1 = 0, count2 = 0;
		for (int i : data) {
			if (i == 1)
				count1++;
			if (i == 2)
				count2++;
		}
		int index = data.length - (count1 + count2);
		while (count1 != 0) {
			retArr[index++] = 1;
			count1--;
		}
		while (count2 != 0) {
			retArr[index++] = 2;
			count2--;
		}
		return retArr;

	}
    //	{2,0,2,1,1,0}
	
	/* if input length is < 2 return input
	 * Create 3 ptr , low, mid as 0 and high as length -1
	 * Iterate the input till mid <= high
	 * 		a ) if current element 0, swap low element and mid, increment low and mid
	 *      b ) if current element 1, increment mid
	 *      c ) if current element 2, swap mid and high, decrement high  
	 * return the input
	 * 
	 * Complexity
	 * Time : O(n)
	 * Space : O(1)
	 * 
	 */
	private int[] sortColorsThreePtrs(int[] data) {
		if (data.length < 2)
			return data;
		int low = 0, mid = 0, high = data.length - 1;
		while (mid <= high) {
//			if current element 0, swap low element and mid, increment low and mid
			if (data[mid] == 0) {
				int temp = data[mid];
				data[mid++] = data[low];
				data[low++] = temp;
			}
//			if current element 1, increment mid
			else if (data[mid] == 1)
				mid++;
			else {
//				if current element 2, swap mid and high, decrement high
				int temp = data[mid];
				data[mid] = data[high];
				data[high--] = temp;
			}
		}
		return data;
	}
	

}
