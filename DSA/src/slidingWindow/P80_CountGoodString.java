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
	 * Problem Statement A string is good if there are no repeated characters. Given
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
		Assert.assertTrue(countGoodString(s) == 13);
	}

	/**
	 * @param s
	 * @return
	 */
	private int countGoodString(String s) {
		int count = 0, left = 0, right = 0;
		Map<Character, Integer> inputMap = new HashMap<>();
		while (right < s.length()) {
			inputMap.put(s.charAt(right), inputMap.getOrDefault(s.charAt(right), 0) + 1);
			while (inputMap.size() > 3) {
				if (inputMap.get(s.charAt(left)) > 1) {
					inputMap.put(s.charAt(left), inputMap.getOrDefault(s.charAt(left), 0) - 1);
				} else
					inputMap.remove(s.charAt(left));
				left++;
			}
			if (inputMap.size() == 3)
				count++;
			right++;
		}
		return count;
	}
}
