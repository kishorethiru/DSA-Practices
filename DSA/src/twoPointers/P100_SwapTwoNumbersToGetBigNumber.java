package twoPointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P100_SwapTwoNumbersToGetBigNumber {
	/*
		Problem Statement
		
		Swap any two digits to get the biggest number
 
		Example 1:
		Input: num = 2736.  
		Output: 7236
		Explanation: Swap the number 2 and the number 7.
		Example 2:
		Input: num = 9973
		Output: 9973
		Explanation: No swap.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int  
		  Output ? int
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
		int input = 2736;
		Assert.assertTrue(swapTwoNumbersToGetBigNumber(input)==7236);
	}

	

	@Test
	public void testData02() { // Negative
		int input = 9998;
		Assert.assertTrue(swapTwoNumbersToGetBigNumber(input)==9999);
	}

	@Test
	public void testData03() { // Edge

	}
	
	private int swapTwoNumbersToGetBigNumber(int input) {
		char[] inputArr = String.valueOf(input).toCharArray();
		int maxVal=Integer.MIN_VALUE, rangeIndex, maxIndex = 0;
		for (rangeIndex = 1; rangeIndex < inputArr.length; rangeIndex++) {
			if(Integer.valueOf(inputArr[rangeIndex]+"") > Integer.valueOf(inputArr[rangeIndex-1]+"")) {
				break;
			}
		}
		if(rangeIndex == inputArr.length) return input;
		maxVal= 0;
		for (int i = rangeIndex; i < inputArr.length; i++) {
			if(Integer.valueOf(inputArr[rangeIndex]+"") > maxVal) {
				maxVal = Integer.valueOf(inputArr[rangeIndex]+"");
				maxIndex = i;
			}
		}
		int minIndex = 0;
		for (int i = 0; i < inputArr.length; i++) {
			if(Integer.valueOf(inputArr[i]+"")<maxVal) {
				minIndex = i;
				break;
			}
		}
		int temp = inputArr[maxIndex];
		inputArr[maxIndex] = inputArr[minIndex];
		inputArr[minIndex] = (char) temp;
		return Integer.parseInt(String.valueOf(inputArr));
	}
}
