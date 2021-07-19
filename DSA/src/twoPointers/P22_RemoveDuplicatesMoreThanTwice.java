package twoPointers;

import org.junit.Assert;
import org.junit.Test;

public class P22_RemoveDuplicatesMoreThanTwice {
	
	/*
	 * Given a sorted array nums, remove the duplicates in-place such 
	 * that duplicates appeared at most twice and return the new length.
		Do not allocate extra space for another array; you must do this by 
		modifying the input array in-place with O(1) extra memory. 
	 */
	/*
	 * 1. 
		    Input(s)? int[]
		    Output ?  int
		    Constraints ?  No extra memory

		2. Test data set
		
		        Positive : 1,1,1,2,2,3
		        Edge 1	 : 1,2,3,4,5,6,7
		        Edge 2   : 0,0,1,1,1,1,2,3,3
		        Edge 3   : 0,0,0,0,0,1
		
		3. Known Approaches
		        Approach 1 :Bruteforce 
		        Approach 2 : Using Two Pointers 
		
		4. O-Notations
				Approach 1 :Bruteforce  - O(n^2), O(n)
		        Approach 2 : Using Two Pointers - O(n),O(1)
		
		5. Pseudocode
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		int [] input = {1,1,1,2,2,3};
		Assert.assertTrue(findCountRemovingAtmostDuplicates(input)==5);
	}


	@Test
	public void testData02(){			 // Edge
		int [] input = {1,2,3,4,5,6,7};
		Assert.assertTrue(findCountRemovingAtmostDuplicates(input)==7);
	}

	@Test
	public void testData03(){			 // Edge
		int [] input = {0,0,0,0,0,1};
		Assert.assertTrue(findCountRemovingAtmostDuplicates(input)==3);
	}
	
	@Test
	public void testData04(){			 // Edge
		int [] input = {0,0,1,1,1,1,2,3,3};
		Assert.assertTrue(findCountRemovingAtmostDuplicates(input)==7);
	}

	
	/* 1. If input length < 3 return the length of input
	 * 2. If first index and last index value are same return 2
	 * 3. Initialize  count as 1, dupCount as 1
	 * 4. Initialize  right as 1, left as 0
	 * 5. Iterate the input till right < input.length
	 *    a) if current element and previous element are same, 
	 *    	  increment dupCount, if dupCount >= 2, count++
	 *    b) else dupCount = 1 and count ++ 
	 *    c) increment left and right
	 * 6. return count
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 * 
	 */
	
	private int findCountRemovingAtmostDuplicates(int[] input) {
		 if(input.length < 3) return input.length;
		 if(input[0]==input[input.length-1]) return 2;
		 int dupCount = 1, count = 1, left = 0, right = 1;
		 while(right < input.length) {
			 if(input[left] == input[right]) {
				 dupCount++;
				 if(dupCount <= 2) count++;
			 }
			 else {
				 dupCount =1;
				 count++;
			 }
			 left++;
			 right++;
			
		 }
		return count;
	}
	

}
