package slidingWindow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class P30_FindMinimumSubarray {

	/* Given an array of positive integers nums and a positive integer target, 
	 * return the minimal length of a contiguous subarray
	 *  [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater 
	 *  than or equal to target. If there is no such subarray, return 0 instead.

 
		Example 1:
		
		Input: target = 7, nums = [2,3,1,2,4,3]
		Output: 2
		Explanation: The subarray [4,3] has the minimal length under the problem constraint.
		Example 2:
		
		Input: target = 4, nums = [1,4,4]
		Output: 1
		Example 3:
		
		Input: target = 11, nums = [1,1,1,1,1,1,1,1]
		Output: 0
	 * 
	 */
	
	/*
	 * 1. 
		    Input(s)? int[], int
		    Output ? int
		    Constraints ?  

		2. Test data set
		
		        Positive : target = 7, nums = [2,3,1,2,4,3]
		        Negative : target = 4, nums = [1,4,4]
		        Edge     : target = 11, nums = [1,1,1,1,1,1,1,1]
		
		3. Known Approaches
		        Approach 1 :Bruteforce 
		        Approach 2 :Sliding Window
		
		4. O-Notations
				Approach 1 :Bruteforce Time :  O(n^2), Space : O(1)
		        Approach 2 :Sliding Window Time :  O(n), Space : O(1)
		
		5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {2,3,1,2,4,3};
		int target = 7;
		Assert.assertTrue(findMinimumSubarray(input,target)==2);
		Assert.assertTrue(findMinimumSubarrayBruteForce(input,target)==2);
	}


	@Test
	public void testData02(){			 // Edge
		int[] input = {1,4,4};
		int target = 4;
		Assert.assertTrue(findMinimumSubarray(input,target)==1);
		Assert.assertTrue(findMinimumSubarrayBruteForce(input,target)==1);
	}

	@Test
	public void testData03(){			 // Negative
		int[] input = {4,4,4};
		int target = 13;
		Assert.assertTrue(findMinimumSubarray(input,target)==0);
		Assert.assertTrue(findMinimumSubarrayBruteForce(input,target)==0);
	}
	/* Initialize min as Integer.MAX_VALUE
	 * Iterate the input
	 *  initialize sum as 0 
	 *  Iterate the input 
	 *  	add the current element to sum
	 *   	if sum >= target find the min length
	 *  return min
	 *  
	 *  Time : O(n^2)
	 *  Space : O(n)
	 * 
	 */
	private int findMinimumSubarrayBruteForce(int[] input, int target) {
		int min = Integer.MAX_VALUE;
		boolean isTargetReached = false;
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			for (int j = i; j < input.length; j++) {
				sum += input[j];
				if(sum>=target) {
					isTargetReached= true;
					min = Math.min(j-i+1, min);
				}
			}
		}
		return isTargetReached? min : 0;
	}
	
	
	/* Initialize left as 0, right as 0 , length as length + 1 and sum as 0
	 * Iterate right < input length
	 *   Add the value of right to sum
	 *   untill sum>= target 
	 *   	find the smallest distance of length and update
	 *   	subtract value of left from sum and increment left
	 *   Check if the length is updated from initialized value if yes
	 *   return updated else 0
	 * Time : O(n)
	 * Space : O(1)
	 */
	
	private int findMinimumSubarray(int[] input, int target) {
		int left = 0, right = 0, length = input.length+1,sum = 0 ;
        while(right < input.length){
            sum += input[right];
            while(sum>=target) {
                if(right-left+1<length) length = right-left+1;
                sum -= input[left++];
            }
            right++;
        }
        return (length == input.length +1) ? 0 : length;
	}
}
