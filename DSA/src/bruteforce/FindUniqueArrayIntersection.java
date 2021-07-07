package bruteforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindUniqueArrayIntersection 
{
	/*
	 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 
		Example 1:
		Input: nums1 = [1,2,2,1], nums2 = [2,2]
		Output: [2]
		
		1. Did I understand the problem? Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? two int[]
        What is the expected output?  int[]
        Do I have any constraints to solve the problem? Do not sort
        Do I have all the information to go to the next steps  Yes
        How big is your test data set will be? 
        [1,2,2,1] [2,2]
        [1,2,3,4,5] [3,4,5]
        [7,8][1,2,3,4,5,7]
        [1] [2]
        [] [2]
        [1] []
        [] []
		

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? Yes, Using Hash Map
        No - can I break the problem into sub problems?

4. Ask for hint (if you dont know how to solve this
5.  Do I know alternate solutions as well
       Approach 1 : Brute forc using with iterations
       Approach 2 : Using Hash Map, Set 

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- O[N*M]
        Approach 2: O[m+n]
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it
	 * 
	 */
	@Test
	public void testData01()
	{
		int[] data1 = {1,2,2,1};
		int[] data2 = {2,2};
		int[] op = {2};
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
		
	}
	@Test
	public void testData02()
	{
		int[] data1 = {1,2,3,4,5,3,4,5};
		int[] data2 = {3,4,5,3,4,5};
		int[] op = {3,4,5};
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
		
	}
	
	@Test
	public void testData03()
	{
		int[] data1 = {7,8};
		int[] data2 = {1,2,3,4,5,7};
		int[] op = {7};
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
		
	}
	
	@Test
	public void testData04()
	{
		int[] data1 = {10,9,11,10,12};
		int[] data2 = {1,2,3,4,5,7};
		int[] op = {};
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
		
	}
	@Test
	public void testData05()
	{
		int[] data1 = {1};
		int[] data2 = {2};
		int[] op = {};
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
	}
	
	@Test
	public void testData06()
	{
		int[] data1 = {};
		int[] data2 = {2};
		int[] op = {};		
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
	}
	@Test
	public void testData07()
	{
		int[] data1 = {1};
		int[] data2 = {};
		int[] op = {};	
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
	}
	
	@Test
	public void testData08()
	{
		int[] data1 = {};
		int[] data2 = {};
		int[] op = {};	
		Assert.assertArrayEquals(getUniqueArrayInterSection(data1,data2), op);
		Assert.assertArrayEquals(getUniqueArrayInterSectionUsingSet(data1,data2), op);
		
	}
	/* Pseudocode
	 * Pre-Checks
	 *   if any one of array or both is empty return corresponding empty array
	 *   if both array length are same and if both are equal return the element in array
	 *    else return empty array 
	 * Create return array of length, which is lower in two input arrays
	 * Create a variable index
	 * Iterate the array
	 *  Check if current element is present in return array if present move to next element
	 *   else 
	 *    iterate the second array if current element matches element in 2 nd array
	 *    Insert to the new array after checking if its availability in the return array, increment the index
	 * Return the array by copying it till index 
	 * Time : O(m*n*o)
	 * Space : O(o) + O(1)  => O(o)
	 */
	
	private int[] getUniqueArrayInterSection(int[] data1, int[] data2) {
		int data1Length = data1.length;
		int data2Length = data2.length;
		if (data1Length == 0 || data2Length == 0)
			return new int[] {};
		if (data1Length == 1 || data2Length == 1) {
			if (data1[0] == data2[0])
				return new int[] { data1[0] };
			else
				return new int[] {};
		}
		int arraySize = (data1Length < data2Length) ? data1Length : data2Length;
		int[] returnArr = new int[arraySize];
		arraySize = 0;
		for (int i = 0; i < data1.length - 1; i++) {
			if (isElementPresentInData(returnArr, data1[i], arraySize) && i != 0) {
				continue;
			} else {
				for (int j = 0; j < data2Length; j++) {
					if (data1[i] == data2[j] && !isElementPresentInData(returnArr, data1[i], arraySize)) {
						returnArr[arraySize++] = data1[i];
						break;
					}
				}
			}
		}
		return Arrays.copyOf(returnArr, arraySize);
	}
	
	/*
	 * Iterate the array till the index
	 * If current element matches target
	 *  return true
	 *  else false
	 *  
	 *  Time : O(i)
	 *  Space : O(1)
	 */
	private boolean isElementPresentInData(int[] data, int target, int index) {
		for (int i = 0; i < index; i++) {
			if (data[i] == target)
				return true;
		}
		return false;
	}
	
	/*Pseudocode - HashSet
	 * Pre-Checks
	 *   if any one of array or both is empty return empty array
	 *   if both array length are same and if both are equal return the element in array
	 *    else return empty array
	 * Create a set and push data 1 to the set
	 * Create return array of length, which is lower in two input arrays
	 * Iterate the data2
	 *  Check if the current element is present in set
	 *   if present  Check if its available in return array if not available
	 *   push to the return array
	 * Return the array till the values are filled
	 * 
	 * Time => O(m) + O(n*o) => O(n*o)
	 * Space => O(n) + O(o) => O(n)
	 */
	
	private int[] getUniqueArrayInterSectionUsingSet(int[] data1, int[] data2) 
	{	
		int data1Length = data1.length;
		int data2Length = data2.length;
		if (data1Length == 0 || data2Length == 0)
			return new int[] {};
		if (data1Length == 1 || data2Length == 1) {
			if (data1[0] == data2[0])
				return new int[] { data1[0] };
			else
				return new int[] {};
		}
		int arraySize = (data1.length < data2.length) ? data1.length : data2.length;
		int[] returnArr = new int[arraySize];
		arraySize = 0;
		Set<Integer> data1Set =  new HashSet<>();
		for (Integer i : data1) 
		{
			data1Set.add(i);
		}
		for (int i : data2) 
		{
			if(data1Set.contains(i))
			{
				if (!isElementPresentInData(returnArr,i,arraySize))   returnArr[arraySize++] = i;
			}
		}
		return Arrays.copyOf(returnArr, arraySize);
	}
	
	
	

}
