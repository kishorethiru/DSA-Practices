package twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P44_StringFormat {
  /* 
   * Given a string, aabbcccdeeee return the output as  a2b2c3d1e4
   */
	
	/* 1. 
    Input(s)? String
    Output ? String 
    Constraints ?  O(n)

2. Test data set

        Positive : String input = "aabbcccdeeee"; String  output = "a2b2c3d1e4"
        Edge : String input = "abcde"; String  output = "a1b1c1d1e1"	
        Edge : String input = "aaaa"; String  output = "a4"
        Edge : String input = "a"; String  output = "a1"

3. Known Approaches
        Approach 1 : Using Map 

4. O-Notations

5. Pseudocode
	 *  Create set
	 *  Create a hashmap
	 *  Iterate the input and push the char and   
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		String input = "aabbcccdeeee"; 
		String  output = "a2b2c3d1e4";
		Assert.assertTrue(formatString(input).equals(output));
	}


	@Test
	public void testData02(){			 // Edge
		String input = "abcde"; 
		String  output = "a1b1c1d1e1";
		Assert.assertTrue(formatString(input).equals(output));
	}

	@Test
	public void testData03(){			 // Edge
		String input = "aaaa";
		String  output = "a4";
		Assert.assertTrue(formatString(input).equals(output));
	}
	
	@Test
	public void testData04(){			 // Edge
		String input = "a"; 
		String  output = "a1";
		Assert.assertTrue(formatString(input).equals(output));
	}


	private String formatString(String input) {
		List<Character> inputChar = new ArrayList<>();
		Map<Character,Integer> inputMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			inputMap.put(currentChar, inputMap.getOrDefault(currentChar, 0)+1);
			if(!inputChar.contains(currentChar))inputChar.add(currentChar);
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : inputChar) {
			sb.append(c);
			sb.append(inputMap.get(c));	
		}
		return sb.toString();
	}
}
