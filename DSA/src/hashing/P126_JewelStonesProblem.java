package hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P126_JewelStonesProblem {
	/*
		Problem Statement
		You're given strings jewels representing the types of stones that are jewels, and 
		stones representing the stones you have. Each character in stones is a type of stone
		 you have. You want to know how many of the stones you have are also jewels.

		Letters are case sensitive, so "a" is considered a different type of stone from "A".

		Example 1:
		
		Input: jewels = "aA", stones = "aAAbbbb"
		Output: 3
		Example 2:
		
		Input: jewels = "z", stones = "ZZ"
		Output: 0
	
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
		String jewels = "aA";
		String stones = "aAAbbbb";
		Assert.assertTrue(findJewelCount(jewels,stones) == 3);
		Assert.assertTrue(numJewelsInStonesHash(jewels,stones) == 3);
	}

	@Test
	public void testData02() { // Negative
		String jewels = "z";
		String stones = "ZZ";
		Assert.assertTrue(findJewelCount(jewels,stones) == 0);
		Assert.assertTrue(numJewelsInStonesHash(jewels,stones) == 0);
	}

	@Test
	public void testData03() { // Edge
		String jewels = "aNcd";
		String stones = "aaaannnCCCdddD";
		Assert.assertTrue(findJewelCount(jewels,stones) == 7);
		Assert.assertTrue(numJewelsInStonesHash(jewels,stones) == 7);
	}

	private int findJewelCount(String jewels, String stones) {
		int[] ascii = new int[52];
		for (char c : stones.toCharArray()) {
			if (Character.isUpperCase(c))
				ascii[c - 'A']++;
			else
				ascii[c - 'a' + 26]++;
		}
		int ret = 0;
		for (char c : jewels.toCharArray()) {
			if (Character.isUpperCase(c))
				ret += ascii[c - 'A'];
			else
				ret += ascii[c - 'a' + 26];
		}
		return ret;
	}

	private int numJewelsInStonesHash(String jewels, String stones) {
		Map<Character, Integer> stonesHash = new HashMap<>();
		for (Character c : stones.toCharArray()) {
			stonesHash.put(c, stonesHash.getOrDefault(c, 0) + 1);
		}
		int ret = 0;
		for (Character c : jewels.toCharArray())
			if (stonesHash.containsKey(c))
				ret += stonesHash.get(c);
		return ret;

	}
}
