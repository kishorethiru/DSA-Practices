package bruteforce;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateValue {
	
	/*
	 * Given an integer array nums, return true if any value appears at
	 *  least twice in the array, and return false if every element is distinct.
	 */
	
	
	 /*
     * 1. Did I understand the problem? Yes

     What is the input(s)? int[]
     What is the expected output? boolean 
     Do I have any constraints to solve the problem? No 
     Do I have all the information to go to the next steps Yes 
     How big is your test data set will be? 


     2. Test data set
             Minimum  3 data set including positive, negative and edge
             Validate with the interviewer if the data set is fine by his/ her assumptions

     3. Do I know to solve it?
             Yes- great is there an alternate ? Yes

     4. Ask for hint (if you dont know how to solve this
     5.  Do I know alternate solutions as well
             Approach 1 : Using Set/Hash
             Approach 2 : Using Two Ptrs
             Approach 3 : BruteForce

     6. If you know the alternate solution find out the O-notations (performance)
     
     Approach 1 : Using Set/Hash - Time - O(n), Space O(n)
     Approach 2 : Using Two Ptrs - Time - nlogn, Space - O(1)
     Approach 3 : BruteForce - Time : O(n^2), Space - O(1)
	* 
	*/
	@Test
	public void testData01() {
		int[] data = {1,2,3,1};
		Assert.assertTrue(findDuplicate(data));

	}

	@Test
	public void testData02() {
		int[] data = {1,2,3,4};
		Assert.assertFalse(findDuplicate(data));

	}

	@Test
	public void testData03() {
		int[] data = {1,1,1,3,3,4,3,2,4,2};
		Assert.assertTrue(findDuplicate(data));

	}
	
	/*
	1. Create a hash Map with Integer as Key and Value
	2. Iterate the input
	     Check if the current element is present in the map as key
	         If present , return true
	3. return true
	Time : O(n)
	Space : O(n)
	
	*/
	
	private boolean findDuplicate(int[] nums) {
		if (nums.length < 2)
			return false;
		Map<Integer, Integer> inputData = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (inputData.containsKey(nums[i]))
				return true;
			else
				inputData.put(nums[i], inputData.getOrDefault(nums[i], 0) + 1);
		}
		return false;
	}
}
