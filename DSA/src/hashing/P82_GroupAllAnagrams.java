package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P82_GroupAllAnagrams {
	/*
		Problem Statement
		Given an array of strings strs, group the anagrams together. 
		You can return the answer in any order.
		An Anagram is a word or phrase formed by rearranging the 
		letters of a different word or phrase, typically using all the original letters exactly once.
		List<List<String>>
		 
		Example 1:
		Input: strs = ["eat","tea","tan","ate","nat","bat"]
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		Example 2:
		Input: strs = [""]
		Output: [[""]]
		Example 3:
		Input: strs = ["a"]
		Output: [["a"]]
	*/

	/*
	   1. 
	  	  Input(s) ? String[] 
		  Output ? List<List<String>>
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
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> output = new ArrayList<>();
		output.add(Arrays.asList("nat","tan"));
		output.add(Arrays.asList("eat"));
		output.add(Arrays.asList("ate","eat","tea"));
		System.out.println(groupAnagrams(input));
		System.out.println(output);
//		Assert.assertTrue(groupAnagrams(input).equals(output));
	}

	@Test
	public void testData02() { // Negative
		String[] input = {""};
		List<List<String>> output = new ArrayList<>();
		output.add(Arrays.asList(""));
		Assert.assertTrue(groupAnagrams(input).equals(output));
	}

	@Test
	public void testData03() { // Edge
		String[] input = {"a"};
		List<List<String>> output = new ArrayList<>();
		output.add(Arrays.asList("a"));
		Assert.assertTrue(groupAnagrams(input).equals(output));
	}

	/* If String[] is empty, return empty. 
	 * Create a HashMap out with HashMap<Character,Integer> as key and List<String> as value.
	 * Iterate the input
	 *   Create a Hashmap and add each item to hashmap.
	 *   Check if its already in hashmap, if yes get the value of the hashmap and append the current item to the list.
	 *   else add to HashMap out
	 * return values of the HashMap
	 * 
	 */
	private List<List<String>> groupAnagrams(String[] input) {
		if (input.length == 0)
			return new ArrayList<>();
		Map<Map<Character, Integer>, List<String>> outMap = new HashMap<>();
		for (String eachVal : input) {
			Map<Character, Integer> currentMap = new HashMap<>();
			for (int i = 0; i < eachVal.length(); i++) {
				currentMap.put(eachVal.charAt(i), currentMap.getOrDefault(eachVal.charAt(i), 0) + 1);
			}
			if (outMap.containsKey(currentMap)) {
				List<String> list = outMap.get(currentMap);
				list.add(eachVal);
				outMap.put(currentMap, list);
			} else {
				List<String> list = new ArrayList<>(Arrays.asList(eachVal));
				outMap.put(currentMap, list);
			}
//			outMap.putIfAbsent(currentMap, null);
//			outMap.get(currentMap).add(eachVal);
		}
		
		List<List<String>> retList = new ArrayList<>(outMap.values());
		return retList;
	}

}
