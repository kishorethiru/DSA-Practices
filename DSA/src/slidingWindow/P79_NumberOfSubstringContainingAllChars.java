package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P79_NumberOfSubstringContainingAllChars {
	/*
		Problem Statement
		Given a string s consisting only of characters a, b and c.
		Return the number of substrings containing at least one occurrence of all 
		these characters a, b and c.
	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? int
		  Constraint(s) ? 
	   
	   2. Test data
			Positive : abcabc
			Negative : aaaa	
			Edge     : aaacb
	
	   3.  Approaches 
			 Approach 1 : SlidingWindow + HashMap
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		String s = "abcabc";
		// 6 - 2+1 => 3 abczzzzzzz
		Assert.assertTrue(numberOfSubstrings(s)==10);
	}

	@Test
	public void testData02() { // Negative
		String s = "aaaa";
		Assert.assertTrue(findNumberOfSubstringOptimized(s)==0);
	}

	@Test
	public void testData03() { // Edge
		String s = "aaacb";
		Assert.assertTrue(findNumberOfSubstringOptimized(s)==3);
	}


	
	/* Check if length of String is less than 3 return 0
	 * Create a one HP for characters a,b,c and another for input
	 * Push the items from input and charMap of length 3
	 * Create variable count as 0
	 * Iterate the input till left reaches length - 3
	 * 	  If the keys in map charMap equals inputMap increment count		
	 *    increment till the length and add the values of right to inputMap
	 *    if key matches increment count
	 * 	  remove the left element from the inputmap
	 * 	  increment left
	 * return count  
	 * 
	 * 
	 */
	private int findNumberOfSubstring(String s) {
		int left = 0, right = 0, count = 0;
		Set<Character> charSet = new HashSet<>();
		Map<Character, Integer> inputMap = new HashMap<>();
		charSet.add('a');
		charSet.add('b');
		charSet.add('c');
		for (int i = 0; i < 3; i++) {
			inputMap.put(s.charAt(right), inputMap.getOrDefault(s.charAt(right++), 0)+1);
		}
		while(left <= s.length()-3) {
			if(charSet.equals(inputMap.keySet()))count++; // count 1
			while(right < s.length()){
				inputMap.put(s.charAt(right), inputMap.getOrDefault(s.charAt(right++), 0)+1);
				if(charSet.equals(inputMap.keySet()))count++;
			}
			if(inputMap.get(s.charAt(left))>1) {
				inputMap.put(s.charAt(left), inputMap.getOrDefault(s.charAt(left), 0)-1);
			}
			else inputMap.remove(s.charAt(left));
			left++;
		}
		return count;
	}
	
	/* 
	 * Check if length of String is less than 3 return 0
	 * Create a one HP for characters a,b,c and another for input
	 * Initialize left and right as zero
	 * Iterate the input 
	 *   Add values to hashmap untill all 3 chars present in the substring
	 *    if present
	 *       Find the difference between count = 1 + (length - right + 1)
	 *    	 move the left and right to left+1
	 *    else 
	 *       break
	 * return the count
	 *        
	 *  
	 * 
	 */
	
	private int findNumberOfSubstringOptimized(String s) {
		int left = 0, right = 0, count = 0;
		Set<Character> charSet = new HashSet<>();
		Map<Character, Integer> inputMap = new HashMap<>();
		charSet.add('a');
		charSet.add('b');
		charSet.add('c');
		while(left <= s.length()-3) {
			while(right < s.length()){
				inputMap.put(s.charAt(right), inputMap.getOrDefault(s.charAt(right), 0)+1);
				if (charSet.equals(inputMap.keySet())) break;
				right++;
			}
			if(right < s.length()) {
				count += 1 + (s.length() - right - 1);
				left++;
				right = left;
				inputMap = new HashMap<>();
			}
			else break;
		}
		return count;
	}
	
	/* 
	 * Initialize n as length of string and count as 0
	 * Initialize int a,b,c as -1
	 * Iterate n times
	 *   Update the index in a,b,c for the matching ones
	 *   Find the minimum of all 3
	 *   add count by min+1 
	 * return count
	 * 
	 * Explanation
	 * abcabc
	 * abc min 0 , count 1
	 * abca min 1, count 2, abca,bca
	 * abcab min 2 , count 3 abcab,bcab, cab
	 * abcabc min 3, count 4 abcabc, bcabc, cabc, abc
	 * count 10
	 */
	
	private int numberOfSubstrings(String s) {
        int n = s.length(), count = 0;
        int a = -1, b = -1, c = -1;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') a = i;
            else if(s.charAt(i) == 'b') b = i;
            else c = i;
            if(a == -1 || b == -1 || c == -1) continue;
            int min = Math.min(a, Math.min(b, c));
            count += min + 1;
        }
        return count;
    }

	
	
	
	
}
