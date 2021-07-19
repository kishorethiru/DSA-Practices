package slidingWindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P29_FindDuplicateElementWithinTarget 
{
	/*
	 * /*
	    Given an array of integers and an integer k, find out whether there are two 
	    distinct indices i and j in the array such that nums[i] = nums[j] 
	    and the absolute difference between i and j is at most k.
	    Example 1:
	    Input: nums = [1,2,3,1], k = 3
	    Output: true
	    Example 2:
	    Input: nums = [1,0,1,1], k = 1
	    Output: true
	    Example 3:
	    Input: nums = [1,2,3,1,2,3], k = 2
	    Output: false
	    Example 3:
	    Input: nums = [1,2,3,2,2,3], k = 2
	    Output: true
	*/
	 /*
	  * 1. Did I understand the problem? Yes
     

        What is the input(s)? int[], target
        What is the expected output?  boolean
        Do I have any constraints to solve the problem?  Use Sliding Window
        Do I have all the information to go to the next steps 
        How big is your test data set will be?
        [1,2,3,1], k = 3 Positiv e
        [1,2,3,2,2,3], k = 2  Negative
        [1,2,3,1,2,3], k = 2 Edge
 
		
		2. Test data set
		        Minimum  3 data set including positive, negative and edge
		        Validate with the interviewer if the data set is fine by his/ her assumptions
		
		3. Do I know to solve it?
		        Yes- great is there an alternate ? Brute force
		        No - can I break the problem into sub problems?
		
		4. Ask for hint (if you dont know how to solve this)
		5.  Do I know alternate solutions as well
		        Yes- what are those?
		        No- that is still fine, proceed to solve by what you know
		
		6. If you know the alternate solution find out the O-notations (performance)
				O(n), O(1)
			  * 
	  */
	
	@Test
	public void testData01() {
		int[] data = { 1, 2, 3, 1 };
		int target = 3;
		Assert.assertTrue(isDuplicateElementFound(data, target));

	}

	@Test
	public void testData02() {
		int[] data = { 1, 2, 3, 1, 2, 3 };
		int target = 2;
		Assert.assertFalse(isDuplicateElementFound(data, target));
	}

	@Test
	public void testData03() {
		int[] data = { 1, 2, 3, 2, 2, 3 };
		int target = 3;
		Assert.assertTrue(isDuplicateElementFound(data, target));
	}
	
	@Test
	public void testData04() {
		int[] data = {8,5,4,18,3,8};
		int target = 6;
		Assert.assertTrue(isDuplicateElementFound(data, target));
	}
	
	 /*
	  *1. Initialize startIndex as 0
	   2. Iterate the input from 1 to end
	   	  	Initialize diff = i -startIndex;
		  		a)Check diff == target
		       		check if startIndex value and i value are same 
			     		if yes return true, else increment start 	
		  		b)Check diff > target startIndex + 1;
	   3. return false
	  * 
	  */
	
//		private boolean twoDistinceIndicesPresent(int[] data, int target) {
//			int startIndex = 0;
//			for (int i = 1; i < data.length; i++) { // Iterate the input from 1 to end
//				int diff = (i - startIndex);
//				if (diff == target) {
//					if (data[startIndex] == data[i])// check if startIndex value and i value are same
//						return true;
//					else
//						startIndex++;
//				} else if (diff > target) // Check diff > target startIndex + 1;
//					startIndex++;
//			}
//			return false;
//		}
	// 1, 2, 3,7,1,4,5,1
		// T - 3	
	private boolean twoDistinceIndicesPresent(int[] data, int target) {
		int startIndex = 0, endIndex = 1;
		while (endIndex <=data.length) { // Iterate the input from 1 to end
			int diff = (endIndex - startIndex)+1;
			if (diff == target) {
				if (data[startIndex] == data[endIndex])// check if startIndex value and i value are same
					return true;
				else
					startIndex++;
			} else if (diff > target)
				startIndex++; // Check diff > target startIndex + 1;
			else if (diff < target)
				endIndex++;
		}
		return false;
	}
	 
	/* 
	 * Create a set
	 * Iterate the input till the target value 
	 * 		Add the items to set, if duplicate element found return true
	 * Iterate the input after target to end
	 *      Remove the first value from the set and add the next value
	 *      if duplicate element found return true
	 * return false
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 * 
	 */
	 private boolean isDuplicateElementFound(int[] data, int target)
	 {
		 Set<Integer> inputData = new HashSet<>();
		 for (int i = 0; i <= target; i++) { //Iterate the input till the target value
			 if (!inputData.add(data[i])) // Add the items to set, if duplicate element found return true
				 return true;
		 }
		 for (int i = target+1; i < data.length; i++) 
		 {
			 inputData.remove(data[i-target-1]); //Remove the first value from the set and add the next value
			 if(!inputData.add(data[i])) return true;	//  if duplicate element found return true
		 }
		 return false;
		 
	 }
	
	
}
;