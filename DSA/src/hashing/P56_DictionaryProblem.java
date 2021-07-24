package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P56_DictionaryProblem {
	
/*Given a string s and a dictionary of strings wordDict, 
 * return true if s can be segmented into a space-separated sequence of 
 * one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
 
Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 * 
 */
	 
/*
 *  1. 
    Input(s)?  String, Set<String>
    Output ? boolean
    Constraints ?  O(n)

2. Test data set

        Positive : s = "leetcode", wordDict = ["leet","code"]
        Negative : s = "applepenapple", wordDict = ["apple","pen"]
        Edge     : s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]

3. Known Approaches
        Approach 1 :Hashing 

4. O-Notations
		Approach 1 :Hashing Time - O(n) Space - O(n)
5. Pseudocode
 */
	
	@Test
	public void testData01(){            // Positive
		String s = "leetcode";
		List<String> dictionary = new ArrayList<>();
		dictionary.add("leet");
		dictionary.add("code");
		Assert.assertTrue(isAllDictionaryValuesPresent(s, dictionary));
	}


	@Test
	public void testData02(){			 // Edge
		String s = "applepenapple";
		List<String> dictionary = new ArrayList<>();
		dictionary.add("apple");
		dictionary.add("pen");
		Assert.assertTrue(isAllDictionaryValuesPresent(s, dictionary));
	}

	@Test
	public void testData03(){			 // Negative
		String s = "catsandog";
		List<String> dictionary = new ArrayList<>();
		dictionary.add("cats");
		dictionary.add("dog");
		dictionary.add("sand");
		dictionary.add("and");
		dictionary.add("cat");
		Assert.assertFalse(isAllDictionaryValuesPresent(s, dictionary));
	}
	
	@Test
	public void testData04(){            // Negative
		String s = "leetcodelc";
		List<String> dictionary = new ArrayList<>();
		dictionary.add("leet");
		dictionary.add("code");
		Assert.assertFalse(isAllDictionaryValuesPresent(s, dictionary));
	}
	
	/* Create a hashmap and values of list to map
	 * Initialize variable count, left , right as 0
	 * Iterate the string till it reaches length - 1
	 *  increment right and check if the map contains the string of range left to right
	 *  if yes update the count in map and increment count, move right + 1 and left  = right
	 * Check if count and map.size is equal and return
	 *  Time : O(n)
	 *  Space : O(n+m)
	 */
	
	private boolean isAllDictionaryValuesPresent(String s, List<String> dictionary) {
		Map<String, Integer> dictMap = new HashMap<>();
		for (String val : dictionary) {
			dictMap.put(val, 0);
		}
		int left = 0, right = 1, count = 0;
		while (right < s.length()) {
			String checkStr = s.substring(left, right + 1);
			if (dictMap.containsKey(checkStr)) {
				if (dictMap.get(checkStr) == 0) {
					dictMap.put(checkStr, 1);
					count++;
				} else
					dictMap.put(checkStr, dictMap.getOrDefault(checkStr, 0) + 1);
				left = right + 1;
			}
			right++;
		}
		return (count == dictMap.size() && left == right);
	}

}
