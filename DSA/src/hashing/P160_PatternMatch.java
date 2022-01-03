package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P160_PatternMatch {
	/*
		Problem Statement
		
		String[] ch = {"abb", "abc", "xyz", "xyy"};
String pattern = "mnn";
Output: ["xyy","abb"] --> List -> Any order
Answer: xyy and abb have same character at index 1 and 2 like the pattern
Example 2:
String[] ch = {"abb", "abc", "xyz", "xyy"};
String pattern =  "mnn";
Output: ["abc", "xyz"]
Output: abc and xyz have all distinct characters, similar to the pattern.
Example 3:
String[] ch = ["abb", "abc", "xyz", "xyy"];
String pattern = "aba";
Output: [] 
Pattern has same character at index 0 and 2. No word in dictionary follows the pattern.
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
		  Constraint(s) ?
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int[] input = {};
		int[] output = {};
//		Assert.assertTrue();
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	private List<String> wordPatternMatch(String[] inputStr, String pattern){
		List<String> retArr = new ArrayList<>();
		Map<Character, Integer> patternMap = new HashMap<>();
		List<String> patternArr =  new ArrayList<>();
		for(int i = 0 ; i < pattern.length(); i++) {
			char addChar = pattern.charAt(i);
			patternMap.put(addChar, patternMap.getOrDefault(addChar, 0)+1);
			patternArr.add(i+""+patternMap.get(addChar));
		}
		for(String eachVal : inputStr){
			
		}
		return patternArr;
	}	
}
