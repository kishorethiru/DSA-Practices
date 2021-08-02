package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P19_FindAnagramIndices {
	
	/* Find All Anagrams in a String

		Given two strings s and p, return an array of all the 
		start indices of p's anagrams in s. You may return the answer in any order.
		
		Example 1:
		
		Input: s = "cbaebabacd", p = "abc"
		Output: [0,6]
		Explanation:
		The substring with start index = 0 is "cba", which is an anagram of "abc".
		The substring with start index = 6 is "bac", which is an anagram of "abc".
	 * 
	 */
	
//	1. Did I understand the problem? Yes
//
//	        What is the input(s)?  String, String
//	        What is the expected output? int[]
//	        Do I have any constraints to solve the problem? O(n) 
//	        Do I have all the information to go to the next steps 
//	        How big is your test data set will be? 
//			
//
//	2. Test data set
//	        Minimum  3 data set including positive, negative and edge
//	        Validate with the interviewer if the data set is fine by his/ her assumptions
//
//	3. Do I know to solve it?
//	        Yes- great is there an alternate ? 
//	        No - can I break the problem into sub problems?
//
//	4. Ask for hint (if you dont know how to solve this
//	5.  Do I know alternate solutions as well
//	       Approach 1 : Bruteforce
//	       Approach 2 : Using Sliding Window technique
//
//	6. If you know the alternate solution find out the O-notations (performance)
//		   Approach 1 : Bruteforce - Time : O(n^2), O(n)
//    	   Approach 2 : Using Sliding Window technique O(n), O(n)
	
	@Test
	public void testData01() // Positive
	{
		String input = "cbaebabacd";
		String match = "abc";	
		Assert.assertArrayEquals(findAllAnagram(input,match), new int[] {0,6});
		Assert.assertArrayEquals(findAllAnagramUsingAscii(input,match), new int[] {0,6});
	}
	
	@Test
	public void testData02() // Negative
	{
		String input = "cbeababada";
		String match = "abc";	
		Assert.assertArrayEquals(findAllAnagram(input,match), new int[] {});
		Assert.assertArrayEquals(findAllAnagramUsingAscii(input,match), new int[] {});
	}
	
	@Test
	public void testData03() // Edge
	{
		String input = "abcabcabca";
		String match = "abc";	
		Assert.assertArrayEquals(findAllAnagram(input,match), new int[] {0,1,2,3,4,5,6,7});
		Assert.assertArrayEquals(findAllAnagramUsingAscii(input,match), new int[] {0,1,2,3,4,5,6,7});
	}
	
	@Test
	public void testData04() // Edge
	{
		String input = "teyuette";
		String match = "te";	
		Assert.assertArrayEquals(findAllAnagram(input,match), new int[] {0,4,6});
		Assert.assertArrayEquals(findAllAnagramUsingAscii(input,match), new int[] {0,4,6});
	}
	
//	Pseudocode 
//	1. Create two maps, currentVal and patternMap
//	2. Iterate patternMap and push the items to patternMap in Character, Integer pairs
//	3. Push the items to currentVal of size of patternMap.
//	4. Create an array of length s and index 0 
//	5. Compare two maps and add to retArr if matches
//	6. Iterate the input from 1 till input length - pattern length
//	    a)  if the previous element occurrence is more than one decrement one from value     
//	    b)  else Remove the previous element from the map and add the current element to map 
//		c)  Compare the two maps if both are equal add i-1 to the array
//	7. Return array
//	Time : O(m)+O(n) => O(m)
//	Space : O(n) + O(n) => O(n)
			
	private int[] findAllAnagram(String input, String match) {
		Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
		Map<Character, Integer> currentVal = new HashMap<Character, Integer>();
		for (int i = 0; i < match.length(); i++) 
		{
			patternMap.put(match.charAt(i), patternMap.getOrDefault(match.charAt(i), 0)+1);
			currentVal.put(input.charAt(i), currentVal.getOrDefault(input.charAt(i), 0)+1);
		}
		int[] retArr = new int[input.length()];
		int index = 0;
		if(patternMap.equals(currentVal)) retArr[index++] = 0;	
		for (int i = 1; i <= input.length() - match.length(); i++) {
			if(currentVal.get(input.charAt(i-1)) > 1)
			   currentVal.put(input.charAt(i-1), 
					   currentVal.getOrDefault(input.charAt(i-1),0)-1);
			else currentVal.remove(input.charAt(i-1));
			currentVal.put(input.charAt(i+match.length()-1),
					currentVal.getOrDefault(input.charAt(i+match.length()-1), 0)+1);
			if(patternMap.equals(currentVal)) retArr[index++] = i;
		}
		return Arrays.copyOf(retArr, index);
	}
	
	private int[] findAllAnagramUsingAscii(String input, String match) {
		int[] matchAscii = new int[128];
		int[] inputAscii = new int[128];
		int[] output = new int[input.length()]; 
		for (int i = 0; i < match.length(); i++) {
			matchAscii[match.charAt(i)]++;
			inputAscii[input.charAt(i)]++;
		}
		int index = 0;
		if(Arrays.equals(inputAscii, matchAscii)) index++;
		for (int i = 1; i <= input.length()-match.length(); i++) {
			inputAscii[input.charAt(i-1)]--;
			inputAscii[input.charAt(i+match.length()-1)]++;
			if(Arrays.equals(inputAscii, matchAscii)) output[index++] = i;
		}
		return Arrays.copyOf(output, index);		
	}
	
	

}
