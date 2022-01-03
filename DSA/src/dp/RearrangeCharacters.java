package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class RearrangeCharacters {
	/*
		Problem Statement
		Given a string s, rearrange the characters of s so that any two adjacent characters are 
		not the same.
		Return any possible rearrangement of s or return "" if not possible.
 
		Example 1:
		Input: s = "aab"
		Output: "aba"
		Example 2:
		Input: s = "aaab"
		Output: ""
	
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

		String s = "cxmwmmm";
		rearrangeCharacters(s);
		int[] output = {};
//		Assert.assertTrue();
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	private String rearrangeCharacters(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (a,b)-> b.getValue().compareTo(a.getValue()));
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(index < list.size()) {
			char firstChar = list.get(index).getKey();
			int  firstVal  = list.get(index).getValue();
			while(firstVal>0 && index < list.size()) {
				sb.append(firstChar);
				list.get(index).setValue(--firstVal);
				char secondChar = list.get(index+1).getKey();
				int  secondVal  = list.get(index+1).getValue();
				if (secondVal > 0) {
					sb.append(secondChar);
					list.get(index).setValue(--secondVal);
				}
				if(firstVal != 0 && secondVal == 0)index++;
			}
			if(firstVal> 0 ) sb.append(firstChar);
			index++;
		}
		return sb.toString();
	}
}
