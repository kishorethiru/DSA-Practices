package events;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P166_SlotProblem {
	/*
		Problem Statement
		Given the availability time slots arrays slots1 and slots2 of two people and a meeting 
		duration duration, return the earliest time slot that works for both of them and is of
		duration duration.
		If there is no common time slot that satisfies the requirements,
		 return an empty array.
		The format of a time slot is an array of two elements [start, end] representing an 
		inclusive time range from start to end.
		It is guaranteed that no two availability slots of the same person intersect 
		with each other. That is, for any two time slots [start1, end1] and [start2, end2] 
		of the same person, either start1 > end2 or start2 > end1.
 
		Example 1:
		Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
		Output: [60,68]
		Example 2:
		Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
		Output: []
	
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
		int[][] slot1  =  {{10,50},{60,120},{140,210}};
		int[][] slot2 = {{0,15},{60,70}};
		int k = 8;
		Assert.assertTrue(Arrays.equals(findMeetingTime(slot1,slot2,k), new int[] {60,68}));
	}

	@Test
	public void testData02() { // Negative
		int[][] slot1  =  {{10,50},{60,120},{140,210}};
		int[][] slot2 = {{0,15},{60,70}};
		int k = 12;
		Assert.assertTrue(Arrays.equals(findMeetingTime(slot1,slot2,k), new int[] {}));
	}	

	@Test
	public void testData03() { // Edge

	}
	
	private int[] findMeetingTime(int[][] slot1, int[][] slot2, int k) {
		Arrays.sort(slot1,(a,b)->{
			if(a[0]!=b[0]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		Arrays.sort(slot2,(a,b)->{
			if(a[0]!=b[0]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		int slotOne = 0, slotTwo = 0;
		while(slotOne<slot1.length&& slotTwo<slot2.length){
			int maxStartTime = Math.max(slot1[slotOne][0], slot2[slotTwo][0]);
		    int minEndTime   = Math.min(slot1[slotOne][1], slot2[slotTwo][1]);
		    if(Math.abs(maxStartTime-minEndTime) >=k) return new int[] {maxStartTime, maxStartTime+k};
		    slotOne++;
		    slotTwo++;
		}
		return new int[] {};
	}
}
