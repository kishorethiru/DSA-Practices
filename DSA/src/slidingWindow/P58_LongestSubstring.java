package slidingWindow;

import org.junit.Assert;
import org.junit.Test;
import java.util.Collections;
import java.util.HashMap;

public class P58_LongestSubstring {
	/*
	 * find the max substring in the given string of k max occrrences //eceba k=2
	 
	 */
	@Test
	public void test1() {
		String s = "eceba";
		int k = 2;
		Assert.assertEquals(findSubString(s, k), 3);
	}

	@Test
	public void test2() {
		String s = "aabab";
		int k = 2;
		Assert.assertEquals(findSubString(s, k), 5);
	}
	
	@Test
	public void test3() {
		String s = "abcd";
		int k = 2;
		Assert.assertEquals(findSubString(s, k), 1);
	}
	
	@Test
	public void test4() {
		String s = "aabbccdeffgghhff";
		int k = 3;
		Assert.assertEquals(findSubString(s, k), 8);
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
}
