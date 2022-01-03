/**
 * 
 */
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
public class P168_PlusOne_LC_66 {
	/*
		 * Leet Code Link : https://leetcode.com/problems/plus-one/
		 * Leet Code Problem Number :66. Plus One
		  
		  Problem Statement
		  You are given a large integer represented as an integer array digits, where each digits[i] is 
		  the ith digit of the integer. The digits are ordered from most significant to least significant 
		  in left-to-right order. The large integer does not contain any leading 0's.

		  Increment the large integer by one and return the resulting array of digits.
			
		*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? int[]
		  Constraint(s) ? Time Optimized 
	   
	   2. Test data
			Positive : [1,2,3] => [1,2,4]
			Negative : [9] =>[1,0]
			Edge     : [9,9] => [1,0,0]
	
	   3.  Approaches Known 
			 Approach 1 : One pass with a pointer
	
	   4.  O - Notation 
			 Approach 1 : One pass with a pointer Time : O(n), Space : O(n) 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		Assert.assertTrue(Arrays.equals(plusOne(new int[] {1,2,3}), new int[] {1,2,4}));
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue(Arrays.equals(plusOne(new int[] {9}), new int[] {1,0}));
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(Arrays.equals(plusOne(new int[] {9,9}), new int[] {1,0,0}));
	}
	
	/* 
	 * 1. Create a list
	 * 2. Create variables carry, sum as 1, index last index value of input array
	 * 3. Iterate till index < 0 or carry not equal to 0
	 *    a) get the index value and add to sum
	 *    b) if sum > 9 add the last digit to list and add reminder to carry
	 *    c) else add to list 
	 * 4. Iterate the list and add to int[]
	 * 5. return int[]
	 * 
	 * Time  : O(n)
	 * Space : O(n)
	 * 
	 */
	public int[] plusOne(int[] digits) {
		List<Integer> retList = new ArrayList<>();
		int carry = 0, sum = 1, index = digits.length-1;
		while(index >=0 || carry!= 0){
			sum += (index >= 0) ? digits[index--] : 0;
			if(sum+carry>9){
				int totalSum = sum+carry;
				carry = totalSum/10;
				sum =   totalSum % 10;
				retList.add(0,sum);
				sum = 0;
			}
			else {
				retList.add(0,sum+carry);
				sum = 0;
				carry = 0;
			}
		}
		int[] arr = retList.stream().mapToInt(i -> i).toArray();
		return arr;
	}
}
