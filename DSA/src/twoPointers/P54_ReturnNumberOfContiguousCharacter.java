package twoPointers;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P54_ReturnNumberOfContiguousCharacter {
	/*
		Problem Statement
		Given a string return the max length of contiguous substring of
	    each character
		Str = abbbccaaaaabbctcccccc
		a=5
		b=3
		c=6
		t=1
	*/

	/*
	   1. 
	  	  Input(s) ?  String
		  Output ? Map<Character,Integer>
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :abbbccaaaaabbctcccccc
			Negative :abtcustba	
			Edge     :aaabbbcccctttaaazzzaaa
	
	   3.  Approaches Known 
			 Approach 1 : TwoPointers with a HashMap
	
	   4.  O - Notation 
			 Approach 1 : Time : O(n), Space O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String s = "abbbccaaaaabbctcccccc";
		System.out.println(findMaxCountOfEachChar(s));
	}

	@Test
	public void testData02() { // Negative
		String s = "abtcustba";
		System.out.println(findMaxCountOfEachChar(s));
	}

	@Test
	public void testData03() { // Edge
		String s = "aaabbbcccctttaaazzzaaa";
		System.out.println(findMaxCountOfEachChar(s));
	}

	/* Pseudocode - Two Pointers, EquiDirectional
	 * Create a new HashMap
	 * Intialize left and right as 1
	 * Iterate till right < input length
	 *  if left and right value is same increment right
	 *  if left and right is not same , add the value of left to map and
	 *  find the distance between right-left+1, if aleady value exits update the max one
	 * 	assign left = right
	 * return Map
	 * Time - O(n)
	 * Space - O(n)
	 * 
	 */
	private Map<Character,Integer> findMaxCountOfEachChar(String s) {
		Map<Character,Integer> map = new HashMap<>();
		int left = 0, right = 1;
		while(right < s.length()) {
			if(s.charAt(left)==s.charAt(right)) {
				if(map.containsKey(s.charAt(left)))
					map.put(s.charAt(left), Math.max(map.get(s.charAt(left)), right-left+1));
				else 
					map.put(s.charAt(left), right-left+1);
				right++;
			}
			else {				
				if(!map.containsKey(s.charAt(left)))map.put(s.charAt(left),1);	
				left= right++;
			}
			
		}
		return map;
	}
}
