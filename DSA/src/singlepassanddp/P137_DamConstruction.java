package singlepassanddp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P137_DamConstruction {
	/*
		Problem Statement
		
		Your company is designing a dam to be built across a stream to create a small lake. 
		To reduce materials cost, it will be made of one or more concrete walls with mud packed 
		in between them. Determine the maximum height of the mud segments in the dam with the 
		following restrictions:
 
		One unit width of the gap between walls will contain one segment of packed mud
		The height of mud in a segment cannot exceed 1 unit more than an adjacent wall or mud segment.
 
		Given the placement of a number of walls and their heights, determine the maximum 
		height of a mud segment that can be built. If no mud segment can be built, return 0.
 
		Example
		wallPositions = [1, 2, 4, 7] 
		wallHeights = [4, 6, 8, 11]
	
	*/

	/*
	   1. 
	  	  Input(s) ? two lists 
		  Output ? int
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
		List<Integer> positions = new ArrayList<>(Arrays.asList(1, 2, 4, 7));
		List<Integer> heights = new ArrayList<>(Arrays.asList(4, 6, 8, 11));
		Assert.assertTrue(findMaxMudWall(positions,heights) == 10);
	
	}
	@Test
	public void testData02() { // Positive
		List<Integer> positions = new ArrayList<>(Arrays.asList(1, 3, 6));
		List<Integer> heights = new ArrayList<>(Arrays.asList(4, 6, 8));
		Assert.assertTrue(findMaxMudWall(positions,heights) == 8);
	
	}

	@Test
	public void testData03() { // Negative
		List<Integer> positions = new ArrayList<>(Arrays.asList(4,5,6,9,10,11,12,13,14));
		List<Integer> heights = new ArrayList<>(Arrays.asList(20,22,11,14,14,21,19,14,23));
		Assert.assertTrue(findMaxMudWall(positions,heights) == 13);
	}

	
	private int findMaxMudWall(List<Integer> wallPositions, List<Integer> wallHeights) {
		int n = wallPositions.size();
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int hDiff = Math.abs((wallHeights.get(i + 1) - wallHeights.get(i)));
            int gapLen = wallPositions.get(i + 1) - wallPositions.get(i) - 1;
            int localMax = 0;
            if (gapLen > hDiff) {
                int low = Math.max(wallHeights.get(i + 1), wallHeights.get(i)) + 1;
                int remGap = gapLen - hDiff - 1;
                localMax = low + remGap / 2;
            } else {
                localMax = Math.min(wallHeights.get(i + 1), wallHeights.get(i)) + gapLen;
            }
            result = Math.max(result, localMax);
        }
        return result;
	}

	
}
