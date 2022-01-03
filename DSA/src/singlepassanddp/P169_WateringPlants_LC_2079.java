/**
 * 
 */
package singlepassanddp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Kishore
 *
 */
public class P169_WateringPlants_LC_2079 {
	/*
		 * Leet Code Link : https://leetcode.com/problems/watering-plants/
		 * Leet Code Problem Number : 2079. Watering Plants
		  
		  Problem Statement
		  You want to water n plants in your garden with a watering can. The plants are arranged in a row and 
		  are labeled from 0 to n - 1 from
		  left to right where the ith plant is located at x = i. There is a river at x = -1 
		  that you can refill your watering can at.
		  
		  Each plant needs a specific amount of water. You will water the plants in 
		  the following way:

   		  Water the plants in order from left to right.
		  After watering the current plant, if you do not have enough water to completely water 
		  the next plant, return to the river to fully refill the watering can.
		  You cannot refill the watering can early.
		  You are initially at the river (i.e., x = -1). It takes one step to move one unit on the x-axis.
		  Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the 
		  ith plant needs, and an integer capacity representing the watering can capacity, return the number 
		  of steps needed to water all the plants.
			
		*/

	/*
	   1. 
	  	  Input(s) ? int[], int
		  Output ? int
		  Constraint(s) ? Time Optimized 
	   
	   2. Test data
			Positive : plants = [2,2,3,3], capacity = 5       => OP 14
			Negative : plants = [1,1,1,4,2,3], capacity = 4   => OP 30
			Edge     : plants = [7,7,7,7,7,7,7], capacity = 8 => OP 49
	
	   3.  Approaches Known 
			 Approach 1 : One Pass, Counting
	
	   4.  O - Notation 
			 Approach 1 : Time O(n), Space O(1)
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] plants = {2,2,3,3};
		int capacity = 5;
		Assert.assertTrue(wateringPlants(plants, capacity) == 14);
	}

	@Test
	public void testData02() { // Negative
		int[] plants = {1,1,1,4,2,3};
		int capacity = 4;
		Assert.assertTrue(wateringPlants(plants, capacity) == 30);
	}

	@Test
	public void testData03() { // Edge
		int[] plants = {7,7,7,7,7,7,7};
		int capacity = 8;
		Assert.assertTrue(wateringPlants(plants, capacity) == 49);
	}

	/**
	 * @param plants
	 * @param capacity
	 * @return int
	 */
	/* Pseudocode
	 * 1. Initialize variable count and tempCapacity
	 * 2. Iterate through the input
	 * 3. If current index plants value > tempCapacity
	 *     a) Add i(Returning to get water)
	 *     b) Add i+1(Returning back to the index)
	 *     c) Update the tempCapacity
	 * 	  else
	 *     d) Increment count by 1
	 *     e) Decrement the current index plants value 
	 * 4. return count
	 */
	private int wateringPlants(int[] plants, int capacity) {
		int count = 0, tempCapacity = capacity;
		for (int i = 0; i < plants.length; i++) {
			if (plants[i] > tempCapacity) {
				count += i;
				count += i + 1;
				tempCapacity = capacity - plants[i];
			} else {
				count++;
				tempCapacity -= plants[i];
			}
		}
		return count;
	}
}
