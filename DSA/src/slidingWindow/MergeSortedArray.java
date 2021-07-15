package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArray 
{	
//	You are given two integer arrays nums1 and nums2, 
//	sorted in non-decreasing order, and two integers m and n, 
//	representing the number of elements in nums1 and nums2 respectively.
//	Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//	The final sorted array should not be returned by the function, 
//	but instead be stored inside the array nums1. To accommodate this, 
//	nums1 has a length of m + n, where the first m elements denote the elements 
//	that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//	
//	
//	Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//	Output: [1,2,2,3,5,6]
//	Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//	The result of the merge is [1,2,2,3,5,6] with the underlined elements
//	coming from nums1.
	
//	1. Did I understand the problem? Yes
//
//	        What is the input(s)?  two int[], two int
//	        What is the expected output? int[]
//	        Do I have any constraints to solve the problem? No extra space
//	        Do I have all the information to go to the next steps 
//	        How big is your test data set will be? 
//			
//
//	2. Test data set
//	        Minimum  3 data set including positive, negative and edge
//	        Validate with the interviewer if the data set is fine by his/ her assumptions
//
//	3. Do I know to solve it?
//	        Yes- great is there an alternate ? No
//	        No - can I break the problem into sub problems?
//
//	4. Ask for hint (if you dont know how to solve this
//	5.  Do I know alternate solutions as well
//	        Yes- what are those?
//	        No- that is still fine, proceed to solve by what you know
//
//	6. If you know the alternate solution find out the O-notations (performance)
//	   Approach 1 : Two pointers - O(n), O(1)
	 
	@Test
	public void testData01() // Positive
	{
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3;
		int n = 3;
		Assert.assertArrayEquals(mergeSortedArray(nums1,m,nums2,n), new 
				int[] {1,2,2,3,5,6});
	}
	
	@Test
	public void testData02() // Edge
	{
		int[] nums1 = {0};
		int[] nums2 = {1};
		int m = 0;
		int n = 1;
		Assert.assertArrayEquals(mergeSortedArray(nums1,m,nums2,n), new int[] {1});
	}
	
	@Test
	public void testData03() // Edge
	{
		int[] nums1 = {1,2,3,0,0,0,0};
		int[] nums2 = {2,2,2,2};
		int m = 3;
		int n = 4;
		Assert.assertArrayEquals(mergeSortedArray(nums1,m,nums2,n), new int[] {1,2,2,2,2,2,3});
	}
	
	/* Pseudocode - Two pointers
	 * if m = 0, return nums2;
		if n = 0, return nums1;
		Initialize two pointer p1 = m-1, p2 = n-1
		Initialize index of nums1 length - 1
		Iterate the array till (p2 < 0)
			compare p2 > p1 || p2 = p1 
			  if p2 is greater push the value of p2 with index value, decrement p2--,decrement index
			  else if swap p1 with index value decrement p1--,decrement index
		return nums1
	 * Time O(m+n)
	 * Space : O(1)
	 */
	private int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
		if(m == 0 && n == 0) return new int[]{};
		if (m == 0)
			return nums2;
		if (n == 0)
			return nums1;
		if(nums1.length < m+n) throw new RuntimeException("Invalid Input");
		int ptr1 = m - 1, ptr2 = n - 1;
		int index = nums1.length - 1;
		while (ptr2 >= 0) {
			if (nums2[ptr2] >= nums1[ptr1]) {	
				nums1[index--] = nums2[ptr2--];
			} else
				nums1[index--] = nums1[ptr1--];
		}
		return nums1;
	}

}
