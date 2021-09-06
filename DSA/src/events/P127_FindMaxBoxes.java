package events;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P127_FindMaxBoxes {
	/*
		Problem Statement
		
		You are assigned to put some amount of boxes onto one truck. You are given a 2D array 
		boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
		numberOfBoxesi is the number of boxes of type i.
		numberOfUnitsPerBoxi is the number of units in each box of the type i.
		You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
		
		Return the maximum total number of units that can be put on the truck.	 
		
		Example 1:
		
		Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
		Output: 8
		Explanation: There are:
		- 1 box of the first type that contains 3 units.
		- 2 boxes of the second type that contain 2 units each.
		- 3 boxes of the third type that contain 1 unit each.
		You can take all the boxes of the first and second types, and one box of the third type.
		The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
		Example 2:
		
		Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
		Output: 91
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[][], int 
		  Output ? int
		  Constraint(s) ?
	   
	   2. Test data
			Positive : boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
			Negative : boxTypes = [[1,2],[6,1],[2,1]], truckSize = 8	
			Edge     : boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[][] boxes = {{1,3},{2,2},{3,1}};
		int truckSize = 4;
		Assert.assertTrue(findMaxBoxes(boxes, truckSize) == 8 );
	}

	@Test
	public void testData02() { // Negative
		int[][] boxes = {{1,2},{1,1},{1,3}};
		int truckSize = 4;
		Assert.assertTrue(findMaxBoxes(boxes, truckSize) == 6);
	}

	@Test
	public void testData03() { // Edge
		int[][] boxes = {{5,10},{2,5},{4,7},{3,9}};
		int truckSize = 10;
		Assert.assertTrue(findMaxBoxes(boxes, truckSize) == 91 );
	}

	/* Sort the input by the 1 index in the descending order
	 * Initiate the variable maxValue and variable boxesFilled
	 * Iterate the input
	 *   Untill boxesFilled == trunkSize   
	 *    add the 1 index of inner array * 0 index of inner array to maxValue 
	 * return max  
	 * 
	 * Time : O(nlogn) + O(n) -> O(nlogn)
	 * Space : O(1)
	 * 
	 */
	private int findMaxBoxes(int[][] boxes, int truckSize) {
		Arrays.sort(boxes, (a,b)->{
			if(a[1] != b[1]) return b[1]-a[1];
			else return b[0]-a[0];
			});
		int maxValue = 0, boxesFilled = 0;
		for(int i = 0 ; i < boxes.length;i++) {
			if(boxes[i][0]<= truckSize-boxesFilled) {
				maxValue += boxes[i][0] * boxes[i][1];
				boxesFilled += boxes[i][0];
			}
			else {
				maxValue +=(truckSize-boxesFilled) * boxes[i][1];
				boxesFilled += truckSize-boxesFilled;
			}
			if(truckSize == boxesFilled) break;
		}
		return maxValue;
	}
}
