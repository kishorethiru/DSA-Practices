package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class P41_FindNextBiggestCharacter {
	
	/* Given a sorted character array and a target character, 
	 * find the next biggest character in the array.
 		char[] char = {‘b’, ‘d’ , ‘h’};
		char k = ‘e’
		Output ->  h
	 * 
	 */
	
	/*
	 * 1. 
    Input(s)? char[] , char
    Output ? char
    Constraints ?  Time O(n) 

2. Test data set

        Positive :{‘b’, ‘d’ , ‘h’}, target = 'e'
        Negative :{‘b’}, target = 'c'  
        Edge     :{‘b’, ‘d’ , ‘h’} target = 'd'

3. Known Approaches
        Approach 1 :Bruteforce
        
        

4. O-Notations
     
5. Pseudocode
	 */
	
	@Test
	public void testData01(){            // Positive
		char[] input = {'b', 'd' , 'h'};
		char target = 'e';
		Assert.assertTrue(findNextBiggestOfTargetBS(input,target) == 'h');
	}


	@Test
	public void testData02(){			 // Negative
		char[] input = {'b'};
		char target = 'c';
		Assert.assertTrue(findNextBiggestOfTargetBS(input,target) == ' ');
	}

	@Test
	public void testData03(){			 // Edge
		char[] input = {'b','d','h'};
		char target = 'd';
		Assert.assertTrue(findNextBiggestOfTargetBS(input,target) == 'h');
	}
	
	@Test
	public void testData04(){			 // Edge
		char[] input = {'b','d','h'};
		char target = 'j';
		Assert.assertTrue(findNextBiggestOfTargetBS(input,target) == ' ');
	}
	
	@Test
	public void testData05(){			 // Edge
		char[] input = {'b','d','h','i','k'};
		char target = 'j';
		Assert.assertTrue(findNextBiggestOfTargetBS(input,target) == 'k');
	}
	
	@Test
	public void testData06(){			 // Edge
		char[] input = {'b','d','h','i','k'};
		char target = 'h';
		Assert.assertTrue(findNextBiggestOfTargetBS(input,target) == 'i');
	}


	private char findNextBiggestOfTarget(char[] input, char target) {
		for (int i = 0; i < input.length; i++) {
			if(input[i]>target) return input[i];			
		}
		return ' ';
	}
	/* low and high
	 * 
	 * 
	 */
//	private char findNextBiggestOfTargetBS(char[] input, char target) {
//		int low = 0, high = input.length-1;
//		while(low<=high) {
//			int mid = (low+high)/2;
//			if(input[mid]>target) return input[mid];
//			if(input[mid]>target) high = mid-1;
//			else low = mid+1;			
//		}
//		return ' ';
//	}
	
	
	private char findNextBiggestOfTargetBS(char[] input, char target) {
		int low = 0, high = input.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(input[mid]>target) return input[mid];
			if(input[mid]<=target) low = mid+1;
			else high = mid-1;			
		}
		return ' ';
	}

}
