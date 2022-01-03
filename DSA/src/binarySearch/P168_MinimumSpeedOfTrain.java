package binarySearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P168_MinimumSpeedOfTrain {
	/*
		Problem Statement
		You are given a floating-point number hour, representing the amount of time you have to 
		reach the office. To commute to the office, you must take n trains in sequential order. 
		You are also given an integer array dist of length n, where dist[i] describes the 
		distance (in kilometers) of the ith train ride.

		Each train can only depart at an integer hour, so you may need to wait in between
		 each train ride.

		For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 
		hours before you can depart on the 2nd train ride at the 2 hour mark.
		Return the minimum positive integer speed (in kilometers per hour) that all the trains
		 must travel at for you to reach the office on time, or -1 if it is impossible to be on time.
		Tests are generated such that the answer will not exceed 107 and hour will have at 
		most two digits after the decimal point.
	
	*/

	/*
	   1. 
	  	  Input(s) ? int[], double 
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

		int[] input = {1,3,2};
		double hrs = 6;
		int output = 1;
		Assert.assertTrue(findSpeedOfTrain(input,hrs) == output);
	}

	@Test
	public void testData02() { // Negative
		int[] input = {1,3,2};
		double hrs = 2;
		int output = -1;
		Assert.assertTrue(findSpeedOfTrain(input,hrs) == output);
	}

	@Test
	public void testData03() { // Edge
		int[] input = {1,3,2};
		double hrs = 2.7;
		int output = 3;
		Assert.assertTrue(findSpeedOfTrain(input,hrs) == output);
	}

	/* If the length of input < n return -1;
	 * 
	 */
	private int findSpeedOfTrain(int[] dist, double hour) {
		if(dist.length - 1 > hour) return -1;
		int low = 1,high = (int)10e7;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isArrivesInTime(dist,mid,hour)) {
            	high = mid-1;
            }
            else {
            	low = mid+1;         
            }
        }
		return low;
	}	
	
	 public boolean isArrivesInTime(int[]dist, int speed, double hour){
		 	double retVal = 0;
	        for(int i = 0;i<dist.length-1;i++){
	        	retVal += Math.ceil((double)dist[i]/speed);
	        }
	        retVal +=  (double)dist[dist.length-1]/speed;
	        return retVal<=hour;
	        
	    }
}
