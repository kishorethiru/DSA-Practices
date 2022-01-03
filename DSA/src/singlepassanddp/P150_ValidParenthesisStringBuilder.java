package singlepassanddp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P150_ValidParenthesisStringBuilder {
	/*
		Problem Statement
	    Confirm with the input String has a valid parenthesis that has only 
	    3 brackets

	*/

	/*
	   1. 
	      Input(s) ? String 
		  Output ? boolean
		  Constraint(s) ? Using StringBuilder and Stacks
	   
	   2. Test data
			Positive : [{(())}]
			Negative : [{())}]
			Edge     : [()]{{{(())[]}
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String input = "[{(())}]";
		Assert.assertTrue(validParenthesisWithStack(input));
		Assert.assertTrue(validParenthesisStringBuilder(input));
	}

	@Test
	public void testData02() { // Negative
		String input = "[{())}]";
		Assert.assertFalse(validParenthesisWithStack(input));
		Assert.assertFalse(validParenthesisStringBuilder(input));
	}

	@Test
	public void testData03() { // Edge
		String input = "[()]{{{(())[]}}}";
		Assert.assertTrue(validParenthesisWithStack(input));
		Assert.assertTrue(validParenthesisStringBuilder(input));
	}
	
	
	/*  Create a map and enter the values of allowed brackets
	 *  Create a stack
	 *  Iterate the input,
	 *     a) If the stack is not empty and map value of peek value matches the current value pop
	 *     b) else add to the stack
	 *  if stack is empty return true else false 
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 */
	
	private boolean validParenthesisWithStack(String input) {
		Map<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<input.length();i++) {
			if(!stack.empty() && map.containsKey(stack.peek()) && map.get(stack.peek()) == input.charAt(i))
				stack.pop();
			else stack.push(input.charAt(i));	
		}
		return stack.empty();
	}
	
	
	private boolean validParenthesisStringBuilder(String input) {
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		StringBuilder sb = new StringBuilder();
		for(char c : input.toCharArray()){
			if(sb.length()>1 && map.containsKey(c) && map.get(c) == sb.charAt(sb.length()-1))
				sb.deleteCharAt(sb.length()-1);
			else sb.append(c);
		}
		return sb.length() == 0;
	}
}
