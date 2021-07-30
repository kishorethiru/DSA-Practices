package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class P65_FindSingleValue {
	/*
	 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
	Follow up: Your solution should run in O(log n) time and O(1) space.
	 
	Example 1:
	Input: nums = [1,1,2,3,3,4,4,8,8]
	Output: 2
	Example 2:
	Input: nums = [3,3,7,7,10,11,11]
	Output: 10
	 * 
	 */
	
	@Test
    public void testData01() {
        int[] input = {1,1,2,3,3,4,4,8,8};
        Assert.assertTrue(findNonDuplicateNumber(input)==2);
    }
    
    
    @Test
    public void testData02() {
        int[] input = {1,1,2,2,3,3,4,8,8};
        Assert.assertTrue(findNonDuplicateNumber(input)==4);
    }


	@Test
    public void testData03() {
        int[] input = {1,1,2,2,3,4,4,8,8};
        Assert.assertTrue(findNonDuplicateNumber(input)==3);
    }
	
	@Test
    public void testData04() {
        int[] input = {1,1,2,2,4,8,8};
        Assert.assertTrue(findNonDuplicateNumber(input)==4);
    }
    
    /* Initialize low  = 0, high = length -1
	 * Iterate till low crosses high
	 *    Find midpoint and check if mid - 1 and mid + 1 is not equal to mid
	 *    if mid and mid-1 value are equal high = mid-2
	 *    else mid and mid+1 value are equal low = mid+2 
	 * 
	 */
	
	private int findNonDuplicateNumber(int[] input) {
		int low = 0, high = input.length-1;
		while(low < high) {
			int mid = (low+high)/2;
			if(input[mid] != input[mid-1] && input[mid]!= input[mid+1]) return input[mid];
			if(input[mid] == input[mid-1]) high = mid;
			else low = mid;
		}
		return 0;
	}

}
