package twoPointers;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P135_FindUnsortedSubarray {
	/*
		Problem Statement
		Given an integer array nums, you need to find one 
		continuous subarray that if you only sort this subarray in ascending order, 
		then the whole array will be sorted in ascending order. 
		
		Return the shortest such subarray and output its length.	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive :  [2,6,4,8,10,9,15]
			Negative :	[1,2,3,4,5]
			Edge     :  [1,3,2,2,2]
	
	   3.  Approaches Known 
			 Approach 1 : Using Sorting and copying Array
			 Approach 2 : Using two nested loops
			 Approach 3 : Using Stack and two pass
	
	   4.  O - Notation 
			 Approach 1 : Using Sorting and copying Array, Time: O(nlogn) Space : O(n)
			 Approach 2 : Using two nested loops, Time: O(n^2) Space : O(1)
			 Approach 3 : Using Stack and two pass Time: O(n) Space : O(n)
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,3,2,2,2};
		System.out.println(findUnsortedBySorting(input));
		System.out.println(findUnsortedBruteForce(input));	
		System.out.println(findUnsortedUsingStack(input));	
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,2,5,3,4};
		System.out.println(findUnsortedBySorting(input));
		System.out.println(findUnsortedBruteForce(input));
		System.out.println(findUnsortedUsingStack(input));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {2,6,4,8,10,9,15};
		System.out.println(findUnsortedBySorting(input));
		System.out.println(findUnsortedBruteForce(input));
		System.out.println(findUnsortedUsingStack(input));
	}
	 
	/* Pseudocode - Sorting Array
	 * 1. Clone the input
	 * 2. Sort the input
	 * 3. Initialize start and end
	 * 4. Iterate the input from 0 if the i value of both array is not same 
	 * 	  update start and break
	 * 5. Iterate the input from end if the i value of both array is not same
	 *     update end and break
	 * 6. If both start and end is -1 return 0
	 * 7. return end - start +1
	 * 
	 * Time : O(nlogn)
	 * Space : O(1)
	 * 
	 */
	private int findUnsortedBySorting(int[] nums) {
		int[] nums2 = nums.clone();
		Arrays.sort(nums2);
		int start = -1, end = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums2[i]) {
				start = i;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != nums2[i]) {
				end = i;
				break;
			}
		}
		if (start == -1 && end == -1)
			return 0;
		return end - start + 1;
	}
	
	/* Pseudocode - Using Nested loops
	 * Initialize left as nums.length right as 0
	 * Iterate the input from 0 to > n-1
	 *    Iterate the input from i+1 till n
	 *    if(j value < i value)
	 *      left = min (left,i)
	 *      right = max (right,i)
	 * return right-left+1
	 * Time :O(n^2)
	 * Space : O(n)
	 */
	
	private int findUnsortedBruteForce(int[] nums) {
		int left = nums.length, right = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					left = Math.min(i, left);
					right = Math.max(right, j);
				}
			}
		}
		return right-left > 0 ? right-left+1:0;

	}
	
	/* Create a stack
	 * Initialize left as nums.length right as 0
	 * Iterate the input from 0
	 *   if nums[i] < nums[stack.peek] compare the sttore the max
	 * Iterate the input from end
	 *   if nums[i] > nums[stack.peek] compare the sttore the min
	 * return right-left+1
	 * Time : O(n)
	 * Space : O(n)
	 */
	private int findUnsortedUsingStack(int[] nums) {
		int left = nums.length, right = 0;
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		while(index < nums.length) {
			if(!stack.empty() && nums[stack.peek()]>nums[index])
				left = Math.min(left, stack.pop());
			stack.push(index++);	
		}
		stack.clear();
		index = nums.length-1;
		while(index >= 0) {
			if(!stack.empty() && nums[stack.peek()]<nums[index])
				right = Math.max(right, stack.pop());
			stack.push(index--);
		}
		return right-left > 0 ? right-left+1:0;

	}
	
}
