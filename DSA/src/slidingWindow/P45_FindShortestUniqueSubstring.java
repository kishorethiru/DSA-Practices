package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P45_FindShortestUniqueSubstring {
	
	/* In the given string find the shortest substring having all the  
	 * unique characters
	 * input : "abbcafcb" output:"bcaf"
	 * 
	 */
	
	/*
	 * 1. 
    Input(s)?  String
    Output ?  String
    Constraints ?  Time Optimized

	2. Test data set
	
	        Positive : input : "abbcafcb" output:"bcaf"
	        Edge     : input : "abbceddf" output:"abbceddf"
	        Edge     : input : "xxyyzzyyxxzzy" output:"xzzy"
	
	3. Known Approaches
	        Approach 1 :Using Map and Sliding Window 
	
	4. O-Notations
		    Approach 1 :Using Map and Sliding Window - Time - O(n), Space - O(n)
	
	5. Pseudocode
		 */
	
	@Test
	public void testData01(){            // Positive
		String input = "abbcafcb";
		Assert.assertTrue(findShortestUniqueSubstring(input).equals("bcaf"));
	}


	@Test
	public void testData02(){			 // Edge
		String input = "abbceddf";
		Assert.assertTrue(findShortestUniqueSubstring(input).equals("abbceddf"));
	}

	@Test
	public void testData03(){			 // Edge
		String input = "xxyyzzyyxxzzy";
		Assert.assertTrue(findShortestUniqueSubstring(input).equals("xyyz"));
	}
	
	/*1. Create a hash set, and add items from input to the set.
	 *2. Create hash map, left , right , minCount and returnString
	 *3. Iterate the input from left to right , till right reaches end and left reaches 
	 *  	before the size of unique elements length - unique count
	 *      a) Add the right element to the map
	 *      b) check if the keys in map equal to hashset size
	 *       if Yes, Check if the length of the subtring is less than minValue
	 *          if yes Update new min value and substr
	 *      c) Repeat this till map count gets less than set size
	 *4. return the substring
	 *          
	 * Time : O(n/2) + O(n) -> O(n)
	 * Space : O(n) + O(n) -> O(n)
	 */
	
	private String findShortestUniqueSubstring(String input) {
		Set<Character> inputSet = new HashSet<>();
		Map<Character, Integer> inputMap = new HashMap<>();
		int left = 0, right = input.length() - 1, minCount = Integer.MAX_VALUE;
		String returnString = "";
		while (left <= right) {
			if (left == right)
				inputSet.add(input.charAt(left++));
			else {
				inputSet.add(input.charAt(left++));
				inputSet.add(input.charAt(right--));
			}
		}
		left = 0;
		right = 0;
		int uniqueCount = inputSet.size();
		while (right < input.length() && left < input.length() - uniqueCount) {
			char currentChar = input.charAt(right);
			inputMap.put(currentChar, inputMap.getOrDefault(currentChar, 0) + 1);
			while (inputMap.size() == uniqueCount) {
				if (right - left + 1 < minCount) {
					minCount = right - left + 1;
					returnString = input.substring(left, right + 1);
				}
				if (inputMap.get(input.charAt(left)) > 1)
					inputMap.put(input.charAt(left), inputMap.getOrDefault(input.charAt(left), 0) - 1);
				else
					inputMap.remove(input.charAt(left));
				left++;
			}
			right++;
		}
		return returnString;
	}	
}
