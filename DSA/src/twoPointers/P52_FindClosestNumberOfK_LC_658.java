package twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P52_FindClosestNumberOfK_LC_658 {
	/*
	 * https://leetcode.com/problems/find-k-closest-elements/
	 * 658. Find K Closest Elements
		Problem Statement
		Given a sorted integer array arr, two integers k and x, return the k closest 
		integers to x in the array. The result should also be sorted in ascending order.
		An integer a is closer to x than an integer b if:
		|a - x| < |b - x|, or
		|a - x| == |b - x| and a < b
		 
		Example 1:
		Input: arr = [1,2,3,4,5], k = 4, x = 3
		Output: [1,2,3,4]
		Example 2:
		Input: arr = [1,2,3,4,5], k = 4, x = -1
		Output: [1,2,3,4]
		 Example 3:
		Input: arr = [8,17,24,25,28], k = 3, x = 23
		Output: [24,25,28]
		2 
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int k, x
		  Output ? int[]
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : Two Pointer
	
	   4.  O - Notation 
			 Approach 1 : Two Pointer - Time O(n),Space - O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,2,3,4,5};
		int k = 4, x = 3;
		Assert.assertTrue(Arrays.equals(findClosestNumbersBS(input,k,x), new int[] {1,2,3,4}));
	}

	@Test
	public void testData02() { // Edge
		int[] input = {1,2,3,4,5};
		int k = 4, x = -1;
		Assert.assertTrue(Arrays.equals(findClosestNumbersBS(input,k,x), new int[] {1,2,3,4}));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {8,17,24,25,28};
		int k = 3, x = 23;
		Assert.assertTrue(Arrays.equals(findClosestNumbersBS(input,k,x), new int[] {24,25,28}));
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {8,17,24,25,28};
		int k = 3, x = 0;
		Assert.assertTrue(Arrays.equals(findClosestNumbersBS(input,k,x), new int[] {8,17,24}));
	}
	@Test
	public void testData05() { // Edge
		int[] input = {1,3,4,5,6};
		int k = 5, x = 5;
		Assert.assertTrue(Arrays.equals(findClosestNumbersBS(input,k,x), new int[] {1,3,4,5,6}));
	}
	
	/* If  x == 0 return array of length k
	 * Create a returnArray of length k
	 * Create int as index = 0
	 * Initialize left = 0, right = length-1;
	 * Iterate till left < right
	 *   If abs value of left < right -> add left value to the outputarr, increment left
	 *   if abs value of left > right -> add right value to the outputArr, decrement right
	 *   if abs value of left == right
	 *           left > right => add right to outArr, decrement right
	 *           else add left outArr, increment left
	 *   if (index == k) break; 
	 * return outputArr
	 * 
	 * Time : O(n)
	 * Space : O(k)
	 */
	private int[] findClosestNumbers(int[] input, int k, int x) {
		if(x==0) return Arrays.copyOf(input, k);
		int[] retArr = new int[k];
		int left = 0, right = input.length-1;
		int leftIndex = 0, rightIndex = k-1;
		while(left <= right){
			if(left==right) {
				retArr[leftIndex++] = input[left++];
			}
			if(Math.abs(input[left]-x)< Math.abs(input[right]-x)) retArr[leftIndex++] = input[left++];
			else if(Math.abs(input[left]-x) > Math.abs(input[right]-x)) retArr[rightIndex--] = input[right--];
			else if(Math.abs(input[left]-x) == Math.abs(input[right]-x)) {
				if(input[left]<input[right]) {
					retArr[leftIndex++] = input[left++];
				}
				else retArr[rightIndex--] = input[right--];
			}
			if(leftIndex > rightIndex) break;
		}
		return retArr;
	}
	
	private int[] findClosestNumbersBS(int[]nums, int k, int x) {
		int low = 0, high = nums.length - k;
		while (low < high) {
			int mid = (low + high) / 2;
			if (x - nums[mid] > nums[mid + k] - x) low = mid + 1;
			else high = mid;		
		}
		int[] op = new int[k];
		int index = 0;
		while (k-- != 0) op[index++] = nums[low++];
		return op;
	}
}
