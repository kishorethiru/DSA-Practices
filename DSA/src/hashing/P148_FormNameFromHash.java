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
public class P148_FormNameFromHash {
	/*
		Problem Statement
	
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
		System.out.println(returnName("Kishore Kumar"));
	}

	@Test
	public void testData02() { // Negative
		System.out.println(returnName("kkK"));
	}

	@Test
	public void testData03() { // Edge
		System.out.println(returnName("k1sh0r3"));
	}
	
	private String returnName(String input) {
		Map<Character, Integer> inputMap = new HashMap<>();
		Map<Character, List<Integer>> indexMap = new HashMap<>();
		for(int i = 0 ; i < input.length(); i++) {
			inputMap.put(input.charAt(i),
					inputMap.getOrDefault(input.charAt(i), 0)+1);
			if(indexMap.containsKey(input.charAt(i))){
				List<Integer> indexList = new ArrayList<Integer>(indexMap.get(input.charAt(i)));
				indexList.add((Integer)i);
				indexMap.put(input.charAt(i), indexList);
			}
			else 
				indexMap.put(input.charAt(i), Arrays.asList(i));
		}
		char[] nameArr = new char[input.length()];
		for(Map.Entry<Character, List<Integer>> eachSet : indexMap.entrySet()) {
			for(Integer i : eachSet.getValue()) nameArr[i] = eachSet.getKey();
		}
		return new String(nameArr);
	}
}
