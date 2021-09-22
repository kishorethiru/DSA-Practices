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
        int[] input = {1,2,2,3,3};
        Assert.assertTrue(findNonDuplicateNumber(input)==1);
    }
    
    
	/* Initialize low as 0 and high as length -1
	 * Check Boundary conditions
	 *  if high is zero return 0th element
	 *  if 0 and 1 element are not same return 0th element
	 *  if last and last - 1 are not same return last element
	 *  Iterate till low<= high
	 *   Get the mid element
	 *   If mid and mid -1 and mid and mid+1 are not same return mid
	 *   If(mid is odd check mid and mid -1 are equal || mid is even mid and mid+1 are same
	 *   ) then low = mid+1;
	 *   else high = mid-1
	 * return 0;
	 * 
	 */
	private int findNonDuplicateNumber(int[] input) {
		int low = 0, high = input.length-1;
        if(high == 0) return input[0];
        else if(input[0] != input[1]) return input[0];
        else if(input[high] != input[high-1]) return input[high];
		while(low <= high) {
            int mid = (low + high) / 2;
            if(input[mid] != input[mid+1] && input[mid]!= input[mid-1]) return input[mid];
            if(mid%2 == 0 && input[mid] == input[mid+1] || mid %2 == 1 && input[mid] == input[mid-1]) low = mid+1;
            else high = mid-1;
		}
		return -1;
	}

}
