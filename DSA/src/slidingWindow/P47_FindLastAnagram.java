package slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P47_FindLastAnagram {
	/*  Given a string and target, find the last matching anagram
	 * 
	 */
	
	/* 1. 
    Input(s)? String, String
    Output ? String
    Constraints ?  Time Optimized

2. Test data set

        Positive :"acbbdacbca" Target : "abc"
        Negative : "welcome" Target : "xyz"
        Edge     : "tuuttuutututu" Target : "ut" 

3. Known Approaches
        Approach 1 :Hashmap and Sliding Window 

4. O-Notations

5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		String input = "acbbdacbca";
		String target = "abc";
		Assert.assertTrue(findLastAnagram(input,target).equals("bca"));
	}


	@Test
	public void testData02(){			 // Negative
		String input = "welcome";
		String target = "xyz";
		Assert.assertTrue(findLastAnagram(input,target).equals(""));
	}

	@Test
	public void testData03(){			 // Edge
		String input = "tuuttuutututu";
		String target = "ut";
		Assert.assertTrue(findLastAnagram(input,target).equals("tu"));
	}
	
	@Test
	public void testData04(){			 // Edge
		String input = "tu";
		String target = "tu";
		Assert.assertTrue(findLastAnagram(input,target).equals("tu"));
	}
	
	/*  
	 * 1.Create two hashmap, 
	 * 		Add the elements to first map from target to targetMap
	 * 		Add the elements of target length from input to inputMap
	 * 2.Create String returnString
	 * 3.If both length are equal, return the input
	 * 4.Iterate the input from 1 till the length - target length
	 *   Remove the previous index from the inputMap
	 *   Add the currentValue + targetLength value to the input Map
	 *   Check if both inputMap and targetMap are same
	 *    if same update the returnString
	 * 5.return   returnString
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 */
	
	private String findLastAnagram(String input, String target) {
		if(input.length() == target.length() && input.contains(target)) return input;
		Map<Character,Integer> targetMap = new HashMap<>();
		Map<Character,Integer> inputMap = new HashMap<>();
		String returnString = "";
		for (int i = 0; i < target.length(); i++) {
			targetMap.put(target.charAt(i), targetMap.getOrDefault(target.charAt(i), 0)+1);
			inputMap.put(input.charAt(i), inputMap.getOrDefault(input.charAt(i), 0)+1);
		}
		if(inputMap.equals(targetMap)) returnString = input.substring(0,target.length());
		for (int i = 1; i <= input.length()-target.length(); i++) {
			if(inputMap.get(input.charAt(i-1))>1)
				inputMap.put(input.charAt(i-1), inputMap.getOrDefault(input.charAt(i-1), 0)-1);
			else inputMap.remove(input.charAt(i-1));
			inputMap.put(input.charAt(i+target.length()-1), inputMap.getOrDefault(input.charAt(i+target.length()-1), 0)+1);	
			if(inputMap.equals(targetMap)) returnString = input.substring(i, i+target.length());
		}
		return returnString;
	}
}
