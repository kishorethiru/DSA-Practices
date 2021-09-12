package twoPointers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P134_PanCakeSorting {
	/*
		Problem Statement
		Given an array of integers arr, sort the array by performing a series of pancake flips.

		In one pancake flip we do the following steps:
		
		Choose an integer k where 1 <= k <= arr.length.
		Reverse the sub-array arr[0...k-1] (0-indexed).
		For example, if arr = [3,2,1,4] and we performed a pancake flip 
		choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] 
		after the pancake flip at k = 3.
		Return an array of the k-values corresponding to a sequence of 
		pancake flips that sort arr. Any valid answer that sorts the array 
		within 10 * arr.length flips will be judged as correct.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? list
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

		int[] input = {3,2,4,1};
		pancakeSort(input);
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int val = arr.length;
        while(val > 0){
            int index = 0;
            while(val != arr[index]){
                index++;
            }
            arr = reverseVal(arr, index);
            arr = reverseVal(arr, val-1);
            list.add(index+1);
            list.add(val);
            val--;
        }
        return list;
    }
    
    public int[] reverseVal(int[]nums, int index){
        int left = 0, right = index;
        while(left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
        return nums;
    }
}
