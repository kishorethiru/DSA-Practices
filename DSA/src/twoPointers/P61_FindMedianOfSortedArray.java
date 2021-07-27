package twoPointers;

import org.junit.Assert;
import org.junit.Test;

public class P61_FindMedianOfSortedArray {
	
	/* Given two sorted arrays nums1 and nums2 of size m and n respectively,
	 *  return the median of the two sorted arrays.

	The overall run time complexity should be O(log (m+n)).
	 * 
	 */
	
	/*
	 *  1. 
    Input(s)? two int[] 
    Output ? double
    Constraints ?  O(log (m+n))

	2. Test data set
	
	        Positive :
	        Negative :
	        Edge     :
	
	3. Known Approaches
	        Approach 1 :Two pointers 
	
	4. O-Notations
			Approach 1 :Two pointers - O(m+n)
	
	5. Pseudocode

	 * 
	 */
	
	@Test
	public void testData1()
	{
		int[] nums1 = {1,2}; 
		int[] nums2 = {3,4};
		Assert.assertTrue(findMedianSortedArrays(nums1,nums2)==2.50000);
	}
	@Test
	public void testData2()
	{
		int[] nums1 = {1,3}; 
		int[] nums2 = {2};
		findMedianSortedArrays(nums1,nums2);
		Assert.assertTrue(findMedianSortedArrays(nums1,nums2)==2.00000);
	}
	@Test
	public void testData3()
	{
		int[] nums1 = {0,0}; 
		int[] nums2 = {0,0};
		findMedianSortedArrays(nums1,nums2);
		Assert.assertTrue(findMedianSortedArrays(nums1,nums2)==0.00000);
	}
	/* Create a new array of length m+n
	 * Initialize two pointers p1 and p2 from last index of m and n
	 * Initialize index of last index of created array
	 * Iterate till p1 and p2 reaches 0
	 *   If p2 current val is greater than p1 current val, push the value of current of p2
	 *   	decrement p2 and index
	 *   else push p1 and decrement p1 and index
	 * Push the item to array if anything missed in m or n
	 * Check if merged array length is even 
	 * 	if yes, find the mid and mid-1 element and add it
	 *  else find the mid element
	 * Return the element if even length /2 or else return the element 
	 *      
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] mergedArr = new int[nums1.length + nums2.length];
		int p1 = nums1.length - 1, p2 = nums2.length - 1, index = mergedArr.length - 1;
		while (p1 >= 0 && p2 >= 0) {
			if (nums1[p1] >= nums2[p2])
				mergedArr[index--] = nums1[p1--];
			else
				mergedArr[index--] = nums2[p2--];
		}
		while (p1 >= 0) {
			mergedArr[index--] = nums1[p1--];
		}
		while (p2 >= 0) {
			mergedArr[index--] = nums2[p2--];
		}
		double retVal;
		if (mergedArr.length % 2 == 0)
			retVal = (mergedArr[mergedArr.length / 2] + mergedArr[(mergedArr.length / 2) - 1]);
		else
			retVal = mergedArr[mergedArr.length / 2];
		return (mergedArr.length % 2 == 0) ? retVal / 2 : retVal;    
    }

}
