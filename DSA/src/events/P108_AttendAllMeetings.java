package events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P108_AttendAllMeetings {
	/*
		Problem Statement
		Given an array of meeting time intervals where intervals[i] = [starti, endi], 
		determine if a person could attend all meetings.
		 
		Example 1:
		Input: intervals = [[0,30],[5,10],[15,20]]
		Output: false
		Example 2:
		Input: intervals = [[7,10],[2,4]]
		Output: true
	
	*/

	/*
	   1. 
	      Input(s) ? int[][] 
		  Output ? boolean
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
		int[][] intervals = {{7,10},{2,4}};
		mergeIntervals(intervals);
//		Assert.assertTrue(mergeIntervals(intervals));
	}

	@Test
	public void testData02() { // Negative
		int[][] intervals = {{0,30},{5,10},{15,20}};
//		Assert.assertFalse(mergeIntervals(intervals));
	}

	@Test
	public void testData03() { // Edge
		int[][] intervals = {{3,5},{1,2},{4,7}};
//		Assert.assertFalse(mergeIntervals(intervals));
	}
	
	/* Sort the data by end time
	 * Iterate the data
	 *   Check if first meeting end time is > next Meeting start time 
	 *     return false
	 * return true
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
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= endTime) {
				endTime = Math.max(endTime, intervals[i][1]);

			} else {
				list.add(Arrays.asList(startTime, endTime));
				startTime = intervals[i][0];
				endTime = intervals[i][1];
			}
		}
		return new int[][] {};
	}
}
