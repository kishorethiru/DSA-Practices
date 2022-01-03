package sdetmeet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class FindCharofK {
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
		String s = "hello  there";
		String type =  "max";
		int k = 2;
		System.out.println(findChar(s,type,k));
	}

	@Test
	public void testData02() { // Negative
		String s = "madam"; // m = 2, a = 2, d= 1
		String type =  "min";
		int k = 2;
		System.out.println(findChar(s,type,k));
	}

	@Test
	public void testData03() { // Edge

	}
	/*
	 *  TIme : O(nlogn)+ O(nlogn) -> O(nlogn)
	 *  Space : O(2n) -> O(n)
	 */
	private char findChar(String s, String type, int k) {
		Map<Character, Integer> map = new TreeMap<>();
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		ArrayList<Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
		if(type.equals("max"))
			Collections.sort(list, (a,b)-> b.getValue().compareTo(a.getValue()));
		else Collections.sort(list, (a,b)-> a.getValue().compareTo(b.getValue()));
		return list.get(k-1).getKey();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
