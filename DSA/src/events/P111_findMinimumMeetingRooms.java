package events;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P111_findMinimumMeetingRooms {
	/*
		Problem Statement
	
	*/

	/*
	   1. 
	  Input(s) ? 
		  Output ?
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

        String[][] meetingTimes = {{"09 00", "11 20"},{"11 00", "11 10"},
                {"09 30", "10 00"},{"10 40", "11 40"}};
		Assert.assertTrue(findMiniumMeetingRooms(meetingTimes)==3);
	}

	@Test
	public void testData02() { // Negative

	}

	@Test
	public void testData03() { // Edge

	}
	
	private int findMiniumMeetingRooms(String[][] meetingTimes) {
		int[][] timings = new int[meetingTimes.length][2];
		for (int i = 0; i < meetingTimes.length; i++) {
			timings[i][0] = Integer.parseInt(meetingTimes[i][0].replace(" ", ""));
			timings[i][1] = Integer.parseInt(meetingTimes[i][1].replace(" ", ""));
		}
		Arrays.sort(timings,(a,b)->{
			if(a[1]!=b[1]) return a[1]-b[1];
			else return a[0]-b[0];});
		int currentMeeting = 0;
		int minMeetingRoom = meetingTimes.length;
		for (int i = 1; i < timings.length; i++) {
			if(timings[i][0]>timings[currentMeeting][1]) {
				currentMeeting++;
				minMeetingRoom--;
			}
		}
		return minMeetingRoom;
	}
}
