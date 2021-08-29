package stacks;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P115_CountToMakeParenthesisValid {
	/*
		Problem Statement
		A parentheses string is valid if and only if:

		It is the empty string,
		It can be written as AB (A concatenated with B), where A and B are valid strings, or
		It can be written as (A), where A is a valid string.
		You are given a parentheses string s. In one move, you can insert a parenthesis at
		 any position of the string.
		
		For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or 
		a closing parenthesis to be "())))".
		Return the minimum number of moves required to make s valid.
	*/

	/*
	   1. 
	  	  Input(s) ? String 
		  Output ? int
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive :
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode	Using Stack	
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		Assert.assertTrue(minAddToMakeValid("())") == 1);
		Assert.assertTrue(minAddToMakeValidUsingString("())") == 1);
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue(minAddToMakeValid("()(())") == 0);
		Assert.assertTrue(minAddToMakeValidUsingString("()(())") == 0);
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(minAddToMakeValid("()))((") == 4);
		Assert.assertTrue(minAddToMakeValidUsingString("()))((") == 4);
	}
	
	/* 
	 * Create a stack
	 * Iterate the input
	 *  if stack is not empty and peek char is ( and current char is ) , pop from stack
	 *  else push to stack
	 * return stack.size()
	 * 
	 * Time : O(n)
	 * Space :O(n)
	 * 
	 */
	private int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
				stack.pop();
			} else
				stack.push(s.charAt(i));
		}
		return stack.size();
	}
	
	private int minAddToMakeValidUsingString(String s) {
		int openBracket = 0, closeBracket = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') {
				openBracket++;
			}
			else if(s.charAt(i) ==')') {
				if(openBracket>0) openBracket--;
				else closeBracket++;
			}
		}
		return openBracket+closeBracket;
	}
}
