package twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P92_UniformString {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  	  Input(s) ? String, int[] 
		  Output ? boolean[]
		  Constraint(s) ?
	   
	   2. Test data
			Positive :abbccaadf
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		
		String s = "abbccaadf";
		int[] target = {4,2,5,3,7};
		Assert.assertTrue(Arrays.equals(uniformStingOfTarget(s,target), new boolean[] {true,true,false,true,false}));
	}

	@Test
	public void testData02() { // Negative
		String s = "cccdyyz";
		int[] target = {2,10,5,51,27};
		Assert.assertTrue(Arrays.equals(uniformStingOfTarget(s,target), new boolean[] {false,false,false,false,false}));
	}

	@Test
	public void testData03() { // Edge
		String s = "aabbcccdddxx";
		int[] target = {1,2,4,3,6,9,8,12,24,48};
		Assert.assertTrue(Arrays.equals(uniformStingOfTarget(s,target), new boolean[] {true,true,true,true,true,true,true,true,true,true}));
	}
	
	@Test
	public void testData04() { // Edge
		String s = "abcd";
		int[] target = {4};
		Assert.assertTrue(Arrays.equals(uniformStingOfTarget(s,target), new boolean[] {true}));
	}
	
	/* Create a hash map - targetMap
	 *    add the target values as key and values as false in targetMap
	 * Create a boolean array of length target array
	 * Create two pointers left as 0 and right
	 * Create count  
	 * Iterate till left < length - 1
	 *  initialize right = left
	 *  make variable count as 0
	 *  Iterate till right is less than the length && left value = left value
	 *    add value of right to count,
	 *    if its exists in map make its value as true
	 *    increment right
	 *  Assign left = right
	 *  
	 * Iterate target array and fetch the value from targetMap
	 * and place in output array
	 * return outputarray
	 * 
	 * 
	 */
	
	private boolean[] uniformStingOfTarget(String s, int[] target) {
		int count;
		Map<Integer,Boolean> targetMap = new HashMap<>();
		for (int i : target) {
			targetMap.put(i, false);
		}
		int left = 0, right;
		while(left<s.length()) {
			right = left;
			count = 0;
			while(right<s.length() && s.charAt(left)==s.charAt(right)) {
				count += (s.charAt(right) - 'a') + 1; 
				if(targetMap.containsKey(count)) targetMap.put(count, true);
				right++;
			}
			left = right;
		}
		
		boolean[] op = new boolean[target.length];
		for (int i = 0; i < target.length; i++) {
			op[i] = targetMap.get(target[i]);
		}
		return op;
	}
	
}
