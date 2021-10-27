package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P150_FunAnagram {
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
		Arrays.asList("code","doce","ecod","framer","frame");
		System.out.println(funAnagram(Arrays.asList("code","doce","ecod","framer","frame")));
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	private List<String> funAnagram(List<String> input){
		List<String> op = new ArrayList<>();
		Set<Map<Character, Integer>> set = new HashSet<>();
		for (String each : input) {
			Map<Character, Integer> map = new HashMap<>();
			for(char c : each.toCharArray())
				map.put(c, map.getOrDefault(c, 0)+1);
			if(!set.contains(map)) { 
				op.add(each);
				set.add(map);
			}
		}
		Collections.sort(op);
		return op;
	}
}
