package hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kishore
 *
 */
public class P124_LemonadeChange {
	/*
		Problem Statement
		At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to 
		buy from you, and order one at a time (in the order specified by bills). 
		Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. 
		You must provide the correct change to each customer so that the net transaction is 
		that the customer pays $5.
		Note that you don't have any change in hand at first.
		Given an integer array bills where bills[i] is the bill the ith customer pays, 
		return true if you can provide every customer with correct change, or false otherwise.
	*/

	/*
	   1. 
	  	  Input(s) ? int[] 
		  Output ? boolean
		  Constraint(s) ? Time Optimized
	   
	   2. Test data
			Positive : 5,5,10
			Negative : 5,5,10,10,20	
			Edge     : 5,5,5,10,20
	
	   3.  Approaches Known 
			 Approach 1 : Using Hashmap for maintaining change
	
	   4.  O - Notation 
			 Approach 1 : 
	
	   5.  Pseudocode		
	
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		int[] input = {5,5,10};
		Assert.assertTrue(lemonadeChange(input));
	}

	@Test
	public void testData02() { // Negative
		int[] input = {5,5,10,10,20};
		Assert.assertFalse(lemonadeChange(input));
	}

	@Test
	public void testData03() { // Edge
		int[] input = {5,5,5,10,20};
		Assert.assertTrue(lemonadeChange(input));
	}

	/* Create a map, and add 5, 10 and add 0 in the value
	 * Iterate the input
	 *   if the current value is 5
	 *     Increment the value of 5 in map
	 *   else if current value is 10
	 *     Increment the value of 10 in map
	 *     Decrement the value of 5 in map
	 *   else 
	 *     get the value of 5 count and 10 count from map
	 *     if 5 value = 0 return return false;
	 *     else if 10Value = 0,
	 *     	  if count5 >2 , decrement 3 from 5 count in map
	 *       else return false  
	 *     else
	 *       decrement 1 value of 5 from map
	 *       decrement 1 value of 10 from map
	 * return true
	 *       
	 *  Time : O(n)
	 *  Space : O(1)
	 * 
	 */
	private boolean lemonadeChange(int[] bills) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(5, 0);
		map.put(10, 0);
		for (Integer i : bills) {
			System.out.println(i);
			System.out.println(map);
			if (i == 5)
				map.put(5, map.getOrDefault(5, 0) + 1);
			else if (i == 10) {
				map.put(10, map.getOrDefault(10, 0) + 1);
				if (map.get(5) > 0)
					map.put(5, map.getOrDefault(5, 0) - 1);
				else
					return false;
			} else {
				int count5 = map.get(5);
				int count10 = map.get(10);
				if (count5 == 0)
					return false;
				else if (count10 == 0) {
					if (count5 >= 3)
						map.put(5, map.getOrDefault(5, 0) - 3);
					else
						return false;
				} else {
					map.put(5, map.getOrDefault(5, 0) - 1);
					map.put(10, map.getOrDefault(10, 0) - 1);
				}
			}
		}
		return true;
	}
}
