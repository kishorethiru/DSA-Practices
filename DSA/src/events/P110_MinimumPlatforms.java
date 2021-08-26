package events;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P110_MinimumPlatforms {
	/*
		Problem Statement
		Given arrival and departure times of all trains that reach a 
		railway station. Find the minimum number of platforms required 
		for the railway station so that no train is kept waiting.
		Consider that all the trains arrive on the same day and 
		leave on the same day. Arrival and departure time can never 
		be the same for a train but we can have arrival time of one train equal 
		to departure time of the other. At any given instance of time, same platform 
		can not be used for both departure of a train and arrival of another train. 
		In such cases, we need different platforms.
	
	*/

	/*
	   1. 
	  	  Input(s) ?  two int[]
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
	 String[] arr = {"0900", "0940", "0950", "1100", "1500", "1800"};
	 String[] dep = {"0910", "1200", "1120", "1130", "1900", "2000"};
	 Assert.assertTrue(findMinumumRequiredPlatforms(arr,dep)==3);
	}

	@Test
	public void testData02() { // Edge
		String[] arr = {"0900", "1100", "1235"};
		String[] dep = {"1000", "1200", "1240"};
		Assert.assertTrue(findMinumumRequiredPlatforms(arr,dep)==1);
	}
	
	@Test
	public void testData03() { // Edge
		String[] arr = {"0900", "1100", "1235"};
		String[] dep = {"1800", "1200", "1240"};
		Assert.assertTrue(findMinumumRequiredPlatforms(arr,dep)==3);
	}
	private int findMinumumRequiredPlatforms(String[] arr, String[] dep) {
		int minPlatforms =arr.length;
		int[][] timings = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			timings[i][0] = Integer.parseInt(arr[i]);
			timings[i][1] = Integer.parseInt(dep[i]); 
		}
		Arrays.sort(timings,(a,b)->{
			if(a[0]!=b[0]) return a[0]-b[0];
			else return a[1]-b[1];});
		int currentTrain = 0;
		for (int  i= 1; i < timings.length; i++) {
			if(timings[i][0]>timings[currentTrain][1]){
				currentTrain++;
				minPlatforms--;
			}	
		}
		return minPlatforms;
	}
}
