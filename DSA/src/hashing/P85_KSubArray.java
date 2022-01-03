package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class P85_KSubArray {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
		  Constraint(s) ?
	   
	   2. Test data
			Positive :
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
		List<Integer> inputList = new ArrayList<>();
		inputList.add(5);
		inputList.add(10);
		inputList.add(11);
		inputList.add(9);
		inputList.add(5);
		int k = 5;
		kSub(k,inputList);
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	public long kSub(int k, List<Integer> nums) {

		// Cumulative Sum of each number in the list
		int sum = 0;

		// Return output
		long output = 0;

		// Find the frequency of remainder occurrence
		Map<Integer, Integer> freqMap = new HashMap<>();
		freqMap.put(0, 1);

		// Traverse
		for (int i = 0; i < nums.size(); ++i) {
			sum += nums.get(i);
			// Calculate remainder and add K to it if it is negative
			int rem = sum % k < 0 ? sum % k + k : sum % k;
			output += freqMap.getOrDefault(rem, 0);
			freqMap.put(rem, freqMap.getOrDefault(rem, 0) + 1);

		}
		return output;

	}

}
