package twoPointers;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P56_TripleSumCount {
	/*
		Problem Statement
		Given an array of strings queries and a string pattern, 
		return a boolean array answer where answer[i] is true if 
		queries[i] matches pattern, and false otherwise.

		A query word queries[i] matches pattern if you can insert 
		lowercase English letters pattern so that it equals the query. 
		You may insert each character at any position and you may not
		insert any characters.
	
	*/

	/*
	   1. 
	  	  Input(s) ? String[], String 
		  Output ? List<Boolean>
		  Constraint(s) ?
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : Using two ptr to matching string and return the boolean output
	
	   4.  O - Notation 
			 Approach 1 : Time O(n), Space O(n) for output
	
	   5.  Pseudocode	
	   	
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int[] input = {1,1,2,2,3,3,4,4,5,5};
		System.out.println(tripleSumCountHashing(input,8));
//		Assert.assertTrue();
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	private int tripleSumCount(int[] nums, int target) {
		int count = 0;
		for(int i = 0; i<nums.length-2;i++) {
			int initSum = nums[i];
			int diff = target- initSum;
			for(int j = i+1; j < nums.length-1;j++) {
				for(int k = j+1; k < nums.length; k++) {
					if(nums[j]+nums[k]==diff) count++;
				}
			}
		}
		return count;
	}
	
	private int tripleSumCountHashing(int[] nums, int target) {
		int count = 0;
		for(int i = 0; i<nums.length-2;i++) {
			int initVal = nums[i];
			Map<Integer, Integer> map = new HashMap<>();
			for(int j =i+1; j < nums.length; j++) {
				int diff = target-initVal;
				int valToFind = diff-nums[j];
				if(!map.isEmpty() && map.containsKey(valToFind) && j != map.get(valToFind)) {
					count++;
					System.out.println(i + " "+j+" "+map.get(valToFind));
				}
				map.put(nums[j], j);
			}
		}
		return count;
	}
}
