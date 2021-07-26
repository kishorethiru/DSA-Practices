package stacks;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P57_FindCountOfMissingBrackets {
	
	/*
	 *  Find out how many missing brackets to make a valid parentheses !! 
	Input can have only open and closing brackets ( )
	String st = “((((” -> 4 brackets 
	String st = “(()))” -> 1 bracket 
	 */
	
	/*1. 
    Input(s)? String
    Output ? int
    Constraints ?  

2. Test data set
        Positive : “((((”
        Negative : "()()"
        Edge     : “(()))”

3. Known Approaches
        Approach 1 :Using Stacks 

4. O-Notations
		Approach 1 :Using Stacks

5. Pseudocode
	 *  
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		String input = "((((";
		Assert.assertTrue(findCountOfBrackets(input)==4);
	}

	@Test
	public void testData02(){			 // Negative
		String input = "()()";
		Assert.assertTrue(findCountOfBrackets(input)==0);
	}

	@Test
	public void testData03(){			 // Edge
		String input = "(()))";
		Assert.assertTrue(findCountOfBrackets(input)==1);
	}	
	@Test
	public void testData04(){			 // Edge
		String input = ")";
		Assert.assertTrue(findCountOfBrackets(input)==1);
	}
	
	/* 1.Convert input to charArray
	 * 2.Create a stack
	 * 3.Iterate the charArray
	 * 	 a) Push to the stack if stack is empty or peek element and current element is same 
	 *   b) else pop the item 
	 * 4.return stack size
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 * 
	 */

	private int findCountOfBrackets(String input) {
		if(input.length()==0) return 0;
		char[] charArr = input.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (Character eachChar : charArr) {
			if(stack.empty() || stack.peek() == eachChar) stack.push(eachChar);
			else stack.pop();
		}
		return stack.size();
	}

}
