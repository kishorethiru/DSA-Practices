package stacks;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P112_RemoveDuplicateOfGivenK {
	/*
		Problem Statement
		You are given a string s and an integer k, a k duplicate removal consists of 
		choosing k adjacent and equal letters from s and removing them, causing the left and 
		the right side of the deleted substring to concatenate together. We repeatedly make k 
		duplicate removals on s until we no longer can.
		Return the final string after all such duplicate removals have been made. 
		It is guaranteed that the answer is unique.
 
		Example 1:
		Input: s = "abcd", k = 2
		Output: "abcd"
		Explanation: There's nothing to delete.
		Example 2:
		Input: s = "deeedbbcccbdaa", k = 3
		Output: "aa"
		Explanation: 
		First delete "eee" and "ccc", get "ddbbbdaa"
		Then delete "bbb", get "dddaa"
		Finally delete "ddd", get "aa"
		Example 3:
		Input: s = "pbbcggttciiippooaais", k = 2
		Output: "ps"
	
	*/

	/*
	   1. 
	  	  Input(s) ? String s, int k 
		  Output ? String 
		  Constraint(s) ?
	   
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
		String s = "deeedbbcccbdaa";
		int k = 3;
		Assert.assertTrue(removeSameCharactersOfKSize(s,k).equals("aa"));
	}

	@Test
	public void testData02() { // Negative
		String s = "abcd";
		int k = 2;
		Assert.assertTrue(removeSameCharactersOfKSize(s,k).equals("abcd"));
	}

	@Test
	public void testData03() { // Edge
		String s = "pbbcggttciiippooaais";
		int k = 2;
		Assert.assertTrue(removeSameCharactersOfKSize(s,k).equals("ps"));
	}
	@Test
	public void testData04() { // Edge
		String s = "aabbccddeeffggghhhhgffeeddccbbaaa";
		int k = 4;
		Assert.assertTrue(removeSameCharactersOfKSize(s,k).equals("a"));
	}
	
	@Test
	public void testData05() { // Edge
		String s = "aabbccdiiiddecba";
		int k = 3;
		Assert.assertTrue(removeSameCharactersOfKSize(s,k).equals("aabbccecba"));
	}

	/*  Create two stacks, stack and charOccur
	 *  Iterate the input,
	 *    If stack is empty, add to the stack and occurence to charOccur.
	 *    else peek the stack if previous and current element is same add to stack and increment the 
	 *    occure and push to charOccur.
	 *    if peek count of charOccur == k, remove the k  number from charOccur and stack.
	 *  Create a SB and pop the item from stack and reverse and return input
	 * 
	 * 
	 */
	private String removeSameCharactersOfKSize(String s, int k) {
		if (k > s.length())
			return s;
		Stack<Character> stack = new Stack<>();
		Stack<Integer> countStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(!stack.empty() && stack.peek() == s.charAt(i)){
				countStack.push((countStack.peek()+1));
			}
			else countStack.push(1);
			stack.push(s.charAt(i));
			if(countStack.peek() == k) {
				int temp = k;
				while(temp!=0) {
					countStack.pop();
					stack.pop();
					temp--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character eachVal : stack) {
			sb.append(eachVal);
		}
		return sb.toString();
	}
}
