package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P34_MaximumRepeatingSubstring_LC_1668 {
	/*
		Problem Statement
		
		https://leetcode.com/problems/maximum-repeating-substring/
		1668. Maximum Repeating Substring
		
		For a string sequence, a string word is k-repeating if word concatenated k times is a 
		substring of sequence. The word's maximum k-repeating value is the highest value 
		k where word is k-repeating in sequence. If word is not a substring of sequence, word's
		 maximum k-repeating value is 0.
		Given strings sequence and word, return the maximum k-repeating value of word in sequence.
	
	*/

	/*
	   1. 
	  	  Input(s) ? Two String 
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : sequence = "ababc", word = "ab"
			Negative : sequence ="ababc", word = "ac"
			Edge     : sequence ="ababc", word = "ac"
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		System.out.println(maxRepeating("ababc","ab"));
		System.out.println(maxRepeating("a","a"));
	}

	@Test
	public void testData02() { // Negative
		System.out.println(maxRepeating("ababc","ac"));
	}

	@Test
	public void testData03() { // Edge
		System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
	}
	
	public int maxRepeating(String sequence, String word) {
		if (!sequence.contains(word))
			return 0;
		if (sequence.length() == word.length()) {
			if (sequence.equals(word))
				return 1;
			else
				return 0;
		}
		int left = 0;
		int temp = 0, max = 0;
		int wordSize = word.length();
		while (left < sequence.length()) {
			if (sequence.charAt(left) == word.charAt(0)) {
				if (left + wordSize >= sequence.length())
					break;
				String substr = sequence.substring(left, left + wordSize);
				if (substr.equals(word)) {
					temp++;
					left += wordSize;
					max = Math.max(max, temp);
				} else {
					left++;
					temp = 0;
				}

			} else {
				temp = 0;
				left++;
			}
		}
		return max;
	}
}
