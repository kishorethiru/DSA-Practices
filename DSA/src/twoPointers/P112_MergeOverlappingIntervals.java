package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P112_MergeOverlappingIntervals {
	/*
		Problem Statement
		Given an array of intervals [[1,3],[2,4],[6,9]], merge the overlapping intervals, 
		i.e to [[1,4],[6,9]]
		[[1,4],[2,3],[3,6]]
		[1,6]
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[][] 
		  Output? int[][]
		  Constraint(s) ?
	   
	   2. Test data
			Positive : [[1,3],[2,4],[6,9]]
			Edge : [[1,4],[2,3],[3,6]]
			Edge : [[1,4],[3,4],[5,7],[8,10],[9,13]]
	
	   3.  Approaches Known 
			 Approach 1 : 
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[][] input = {{1,3},{2,4},{6,9}};
		Assert.assertTrue(Arrays.equals(mergeIntervals(input), new int[][] {{1,4},{6,9}}));
	}

	@Test
	public void testData02() { // Negative
		int[][] input = {{1,3},{2,3},{3,6}};
		Assert.assertTrue(Arrays.equals(mergeIntervals(input), new int[][] {{1,6}}));
	}

	@Test
	public void testData03() { // Edge
		int[][] input = {{1,3},{2,3},{3,6}};
		Assert.assertTrue(Arrays.equals(mergeIntervals(input), new int[][] {{1,6}}));
	}
	@Test
	public void testData04() { // Edge
		int[][] input = {{1,13},{3,4},{5,7},{8,10},{9,11}};
		Assert.assertTrue(Arrays.equals(mergeIntervals(input), new int[][] {{1,13}}));
	}
	
	@Test
	public void testData05() { // Negative
		int[][] input = {{1,3},{4,5},{6,7}};
		Assert.assertTrue(Arrays.equals(mergeIntervals(input), new int[][] {{1,3},{4,5},{6,7}}));
	}


	/* Sort the input by start time.
	 * Create a list of list
	 * Initialize  startTime and endTime store the value of 1st item in it
	 * Iterate the input from 1
	 *  if ith index start > endTime find the the max of endTime and update it
	 *  else add the start and endtime to list and update start and end time
	 * Iterate the list and add to int[][]
	 * return int[][]
	 */

	private int[][] mergeIntervals(int[][] intervals) {
		Arrays.sort(intervals, (i, j) -> {
			if (i[0] != j[0])
				return i[0] - j[0];
			else
				return i[1] - j[1];
		});
		List<List<Integer>> list = new ArrayList<>();
		int startTime = intervals[0][0], endTime = intervals[0][1];
		for(int i = 1; i < intervals.length; i++){
			if(endTime>=intervals[i][0]){
				endTime = Math.max(endTime, intervals[i][1]);
			}
			else {
				list.add(Arrays.asList(startTime,endTime));
				startTime = intervals[i][0];
				endTime =  intervals[i][1];
			}
		}
		list.add(Arrays.asList(startTime,endTime));
		int[][] retArr = new int[list.size()][2];
		int index  = 0; 
		list.toArray(new int[list.size()][]);
//		for (List<Integer> eachList : list) {
//			retArr[index][0] = eachList.get(0);
//			retArr[index++][1] = eachList.get(1);
//		}
		return list.toArray(new int[list.size()][]);
	}
}
