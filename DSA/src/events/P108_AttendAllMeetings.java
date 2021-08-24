package events;

import java.util.Arrays;

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
		Assert.assertTrue(isAllMeetingsCanBeAttended(intervals));
	}

	@Test
	public void testData02() { // Negative
		int[][] intervals = {{0,30},{5,10},{15,20}};
		Assert.assertFalse(isAllMeetingsCanBeAttended(intervals));
	}

	@Test
	public void testData03() { // Edge
		int[][] intervals = {{3,5},{1,2},{4,7}};
		Assert.assertFalse(isAllMeetingsCanBeAttended(intervals));
	}
	
	/* Sort the data by end time
	 * Iterate the data
	 *   Check if first meeting end time is > next Meeting start time 
	 *     return false
	 * return true
	 */
	
	private boolean isAllMeetingsCanBeAttended(int[][] intervals) {
		Arrays.sort(intervals,(a,b)->{
			if(a[1]!=b[1]) return a[1]-b[1];
			else return a[0]-b[0];});
		int currentEnd = 0, nextStart = 1;
		while(currentEnd<intervals.length-1) {
			if(intervals[currentEnd++][1]>intervals[nextStart++][0]) return false;
		}
		return true;
		
	}
}
