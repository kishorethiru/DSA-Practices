package slidingWindow;

import org.junit.Assert;
import org.junit.Test;
import java.util.Collections;
import java.util.HashMap;

public class LongestSubstring {
	/*
	 * find the max substring in the given string of k max occrrences //eceba k=2
	 * Solution:- initialize the variables left=0, right=0, max=1 initialize a
	 * hashmap<Integer, index> Traverse the string and add each ascii value of the
	 * character as key and index as value to map until map.size is<=k When the map
	 * size crosses k - remove the least index that was found - move left by
	 * minIndex+1 - compare the max value between the max and right-left return max
	 */
	@Test
	public void test1() {
		String s = "eceba";
		int k = 2;
		Assert.assertEquals(findLongestSubstringAscii(s, k), 3);
	}

	@Test
	public void test2() {
		String s = "aabab";
		int k = 2;
		Assert.assertEquals(findSubString(s, k), 5);
	}

	private int findSubString(String s, int k) {
		if (s.trim().length() == 0)
			return 0;
		if (s.trim().length() < k)
			return s.length();
		int left = 0, right = 0, max = 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		while (right < s.length()) {
			map.put((int) s.charAt(right), right++);
			if (map.size() > k) {
				Integer minIndex = Collections.min(map.values());
				map.remove((int) s.charAt(minIndex));
				left = minIndex + 1;
			}
			max = Math.max(max, right - left);
		}
		return max;
	}
	
	/* Initialize max as 0, dupCount as 1; left as  0
	 * Initialize int[] of length 128
	 * Traverse the given string from 0
	 * 
	 * 
	 * 
	 */
	
	private int findLongestSubstringAscii(String s, int target) {
		int left = 0, right = 0, uniqueCount = 0, max = 0;
		int[] ascii = new int[128];
		for ( right = 0; right < s.length(); right++) {
			if(ascii[s.charAt(right)] == 0) {
				ascii[s.charAt(right)]++;
				uniqueCount++;
			}
			else ascii[s.charAt(right)]++;
			if(uniqueCount > target) {
				while(ascii[s.charAt(left)] > 0) {
					--ascii[s.charAt(left++)];
				}
				uniqueCount--;
			}
			max = Math.max(max, right-left+1);
		}
		return max;
	}
}
