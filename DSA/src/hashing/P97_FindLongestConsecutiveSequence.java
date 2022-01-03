package hashing;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P97_FindLongestConsecutiveSequence {
	
	/*
	 *  
	 * Given an unsorted array of integers nums, return the length of the 
	 * longest consecutive elements sequence.You must write an algorithm that runs in O(n) time,
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {100,4,200,1,3,2};
		Assert.assertTrue(findConsecutiveSeq(input)==4);
	}


	@Test
	public void testData02(){			 // Negative
		int[] input = {100,98,96,102};
		Assert.assertTrue(findConsecutiveSeq(input)==0);
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {0,3,7,2,5,8,4,6,0,1};
		Assert.assertTrue(findConsecutiveSeq(input)==9);
	}
	
	
	/*  Create a hash set, add all elements to hashset
	 *  Iterate the input,
	 *   if current element - 1 , is not contains then check 
	 *     untill next element is not present in set increment the count
	 *   Save the maxValue by finding difference between current Value and last found  
	 * return maxValue
	 */
	private int findConsecutiveSeq(int[] input) {
		 Set<Integer> inputSet = new HashSet<>();
         for(int currentVal : input) {
             inputSet.add(currentVal);
         }
         int maxCount = 0;
         for(int currentVal : inputSet) {
             if(!inputSet.contains(currentVal - 1)) {  // only check for one direction
                 int nextVal = currentVal + 1;
                 while(inputSet.contains(nextVal)) {
                     nextVal++;
                 }
                 maxCount = Math.max(maxCount, nextVal - currentVal);
             }
         }
         return maxCount;
	}
	
	

}
