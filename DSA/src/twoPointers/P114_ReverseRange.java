package twoPointers;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P114_ReverseRange {
	/*
		Problem Statement
		Given a given list,and list of list with 2 values each. Reverse the range in the list
	
	*/

	/*
	   1. 
	  	 Input(s) ? List, List of List 
		  Output ? List
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

		List<Integer> arr1 =  Arrays.asList(3,5,2,1,3);
		List<List<Integer>> ranges =  Arrays.asList(Arrays.asList(1,4),Arrays.asList(2,4));
		Assert.assertTrue(reverseRange(arr1, ranges).equals(Arrays.asList(3,3,5,2,1)));
	}
	@Test
	public void testData02() { // Edge
		List<Integer> arr2 =  Arrays.asList(1,2,3,4,5);
		List<List<Integer>> ranges =  Arrays.asList(Arrays.asList(1,3),Arrays.asList(2,3));
		Assert.assertTrue(reverseRange(arr2, ranges).equals(Arrays.asList(1,4,2,3,5)));
	}

	
	/* Write a new helper method to reverse the list with two pointers and using temp technique
	 * Iterate the ranges function and call reverse function with input list as 
	 *  input list and and range index 0 and 1 as start and end index
	 * return the list
	 * 
	 */
	private List<Integer> reverseRange(List<Integer> inputList, List<List<Integer>> ranges) {
		for (List<Integer> list : ranges) {
			reverseList(inputList, list.get(0),list.get(1));
		}
		return inputList;
	}
	
	public List<Integer> reverseList(List<Integer> list, int start, int end){
		while(start<end) {
			int temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			start++;
			end--;			
		}
		return list;
	}

}
