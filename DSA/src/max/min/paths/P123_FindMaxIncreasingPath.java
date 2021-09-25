package max.min.paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P123_FindMaxIncreasingPath {
	/*
		Problem Statement
		In the given input, find the max increasing path 
	
	*/

	/*
	   1. 
	  	 Input(s) ? int[] 
		  Output ? int[]
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
		int[] input = {1,3,2,5,4,2,6,7,8};
		System.out.println(Arrays.toString(findLongSeq(input)));
		Arrays.equals(findMaxIncreasingSubArray(input), new int[] {1,2,4,6,7,8});
	}

	@Test
	public void testData02() { // Negative
		int[] input = {8,8,8,8,8,8,8,8};
		Arrays.equals(findMaxIncreasingSubArray(input), new int[] {8});
	}

	@Test
	public void testData03() { // Edge
		int[] input = {9,8,7,5,4,3};
		Arrays.equals(findMaxIncreasingSubArray(input), new int[] {5,4,3});
	}
	
	
	@Test
	public void testData04() { // Edge
		int[] input = {3,5,6,2,5,4,19,5,6,7,12};
		Arrays.equals(findMaxIncreasingSubArray(input), new int[] {5,4,3});
	}
	
	
	/* Using List
	 * 1. Create a new list
	 * 2. Add the 0 index value to list
	 * 3. Iterate the input
	 *    a) If the current index value is greater than last added add to list
	 *    b) else find the if the current value is greater than any and get the index
	 *    c) Push the value at the corresponding index
	 * 4. return the list by converting to array
	 * Time : O(nlogn)
	 * Space : O(n)  
	 */
	private int[] findMaxIncreasingSubArray(int[] input) {
		List<Integer> list = new ArrayList<>();
		list.add(input[0]);
		for(int i = 1; i<input.length;i++){
			int num = input[i];
			if(num>list.get(list.size()-1)){
				list.add(num);
			}
			else {
				int j = bs(list,num);
				list.set(j, num);
			}
		}
		int[] ret = new int[list.size()];
		int index=0;
		for(Integer i : list)
			ret[index++] = i;
		return ret;	
	}
	
	public int bs(List<Integer> list, int num) {
		int l = 0, h = list.size()-1;
		while(l<h) {
			int mid = l + (h-l)/2;
			if(list.get(mid)>=num) h =mid;
			else l = mid+1;
		}
		return h;
	}
	
	/* Without using list
	 * 
	 */
	public int[] findLongSeq(int[]nums) {
		int[] arr = new int[nums.length];
		arr[0] = nums[0];
		int len = 1;
		for(int i =1; i<nums.length; i++){
			int cur = nums[i];
			if(cur>arr[len-1]) arr[len++] = cur;
			else {
				arr[bsArr(arr,len-1,cur)] = cur;
			}
		}
		return Arrays.copyOf(arr, len);
	}
	
	public int bsArr(int[] nums, int len, int i) {
		int l = 0, h = len ;
		while(l<h) {
			int mid = l + (h-l)/2;
			if(nums[mid]>=i) h =mid;
			else l = mid+1;
		}
		return h;
	}	
	
	/* Initialize a new array and fill value by 1
	 * Iterate the input from 1 till length
	 *   Iterarte inner nested loop from 0 and before i
	 *    if the i value is > j and value of newarr[j]>=newArr[j] 
	 *    update newArr[i] as newArr[j]+1
	 * Iterate and find the max
	 * return max;
	 * Time : O(n^2)
	 * Space : O(n)
	 * 
	 */
	private int findLongestIncreasingSub(int[] nums) {
		int[] iArr = new int[nums.length];
		Arrays.fill(iArr, 1);
		int max= 0;
		for(int i = 1;i<nums.length;i++){
			for(int j = 0;j <i; j++) {
				if(nums[i]>nums[j] && iArr[i]<=iArr[j]) iArr[i] = iArr[j]+1; 
			}
		}
		
		for(int i : iArr) max = Math.max(max, i);
		return max;
	}
}
