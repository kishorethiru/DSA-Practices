package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P46_AddAToArrayFormOfInteger_LC_989 {
	/*
	 * https://leetcode.com/problems/add-to-array-form-of-integer/
	 * 989. Add to Array-Form of Integer
	 * 
	 * 
		Problem Statement
		The array-form of an integer num is an array representing its digits in left to right order.
		For example, for num = 1321, the array form is [1,3,2,1].
		Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], int 
		  Output ? List<Integer>
		  Constraint(s) ? No
	   
	   2. Test data
			Positive : num = [1,2,0,0], k = 34 , OP = [1,2,3,4]
			Negative : num = [2,1,5], k = 806	OP = [1,0,2,1]
			Edge     : num = [9,9,9,9,9,9,9,9,9,9], k = 1 OP = [1,0,0,0,0,0,0,0,0,0,0]
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive

		int[] input = {1,2,0,0};
		int k = 34;
		Integer[] output = {1,2,3,4};
		List<Integer> list =Arrays.asList(output) ;
		Assert.assertTrue(addArrayFormOfInteger(input,k).equals(list));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {2,1,5};
		int k = 806;
		Integer[] output = {1,0,2,1};
		List<Integer> list =Arrays.asList(output);
		Assert.assertTrue(addArrayFormOfInteger(input,k).equals(list));

	}

	@Test
	public void testData03() { // Edge
		int[] input = {9,9,9,9,9,9,9,9,9,9};
		int k = 1;
		Integer[] output = {1,0,0,0,0,0,0,0,0,0,0};
		List<Integer> list =Arrays.asList(output);
		Assert.assertTrue(addArrayFormOfInteger(input,k).equals(list));
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {0};
		int k = 1000;
		Integer[] output = {1,0,0,0};
		List<Integer> list =Arrays.asList(output) ;
		Assert.assertTrue(addArrayFormOfInteger(input,k).equals(list));
	}
	
	@Test
	public void testData05() { // Positive

		int[] input = {7};
		int k = 993;
		Integer[] output = {1,0,0,0};
		List<Integer> list = Arrays.asList(output);
		Assert.assertTrue(addArrayFormOfInteger(input,k).equals(list));
	}

	/**
	 * @param input
	 * @param k
	 * @return 
	 */
	/* Create a list
	 * Create variable right as length -1 and carry as 0
	 * Iterate till right < = 0  or carry !=0 or k !=0
	 *  find lastDigit by k%10
	 *  modify k as k/10
	 *  if current number + carry+k > 9
	 *    find the carry
	 *    Add remainder to the list on the 0th index
	 *  else 
	 *    add the sum number to the list on 0th index
	 *  decrement right
	 *return list;  
	 * 
	 *Time : O(n or m)
	 *Space : O(m)  
	 * 
	 */
	private List<Integer> addArrayFormOfInteger(int[] input, int k) {
		List<Integer> list = new ArrayList<>();
		int right = input.length - 1, carry = 0;
		while (right >= 0 || carry != 0 || k != 0) {
			int lastDigit = k % 10;
			k /= 10;
			int numToAdd = right < 0 ? carry + lastDigit : input[right] + carry + lastDigit;
			if (numToAdd > 9) {
				carry = numToAdd / 10;
				numToAdd %= 10;
				list.add(0, numToAdd);
			} else {
				list.add(0, numToAdd);
				carry = 0;
			}
			right--;
		}
		if (list.size() == 0)
			list.add(0);
		return list;
	}
}
