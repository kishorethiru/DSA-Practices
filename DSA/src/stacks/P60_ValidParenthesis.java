package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P60_ValidParenthesis {
	
	/*
	 *  From a given string consists of parenthesis , verify that if the given is
	 *  valid parenthesis or not 
	 * 
	 */
	
/* 
 * 1. 
    Input(s)? String 
    Output ? boolean
    Constraints ?  only {},[],(),<> are allowed in input

	2. Test data set
	
	        Positive : {[]}()
	        Negative : {{{{{))))
	        Edge     : {[(<>)]}<<{[]}>>
	
	3. Known Approaches
	        Approach 1 :Using Stacks 
	
	4. O-Notations
	
	5. Pseudocode
 * 
 * 
 */
	
	@Test
	public void testData01(){            // Positive
		String input = "{[]}()";
		Assert.assertTrue(isValidParanthesis(input));
	}


	@Test
	public void testData02(){			 // Negative
		String input = "{{{{{))))";
		Assert.assertFalse(isValidParanthesis(input));
	}

	@Test
	public void testData03(){			 // Edge
		String input = "{[(<>)]}<<{[]}>>";
		Assert.assertTrue(isValidParanthesis(input));
	}
	
	/*  
	 * Create a Hashmap holding the parenthesis pairs
	 * Create a stack
	 * Iterate the input
	 *   If stack is not empty and current element is present in key 
	 *    	pop the item from stack and check if equals to value of current key in map, if not return false 
	 *   else push to stack
	 * If stack is empty return true else false
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 * 
	 */

	private boolean isValidParanthesis(String input) {
		if(input.length() % 2 == 1) return false;
		Map<Character, Character> pairs = new HashMap<>();
		pairs.put('}', '{');
		pairs.put(']', '[');
		pairs.put('>', '<');
		pairs.put(')', '(');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			if(!stack.isEmpty() && pairs.containsKey(input.charAt(i))) {
				if (!stack.pop().equals(pairs.get(input.charAt(i)))) return false;
			}
			else stack.push(input.charAt(i));
		}
		return stack.size() == 0;
	}

}
