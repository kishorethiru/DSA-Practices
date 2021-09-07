package stacks;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P128_RemoveMinimumParenthesis {
	/*
		Problem Statement
		Remove the minimum number of parentheses ( '(' or ')', in any positions ) so 
		that the resulting parentheses string is valid and return any valid string.

		Formally, a parentheses string is valid if and only if:

		It is the empty string, contains only lowercase characters, or
		It can be written as AB (A concatenated with B), where A and B are valid strings, or
		It can be written as (A), where A is a valid string.
	
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? String
		  Constraint(s) ? Time Optimized
	   
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
		String s = "abc(a(c)e)de)";
		Assert.assertTrue(removeMinimumParenthesis(s).equals("abc(a(c)e)de"));
	}

	@Test
	public void testData02() { // Negative
		String s = "abcacede";
		Assert.assertTrue(removeMinimumParenthesis(s).equals("abcacede"));
	}

	@Test
	public void testData03() { // Edge
		String s = "(a(b(c)d)";
		Assert.assertTrue(removeMinimumParenthesis(s).equals("a(b(c)d)"));
	}
	
	@Test
	public void testData04() { // Edge
		String s = "))((";
		Assert.assertTrue(removeMinimumParenthesis(s).equals(""));
	}

	/*  Create a stack of character and another stack for index
	 *  Iterate the input
	 *    Add the brackets in one stack and its index in another stack
	 *    if peek value is open and current is closed remove from both 
	 *  Create a StringBuilder 
	 *  Iterate the input , dont append the value in stack index to sb
	 *  Return the sb.toString()
	 *  
	 * Time : O(2n) -> O(n)
	 * Space : O(n)
	 * 
	 */
	private String removeMinimumParenthesis(String s) {
		Stack<Character> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(!stack.empty() && stack.peek() == '(' && s.charAt(i) == ')') {
				stack.pop();
			    index.pop();
			}
			else if(!Character.isLetter(s.charAt(i))) {
				stack.push(s.charAt(i));
			    index.push(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1 ; i >=0; i--) {
			if( !index.empty() && index.peek() == i) {
				index.pop();
			}
			else sb.insert(0, s.charAt(i));
		}
		return sb.toString();
	}
}
