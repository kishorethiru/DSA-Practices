package slidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ShortestDistanceToCharacter {
	/*
	 * Given a string s and a character c that occurs in s, return an array of 
	 * integers answer where answer.length == s.length and answer[i] is the distance 
	 * from index i to the closest occurrence of character c in s.

	   The distance between two indices i and j is abs(i - j), where abs is the 
	   absolute value function.

 

		Example 1:
		
		Input: s = "loveleetcode", c = "e"
		Output: [3,2,1,0,1,0,0,1,2,2,1,0]		        
		Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
		The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
		The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 3.
		For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
		The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
		Example 2:
		
		Input: s = "aaab", c = "b"
		Output: [3,2,1,0]
	 * 
	 */
	
	/*
	 * 1. Did I understand the problem? Yes

        What is the input(s)? String, char
        What is the expected output? int[]
        Do I have any constraints to solve the problem? No 
        Do I have all the information to go to the next steps 
        How big is your test data set will be? 
		

		2. Test data set
		        Minimum  3 data set including positive, negative and edge
		        Validate with the interviewer if the data set is fine by his/ her assumptions
		
		3. Do I know to solve it?
		        Yes- great is there an alternate ? Yes
		        No - can I break the problem into sub problems?
		
		4. Ask for hint (if you dont know how to solve this
		5.  Do I know alternate solutions as well
		    Approach 1 : Using two for loops
		
		6. If you know the alternate solution find out the O-notations (performance)
		Approach 1 : Using two for loops - O(n^2), O(n)
	 * 
	 */
	
	@Test
	public void testData01()
	{
		String input = "loveleetcode";
		
		
		char matchChar = 'e';
		Assert.assertArrayEquals(findShortestLengthTwoPass(input, matchChar),
				new int[] {3,2,1,0,1,0,0,1,2,2,1,0});
	}
	
	@Test
	public void testData02()
	{
		String input = "welcome";
		char matchChar = 'm';
		Assert.assertArrayEquals(findShortestLengthTwoPass(input, matchChar), new int[] {5,4,3,2,1,0,1});
	}
	
	@Test
	public void testData03()
	{
		String input = "rrrrr";
		char matchChar = 'r';
		Assert.assertArrayEquals(findShortestLengthTwoPass(input, matchChar), new int[] {0,0,0,0,0});	
	}
	
	/* if input is empty return empty array
	 * Create a int[] retArr of string length
	 * Iterate the input
	 * 	  create variable minLen = 0;
	 * 	  Iterate the input, if matchChar found , find the difference and store to minLen
	 *             if more than one occurrence found compare and store the min length
	 * 	  Store the minLen to the retArr
	 * return retArr
	 *    
	 * Time : O(n^2)
	 * Space: O(n)
	 * 
	 */

	private int[] findShortestDistance(String input, char matchChar) {
		if(input.length() == 0) return new int[] {};
		int[] retVal = new int[input.length()];
		for (int i = 0; i < input.length(); i++) 
		{
			int minLen = Integer.MAX_VALUE;
			if(input.charAt(i) == matchChar) continue;
			else {
				for (int j = 0; j < input.length(); j++) 
				{
					if(i!=j && input.charAt(j)==matchChar) minLen = Math.min(minLen, Math.abs(i-j));
				}
				retVal[i] = minLen;
			}
		}
		return retVal;
	}
	
	/* Pseudocode
	 * Create two pointers left = 0, right = 0
	 * Create two variables int lastFoundOccr, isLastOccFound
	 * Craete retArr of length input
	 * Iterate the input till left <= input length
	 *   if left == char,left++
	 *   else if right != char and right <= input length and !isLastOccFound
	 *        increment the right till finding char
	 *   else if left > right increment right
	 *   else calculate min length and add to retARr
	 *     
	 * 
	 * 
	 */
	
	private int[] findShortestLengthTwoPtr(String input, char mathChar) {
		int left = 0, right = 0;
		int lastFoundOccr = Integer.MAX_VALUE;
		int[] retArr = new int[input.length()];
		while (left < input.length()) {
			if (input.charAt(left) == mathChar){
				lastFoundOccr = right;
				right = left;
				retArr[left++] = 0;
			}
			else if (input.charAt(right) != mathChar && right < input.length()) {
				while (right < input.length()) {
					if (input.charAt(right) == mathChar) {
						break;
					}
					right++;
				}
			} else if (left > right && right <=input.length() ) {
				lastFoundOccr = right++;
			} else {
				int minLen = Math.min(Math.abs(lastFoundOccr - left), Math.abs(left - right));
				retArr[left++] = minLen;
			}
		}
		return retArr;
	}
	
	/* Create a list and push the index of matching char to list
	 * Create array of length string
	 * Create previousIndex and remove the first index of list , assign the removed value to it
	 * Create currentIndex and push the value of previousIndex to this
	 * Iterate the input string
	 *   If currentElmentIndex > currentIndex and list is not empty
	 *      Assign the value of currrentIndex to previousIndex
	 *      remove the value of first index from index and assign to currentIndex
	 *   Find the min length between currentIndex and currentElement and currentElement and previousIndex
	 *   push to the return array
	 * return retArr
	 * Time : O(n) + O(n) => O(2n) => O(n)
	 * Space : O(n)
	 */
	
	private int[] findShortestLengthTwoPass(String input, char matchChar) {
		List<Integer> matchIndex = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) 
		{
			if(input.charAt(i) == matchChar) matchIndex.add(i);
		}
		if(matchIndex.isEmpty()) throw new RuntimeException("No Matching Char");
		int[] retArr = new int[input.length()];
		int previousIndex = matchIndex.remove(0);
		int currentIndex =previousIndex; 
		for (int i = 0; i < input.length(); i++) 
		{
			if(i > currentIndex & !matchIndex.isEmpty())
			{ 
				previousIndex = currentIndex;
				currentIndex = matchIndex.remove(0);
			}
			retArr[i] = Math.min(Math.abs(currentIndex-i), Math.abs(previousIndex-i));	
		}
		return retArr;
	}
	
	

}
