package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P67_DecodeString {
	
	/*
	 *  Decode the given string
	 * 
	 */
	
	/*
	 *  1. 
	    Input(s)? String
	    Output ? String
	    Constraints ?  
	
	2. Test data set
	
	        Positive : 2[abc3[ab]]
	        Negative : a[abc[az]]
	        Edge     : 2[abc2[ab2[c]]]
	
	3. Known Approaches
	        Approach 1 : Using Stacks 
	
	4. O-Notations
	
	5. Pseudocode
	 */
	
	@Test
	public void testData01(){            // Positive
		String input = "2[abc3[ab]]";
		Assert.assertTrue(decodeString(input).equals("abcababababcababab"));
	}


	@Test
	public void testData02(){			 // Negative
		String input = "a[abc[az]]";
		Assert.assertTrue(decodeString(input).equals("aabcaz"));
	}

	@Test
	public void testData03(){			 // Edge
		String input = "2[abc2[ab2[c]]]";
		Assert.assertTrue(decodeString(input).equals("abcabccabccabcabccabcc"));
	}


	/**
	 * @param input
	 * @return
	 */
	/* 
	 * Create a new stack
	 * Iterate the input 
	 * 		Push the values to the stack untill close bracket is found
	 * 		else 
	 *         Create a list and add the values to the list untill open bracket is found
	 *         After open bracket, pop the next item and add to list 
	 *         Iterate the list in reverse order for the next found k items 
	 *         and push to the stack again 
	 * return the stack as string
	 * Time : O(m*n) m - multiple digits and n - brackets
	 * Space : O(m*n) m - multiple digits and n - brackets
	 */
	private String decodeString(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ']') stack.push(input.charAt(i));
			else {
				List<Character> list = new ArrayList<>();
				while(stack.peek() != '[') {
					list.add(stack.pop());				
				}
				stack.pop();
				int k = 1;
				if(!stack.empty() && Character.isDigit(stack.peek())) k = Character.getNumericValue(stack.pop());
				while(k > 0)
				{
					for (int j = list.size()-1; j >= 0 ; j--) {
						stack.push(list.get(j));
					}
					k--;
				}			
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character eachChar : stack) {
			sb.append(eachChar);
		}
		return sb.toString();
	}

}
