package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P18_FindFirstLongestEvenWord {
	/*
		Problem Statement
		Given a String , find the longest word which length is even
	
	*/

	/*
	   1. 
	  	  Input(s) ? String
		  Output   ? String
		  Constraint(s) ? Optimized
	   
	   2. Test data
			Positive :  "Time to write great code"
			Negative :	"Tim tos write great coe"
			Edge     :  "Time to writes greatest code"
	
	   3.  Approaches Known 
			 Approach 1 : Single Pass
			 Approach 2 : Two Pointers
	
	   4.  O - Notation 
			 Approach 1 : Single Pass Time : O(n), Space: O(n)
			 Approach 2 : Two Pointers Time : O(n/2), Space: O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "Time to write great code";
		Assert.assertTrue(findLongestEvenWord(s).equals("code"));
		Assert.assertTrue(findLongestEvenWordTwoPtr(s).equals("code"));
	}

	@Test
	public void testData02() { // Negative
		String s = "Tim tos write great coe";
		Assert.assertTrue(findLongestEvenWord(s).equals(""));
		Assert.assertTrue(findLongestEvenWordTwoPtr(s).equals(""));
	}

	@Test
	public void testData03() { // Edge
		String s = "Time to writes greatest code";
		Assert.assertTrue(findLongestEvenWord(s).equals("greatest"));
		Assert.assertTrue(findLongestEvenWordTwoPtr(s).equals("greatest"));
	}

	/* Create int max and index  as -1
	 * Iterate the input
	 *  find the length of each char
	 *  if its even store the count of max and its index
	 * if index = -1 return ""
	 * else return string[index]
	 * 
	 */
	private String findLongestEvenWord(String s) {
		String[] ch = s.split(" ");
		int max = 0, index = -1;
		for(int i = 0; i<ch.length;i++) {
			if(ch[i].length()%2==0 && ch[i].length()>=max) {
				max = ch[i].length();
				index = i;
			}
		}
		if (index == -1)
			return "";
		return ch[index];
	}
	
	/* Pseudocode : Two Pointers
	 * Create int max and index  as -1
	 * Initialize left and right
	 * Iterate till left<=right
	 *   if the word length is even and length >= max
	 *   Update max value and its index
	 * return the max word
	 * 
	 * Time  : O(n)
	 * Space : O(n)
	 * 
	 */
	
	private String findLongestEvenWordTwoPtr(String s) {
		String[] ch = s.split(" ");
		int max = 0, index = -1;
		int left = 0, right = ch.length - 1;
		while (left <= right) {
			if (left == right) {
				if (ch[left].length() % 2 == 0 && ch[left].length() >= max) {
					max = ch[left].length();
					index = left;
				}
				left++;
			} else {
				if (ch[left].length() % 2 == 0 && ch[left].length() >= max) {
					max = ch[left].length();
					index = left;
				}
				if (ch[right].length() % 2 == 0 && ch[right].length() >= max) {
					max = ch[right].length();
					index = right;
				}
				left++;
				right--;
			}
		}
		if (index == -1)
			return "";
		return ch[index];
	}
}
