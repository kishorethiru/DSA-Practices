package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P62_RepeatedDNASequences {
	/*
		Problem Statement
		The DNA sequence is composed of a series of nucleotides abbreviated as 'A',
		'C', 'G', and 'T'.
		For example, "ACGAATTCCG" is a DNA sequence.
		When studying DNA, it is useful to identify repeated sequences within 
		the DNA.

		Given a string s that represents a DNA sequence, return all the 
		10-letter-long sequences (substrings) that occur more than once 
		in a DNA molecule. 
		You may return the answer in any order.
	
	*/

	/*
	   1. 
	  	  Input(s) ? String  
		  Output ? int
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : Nested for loops and hashmap
			 Approach 2 : Sliding Window and hashmap
	
	   4.  O - Notation 
			 Approach 1 : Nested for loops and hashmap - Time O(n^2) Space : O(n)
			 Approach 2 : Sliding Window and hashmap - Time O(n) Space : O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> output = Arrays.asList("AAAAACCCCC","CCCCCAAAAA");
		Assert.assertTrue(findRepeatedDnaSequences(input).equals(output));
	}

	@Test
	public void testData02() { // Negative
		String input = "AAAAACCCCC";
		List<String> output = Arrays.asList();
		Assert.assertTrue(findRepeatedDnaSequences(input).equals(output));
	}

	@Test
	public void testData03() { // Edge
		String input = "AAAAAAAAAAAAA";
		List<String> output = Arrays.asList("AAAAAAAAAA");
		Assert.assertTrue(findRepeatedDnaSequences(input).equals(output));
	}
	
	/* Pseudocode - Sliding Window & HashMap
	 * If string length is less than 11 return empty list
	 * Create a hash map
	 * Initialize left as 0 and right as 10
	 * Iterate till the input length
	 *    Extract the substring from left to right
	 *    Add to map and increment the occurrences
	 * Convert the map to entry list and iterate it
	 *    If the value of the item is more than 1 add to list
	 * return list
	 * Time : O(2n) -> O(n)
	 * Space : O(n)
	 * 
	 */
	private List<String> findRepeatedDnaSequences(String s) {
		if (s.length() < 11)
			return new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int left = 0, right = 10;
		while (right <= s.length()) {
			String sb = s.substring(left++, right++);
			map.put(sb, map.getOrDefault(sb, 0) + 1);
		}
		List<String> retList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1)
				retList.add(entry.getKey());
		}
		return retList;

	}
}
