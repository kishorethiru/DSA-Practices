/**
 * 
 */
package singlepassanddp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P171_Destroying_Asteroids_LC_2126 {
	/*
		 * Leet Code Link : https://leetcode.com/problems/destroying-asteroids/
		 * Leet Code Problem Number : 2126. Destroying Asteroids
		  
		  Problem Statement
		  You are given an integer mass, which represents the original mass of a planet. You are further 
		  given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.

		  You can arrange for the planet to collide with the asteroids in any arbitrary order. 
		  If the mass of the planet is greater than or equal to the mass of the asteroid, 
		  the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, 
		  the planet is destroyed.

		 Return true if all asteroids can be destroyed. Otherwise, return false.
			
		*/

	/*
	   1. 
	  	  Input(s) ? int, int[]
		  Output ? boolean
		  Constraint(s) ?  Time OPtimized
	   
	   2. Test data
			Positive :  mass = 10, asteroids = [3,9,19,5,21] => true
			Negative :  mass = 5, asteroids = [4,9,23,4] => false
			Edge     :  mass = 1, asteroids = [1] => true
	
	   3.  Approaches Known 
			 Approach 1 : Sorting and Greedy Approach
	
	   4.  O - Notation 
			 Approach 1 : Sorting and Greedy Approach Time : O(n log n) 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int mass = 10;
		int[] asteroids = {3,9,19,5,21};
		Assert.assertTrue(canDestroyAsteroids(mass,asteroids));
	}

	@Test
	public void testData02() { // Negative
		int mass = 5;
		int[] asteroids = {4,9,23,4};
		Assert.assertFalse(canDestroyAsteroids(mass,asteroids));
	}

	
	@Test
	public void testData03() { // Edge
		int mass = 1;
		int[] asteroids = {1};
		Assert.assertTrue(canDestroyAsteroids(mass,asteroids));
		
	}
	
	/*
	 * 1. Sort the asteroids input arrays
	 * 2. Initialize a long as sum
	 * 3. Iterate the asteroids input array
	 *   a) If the sum >= eachVal , add the current value to sum
	 *   b) else return false
	 * 4. return true
	 * 
	 * Time : O(n log n)
	 * Space : O(1)
	 */

	private boolean canDestroyAsteroids(int mass, int[] asteroids) {
		long sum = mass;
		for(int eachAsteroid : asteroids) {
			if(sum >= eachAsteroid) sum+=eachAsteroid;
			else return false;
		}
		return true;
	}
	
	
}
