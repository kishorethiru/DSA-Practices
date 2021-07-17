package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class StringPermutation {
	/*
	 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.

		In other words, one of s1's permutations is the substring of s2.
		
		Example 1:
		
		Input: s1 = "ab", s2 = "eidbaooo"
		Output: true
		Explanation: s2 contains one permutation of s1 ("ba").
		Example 2:
		
		Input: s1 = "ab", s2 = "eidboaoo"
		Output: false
	 * 
	 */
	
/*
	 * 	1. 
	    Input(s)?  Two String
	    Output ? Boolean
	    Constraints ?   Np
	
	2. Test data set
	
	        Positive :s1 = "ab", s2 = "eidbaooo"
	        Negative :s1 = "ab", s2 = "eidboaoo"
	        Edge     :s1 = "abcd", s2 = "mnoiabdaacbd"
	
	3. Known Approaches
	        Approach 1 : Bruteforce using List and array
	        Approach 2 : Hashmap with Sliding window
	
	4. O-Notations
			Approach 1 : Bruteforce using List and array
	        Approach 2 : Hashmap with Sliding window Time : O(n), Space : O(n)
	
	5. Pseudocode
 * 
 */

@Test
public void testData01(){            // Positive
	String s1 = "ab";
	String s2 = "eidbaooo";
	Assert.assertTrue(isStringPermutationPresent(s1,s2));
	Assert.assertTrue(isStringPermutationPresentBruteForce(s1,s2));
}


@Test
public void testData02(){			 // Negative
	String s1 = "ab";
	String s2 = "eidboaoo";
	Assert.assertFalse(isStringPermutationPresent(s1,s2));
	Assert.assertTrue(isStringPermutationPresentBruteForce(s1,s2));
}

@Test
public void testData03(){			 // Edge
	String s1 = "abcd";
	String s2 = "mnoiabdaacbd";
	Assert.assertTrue(isStringPermutationPresent(s1,s2));
	Assert.assertTrue(isStringPermutationPresentBruteForce(s1,s2));
}


/* 1.Create a hash map s1Map and put the items present in s1
 * 2.Create a hash map s2Map and add items of s1 length from s2
 * 3.Iterate the input from 1 till s2 length - s1 length
 * 	  a) Remove the previous index value
 *    b) Insert the i+s2 length value
 *    c) Compare s1Map and s2Map, if equals return true
 * 4.return false
 *
 *Time : O(m) + O(n) => O(m+n)=> O(n)
 *Space : O(m) + O(n) => O(m+n) => O(n)
 */
private boolean isStringPermutationPresent(String s1, String s2) {
	if (s1.length() > s2.length())
		return false;
	if (s1.length() == 0 || s2.length() == 0)
		return false;
	Map<Character, Integer> s1Map = new HashMap<>();
	for (int i = 0; i < s1.length(); i++) {
		s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
	}
	Map<Character, Integer> s2Map = new HashMap<>();
	for (int i = 0; i < s1.length(); i++) {
		s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
	}
	for (int i = 1; i <= s2.length() - s1.length(); i++) {
		if (s2Map.get(s2.charAt(i - 1)) > 1) {
			s2Map.put(s2.charAt(i - 1), s2Map.getOrDefault(s2.charAt(i - 1), 0) - 1);
		} else
			s2Map.remove(s2.charAt(i - 1));
		s2Map.put(s2.charAt(i + s1.length() - 1), s2Map.getOrDefault(s2.charAt(i + s1.length() - 1), 0) + 1);
		if (s1Map.equals(s2Map))
			return true;
	}
	return false;
}

/* 
 *  Convert s1 to charArray and sort
 *  Create a char array of length s1 as s2CharArr
 *  Iterate s2 from 0 till s2.length - s1.length 
 *     Iterate from i+1 till i+s1.length
 *     Add items to s2CharArr
 *     Sort and equals with s1CharArr 
 *      if true return true
 *  return false
 * Time : O(n^2) + O(n) + O(n) + n * nlogn => O(n^2)
 * Space : O(n) + O(n) => O(2n) => O(n)
 */

private boolean isStringPermutationPresentBruteForce(String s1, String s2) {
	if (s1.length() > s2.length())
		return false;
	if (s1.length() == 0 || s2.length() == 0)
		return false;
	char[] s1CharArr = s1.toCharArray();
	Arrays.sort(s1CharArr);
	char[] s2CharArr = new char[s1.length()];
	for (int i = 0; i <= s2.length()-s1.length(); i++) {
		int index = 0;
		for (int j = i; j < i+s1.length(); j++) {
			s2CharArr[index++] = s2.charAt(j);
		}
		Arrays.sort(s2CharArr);
		if (Arrays.equals(s1CharArr, s2CharArr)) return true;
	}
	return false;
	}
}
