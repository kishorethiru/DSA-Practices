package slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P65_MaxNumberOfSubstringOccurrence {
	/*
		Problem Statement
		Given a string s, return the maximum number of ocurrences of any 
		substring under the following rules:
		The number of unique characters in the substring must be less than or 
		equal to maxLetters.
		The substring size must be between minSize and maxSize inclusive.
	
	*/

	/*
	   1. 
	  	 Input(s) ? String, 3 int 
		  Output ? int		  Constraint(s) ?
	   
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
		String s = "aababcaab";
		int maxLetters = 2, minSize = 3, maxSize = 4;
		Assert.assertTrue(maxFreq(s,maxLetters,minSize,maxSize)==2);
	}

	@Test
	public void testData02() { // Negative
		String s = "abcde";
		int maxLetters = 2, minSize = 3, maxSize = 3;
		Assert.assertTrue(maxFreq(s,maxLetters,minSize,maxSize)==0);
	}

	@Test
	public void testData03() { // Edge
		String s = "aabcabcab";
		int maxLetters = 2, minSize = 2, maxSize = 3;
		Assert.assertTrue(maxFreq(s,maxLetters,minSize,maxSize)==3);
	}
	
	/*  Initialize two maps
	 *  Initialize left and right as 0
	 *  Iterate till right < input length
	 *    Add the right value to charMap
	 *    While input length > minSize
	 *      remove the left value from charMap
	 *      incrment left
	 *    if value in charMap is >= maxletters and substring size >= minsize
	 *     Update the max size
	 *  return maxSize
	 */
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		HashMap<String, Integer> map = new HashMap<>();
		int left = 0, right = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		while (right < s.length()) {
			charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);
			while (right - left + 1 > minSize) {
				char remove = s.charAt(left);
				if (charMap.get(remove) > 1)
					charMap.put(remove, charMap.get(remove) - 1);
				else
					charMap.remove(remove);
				left++;
			}
			if (charMap.size() <= maxLetters && right - left + 1 >= minSize) {
				map.put(s.substring(left, right + 1), map.getOrDefault(s.substring(left, right + 1), 0) + 1);
			}
			right++;
		}
		if (map.size() == 0)
			return 0;
		return Collections.max(map.values());
	}
}
