package twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P46_RearrangeNegativePositiveAlternatively {
	
	/*  	
	 * In the given input array, rearrange the positive and negative items
	 * alternatively. Input contains negative and positive numbers equally 
	 * Input = {12,-90,-100,15,98,99,-56}
	 * output  = {12,-90,15,-100,98,-56,99}
	 * 
	 */
	
	/* 1. 
    Input(s)? int[]
    Output ? int[]
    Constraints ?  No extra space

	2. Test data set
	
	        Positive : {12,-90,-100,15,98,99,-56}
	        Edge : {-1,-2,-3,1,2,2}
	        Edge     : {-1,2,-1,2,-1,2}
	
	3. Known Approaches
	        Approach 1 :Bruteforce with two list
	        Approach 2 :Using Two Ptrs 
	
	4. O-Notations
			Approach 1 :Bruteforce with two list - O(n^2), O(2n)
	        Approach 2 :Using Two Ptrs - O(n), O(1) 
	
	5. Pseudocode
	
	 */
	
	@Test
	public void testData01(){            // Positive
		int[] input = {12,-90,-100,15,98,99,-56};
		Assert.assertTrue(Arrays.equals(rearrangeNegativePositiveAlternatively(input),
				new int[]{12, -90, 15, -100, 98, -56, 99}));
	}


	@Test
	public void testData02(){			 // Edge
		int[] input = {-1,-2,-3,1,2,2};
		Assert.assertTrue(Arrays.equals(rearrangeNegativePositiveAlternatively(input),
				new int[]{1,-2,2,-1,2,-3}));
	}

	@Test
	public void testData03(){			 // Edge
		int[] input = {-1,2,-1,2,-1,2};
		Assert.assertTrue(Arrays.equals(rearrangeNegativePositiveAlternatively(input),
				new int[]{2,-1,2,-1,2,-1}));
	}
	
	/*1. Create a pointer searchPtr = 0
	  2. Iterate the input
	   		a)if current element index is even and element is -ve
	    	  find the next present positive element and replace with current index element
	   		b)else if current element index is odd and element is +ve  
	   		  find the next present negative element and replace with current index element
	  3. return input
	   Time : O(n)
	   Space : O(1)
	 */ 
	
	private int[] rearrangeNegativePositiveAlternatively(int[] input) {
		if(input.length==0)return new int[]{};
		int searchPtr = 0;
		for (int i = 0; i < input.length; i++) {
			if(i%2==0 && input[i]<0) {
				searchPtr = i;
				while(input[++searchPtr] < 0);
				int temp = input[searchPtr];
				input[searchPtr] =input[i];
				input[i] = temp;
			}
			else if(i%2!=0 && input[i]>0) {
				searchPtr = i;
				while(input[++searchPtr]>0);
				int temp = input[searchPtr];
				input[searchPtr] =input[i];
				input[i] = temp;
			}
		}
		return input;
	}
	
	
	 

}
