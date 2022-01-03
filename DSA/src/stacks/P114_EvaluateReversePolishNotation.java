package stacks;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P114_EvaluateReversePolishNotation {
	/*
		Problem Statement
		Evaluate the value of an arithmetic expression in Reverse Polish Notation.

		Valid operators are +, -, *, and /. Each operand may be an integer or 
		another expression.

		Note that division between two integers should truncate toward zero.

		It is guaranteed that the given RPN expression is always valid. 
		That means the expression would always evaluate to a result, and there will 
		not be any division by zero operation.
	
	*/

	/*
	   1. 
	  	  Input(s) ? String[]
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : ["2","1","+","3","*"]
			Negative : ["4","13","5","/","+"]	
			Edge     : ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		String[] input = {"2","1","+","3","*"};
		Assert.assertTrue(evalRPN(input)==9);
	}

	@Test
	public void testData02() { // Negative
		String[] input = {"4","13","5","/","+"};
		Assert.assertTrue(evalRPN(input)==6);
	}

	@Test
	public void testData03() { // Edge
		String[] input = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		Assert.assertTrue(evalRPN(input)==22);
	}

	
	private int evalRPN(String[] input) {
		ArrayList<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        Stack<Integer> stack = new Stack<>();
        for(String s : input){
            if(list.contains(s)){
              int second = stack.pop();
              int first  = stack.pop();
              stack.push(doCal(first,second, s));  
            }
            else stack.push(Integer.valueOf(s));
        }
        return stack.pop();
	}

	private int doCal(int a, int b, String s) {
		  switch (s){
          case "+":
              return a + b;
          case "-":
              return a - b;
          case "*":
              return a * b;
          case "/":
              return a / b;
      }
      return 1;
	}
}
