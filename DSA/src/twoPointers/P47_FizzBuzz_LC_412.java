package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P47_FizzBuzz_LC_412 {
	/*
	 * https://leetcode.com/problems/fizz-buzz/
	 * 412. Fizz Buzz
		Problem Statement
		
		Given an integer n, return a string array answer (1-indexed) where:

		answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
		answer[i] == "Fizz" if i is divisible by 3.
		answer[i] == "Buzz" if i is divisible by 5.
		answer[i] == i if non of the above conditions are true.
		
		// 2 Mins
	
	*/

	/*
	   1. 
	  	  Input(s) ? int 
		  Output ? String[]
		  Constraint(s) ? Two Ptr + Hashing
	   
	   2. Test data
			Positive : n = 3
			Negative : n = 2	
			Edge     : n = 15
	
	   3.  Approaches Known 
			 Approach 1 : Two Ptr + Hashing
	
	   4.  O - Notation 
			 Approach 1 :  Two Ptr + Hashing - O(n), O(n)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int input = 3;
		String[] output = {"1","2","Fizz"};
		List<String> op = Arrays.asList(output);
		Assert.assertTrue(fizzBuzz(input).equals(op));
	}

	@Test
	public void testData02() { // Negative
		int input = 2;
		String[] output = {"1","2"};
		List<String> op = Arrays.asList(output);
		Assert.assertTrue(fizzBuzz(input).equals(op));

	}

	@Test
	public void testData03() { // Edge
		int input = 15;
		String[] output = {"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"};
		List<String> op = Arrays.asList(output);
		Assert.assertTrue(fizzBuzz(input).equals(op));
	}
	// 3 mins
	
	/* Pseudocode - Hashing and Two Ptrs
	 * Create a hashmap and add values for 3 as Fizz, 5 as Buzz, 15 as FizzBuzz
	 * Initialize an outputarray of length as input
	 * Initialize pointer as left = 0, right as length - 1
	 * Iterate till  left <= right
	 * 	  if left and rigth are equal only left are right needs to be checked and added
	 * 	  if(left+1 is divisible by 3) get the 3 value from map and push to the left index 
	 * 	  if(left+1 is divisible by 5) get the 5 value from map and push to the left index
	 * 	  if(left+1 is divisible by 15) get the 5 value from map and push to the left index
	 *    increment left
	 * 	  
	 *    if(right+1 is divisible by 3) get the 3 value from map and push to the right index 
	 * 	  if(right+1 is divisible by 5) get the 5 value from map and push to the right index
	 * 	  if(right+1 is divisible by 15) get the 5 value from map and push to the right index
	 *    decrement right
	 * 
	 * return outputarray
	 * Time : O(n/2)
	 * Space : O(n) 
	 *  
	 *  
	 * 5mins 
	 */
	
	/*  Time Taken
	 *  Question/ Template - 3 mins
	 *  Test data - 3 mins used question data
	 *  Pseudocode - 5 mins
	 *  Coding / debug / fix - 10 mins    
	 *  
	 */
	

private List<String> fizzBuzz(int input) {
		Map<Integer, String> map = new HashMap<>();
		map.put(3, "Fizz");
		map.put(5, "Buzz");
		map.put(15, "FizzBuzz");
		String[] output = new String[input];
		int left = 0, right = input-1;
		while(left<=right){
			if(left==right) {
				if((left+1) % 15 == 0) output[left] = map.get(15);
				else if((left+1) % 3 == 0) output[left] = map.get(3);
				else if((left+1) % 5 == 0) output[left] = map.get(5); 
				else output[left] = ""+(left+1);
				left++;
			}
			else {
				if((left+1) % 15 == 0) output[left] = map.get(15);
				else if((left+1) % 3 == 0) output[left] = map.get(3);
				else if((left+1) % 5 == 0) output[left] = map.get(5);
				else output[left] = ""+(left+1);
				
				if((right+1) % 15 == 0) output[right] = map.get(15);
				else if((right+1) % 3 == 0) output[right] = map.get(3);
				else if((right+1) % 5 == 0) output[right] = map.get(5);
				else output[right] = ""+(right+1);
				left++;
				right--;
			}	
		}
		List<String> op = new ArrayList<>();
		for (String eachVal : output) {
			op.add(eachVal);
		}
		return op;
	}
	
	
		// 10 Mins
}
