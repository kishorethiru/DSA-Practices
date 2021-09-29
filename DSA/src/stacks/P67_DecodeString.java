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
	
	/*
	 * Create a Stack
	   Iterate the input and add the each char to Stack 
 		  If [ is found , add the items till [ is found to array List
 		  Pop '[' brace
 		  Initialize K as 1 
  		  if is a digit iterate till [ or if char present or till stack is not empty
          update K value
          Push the items to stack k times
		Create StringBuilder and pop the items from stack and return
		Time : O(m*n) m - multiple digits and n - brackets
	    Space : O(m*n) m - multiple digits and n - brackets
	 */
	private String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ']')
				stack.push(s.charAt(i));
			else {
				List<Character> list = new ArrayList<>();
				while (stack.peek() != '[')
					list.add(stack.pop());
				stack.pop();
				int times = 1;
				if (Character.isDigit(stack.peek())) {
					StringBuilder valueOfK = new StringBuilder();
					while (!stack.empty() && stack.peek() != '[' && Character.isDigit(stack.peek())) {
						valueOfK.insert(0, stack.pop());
					}
					times = Integer.valueOf(valueOfK.toString());
				}
				while (times > 0) {
					for (int j = list.size() - 1; j >= 0; j--)
						stack.push(list.get(j));
					times--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : stack)
			sb.append(c);
		return sb.toString();
	}
}
