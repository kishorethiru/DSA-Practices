package binarySearch;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P64_FindStaringEndingIndexOfTarget {
	
	/*
	 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
		If target is not found in the array, return [-1, -1].
		You must write an algorithm with O(log n) runtime complexity.
		 
		Example 1:
		Input: nums = [5,7,7,8,8,10], target = 8
		Output: [3,4]
		Example 2:
		Input: nums = [5,7,7,8,8,10], target = 6
		Output: [-1,-1]
		Example 3:
		Input: nums = [], target = 0
		Output: [-1,-1]
	 * 
	 */
	
	/*1. 
		    Input(s)? int[], int 
		    Output ? int[]
		    Constraints ? time : O (log n)  

		2. Test data set
		
		        Positive :nums = [5,7,7,8,8,10], target = 8
		        Negative :nums = [5,7,7,8,8,10], target = 6
		        Edge     :nums = [], target = 0
		
		3. Approaches
		        
		
		4. O-Notations
		
		5. Pseudocode
	 * 
	 */
	@Test
	public void testData01()
	{
		int[] input = {5,7,7,8,8,10};
		int k = 8;
		Assert.assertTrue(Arrays.equals(findFirstAndLastIndices(input,k), new int[] {3,4}));
		
	}
	
	@Test
	public void testData02()
	{
		int[] input = {7,7,7,7,7,7};
		int k = 7;
		Assert.assertTrue(Arrays.equals(findFirstAndLastIndices(input,k), new int[] {0,5}));
		
	}
	
	@Test
	public void testData03()
	{
		int[] input = {5,7,7,8,8,10};
		int k = 6;
		Assert.assertTrue(Arrays.equals(findFirstAndLastIndices(input,k), new int[] {-1,-1}));
		
	}
	@Test
	public void testData04()
	{
		int[] input = {2,3,3,5,6,7,8,9};
		int k = 3;
		Assert.assertTrue(Arrays.equals(findFirstAndLastIndices(input,k), new int[] {1,2}));
		
	}
	
	/*
	 *  Find first Index
	 *  	Initialize  low = 0, high = length -1
	 *  	Iterate till low<=high
	 *  		find mid point
	 *  		if mid value is lower then target, move low = mid+1
	 *  		else high = mid-1
	 *  	return low
	 *  Find Second Index
	 *  	Initialize  low = 0, high = length -1
	 *  	Iterate till low<=high
	 *  		find mid point
	 *  		if mid value is higher then target, move high = mid-1
	 *  		else low = mid+1
	 *  	return high
	 *  
	 *  Finally check if the both index is pointing the target value
	 *  If not return -1,-1
	 *  else return first and last index
	 *  
	 *  Time - O 2(log m)
	 *  Space - O(1)
	 * 
	 */
	private int[] findFirstAndLastIndices(int[] input, int target) {
		int first = findfirstIndex(input,target);
		int last  = findLastIndex(input,target);
		if (!(input[first] == target && input[last] == target))return new int[] {-1,-1};
		return new int[] {first, last};	
	}
	
	 private int findfirstIndex(int[] input,int target) {
		 int low = 0, high = input.length-1;
		 while(low<=high) {
			 int mid = (low+high)/2;
			 if(input[mid] < target) low = mid+1;
			 else high = mid-1;
		 }
		 return low; 
	 }
	 
	 private int findLastIndex(int[] input,int target) {
		 int low = 0, high = input.length-1;
		 while(low<=high) {
			 int mid = (low+high)/2;
			 if(input[mid] > target) high = mid-1;
			 else low = mid+1;
		 }
		 return high;	 
	 }

}
