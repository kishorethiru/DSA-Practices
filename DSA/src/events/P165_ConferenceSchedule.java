package events;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P165_ConferenceSchedule {
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
		int[][] input = {{1,3},{1,2},{2,4}};
		Assert.assertTrue(findMaxConferenceToAttend(input)==2);
	}
	@Test
	public void testData02() { // Negative
		int[][] input = {{1,5},{5,6}};
		Assert.assertTrue(findMaxConferenceToAttend(input)==2);
	}

	@Test
	public void testData03() { // Edge
		int[][] input = {{1,2},{1,3},{2,3},{3,4}};
		Assert.assertTrue(findMaxConferenceToAttend(input)==3);
	}
	
	private int findMaxConferenceToAttend(int[][] input) {
		Arrays.sort(input, (a,b)->{
			if(a[1] != b[1]) return a[1]-b[1];
			else return a[0]-b[0];});
		int count = 1, currentMeeting = 0;
		for (int i = 1; i < input.length; i++) {
			if(input[currentMeeting][1]<= input[i][0]) {
				count++;
				currentMeeting++;
			}
		}
		return count;
	}
}
