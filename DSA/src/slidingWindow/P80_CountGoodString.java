package slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P80_CountGoodString {
	/*
	 * Problem Statement
	 *  A string is good if there are no repeated characters. Given
	 * a string s​​​​​, return the number of good substrings of length three in
	 * s​​​​​​. Note that if there are multiple occurrences of the same substring,
	 * every occurrence should be counted. A substring is a contiguous sequence of
	 * characters in a string.
	 * 
	 */

	/*
	 * 1. Input(s) ? String Output ? int Constraint(s) ? Time Optimized
	 * 
	 * 2. Test data Positive :xyzzaz, 1 Negative :aaaaaa, 0 Edge :aababcabc, 4
	 * 
	 * 3. Approaches Known Approach 1 :
	 * 
	 * 4. O - Notation Approach 1 :
	 * 
	 * 5. Pseudocode
	 * 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "xyzzaz";
		Assert.assertTrue(countGoodString(s) == 1);
	}

	@Test
	public void testData02() { // Negative
		String s = "aaaaaa";
		Assert.assertTrue(countGoodString(s) == 0);
	}

	@Test
	public void testData03() { // Edge
		String s = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
		Assert.assertTrue(countGoodString(s) == 9);
	}

	private int countGoodString(String s) {
		Map<Character, Integer> inputMap = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			inputMap.put(s.charAt(i), inputMap.getOrDefault(s.charAt(i), 0)+1);
		}
		int count = 0;
		if(inputMap.size()==3) count++;
		for (int i = 3; i < s.length(); i++) {
			inputMap.put(s.charAt(i), inputMap.getOrDefault(s.charAt(i), 0)+1);
			if(inputMap.get(s.charAt(i-3)) > 1)
				inputMap.put(s.charAt(i-3), inputMap.getOrDefault(s.charAt(i-3), 0)-1);
			else
				inputMap.remove(s.charAt(i-3));
			if(inputMap.size()==3) count++;	
		}
		return count;
	}
}
