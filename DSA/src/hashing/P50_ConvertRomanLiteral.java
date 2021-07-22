package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P50_ConvertRomanLiteral {
 /*  1.Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

		Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		For example, 2 is written as II in Roman numeral, just two one's added together. 
		12 is written as XII, which is simply X + II. The number 27 is written as XXVII, 
		which is XX + V + II.
		
		Roman numerals are usually written largest to smallest from left to right.
		 However, the numeral for four is not IIII. Instead, the number four is written 
		 as IV. Because the one is before the five we subtract it making four. 
		 The same principle applies to the number nine, which is written as IX. 
		 There are six instances where subtraction is used:
		
		I can be placed before V (5) and X (10) to make 4 and 9. 
		X can be placed before L (50) and C (100) to make 40 and 90. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
		Given a roman numeral, convert it to an integer.
		
		 
		
		Example 1:
		
		Input: s = "III"
		Output: 3
		Example 2:
		
		Input: s = "IV"
		Output: 4
		Example 3:
		
		Input: s = "IX"
		Output: 9
		Example 4:
		
		Input: s = "LVIII"
		Output: 58
		Explanation: L = 50, V= 5, III = 3.
		Example 5:
		
		Input: s = "MCMXCIV"
		Output: 1994
		Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
  * 
  * 
  */
	/* 1. 
    Input(s)? String  
    Output ? int
    Constraints ? Time Optimized  

	2. Test data set
	
	        Positive : "III"
	        Negative : "BB"
	        Edge     : "MCMXCIV"
	
	3. Known Approaches
	        Approach 1 : Use hashing 
	
	4. O-Notations
			Approach 1 : Use hashing, Time - O(n), Space - O(n)
	5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		String input = "III";
		Assert.assertTrue(convertRomanLiteral(input)==3);
	}


	@Test(expected = RuntimeException.class)
	public void testData02(){			 // Negative
		String input = "BB";
		Assert.assertTrue(convertRomanLiteral(input)==3);
	}

	@Test
	public void testData03(){			 // Edge
		String input = "MCMXCIV";
		Assert.assertTrue(convertRomanLiteral(input)==1994);
	}
	
	@Test
	public void testData04(){			 // Edge
		String input = "LVIII";
		Assert.assertTrue(convertRomanLiteral(input)==58);
	}

	
	/* Create a hashmap and add the roman literal and values to the map
	 * Create variable sum and add the first value to the sum
	 * Iterate the input from 1 till end
	 *  if current element is not in map, return exception
	 * 	if current index is > index i - 1, subtract the previous value from sum and find the diff
	 * 		between current and previous value add to sum 
	 *  else add the value to sum
	 *  return sum
	 *  Time : O(2n) => O(n)
	 *  Space : O(1) 
	 */
	
	private int convertRomanLiteral(String input) {
		Map<Character, Integer> romanHash = new HashMap<>();
		romanHash.put('I', 1);
		romanHash.put('V', 5);
		romanHash.put('X', 10);
		romanHash.put('L', 50);
		romanHash.put('C', 100);
		romanHash.put('D', 500);
		romanHash.put('M', 1000);
		if (input.length() == 1 && romanHash.containsKey(input.charAt(0)))
			return romanHash.get(input.charAt(0));
		if (!romanHash.containsKey(input.charAt(0)))
			throw new RuntimeException("Invalid Input");
		int sum = romanHash.get(input.charAt(0));
		for (int i = 1; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			char prevChar = input.charAt(i - 1);
			if (!romanHash.containsKey(currentChar))
				throw new RuntimeException("Invalid Input");
			if (romanHash.get(currentChar) > romanHash.get(prevChar))
				sum += (romanHash.get(currentChar) - romanHash.get(prevChar)) - romanHash.get(prevChar);
			else
				sum += romanHash.get(currentChar);
		}
		return sum;
	}

}
