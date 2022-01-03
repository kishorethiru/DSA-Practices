package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P64_BalancedString {
	/*
		Problem Statement
		You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.
		A string is said to be balanced if each of its characters appears n/4 
		times where n is the length of the string.
		Return the minimum length of the substring that can be replaced 
		with any other string of the same length to make the original 
		string s balanced.
		Return 0 if the string is already balanced	
	*/

	/*
	   1. 
	  	  Input(s) ? String  
		  Output ? int
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :  "QQWE" 
			Negative :	"QWER"
			Edge     :  "QQQQ"
	
	   3.  Approaches Known 
			 Approach 1 : Sliding Window + HashMap
	
	   4.  O - Notation 
			Approach 1 : Sliding Window + HashMap 
			             Time  O(n), Space - O(n) 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "QQWE";
		Assert.assertTrue(balancedString(s) == 1);
	}

	@Test
	public void testData02() { // Negative
		String s = "QWER";
		Assert.assertTrue(balancedString(s) == 0);
	}

	@Test
	public void testData03() { // Edge
		String s = "QQQQ";
		Assert.assertTrue(balancedString(s) == 3);
	}

	/* Create two maps
	 * Iterate the input and add to map its value and occur
	 * Initialize int as min and valueToOccur
	 * Iterate the map and remove the values that are balanced
	 *  and retain the extra values that are more than the valueToOccur
	 * If map size is zero return 0 (fully balanced)
	 * Initialize left and right as 0
	 * Iterate till right < input length
	 *   Add the right value to inputMap
	 *   While left<=right and if the values in map is present in InputMap
	 *     find the distance
	 *     remove the value of left from inputMap
	 *     increment left
	 *   increment right 
	 * return min
	 *  
	 */
	private int balancedString(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> inputMap = new HashMap<>();
		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		int min = Integer.MAX_VALUE;
		int valToOcc = s.length() / 4;
		ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		for (Map.Entry<Character, Integer> val : list) {
			if (map.get(val.getKey()) > valToOcc)
				map.put(val.getKey(), map.get(val.getKey()) - valToOcc);
			else
				map.remove(val.getKey());
		}
		if (map.size() == 0)
			return 0;
		int left = 0, right = 0;
		while (right < s.length()) {
			char current = s.charAt(right);
			inputMap.put(current, inputMap.getOrDefault(current, 0) + 1);
			while (left <= right && isPresent(inputMap, map)) {
				min = Math.min(min, right - left + 1);
				char remove = s.charAt(left);
				if (inputMap.get(remove) > 1)
					inputMap.put(remove, inputMap.get(remove) - 1);
				else
					inputMap.remove(remove);
				left++;
			}
			right++;
		}
		return min;
	}

	public boolean isPresent(Map<Character, Integer> input, Map<Character, Integer> target) {
		Set<Character> charSet = target.keySet();
		for (Character each : charSet) {
			if (!input.containsKey(each))
				return false;
			if (input.get(each) < target.get(each))
				return false;
		}
		return true;
	}

}
