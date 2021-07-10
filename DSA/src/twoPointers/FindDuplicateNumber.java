package twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateNumber 
{
	/*1) Given a non-empty array of integers nums, every element
	 appears twice except for one. Find that single one. You must implement a solution with a 
	 linear runtime complexity and use only constant extra space.
	 
	
	 Example 1:
	  Input: nums = [2,2,1]
	  Output: 1
	
	  Example 2:
	  Input: nums = [4,1,2,1,2]
	  Output: 4
	 * 
	 */
	
	/*
	 * 1. Did I understand the problem? Yes

        What is the input(s)? int[]
        What is the expected output? int 
        Do I have any constraints to solve the problem? Use two ptr 
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
		[2,2,1]
		[4,1,2,1,2]
		[2,2,3,4,4]

		2. Test data set
		        Minimum  3 data set including positive, negative and edge
		        Validate with the interviewer if the data set is fine by his/ her assumptions
		
		3. Do I know to solve it?
		        Yes- great is there an alternate ? Yes
		        No - can I break the problem into sub problems?
		
		4. Ask for hint (if you dont know how to solve this
		5.  Do I know alternate solutions as well
		        Yes- what are those?
		        No- that is still fine, proceed to solve by what you know
		        
		     Approach 1 - Two Ptr
		
		6. If you know the alternate solution find out the O-notations (performance)
		Approach 1 - Two Ptr - O(n), O(1) 	
	 * 
	 */
	@Test
	public void testData01() {
		int[] data = { 2, 2, 1 };
		Assert.assertTrue(findDuplicateNumber(data) == 1);
	}

	@Test
	public void testData02() {
		int[] data = { 4, 1, 2, 1, 2 };
		Assert.assertTrue(findDuplicateNumber(data) == 4);
	}

	@Test
	public void testData03() {
		int[] data = { -1, 2, 2, 3, 4, -1, 4 };
		Assert.assertTrue(findDuplicateNumber(data) == 3);
	}
	
	/* Pseudocode
	 * 1.Sort the input
	 * 2.initialize pointer ptr = 0
	 * 3.Traverse the input till ptr < data.length
	 *   a) if( ptrData == ptrData +1) , increment ptr by 2
	 *   b) else return input[ptr]
	 * 4. return input[ptr]
	 * 
	 * Time : n log n + O(n) => n log n
	 * Space : O(1)
	 * 
	 */
	
	private int findDuplicateNumber(int[] data) {
		if (data.length < 2)
			throw new RuntimeException("Invalid Input");
		Arrays.sort(data);
		int ptr = 0;
		while (ptr < data.length-1) {
			if (data[ptr] == data[ptr + 1]) ptr += 2;
			else return data[ptr];
		}
		return data[ptr];
	}

}
