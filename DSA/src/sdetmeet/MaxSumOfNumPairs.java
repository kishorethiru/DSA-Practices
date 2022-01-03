package sdetmeet;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class MaxSumOfNumPairs {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
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

		int[] input = {51,71,17,42};
		System.out.println(findSumOfEach(input));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {42,33,60};
		System.out.println(findSumOfEach(input));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {51,32,43};
		System.out.println(findSumOfEach(input));
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {10,01,02,20,11};
		System.out.println(findSumOfEach(input));
	}
	
	/* 1) Create a HasmMap
	 * 2) Initialize max as -1 
	 * 3) Iterate the input
	 *   a) find the sum of each digit in the value
	 *   b) if it contains in map add the current value + value of key in map
	 *   	1) Compare and store the max
	 *      2) if(value of current sum of digits is > current index value)
	 *        replace value in map
	 *   c) else add to map sum of digits as key and current index value as value 
	 * 4) return max
	 * 
	 * Time : O(n)
	 * Space : O(n)
	 * 
	 */
	
	private int findSumOfEach(int[] nums) {
		int max = -1;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : nums) {
			int sum = sumOfDigit(i);
			if(map.containsKey(sum)) {
				max = Math.max(max, map.get(sum)+i);
				if(map.get(sum)<i) map.put(sum, i);
			}
			else map.put(sum, i);
		}
		return max;
	}
	
	private int sumOfDigit(int n) {
		int sum = 0;
		while(n!=0) {
			sum += n%10;
			n = n/10;
		}
		return sum;
		
	}
}
