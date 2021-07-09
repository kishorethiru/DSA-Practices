package bruteforce;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindMissingElementProb2 {
/*
 * Given an array nums containing n distinct numbers in the range [0, n], return the 
 * only number in the range that is missing from the array.
   Input: nums = [22,24,25]
   Output: 23
 * 	
 * 1. Did I understand the problem? Yes
	
        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? int[]
        What is the expected output?  int 
        Do I have constraints to solve the problem? Dont use additional DS, Should not sort
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
		nums = [22,24,25]
		nums = [22]
		nums = [22,23,23,25]
		

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? Yes 
        No - can I break the problem into sub problems?

4. Ask for hint (if you dont know how to solve this)
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know
        1. Sort the array and find diff between i and i+1
        2. Iterate the array and using expected and actual sum
        3. Using set 

Simple technique brute force

6. If you know the alternate solution find out the O-notations (performance)
Approach 1: n log n
Approach 2: O(n)
Approach 3: O(n)
 */
		
	@Test
	public void testData01() {
		int[] data = {24,25,22,23,27};
		Assert.assertTrue(findMissingElementUsingSort(data) == 26);

	}

	@Test(expected = RuntimeException.class)
	public void testData02() {
		int[] data = {22};
		Assert.assertTrue(findMissingElementUsingSort(data) == 0);

	}

	@Test(expected = RuntimeException.class)
	public void testData03() {
		int[] data = {22,23,23,24};
		Assert.assertTrue(findMissingElementUsingSort(data) == -1);

	}
	@Test(expected = RuntimeException.class)
	public void testData04() {
		int[] data = {22,23,24};
		Assert.assertTrue(findMissingElementUsingSort(data) == -1);

	}
	
	/*
	 * Sort the input data
	 * Iterate the input 
	 *     If the difference between current element and next element is equal to 2
	 *      return the current element + 1
	 *      throw exception when difference between both values are equal to zero 
	 * Time : n log n
	 * Space : O(1)
	 */

	private int findMissingElementUsingSort(int[] data) {
		if (data.length < 2)
			throw new RuntimeException("Invalid Input");
		Arrays.sort(data);
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] == data[i + 1])
				throw new RuntimeException("Invalid Input");
			else if (data[i + 1] - data[i] == 2)
				return data[i] + 1;
		}
		throw new RuntimeException("Invalid Input");
	}
}
