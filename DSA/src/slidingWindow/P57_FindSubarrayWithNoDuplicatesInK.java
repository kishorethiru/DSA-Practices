package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P57_FindSubarrayWithNoDuplicatesInK {
	/*
		Problem Statement
		You are given an array 𝐴 of of integers, length 𝑁. What is the longest ("sub") 
		array you can generate from 𝐴, such that there are no duplicates within distance 
		𝐾 of one another. The ("sub") array must be constructed by removing values from 𝐴, i.e.,
		 the order must be preserved, but any entry may be skipped/ignored/removed.
		Trivial example: For 𝐾=1, 𝐴=[1,2,1,3,2], the answer is: 5 ([1,2,1,3,2]).
		Non-trivial example: For 𝐾=2, 𝐴=[1,2,1,3,2], the answer is: 4 ([2,1,3,2]).
		Note that in the non-trivial example, we had to skip the first element, such that we could 
		add both 2's; else we would have had [1,2,3].
		Desired solution is O(N).
	*/

	/*
	   1. 
	  	  Input(s) ? int[],int
		  Output ? int[]
		  Constraint(s) ? O(n)
	   
	   2. Test data
			Positive :1,2,1,3,2, k = 2
			Negative :1,2,1,3,2, k = 1	
			Edge     :
	
	   3.  Approaches Known 
				Approach 1 : Sliding window + Hashmap
	
	   4.  O - Notation 
			 Approach 1 : Sliding window + Hashmap
			 Time - O(n), Space: O(k+1)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {1,2,1,3,2};
		int k = 2;
		Assert.assertTrue(Arrays.equals(findSubarrayWithNoDuplicatesWithinK(input,k), 
				new int[] {2,1,3,2}));
	}

	@Test
	public void testData02() { // Edge
		int[] input = {1,2,3,4,5,4,3,2};
		int k = 4;
		Assert.assertTrue(Arrays.equals(findSubarrayWithNoDuplicatesWithinK(input,k), 
				new int[] {1,2,3,4,5}));
	}

	@Test
	public void testData03() { // Negative
		int[] input = {1,2,1,2,1,2,1,2};
		int k = 2;
		Assert.assertTrue(Arrays.equals(findSubarrayWithNoDuplicatesWithinK(input,k), 
				new int[] {}));
	}
	
	@Test
	public void testData04() { // Edge
		int[] input = {1,1,1,1,5,4,6,7};
		int k = 2;
		Assert.assertTrue(Arrays.equals(findSubarrayWithNoDuplicatesWithinK(input,k), 
				new int[] {1,5,4,6,7}));
	}

	
	/* Pseudocode
	 * Initialize left as 0, right as k+1  startIndex as 0 , endIndex as 0, maxWindow as k+1
	 * Create a new Hashmap
	 * Iterate the values from 0 to k and add to map
	 * If all the values in range 0 to k are unique then update start index and end index along
	 * with maxwindow
	 * Iterate right until it reaches the end
	 *   If the all elements in window k+1 is not unique and distance between left and right -1 is till k
	 *  	 increment left;
	 *   Add the right value to map
	 *   remove the right-k-1 value from map
	 *   if values in the range is unique , then if window is greater or equal to the maxWindow
	 *    Update startIndex, endIndex and maxWindow value; 
	 * if both start and end index is 0 return {}
	 * Return the input array by copying it from startIndex, endIndex+1
	 * 
	 * Time :O(n)
	 * Space : O(k+1)
	 * 
	 */
	private int[] findSubarrayWithNoDuplicatesWithinK(int[] input, int k) {
		int left = 0, right = k+1, startIndex = 0, endIndex = 0;
		int maxWindow = k+1;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0;i<=k;i++) {
			map.put(input[i], map.getOrDefault(input[i], 0)+1);
		}
		if(map.size() == k+1) {
			maxWindow = k+1;
			startIndex = 0;
			endIndex = k;
		}
		while(right<input.length){
			while(map.size() != k+1 && right-left-1 ==k){
				left++;
			}
			map.put(input[right], map.getOrDefault(input[right], 0)+1);
			int remove = input[right-k-1];
			if(map.get(remove)>1){
				map.put(remove, map.getOrDefault(remove, 0)-1);
			}
			else map.remove(remove);
			if(map.size() == k+1) {
				if(maxWindow<=right-left+1)
				startIndex = left;
				endIndex = right;
				maxWindow = right-left+1;
			}
			right++;
			
		}
		if(startIndex == 0 && endIndex == 0) return new int[]{};
		return Arrays.copyOfRange(input, startIndex, endIndex+1);
	}
}
