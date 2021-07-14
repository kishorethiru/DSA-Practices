package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArray 
{
	
	@Test
	public void testData01() // Positive
	{
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3;
		int n = 3;
		Assert.assertArrayEquals(mergeSortedArray(nums1,m,nums2,n), new int[] {1,2,2,3,5,6});
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
	
	/*
	 * if m = 0, return nums2;
		if n = 0, return nums1;
		Initialize two pointer p1 = m-1, p2 = n-1
		Initialize index of nums1 length - 1
		Iterate the array till (p2 < 0)
			compare p2 > p1 || p2 = p1 
			  if p2 is greater push the value of p2 with index value, decrement p2--
			  else if swap p1 with index value decrement p1--
		return nums1
	 * 
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
