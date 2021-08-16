package stacks;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P58_RemoveAdjacentCharactes {
	
	/*
	 *  Remove the adjacent characters in the string
   abbaaba = aba
   abccba  = empty string
   abbaca  = c
	 * 
	 */
	
/*
 * 
 * 1. 
    Input(s)? String 
    Output ?  String
    Constraints ?   Time Optimized
	
	2. Test data set
	
	        Positive : abbaaba
	        Edge : abccba
	        Edge     : abbaca
	        Negative : ""
	
	3. Known Approaches
	        Approach 1 :Using Stacks 
	
	4. O-Notations
	
	5. Pseudocode
 */
	
	@Test
	public void testData01(){            // Positive
		String input = "abbaaba";
		Assert.assertTrue(removeAdjacentChars(input).equals("aba"));
	}


	@Test
	public void testData02(){			 // Edge
		String input = "abccba";
		Assert.assertTrue(removeAdjacentChars(input).equals(""));
	}

	@Test
	public void testData03(){			 // Edge
		String input = "abbaca";
		Assert.assertTrue(removeAdjacentChars(input).equals("ca"));
	}

	/* 
	 * Convert input to charArray
	 * Craete a stack
	 * Iterate the charArray
	 *   If stack is empty or current value and peek value is not same push to stack
	 *   else pop
	 * Create a StringBuilder and add the items to sb
	 * return sb
	 * 
	 * Time : O(n) + O(n) => O(2n) => O(n)
	 * Space : O(3n) => O(n)
	 */
	private String removeAdjacentChars(String input) {
		if(input.length()==0) return "";
		char[] charArr = input.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (Character eachChar : charArr) {
			if (stack.empty() || stack.peek() != eachChar)
				stack.push(eachChar);
			else
				stack.pop();
		}
		int stackSize = stack.size();
		if (stackSize == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (Character stackChar : stack) {
			sb.append(stackChar);
		}
		return sb.toString();
	}
	


}
