package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class P71_FindUniqueLongestSubstring {
	
	/*
	 * Given a string s, find the length of the longest substring without repeating characters.
 
		Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
		Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * 
	 */
	
	/*
	 * 1. 
    Input(s)? String
    Output ? int
    Constraints ?   SlindingWindow + ASCII

2. Test data set

        Positive : abcabcbb
        Edge :bbbbb
        Edge     :pwwkew

3. Known Approaches
        Approach 1 :SlidingWindow 

4. O-Notations
        Approach 1 :SlidingWindow 

5. Pseudocode

	 * 
	 */
	
	@Test
	public void testData01(){    
		// Positive
		String s = "abcabcbb";
		Assert.assertTrue(findLongestSubstring(s) == 3);
	}


	@Test
	public void testData02(){	 // Edge
		String s = "bbbbb";
		Assert.assertTrue(findLongestSubstring(s) == 1);
	}

	@Test
	public void testData03(){			 // Edge
		String s = "pwwkew";
		Assert.assertTrue(findLongestSubstring(s) == 3);
	}   
	@Test
	public void testData04(){			 // Edge
		String s = "unique";
		Assert.assertTrue(findLongestSubstring(s) == 4);
	}   
	/* Initialize left, max = 0
	 * Initialize int[] of 128 length - asciiArr
	 * Iterate the input
	 *     Increment the count of right value in asciiArr
	 *     If right value count in asciiArr  > 1
	 *        if Yes, Iterate till right value count in asciiArr becomes 0
	 *         decrement the value of left in asciiArr
	 *         increment left
	 *     compare and store max
	 * Time : O(n)
	 * Space : O(128)
	 */
	private int findLongestSubstring(String s) {
		if (s.length() < 2)
			return s.length();
		int left = 0, max = 0;
		int[] asciiArr = new int[128];
		for (int right = 0; right < s.length(); right++) {
			asciiArr[s.charAt(right)]++;
			while (asciiArr[s.charAt(right)] > 1) {
				asciiArr[s.charAt(left)]--;
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
	

	
	

}
