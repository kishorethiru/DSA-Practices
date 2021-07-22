package twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P49_FindStrongestValue {
	
	/* Given an array of integers arr and an integer k.

	A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| > |arr[j] - m|
 	where m is the median of the array.
	If |arr[i] - m| == |arr[j] - m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].

	Return a list of the strongest k values in the array. return the answer in any arbitrary order.
	 * 
	 */
	
	/* 1. 
    Input(s)? int[], int  
    Output ?  int[]
    Constraints ?  

	2. Test data set
	
	        Positive : [1,2,3,4,5], k = 2
	        Negative : [1,1,3,5,5], k = 2
	        Edge     : [6,-3,7,2,11], k = 3
	
	3. Known Approaches
	        Approach 1 :Two pointers 
	
	4. O-Notations
			Approach 1 :Two pointers - O(nlogn)
	5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {1,2,3,4,5};
		int k = 2;
		Assert.assertTrue(Arrays.equals(findStrongestValue(input,k), new int[] {5,1}));
	}


	@Test
	public void testData02(){			 // Negative
		int[] input = {1,1,3,5,5};
		int k = 5;
		Assert.assertTrue(Arrays.equals(findStrongestValue(input,k), new int[] {5,5,1,1,3}));
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {6,-3,7,2,11};
		int k = 3;
		Assert.assertTrue(Arrays.equals(findStrongestValue(input,k), new int[] {-3,11,2}));
	}

	/*  1. Sort the input
		2. Create a array of output length and a index 0
		3. Find median value
		4. Create pointer left as 0 and right = length -1
			Check if abs of right value - median > left, then add to ret array, decrement right
			Check if abs of left value - median > right, then add to ret array, increment left
			if abs of both left and right are same find the greater value among them and add left 
			value and increment left
		5. Return input by length k
	 *  Time : O(nlogn) + O(n) => O(nlogn)
	 *  Space : O(n)
	 */
	private int[] findStrongestValue(int[] input, int k) {
		Arrays.sort(input);
		int[] retArr = new int[input.length];
		int median = input[(input.length-1)/2];
		int left = 0, right = input.length-1,index=0;
		while(left<=right) {
			if(Math.abs(input[right]-median) > Math.abs(input[left]-median)) retArr[index++] = input[right--];
			else if (Math.abs(input[right]-median) < Math.abs(input[left]-median)) retArr[index++] = input[left++];
			else retArr[index++] = input[left]>input[right] ? input[left++] : input[right--];		
		}
		return Arrays.copyOf(retArr, k);
	}
	

}
