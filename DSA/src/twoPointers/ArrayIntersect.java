package twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArrayIntersect 
{
	
	 /*
    1. Did I understand the problem? Yes

    What is the input(s)? two int[]
    What is the expected output? int[]
    Do I have any constraints to solve the problem? Time - O(n)
    Do I have all the information to go to the next steps Yes
    How big is your test data set will be? 
	

    2. Test data set
            Minimum  3 data set including positive, negative and edge
            Validate with the interviewer if the data set is fine by his/ her assumptions

    3. Do I know to solve it?
            Yes- great is there an alternate ? No
            No - can I break the problem into sub problems?

    4. Ask for hint (if you dont know how to solve this
    5.  Do I know alternate solutions as well
    6. If you know the alternate solution find out the O-notations (performance)
            Approach 1 : Two ptrs - Time : O(m or n) Space: O(m or n)
            Approach 2: BruteForce - Time : O(n^2) Space : O(m or n)
    */
	
	@Test
	public void testData01() {
		int[] data1 = { 1, 2, 2, 1 };
		int[] data2 = { 2 };
		Assert.assertArrayEquals(intersectArray(data1, data2), new int[] { 2 });

	}

	@Test
	public void testData02() {
		int[] data1 = { 3, 8, 9, 7, 8, 4, 6 };
		int[] data2 = { 1, 2, 9, 7 };
		Assert.assertArrayEquals(intersectArray(data1, data2), new int[] { 7, 9 });

	}

	@Test
	public void testData03() {
		int[] data1 = { 1 };
		int[] data2 = { 1 };
		Assert.assertArrayEquals(intersectArray(data1, data2), new int[] { 1 });

	}
	
	/*
    Pseudocode : Two Pointers
    Prechecks
    1. If any one of the array is empty return empty array
    2. If any one of the array length is 1, 
            then compare the first index of both inputs and return the matching value
    
    1. Sort the two inputs
    2. Initialize pointer1 and pointer2 as 0
    3. Create a retArr of length data1 or data 2 which is smaller and a int index = 0
    4. Traverse both the inputs till the end of value in array
        a) if pointer1 value = pointer2 value, push the value to retArr, increment pointer1 and pointer2
        b) if pointer1value > pointer2 value, increment pointer 2
        c) if pointer1 value < pointer2 value, increment pointer1
    5. Return the retArr
    
    Complexity
    Time : m log m + nlogn + O(m or n) => m/n log m/n (which is of higher value)
    Space : O(m or n) => which is lower value
        
*/
	
	private int[] intersectArray(int[] data1, int[] data2) {
		int data1Len = data1.length;
		int data2Len = data2.length;
		if (data1Len == 0 || data2Len == 0)
			return new int[] {};
		if (data1Len == 1 && data2Len == 1) {
			if (data1[0] == data2[0])
				return new int[] { data1[0] };
			else
				return new int[] {};
		}
		int length = (data1Len > data2Len) ? data2Len : data1Len;
		int[] retArr = new int[length];
		length = 0;
		Arrays.sort(data1);
		Arrays.sort(data2);
		int pointer1 = 0, pointer2 = 0;
		while (pointer1 < data1Len && pointer2 < data2Len) {
			if (data1[pointer1] == data2[pointer2]) {
				retArr[length++] = data2[pointer2++];
				pointer1++;
			} else if (data1[pointer1] > data2[pointer2])
				pointer2++;
			else
				pointer1++;
		}
		return Arrays.copyOf(retArr, length);

	}

}
