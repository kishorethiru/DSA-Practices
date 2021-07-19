package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class P34_FindSquareRootOfNumber {
	/*
	 * FInd the square root of the given number
	 * Ex : 4, output => 2
	 * 
	 */
	
	/*
	 * 1. 
    Input(s)? int  
    Output ? int
    Constraints ? No inbuild math function  

	2. Test data set
	
	        Positive : 4
	        Negative : 
	        Edge     : 8
	
	3. Known Approaches
	        Approach 1 : Linear approach 
	
	4. O-Notations
	
	5. Pseudocode
	 */
	
	@Test
	public void testData01(){            // Positive
		int n = 15;
		Assert.assertTrue(findSquareRootBS(n) == 3);
	}


	@Test
	public void testData02(){			 // Edge
		int n = 8;
		Assert.assertTrue(findSquareRootBS(n) == 2);
	}

	@Test
	public void testData03(){			 // Edge
		int n = 1;
		Assert.assertTrue(findSquareRootBS(n) == 1);
	}
	
	@Test
	public void testData04(){			 // Edge
		int n = 624;
		Assert.assertTrue(findSquareRootBS(n) == 24);
	}



	
	/* 
	 *1. Iterate from 1 till the input number n/2
	 *    a)Square the number and check if equals to n
	 *    b)if yes return the current number
	 *    c) else if squared > n, return i-1
	 *2. return 0  
	 * Time : O(n/2)
	 * Space : O(1)
	 */
	private int findSquareRoot(int n) {
		if(n<0) throw new RuntimeException("Invalid number");
		if(n < 3) return 1;
		for (int i = 1; i <= n/2; i++) {
			int squaredNumber = i*i;
			if(squaredNumber==n) return i;
			else if(squaredNumber>n) return i-1;
		}
		return 0;
	}
	/* Initialize low as 1 and high as n/2
	 * Iterate till low <= high
	 *   find the midpoint and square it
	 *   if squaredValue matches n, return midpoint
	 *   else if squaredValue > n, 
	 *         if  square midpoint - 1 value and check if matches return midpoint -1
	 *         else  square midpoint -2 > n , high = mid -1
	 *         else return     midpoint -2
	 * return 0  
	 *   
	 *   
	 * 
	 */
	
//	private int findSquareRootBS(int n) {
//		if(n<0) throw new RuntimeException("Invalid number");
//		if(n < 3) return 1;
//		int low = 1, high = n/2;
//		while(low<=high) {
//			int midpoint = (low+high)/2;
//			int squaredNumber = midpoint * midpoint;
//			if(squaredNumber==n) return midpoint;
//			else if(squaredNumber>n) {
//				if((midpoint-1) * (midpoint -1) == n) return midpoint-1;
//				else if((midpoint-2) * (midpoint -2)>n) high = midpoint-1;
//				else return midpoint-2;				
//			}
//		}
//		return 0;
//	}
	
	private int findSquareRootBS(int n) {
		if(n<0) throw new RuntimeException("Invalid number");
		if(n < 3) return 1;
		int low = 1, high = n/2;
		while(low <= high) {
			int midpoint = (low+high)/2;
			int squaredNumber = midpoint * midpoint; // 12 == 9
			if(squaredNumber>n) high = midpoint-1;
			else if(squaredNumber<n) low = midpoint+1;
			else return midpoint;
		}
		return high;
	}
	

}
