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
		int[] input = {1,3,2,5,4,6,7,8};
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
	
	private int[] findMaxIncreasingSubArray(int[] input) {
		List<Integer> list = new ArrayList<>();
		list.add(input[0]);
		for(int i = 1; i<input.length;i++){
			int num = input[i];
			if(num>list.get(list.size()-1)){
				list.add(num);
			}
			else {
				int j = 0;
				while(num>list.get(j++));
				if(j==list.size()-1) list.set(j, num);
			}
		}
		int[] ret = new int[list.size()];
		int index=0;
		for(Integer i : list)
			ret[index++] = i;
		return ret;	
	}
}
